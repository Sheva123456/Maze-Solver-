package maze;

public interface Maze {

    void addWall(int row, int col);
    void removeWall(int row, int col);
    void loadDefaultMaze();
    void printMaze();
}

