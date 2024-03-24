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

## How to Run

### Terminal:
- Compile: `javac *.java`
- Run: `java FindShortestPath dungeon1.txt`

### Eclipse:
- Method 1: Configure run configurations in Eclipse, ensuring files are in the correct directories.
- Method 2: Configure working directory in Eclipse run configurations, then run as usual.

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
