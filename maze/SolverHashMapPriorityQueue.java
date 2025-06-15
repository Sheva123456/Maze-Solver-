package maze;

import java.util.*;

public class SolverHashMapPriorityQueue extends SolverBase {

    private MazeHashMap mazeObj;                  // Maze object containing structure and size
    private Map<String, Character> maze;          // The actual maze grid stored as a HashMap
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost)); // Min-heap based on cost

    HashMap<String, Node> cameFrom = new HashMap<>(); // Tracks path (child -> parent)
    ArrayList<String> visitedNodes = new ArrayList<>(); // Prevents revisiting nodes
    int rows; // Number of rows in maze
    int cols; // Number of cols in maze
    int currentRow; // Starting row
    int currentColumn; // Starting column

    // Directions for movement: up, down, left, right
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Constructor
    public SolverHashMapPriorityQueue(MazeHashMap mazeObj) {
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();
        this.rows = mazeObj.getRows();
        this.cols = rows; // Assuming square maze
    }

    // Adds a new node to the queue if not visited yet
    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (!this.visitedNodes.contains(name)) {
            Node newNode = new Node(row, col, cost, name, parent);
            this.priorityQueue.add(newNode);
            this.cameFrom.put(name, parent);
            this.visitedNodes.add(name);
        }
    }

    // Finds the starting position 'S' in the maze
    public void findStart() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                if (this.maze.get(this.key(i, j)) == 'S') {
                    this.currentRow = i;
                    this.currentColumn = j;
                }
            }
        }
    }

    // Removes and returns the node with the lowest cost from the queue
    public Node removeLowestCostNode() {
        return this.priorityQueue.poll();
    }



    // Core Dijkstra-style solving logic
    public void solve() {
        this.findStart(); // Locate the start
        Node startNode = new Node(this.currentRow, this.currentColumn, 0, "S", null);
        this.priorityQueue.add(startNode);
        this.cameFrom.put("S", null);
        this.visitedNodes.add("S");

        while (!this.priorityQueue.isEmpty()) {
            Node current = this.removeLowestCostNode();

            // Check if we reached the end
            if (this.maze.get(this.key(current.row, current.col)) == 'E') {
                System.out.println("Reached the End!");
                this.traceBackPath(current);
                return;
            }

            // Explore neighbors
            for (int[] dir : this.directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                // Only move to walkable tiles ('0') or the end ('E')
                if (this.isValid(newRow, newCol) &&
                        (this.maze.get(this.key(newRow, newCol)) == '0' || this.maze.get(this.key(newRow, newCol)) == 'E')) {

                    String nodeName = this.getNodeName(newRow, newCol);
                    int newCost = current.cost + 1;
                    this.addNode(newRow, newCol, newCost, nodeName, current);
                }
            }
        }

        System.out.println("No path to end found.");
    }

    // Traces the path from end node back to start using cameFrom map
    public void traceBackPath(Node end) {
        LinkedList<String> finalPath = new LinkedList<>();
        Node current = end;

        while (current != null) {
            finalPath.addFirst(current.name);
            current = this.cameFrom.get(current.name);

            // Mark the path with '.' except for start
            if (current != null && !current.name.equals("S")) {
                this.maze.put(this.key(current.row, current.col), '.');
            }
        }

        System.out.println("Final path: " + finalPath);

        // Print the final maze with path
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                System.out.print(this.maze.get(this.key(i, j)) + " ");
            }
            System.out.println();
        }
    }

    // Checks if position is within maze bounds
    public boolean isValid(int i, int j) {
        return i >= 0 && i < this.rows && j >= 0 && j < this.cols;
    }

    // Gets a unique node name. 'E' if it's the end, otherwise a generated label like q23
    public String getNodeName(int i, int j) {
        return this.maze.get(this.key(i, j)) == 'E' ? "E" : "q" + i + j;
    }

    // Converts (row, col) to a string key for HashMap access
    private String key(int row, int col) {
        return row + "," + col;
    }
}
