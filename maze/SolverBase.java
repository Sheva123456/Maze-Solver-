package maze;

public abstract class SolverBase {
    // Solves the maze while measuring and printing execution time

    public void solveMazeWithTimer() {
        long startTime = System.nanoTime();
        solve();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Solving time: " + duration + " ms");
    }


    public abstract void solve();
}
