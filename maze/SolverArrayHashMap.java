package maze;
import java.util.*;

public class SolverArrayHashMap {
    private MazeHashMap mazeObj;
    private Map<String, Character> maze;
    ArrayList<Node> priorityQueue = new ArrayList<>();
    HashMap<String, Node> cameFrom = new HashMap<>();
    HashSet<String> visitedNodes = new HashSet();// To prevent duplicate nodes
    int rows ;
    int cols;
    int currentRow;
    int currentColumn;

    public SolverArrayHashMap(MazeHashMap mazeObj){
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();
        this.rows = mazeObj.getRows();
        this.cols = rows;
    }

    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (visitedNodes.contains(name)) return;

        Node newNode = new Node(row, col, cost, name, parent);
        priorityQueue.add(newNode);
        cameFrom.put(name, parent);

        visitedNodes.add(name);
    }
    public void findStart(){
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if ((maze.get(key(i, j)) == 'S')){
                    currentRow = i;
                    currentColumn = j;}
            }
        }}
    public Node removeLowestCostNode() {
        if (priorityQueue.isEmpty()) {
            return null;
        }

        Node lowest = priorityQueue.get(0);
        int lowestIndex = 0;

        for (int i = 1; i < priorityQueue.size(); i++) {
            Node current = priorityQueue.get(i);
            if (current.cost < lowest.cost) {
                lowest = current;
                lowestIndex = i;
            }
        }


        return priorityQueue.remove(lowestIndex); // remove and return the lowest-cost node
    }
    public void solveMazeWithTimer() {
        long startTime = System.nanoTime(); // Start timer
        solve();

        long endTime = System.nanoTime(); // End timer
        long duration = endTime - startTime;

        System.out.printf("Maze solved in %.2f milliseconds.%n", duration / 1_000_000.0);
    }
    public void solve() {
        findStart(); // sets currentRow, currentCol
        Node startNode = new Node(currentRow, currentColumn, 0, "S", null);
        priorityQueue.add(startNode);
        cameFrom.put("S", null);
        visitedNodes.add("S");

        while (!priorityQueue.isEmpty()) {
            // Step 1: get and remove the lowest-cost node
            Node current = removeLowestCostNode();

            // Step 2: if it's the end, trace the path
            if (maze.get(key(current.row, current.col))== 'E') {
                System.out.println("Reached the End!");
                traceBackPath(current);
                return;
            }

            // Step 3: expand the node in all directions
            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (isValid(newRow, newCol) && (maze.get(key(newRow, newCol)) == '0' || maze.get(key(newRow, newCol))  == 'E')) {
                    String nodeName = getNodeName(newRow, newCol);
                    int newCost = current.cost + 1;
                    addNode(newRow, newCol, newCost, nodeName, current);
                }
            }
        }

        System.out.println("No path to end found.");
    }
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // up, down, left, right

    public void traceBackPath(Node end) {
        LinkedList<String> finalPath = new LinkedList<>();
        Node current = end;

        while (current != null) {
            finalPath.addFirst(current.name);
            current = cameFrom.get(current.name);

            if (current != null && !current.name.equals("S") ){
                maze.put(key(current.row, current.col),'.');
            }
        }

        System.out.println("Final path: " + finalPath);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze.get(key(i, j))+" ");
            }
            System.out.println();

        }
    }


    public boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public String getNodeName(int i, int j) {
        if (maze.get(key(i,j)) == 'E') return "E";
        return "q" + i + j;
    }
    private String key(int row, int col) {
        return row + "," + col;
    }
}

