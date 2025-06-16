package maze;

public class Main {
    public static void main(String[] args) {

        // --- Warmup 1 ---
        Maze2dArray maze = new Maze2dArray(20);
        System.out.println("Warm up 1:");
        maze.loadDefaultMaze();

        SolverBase solver1 = new Solver2dArrayArraylist(maze);
        solver1.solve();
        System.out.println("");

        // --- Warmup 2 :
        System.out.println("Warm up 2:");
        Maze2dArray maze2 = new Maze2dArray(20);
        maze2.loadDefaultMaze();

        SolverBase solver2 = new Solver2dArrayPriorityQueue(maze2);
        solver2.solve();
        System.out.println("");

        // --- Final Tests -------------------------------------------------------------------------------

        System.out.println("2d Array Priority Queue:");

        // --- Memory Tracking Start ---
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();


        // --- Maze Setup ---
        MazeHashMap maze3 = new MazeHashMap(20);      // 20x20 maze stored in 2D array
        maze3.loadDefaultMaze();
        SolverBase solver3 = new SolverHashMapPriorityQueue(maze3); // Uses priority queue

        // --- Add Wall ---
        maze3.addWall(5, 5);

        // --- Remove Wall ---
        maze3.removeWall(5, 5);

        // --- Solve Maze ---

        solver3.solveMazeWithTimer();

        long endMem = runtime.totalMemory() - runtime.freeMemory();
        // --- Memory Tracking End ---

        long memoryUsed = endMem - startMem;


        System.out.println("Total memory used for full process: " + memoryUsed + " bytes (" + (memoryUsed / 1024.0) + " KB)");

        System.out.println("");


        // -- All tests complete --
    }
}
