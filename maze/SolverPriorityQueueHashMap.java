package maze;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;


public class SolverPriorityQueueHashMap {

    private MazeHashMap mazeObj;
    private Map<String, Character> maze;
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

    HashMap<String, Node> cameFrom = new HashMap();
    HashSet<String> visitedNodes = new HashSet();
    int rows ;
    int cols ;
    int currentRow;
    int currentColumn;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public SolverPriorityQueueHashMap(MazeHashMap mazeObj) {
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();
        this.rows = mazeObj.getRows();
        this.cols = rows;
    }

    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (!this.visitedNodes.contains(name)) {
            Node newNode = new Node(row, col, cost, name, parent);
            this.priorityQueue.add(newNode);
            this.cameFrom.put(name, parent);
            this.visitedNodes.add(name);
        }

    }

    public void findStart() {
        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                if ((Character)this.maze.get(this.key(i, j)) == 'S') {
                    this.currentRow = i;
                    this.currentColumn = j;
                }
            }
        }

    }

    public Node removeLowestCostNode() {
        return (Node)this.priorityQueue.poll();
    }

    public void solveMazeWithTimer() {
        long startTime = System.nanoTime(); // Start timer


        solve();

        long endTime = System.nanoTime(); // End timer
        long duration = endTime - startTime;

        System.out.printf("Maze solved in %.2f milliseconds.%n", duration / 1_000_000.0);
    }
    public void solve() {
        this.findStart();
        Node startNode = new Node(this.currentRow, this.currentColumn, 0, "S", (Node)null);
        this.priorityQueue.add(startNode);
        this.cameFrom.put("S", null);
        this.visitedNodes.add("S");

        while(!this.priorityQueue.isEmpty()) {
            Node current = this.removeLowestCostNode();
            if ((Character)this.maze.get(this.key(current.row, current.col)) == 'E') {
                System.out.println("Reached the End!");
                this.traceBackPath(current);
                return;
            }

            for(int[] dir : this.directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                if (this.isValid(newRow, newCol) && ((Character)this.maze.get(this.key(newRow, newCol)) == '0' || (Character)this.maze.get(this.key(newRow, newCol)) == 'E')) {
                    String nodeName = this.getNodeName(newRow, newCol);
                    int newCost = current.cost + 1;
                    this.addNode(newRow, newCol, newCost, nodeName, current);
                }
            }
        }

        System.out.println("No path to end found.");
    }

    public void traceBackPath(Node end) {
        LinkedList<String> finalPath = new LinkedList();
        Node current = end;

        while(current != null) {
            finalPath.addFirst(current.name);
            current = (Node)this.cameFrom.get(current.name);
            if (current != null && !current.name.equals("S")) {
                this.maze.put(this.key(current.row, current.col), '.');
            }
        }

        System.out.println("Final path: " + String.valueOf(finalPath));

        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                PrintStream var10000 = System.out;
                Map var10001 = this.maze;
                String var10002 = this.key(i, j);
                var10000.print(String.valueOf(var10001.get(var10002)) + " ");
            }

            System.out.println();
        }

    }

    public boolean isValid(int i, int j) {
        return i >= 0 && i < this.rows && j >= 0 && j < this.cols;
    }

    public String getNodeName(int i, int j) {
        return (Character)this.maze.get(this.key(i, j)) == 'E' ? "E" : "q" + i + j;
    }

    private String key(int row, int col) {
        return row + "," + col;
    }
}
