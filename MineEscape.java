public class MineEscape {
     private Map map;
     private int goldCount;
     private int[] numKeys;

     public MineEscape (String filename){
          //use try-catch statement to catch-exception if there is an issue in reading the map file
          try {
               this.map = new Map (filename);
               this.goldCount = 0;
               numKeys = new int[3];

          } catch (Exception e) {
               System.out.println(e);
          }
     }

     private MapCell findNextCell(MapCell cell) {
          //declares array of MapCell objects named neighbours and allocates space for six elements in that array
          MapCell[] neighbours = new MapCell[6];
      
          for (int i = 0; i < 6; i++) {
              try {
                    //iterates over potential neighboring cells around a given cell.
                    MapCell neighbour = cell.getNeighbour(i);
      
                    //if neighbour is null continue the loop
                    if (neighbour == null) {
                         continue;
                    }

                    ///if neighbour is mark continue the loop
                    if(neighbour.isMarked()){
                         continue;
                    }

                    //return the neighbour cell only if a floor cell
                    if (neighbour.isFloor()) {
                         return neighbour;
                    }
      
                    //return the neighbour, moving to an unmarked gold cell, pick up the gold
                    if (neighbour.isGoldCell()) {
                         //change the cell type to floor
                         neighbour.changeToFloor();
                         //increment the gold count
                         goldCount++;
                         return neighbour;
                    }
      
                    //return the neighbour, signifying that the agent has moved to this key cell, 
                    //picked up the key, and updated the key count accordingly
                    if (neighbour.isKeyCell()) {
                         neighbour.changeToFloor();
                         if (neighbour.isRed()) {
                              numKeys[0]++;
                         } else if (neighbour.isGreen()) {
                              numKeys[1]++;
                         } else if (neighbour.isBlue()) {
                              numKeys[2]++;
                         }
                              return neighbour;
                    }    
      
                    //return the neighbour, signifying that the agent has moved to this locked door cell, 
                    //unlocked the door using the appropriate key, and updated the key count accordingly.                    
                    if (neighbour.isLockCell()) {
                         if (neighbour.isRed() && numKeys[0] > 0 || neighbour.isGreen() && numKeys[1] > 0 || neighbour.isBlue() && numKeys[2] > 0) {
                              neighbour.changeToFloor();
                              if (neighbour.isRed()) {
                                   numKeys[0]--;
                              } else if (neighbour.isGreen()) {
                                   numKeys[1]--;
                              } else if (neighbour.isBlue()) {
                                   numKeys[2]--;
                              }    
                                   return neighbour;
                         }
                    }
      
                    //return the neighbour, move to the exit cell
                    if (neighbour.isExit()) {
                         return neighbour;
                    }

               } catch (Exception e) {
                  System.out.println(e);
               }
          }
      
          // return null if no next cell exist
          return null;
     }

     public String findEscapePath() {
          ArrayStack<MapCell> S = new ArrayStack<>();
          MapCell startingell = map.getStart();
          S.push(startingell);
          boolean running = true;
          String path = startingell.getID() + " ";    
          //initial goldCount to 0        
          int goldCount = 0;
          
          while (!S.isEmpty() && running) {
               //return the top element of the stack but doesn't remove it
               MapCell curr = S.peek();
          
               //continues exploring map until it reaches the exit cell
               if (curr.isExit()) {
                    running = false;
                    break;
               }
          
               //update the count of keys based on the color of the key, if the key cell is red/green/blue, it increments the count of red/green/blue keys
               if (curr.isKeyCell()) {
                    if (curr.isRed()) {
                         numKeys[0]++; 
                    } else if (curr.isGreen()) {
                         numKeys[1]++; 
                    } else if (curr.isBlue()) {
                         numKeys[2]++; 
                    }
               }
          
               if (curr.isGoldCell()) {
                    //increments the count of gold chunks 
                    goldCount++;
                    //the gold has been collected, changes the cell to a floor cell
                    curr.changeToFloor(); 
               }
          
               if (curr.isLava()) {
                    //lose any collected gold, resets to zero
                    goldCount = 0;
               }
          
               MapCell next = findNextCell(curr);
          
               if (next == null) {
                    // marke cells as visited, marks the current cell
                    curr.markOutStack();
                    //backtrack to the previous cell, removes the top element
                    S.pop();
               } else {
                    //update the path 
                    path = path + next.getID() + " ";
                    //moving forward to this cell, pushes the next cell onto the stack
                    S.push(next);
          
                    //assumption here is that the color indices for keys are 1 for red, 2 for green, and 3 for blue
                    if (next.isLockCell()) {
                         int lockedDoorColour = 0; 
                         if (next.isRed()) {
                              lockedDoorColour = 1;
                         } else if (next.isGreen()) {
                              lockedDoorColour = 2;
                         } else if (next.isBlue()) {
                              lockedDoorColour = 3;
                         }
                         //if lockedDoorColour is not 0, it means a valid color was determined
                         if (lockedDoorColour != 0) {
                              //the colors are assumed to start from 1, decrements the count of the corresponding key color
                              numKeys[lockedDoorColour - 1]--;
                              next.changeToFloor();
                         }
                    }    
                         next.markInStack();
               }
          }
          
          //return total path otherwise return No solution found
          if (!running) {
               return "Path: " + path + goldCount + "G";
          } else {
               return "No solution found";
          }
     }
      

}