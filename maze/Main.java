package maze;
public class Main {
    public static void main(String[] args) {
        Maze_2d_list maze = new Maze_2d_list(15);
        maze.loadDefaultMaze();
        System.out.println("Arraylist 2d Array maze:");
        Solver2dArrayArray  solver = new Solver2dArrayArray(maze);
        solver.solveMazeWithTimer();
        System.out.println("");


        //-------------------------------------
        System.out.println("Priority Q Array maze:");
        Maze_2d_list maze4 = new Maze_2d_list(15);
        maze4.loadDefaultMaze();
        Solver2dArrayPriorityQueue solver4 = new Solver2dArrayPriorityQueue(maze4);
        solver4.solveMazeWithTimer();
        System.out.println("");

        //--------------------------------
        System.out.println("Hashmap 2d Array maze:");
        MazeHashMap maze2 = new MazeHashMap(15);
        maze2.loadDefaultMaze();





        SolverArrayHashMap solver2 = new SolverArrayHashMap(maze2);
        solver2.solveMazeWithTimer();

        System.out.println("");
        //-------------------------------------
        System.out.println("Priority Q Hashmap maze:");
        MazeHashMap maze3 = new MazeHashMap(15);

        maze3.loadDefaultMaze();


        SolverPriorityQueueHashMap solver3 = new SolverPriorityQueueHashMap(maze3);
        solver3.solveMazeWithTimer();

        System.out.println("");
        //------------------------------------------

    }
}