public class ArrayStack<T> {
     private T[] array;
     private int top;

     //initializes array with 10 and set top to -1
     public ArrayStack(){
          array = (T[]) new Object[10]; 
          top = -1;
     }

     public void push(T element){
          //check the fraction of the array is being used 
          double fraction = (double) size() / getCapacity();
          // if the stack is at least 0.75, expand capacity by adding 10
          if(fraction >= 0.75){
               expandCapacity();
          }
          //add the element to top and update the value of top 
          array[++top] = element;

     }

     public T pop() throws StackException{
          //check the fraction of the array is being used 
          double fraction = (double) size() / getCapacity();
          //if stack is empty throw Stack is empty
          if (isEmpty()){
               throw new StackException("Stack is empty");
          }
          // If the stack is at most 0.25 or capacity less than 20, expand its capacity by removing 10
          if(fraction <= 0.25 && getCapacity() >= 20){
               shrinkCapacity();
          }
          //remove the element to top and update the value of top 
          T dataItem = array[top--];
          return dataItem;
          
     }

     public T peek() throws StackException{
          //if stack is empty throw Stack is empty
          if (isEmpty()){
               throw new StackException("Stack is empty");
          }
          //return element from top without remove
          return array[getTop()];
     }

     //return true if stack is empty
     public boolean isEmpty(){
          return (getTop() == -1);
     }

     //return how many element in stack
     public int size(){
          return getTop() + 1;
     }

     //clear all element andrestore original
     public void clear(){
          array = (T[]) new Object[10];
          top = -1;
     }

     //return length of array
     public int getCapacity(){
          return array.length;
     }

     //return element of top
     public int getTop(){
          return top;
     }

     public String toString(){
          //if stack is empty return Empty stack.
          if(isEmpty()){
               return "Empty stack.";
          }
          //build string beginning with Stack: 
          StringBuilder s = new StringBuilder("Stack: ");
          //stack from top to bottom
          for(int i = top; i > -1; i--){
               s.append(array[i]);
               //separated by a comma
               if(i >= 1){
                    s.append(", ");
               //add period at the end
               } else{
                    s.append(".");
               }
          }
          return s.toString();
     }

     private void expandCapacity() {
          //check the fraction of the array is being used 
          double fraction = (double) size() / getCapacity();
          // if the stack is at least 0.75, expand capacity by adding 10
          if (fraction >= 0.75) {
               T[] newArray = (T[]) new Object[getCapacity() + 10];
               for (int i = 0; i <= top; i++) {
                    newArray[i] = array[i];
               }
                    array = newArray;
          }
     }

     private void shrinkCapacity() {
          //check the fraction of the array is being used 
          double fraction = (double) size() / array.length;
          // If the stack is at most 0.25 or capacity less than 20, expand its capacity by removing 10
          if (fraction <= 0.25 && array.length >= getCapacity()) {
               T[] newArray = (T[]) new Object[getCapacity() - 10];
               for (int i = 0; i <= top; i++) {
                    newArray[i] = array[i];
               }
                    array = newArray;
          }
     }

}
