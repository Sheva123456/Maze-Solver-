package maze;
import java.util.ArrayList;

public class Maze2dArray implements Maze {

    // The maze that will be used during runtime
    private char[][] newmaze;
    private int rows;
    private int cols;

    // Keeps track of already generated node names to avoid duplicates
    ArrayList<String> generatedNodes = new ArrayList<>();

    // Default mazes for different sizes (10x10, 15x15, 20x20)
    private char[][] defaultmaze = {
            {'S', '1', '0', '1', '0', '1', '1', '1', '1', '1'},
            {'0', '1', '0', '1', '0', '0', '0', '0', '0', '1'},
            {'0', '1', '0', '1', '0', '1', '1', '1', '0', '1'},
            {'0', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '1', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1', '1', '1', '1', '0', '1'},
            {'1', '1', '0', '0', '0', '0', '0', '0', '0', 'E'},
    };

    private char[][] defaultmaze20 = {
            // 'S' = Start, 'E' = End, '1' = wall, '0' = path
            // this layout is customizable as desired
            {'S', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1'},
            {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
            {'1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '0', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '0', '1', '1', '0', '1', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '0', '1', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'E'}
    };

    private char[][] defaultmaze15 = {
            // 15x15 maze
            {'S', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '1'},
            {'1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '0', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1', '1', '1', '0', '0', '0', '1', '0', '1', '0', '1'},
            {'1', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', 'E'}
    };

    // Constructor for creating a blank maze of size n x n
    public Maze2dArray(int size) {
        newmaze = new char[size][size];
        rows = size;
        cols = size;

        // Initialize every cell to '0' (open path)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newmaze[i][j] = '0';
            }
        }
    }

    // Loads the corresponding default maze based on size
    public void loadDefaultMaze() {
        if (rows == 10) {
            newmaze = defaultmaze;

        } else if (rows == 20) {
            newmaze = defaultmaze20;

        } else if (rows == 15) {
            newmaze = defaultmaze15;

        } else {
            System.out.println("Unsupported maze size.");
        }
    }



    // Adds a wall at the specified location
    public void addWall(int row, int col) {
        if (isValid(row, col)) {
            newmaze[row][col] = '1';
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Removes a wall at the specified location
    public void removeWall(int row, int col) {
        if (isValid(row, col)) {
            newmaze[row][col] = '0';
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Sets the start point of the maze and clears any existing one
    public void setStart(int row, int col) {
        if (!isValid(row, col)) {
            System.out.println("Invalid position.");
            return;
        }

        // Clear existing start
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (newmaze[i][j] == 'S') newmaze[i][j] = '0';

        newmaze[row][col] = 'S';
    }

    // Sets the end point of the maze and clears any existing one
    public void setEnd(int row, int col) {
        if (!isValid(row, col)) {
            System.out.println("Invalid position.");
            return;
        }

        // Clear existing end
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (newmaze[i][j] == 'E') newmaze[i][j] = '0';

        newmaze[row][col] = 'E';
    }

    // Prints the current maze to console
    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(newmaze[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Adds a node to the list of generated nodes if it hasn't been added before
    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (generatedNodes.contains(name)) return;

        Node newNode = new Node(row, col, cost, name, parent);
        generatedNodes.add(name);
    }

    // Possible directions (up, down, left, right)
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    // Converts (row, col) to a string name like "q12"
    public String getNodeName(int i, int j) {
        return "q" + i + j;
    }

    // Returns the internal maze grid
    public char[][] getMaze() {
        return newmaze;
    }

    // Checks if a coordinate is within bounds
    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
