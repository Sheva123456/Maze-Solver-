package maze;
import java.util.ArrayList;

public class Maze_2d_list {


    private char[][] newmaze ;
    private int rows ;
    private int cols;

    ArrayList<String> generatedNodes = new ArrayList<>();


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
    public Maze_2d_list(int size) {  //loads a new maze filled with 0's
            newmaze = new char[size][size];
            rows = size;
            cols= rows;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    newmaze[i][j] = '0';
                }
            }
    }

    public void loadDefaultMaze() {
        if (rows == 10) {
            newmaze = new char[10][10];
            copyMaze(defaultmaze, newmaze);
        } else if (rows == 20) {
            newmaze = new char[20][20];
            copyMaze(defaultmaze20, newmaze);
        } else if (rows == 15) {
            newmaze = new char[15][15];
            copyMaze(defaultmaze15, newmaze);
        } else {
            System.out.println("Unsupported maze size.");
        }
    }
    private void copyMaze(char[][] source, char[][] target) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                target[i][j] = source[i][j];
            }
        }
    }
    public void addWall(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            newmaze[row][col] = '1';
        }
        else {
            System.out.println("Invalid position.");
        }
    }
    public void removeWall(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            newmaze[row][col] = '0';
        }
        else {
            System.out.println("Invalid position.");
        }
    }
    public void setStart(int row, int col) {
        if (!(row >= 0 && row < rows && col >= 0 && col < cols)) {
            System.out.println("Invalid position.");
            return;

        }
        for (int i=0;i<rows;i++){  //checks to see if another Start exists, if so it replaces it with 0
            for(int j=0;j<cols;j++){
                if(newmaze[i][j]=='S'){
                    newmaze[i][j] ='0';
                }
            }
        }
        newmaze[row][col] = 'S'; //adds the Start
    }
    public void setEnd(int row, int col) {
        if (!(row >= 0 && row < rows && col >= 0 && col < cols)) {
            System.out.println("Invalid position.");
            return;

        }
        for (int i=0;i<rows;i++){  //checks to see if another End exists, if so it replaces it with 0
            for(int j=0;j<cols;j++){
                if(newmaze[i][j]=='E'){
                    newmaze[i][j] ='0';
                }
            }
        }
        newmaze[row][col] = 'E';
    }
    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(newmaze[i][j] + " ");
            }
            System.out.println();

        }
    }
    public void addNode(int row, int col, int cost, String name, Node parent) {
        if (generatedNodes.contains(name)) return;

        Node newNode = new Node(row, col, cost, name, parent);
        generatedNodes.add(name);
    }

    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };


    public String getNodeName(int i, int j) {

        return "q" + i + j;

    }




    public char[][] getMaze() {
        return newmaze;
    }




}
