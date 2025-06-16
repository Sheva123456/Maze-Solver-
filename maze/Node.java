package maze;

public class Node {

    int row, col;        // Position of the node in the maze
    int cost;            // Cost to reach this node (e.g., distance from start)
    String name;         // Optional name or type (e.g., "S" for start, "E" for end)
    Node parent;         // Reference to the previous node (for path reconstruction)

    // Constructor to initialize the node
    public Node(int row, int col, int cost, String name, Node parent) {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.name = name;
        this.parent = parent;
    }
}
