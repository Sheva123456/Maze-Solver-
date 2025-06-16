package maze;

import java.util.*;

public class Solver2dArrayArraylist extends SolverBase {
    private Maze2dArray mazeObj;                // Maze object holding the 2D array maze
    private char[][] maze;                       // 2D array representation of the maze
    ArrayList<Node> priorityQueue = new ArrayList<>(); // Acts as a manual priority queue
    HashMap<String, Node> cameFrom = new HashMap<>();  // For tracing back the final path
    ArrayList<String> visitedNodes = new ArrayList<>(); // Stores visited node names

    int rows;          // Maze row count
    int cols;          // Maze column count
    int currentRow;    // Start row
    int currentColumn; // Start column

    // Constructor
    public Solver2dArrayArraylist(Maze2dArray mazeObj) {
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();   // Use 2D array
        this.rows = maze.length;
        this.cols = maze[0].length;      // Support rectangular mazes
    }

    // Adds a new node to the frontier if it's not visited
    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (visitedNodes.contains(name)) return;

        Node newNode = new Node(row, col, cost, name, parent);
        priorityQueue.add(newNode);
        cameFrom.put(name, parent);
        visitedNodes.add(name);
    }


    // Finds and removes the node with the lowest cost in the frontier
    public Node removeLowestCostNode() {
        if (priorityQueue.isEmpty()) return null;

        Node lowest = priorityQueue.get(0);
        int lowestIndex = 0;

        for (int i = 1; i < priorityQueue.size(); i++) {
            Node current = priorityQueue.get(i);
            if (current.cost < lowest.cost) {
                lowest = current;
                lowestIndex = i;
            }
        }

        return priorityQueue.remove(lowestIndex);
    }




    // Solves the maze using a manual priority queue and BFS-style expansion
    public void solve() {
        currentRow = 0;
        currentColumn = 0;

        Node startNode = new Node(currentRow, currentColumn, 0, "S", null);
        priorityQueue.add(startNode);
        cameFrom.put("S", null);
        visitedNodes.add("S");

        while (!priorityQueue.isEmpty()) {
            Node current = removeLowestCostNode();

            if (maze[current.row][current.col] == 'E') {
                System.out.println("Reached the End!");
                traceBackPath(current);
                return;
            }

            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (isValid(newRow, newCol) &&
                        (maze[newRow][newCol] == '0' || maze[newRow][newCol] == 'E')) {

                    String nodeName = getNodeName(newRow, newCol);
                    int newCost = current.cost + 1;

                    addNode(newRow, newCol, newCost, nodeName, current);
                }
            }
        }

        System.out.println("No path to end found.");
    }

    // Directions: up, down, left, right
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    // Traces back from the end node to start and marks path with '.'
    public void traceBackPath(Node end) {
        LinkedList<String> finalPath = new LinkedList<>();
        Node current = end;

        while (current != null) {
            finalPath.addFirst(current.name);
            current = cameFrom.get(current.name);

            if (current != null && !current.name.equals("S")) {
                maze[current.row][current.col] = '.'; // Mark path
            }
        }

        System.out.println("Final path: " + finalPath);
        System.out.println("Solved in " + finalPath.size() +" steps");

        // Print the maze with path
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Checks if row and column are inside the maze boundaries
    public boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    // Generates a unique string name for a node based on its position
    public String getNodeName(int i, int j) {
        if (maze[i][j] == 'E') return "E";
        return "q" + i + j;
    }
}
