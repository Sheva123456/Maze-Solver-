package maze;



import java.util.*;

public class Solver2dArrayPriorityQueue {
    private Maze_2d_list mazeObj;
    private char[][] maze;
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
    HashMap<String, Node> cameFrom = new HashMap<>();
    HashSet<String> visitedNodes = new HashSet();
    int rows ;
    int cols ;
    int currentRow;
    int currentColumn;

    public Solver2dArrayPriorityQueue(Maze_2d_list mazeObj){
        this.mazeObj = mazeObj;
        this.maze = mazeObj.getMaze();
        this.rows = maze.length;
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
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (maze[i][j] == 'S') {
                    currentRow = i;
                    currentColumn = j;
                }
            }
        }
    }

    public Node removeLowestCostNode() {
        return priorityQueue.poll();
    }

    public void solveMazeWithTimer() {
        long startTime = System.nanoTime();

        solve();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.printf("Maze solved in %.2f milliseconds.%n", duration / 1_000_000.0);
    }

    public void solve() {
        findStart();
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

                if (isValid(newRow, newCol) && (maze[newRow][newCol] == '0' || maze[newRow][newCol] == 'E')) {
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
            if (current != null && !current.name.equals("S")) {
                maze[current.row][current.col] = '.';
            }
        }

        System.out.println("Final path: " + finalPath);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public String getNodeName(int i, int j) {
        return maze[i][j] == 'E' ? "E" : "q" + i + j;
    }
}

