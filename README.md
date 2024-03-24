# Dungeon Escape - Shortest Path Finder
Welcome to Dungeon Escape, a Java program designed to help warriors find the shortest path to escape the dungeons of the evil Black Queen! 🗡️🛡️

## About
Dungeon Escape is a Java application that assists warriors in navigating through hexagonal chambers within the dungeons. By utilizing a priority queue and an efficient algorithm, the program finds the shortest path from the initial chamber to the exit, avoiding dragon lairs and wall chambers along the way.

## Features
- **Priority Queue Implementation:** Utilizes a custom priority queue implemented with a doubly linked list.
- **Hexagonal Chamber Representation:** Chambers are represented using the `Hexagon` class, allowing for interaction with neighboring chambers and distance calculations.
- **Dungeon Representation:** The `Dungeon` class reads input files describing dungeon layouts and provides methods to retrieve the starting chamber.
- **Pathfinding Algorithm:** Implements an algorithm to find the shortest path from the initial chamber to the exit, prioritizing chambers based on distance to the exit and initial chamber while avoiding obstacles.
- **Exception Handling:** Handles various exceptions, such as invalid dungeon characters and empty priority queues.

## Requirements
- Java 8 or higher
- Eclipse IDE (optional)

## Usage
1. Clone or download the repository to your local machine.
2. Ensure you have the required input files containing dungeon layouts.
3. Open the project in Eclipse IDE or your preferred Java development environment.
4. Configure the project to include all provided Java files and input files.
5. Choose one of the provided input files (e.g., dungeon1.txt, dungeon2.txt) to analyze.
6. Run the `FindShortestPath.java` class.
7. Follow the prompts to input the desired dungeon file.
8. The program will display the shortest path information or indicate if no path is found.

## Example
```java
// Run the program to find the shortest path for the given dungeon layout
FindShortestPath.main(new String[]{"dungeon1.txt"});
```

## How to Run

### Terminal:
- Compile: `javac *.java`
- Run: `java FindShortestPath dungeon1.txt`

### Eclipse:
#### Method 1: Configure run configurations in Eclipse, ensuring files are in the correct directories.
**Put Files in src Folder:**
   - Place all provided Java files and your Java files inside the `src` folder of your project.
   - However, ensure that the image files and input dungeon files are **not** placed in the `src` folder. They should be in the project root folder, where `src` and the JRE System Library are located.
   - Select the `FindShortestPath.java` class in the Package Explorer.
   - Then, navigate to `Run` → `Run Configurations`.
   - In the window that opens, select `Arguments` and under "Working directory," choose `Other`.
   - Click on "File System" and select the folder where you have placed all your files.
   - After configuring the working directory, go back to the `Arguments` tab and in the `Program Arguments` box, enter the name of the input file (`dungeon1.txt`, `dungeon2.txt`, etc.).
   - Finally, click `Run` to execute the program.

#### Method 2: Configure working directory in Eclipse run configurations, then run as usual.
2. **Keep Files in the Same Directory:**
   - Place all provided files and your Java files in the same directory.
   - In Eclipse, select `Run` → `Run Configurations`.
   - In the window that opens, select `Arguments` and under "Working directory," select `Other`.
   - Click on "File System" and choose the folder where you have placed all your files.
   - Again, select the `FindShortestPath.java` class in the Package Explorer.
   - Go to `Run` → `Arguments` and in the `Program Arguments` box, enter the name of the input file (`dungeon1.txt`, `dungeon2.txt`, etc.).
   - Finally, click `Run` to execute the program.

By following these steps, you should be able to run the program smoothly in Eclipse. If you encounter any issues with Eclipse displaying the dungeons, ensure that your files are placed correctly and try the second method mentioned above.


## Input Files
The program expects input files describing dungeon layouts. These files contain characters representing chambers, dragons, walls, and the exit.

## Output
The program outputs the number of chambers in the shortest path from the initial chamber to the exit. If no path is found, it displays a corresponding message.

## Adding or Modifying Data
- **Adding New Dungeons:** Ensure new dungeon layouts are correctly formatted in input files.
- **Modifying Dungeons:** Edit input files to modify dungeon layouts or add new chambers.

## Guidelines
- Maintain consistency in data formatting and naming conventions.
- Create backups of original input files before making modifications.
- Verify accuracy of added or modified data.

## Contributing
Contributions to Dungeon Escape are welcome! Please refer to the contributing guidelines for more information.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or suggestions regarding Dungeon Escape, feel free to reach out.

Happy dungeon escaping! 🗝️🚪
