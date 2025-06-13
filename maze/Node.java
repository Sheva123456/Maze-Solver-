package maze;
public class Node {

    int row, col, cost;
    String name; // e.g., "q1", "S", "E"
    Node parent;


    public Node(int row, int col, int cost, String name, Node parent) {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.name = name;
        this.parent = parent;
    }


}
