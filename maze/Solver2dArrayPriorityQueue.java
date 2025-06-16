package maze;

import java.util.*;

public class Solver2dArrayPriorityQueue extends SolverBase {
    private Maze2dArray mazeObj;                // Object holding the 2D char maze
    private char[][] maze;                       // 2D array representation of the maze
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost)); // Min-heap based on cost
    HashMap<String, Node> cameFrom = new HashMap<>();    // Tracks parent nodes for path reconstruction
    ArrayList<String> visitedNodes = new ArrayList<>();  // Prevents revisiting nodes (should be HashSet for performance)

    int rows;            // Number of rows in maze
    int cols;            // Number of columns in maze
    int currentRow;      // Start row
    int currentColumn;   // Start column

    // Directions: up, down, left, right
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    // Constructor
    public Solver2dArrayPriorityQueue(Maze2dArray mazeObj) {
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();
        this.rows = maze.length;
        this.cols = rows; // Assumes square maze
    }

    // Adds a node to the priority queue if it hasn't been visited
    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (visitedNodes.contains(name)) return;

        Node newNode = new Node(row, col, cost, name, parent);
        priorityQueue.add(newNode);            // Insert into priority queue (min-heap)
        cameFrom.put(name, parent);            // Store where it came from
        visitedNodes.add(name);                // Mark as visited
    }


    // Removes the node with the lowest cost from the priority queue
    public Node removeLowestCostNode() {
        return priorityQueue.poll(); // Automatically retrieves lowest-cost node
    }



    // Solves the maze using uniform-cost search (Dijkstra-like logic)
    public void solve() {
        currentRow = 0;
        currentColumn= 0;// Set currentRow and currentColumn
        Node startNode = new Node(currentRow, currentColumn, 0, "S", null);
        priorityQueue.add(startNode);
        cameFrom.put("S", null);
        visitedNodes.add("S");

        while (!priorityQueue.isEmpty()) {
            Node current = removeLowestCostNode();

            // If we reached the end node
            if (maze[current.row][current.col] == 'E') {
                System.out.println("Reached the End!");
                traceBackPath(current);
                return;
            }

            // Explore neighbors
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

    // Traces back the final path from the end node and marks it on the maze
    public void traceBackPath(Node end) {
        LinkedList<String> finalPath = new LinkedList<>();
        Node current = end;

        while (current != null) {
            finalPath.addFirst(current.name);
            current = cameFrom.get(current.name);

            if (current != null && !current.name.equals("S")) {
                maze[current.row][current.col] = '.'; // Mark the path
            }
        }

        System.out.println("Final path: " + finalPath);
        System.out.println("Solved in " + finalPath.size() +" steps");
        // Print the maze with the path
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Checks if a position is inside the maze bounds
    public boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    // Generates a unique name for a node at a position
    public String getNodeName(int i, int j) {
        return maze[i][j] == 'E' ? "E" : "q" + i + j;
    }
}
