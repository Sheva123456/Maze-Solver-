package maze;
import java.util.HashMap;
import java.util.Map;

public class MazeHashMap {
    private int rows;
    private int cols;
    private Map<String, Character> maze = new HashMap<>();

    private final Map<String, Character> defaultMaze10 = Map.ofEntries(
            Map.entry("0,0", 'S'), Map.entry("0,1", '1'), Map.entry("0,2", '0'), Map.entry("0,3", '1'),
            Map.entry("0,4", '0'), Map.entry("0,5", '1'), Map.entry("0,6", '1'), Map.entry("0,7", '1'),
            Map.entry("0,8", '1'), Map.entry("0,9", '1'),

            Map.entry("1,0", '0'), Map.entry("1,1", '1'), Map.entry("1,2", '0'), Map.entry("1,3", '1'),
            Map.entry("1,4", '0'), Map.entry("1,5", '0'), Map.entry("1,6", '0'), Map.entry("1,7", '0'),
            Map.entry("1,8", '0'), Map.entry("1,9", '1'),

            Map.entry("2,0", '0'), Map.entry("2,1", '1'), Map.entry("2,2", '0'), Map.entry("2,3", '1'),
            Map.entry("2,4", '0'), Map.entry("2,5", '1'), Map.entry("2,6", '1'), Map.entry("2,7", '1'),
            Map.entry("2,8", '0'), Map.entry("2,9", '1'),

            Map.entry("3,0", '0'), Map.entry("3,1", '0'), Map.entry("3,2", '0'), Map.entry("3,3", '0'),
            Map.entry("3,4", '0'), Map.entry("3,5", '0'), Map.entry("3,6", '0'), Map.entry("3,7", '1'),
            Map.entry("3,8", '0'), Map.entry("3,9", '1'),

            Map.entry("4,0", '1'), Map.entry("4,1", '1'), Map.entry("4,2", '1'), Map.entry("4,3", '1'),
            Map.entry("4,4", '1'), Map.entry("4,5", '1'), Map.entry("4,6", '0'), Map.entry("4,7", '1'),
            Map.entry("4,8", '0'), Map.entry("4,9", '1'),

            Map.entry("5,0", '1'), Map.entry("5,1", '0'), Map.entry("5,2", '0'), Map.entry("5,3", '0'),
            Map.entry("5,4", '0'), Map.entry("5,5", '0'), Map.entry("5,6", '0'), Map.entry("5,7", '1'),
            Map.entry("5,8", '0'), Map.entry("5,9", '1'),

            Map.entry("6,0", '1'), Map.entry("6,1", '0'), Map.entry("6,2", '1'), Map.entry("6,3", '1'),
            Map.entry("6,4", '1'), Map.entry("6,5", '1'), Map.entry("6,6", '1'), Map.entry("6,7", '1'),
            Map.entry("6,8", '0'), Map.entry("6,9", '1'),

            Map.entry("7,0", '1'), Map.entry("7,1", '0'), Map.entry("7,2", '0'), Map.entry("7,3", '0'),
            Map.entry("7,4", '0'), Map.entry("7,5", '0'), Map.entry("7,6", '0'), Map.entry("7,7", '0'),
            Map.entry("7,8", '0'), Map.entry("7,9", '1'),

            Map.entry("8,0", '1'), Map.entry("8,1", '1'), Map.entry("8,2", '0'), Map.entry("8,3", '1'),
            Map.entry("8,4", '1'), Map.entry("8,5", '1'), Map.entry("8,6", '1'), Map.entry("8,7", '1'),
            Map.entry("8,8", '0'), Map.entry("8,9", '1'),

            Map.entry("9,0", '1'), Map.entry("9,1", '1'), Map.entry("9,2", '0'), Map.entry("9,3", '0'),
            Map.entry("9,4", '0'), Map.entry("9,5", '0'), Map.entry("9,6", '0'), Map.entry("9,7", '0'),
            Map.entry("9,8", '0'), Map.entry("9,9", 'E')
    );
    private final Map<String, Character> defaultMaze20 = Map.ofEntries(
            // Row 0
            Map.entry("0,0", 'S'), Map.entry("0,1", '0'), Map.entry("0,2", '1'), Map.entry("0,3", '1'),
            Map.entry("0,4", '1'), Map.entry("0,5", '1'), Map.entry("0,6", '1'), Map.entry("0,7", '1'),
            Map.entry("0,8", '1'), Map.entry("0,9", '1'), Map.entry("0,10", '1'), Map.entry("0,11", '1'),
            Map.entry("0,12", '1'), Map.entry("0,13", '1'), Map.entry("0,14", '1'), Map.entry("0,15", '1'),
            Map.entry("0,16", '1'), Map.entry("0,17", '1'), Map.entry("0,18", '1'), Map.entry("0,19", '1'),

            // Row 1
            Map.entry("1,0", '1'), Map.entry("1,1", '0'), Map.entry("1,2", '0'), Map.entry("1,3", '0'),
            Map.entry("1,4", '0'), Map.entry("1,5", '0'), Map.entry("1,6", '0'), Map.entry("1,7", '0'),
            Map.entry("1,8", '1'), Map.entry("1,9", '0'), Map.entry("1,10", '0'), Map.entry("1,11", '0'),
            Map.entry("1,12", '0'), Map.entry("1,13", '0'), Map.entry("1,14", '0'), Map.entry("1,15", '0'),
            Map.entry("1,16", '0'), Map.entry("1,17", '0'), Map.entry("1,18", '0'), Map.entry("1,19", '1'),

            // Row 2
            Map.entry("2,0", '1'), Map.entry("2,1", '0'), Map.entry("2,2", '1'), Map.entry("2,3", '0'),
            Map.entry("2,4", '1'), Map.entry("2,5", '1'), Map.entry("2,6", '1'), Map.entry("2,7", '1'),
            Map.entry("2,8", '1'), Map.entry("2,9", '1'), Map.entry("2,10", '1'), Map.entry("2,11", '1'),
            Map.entry("2,12", '1'), Map.entry("2,13", '1'), Map.entry("2,14", '1'), Map.entry("2,15", '1'),
            Map.entry("2,16", '1'), Map.entry("2,17", '1'), Map.entry("2,18", '0'), Map.entry("2,19", '1'),

            // Row 3
            Map.entry("3,0", '1'), Map.entry("3,1", '0'), Map.entry("3,2", '1'), Map.entry("3,3", '0'),
            Map.entry("3,4", '0'), Map.entry("3,5", '0'), Map.entry("3,6", '0'), Map.entry("3,7", '0'),
            Map.entry("3,8", '0'), Map.entry("3,9", '0'), Map.entry("3,10", '0'), Map.entry("3,11", '0'),
            Map.entry("3,12", '0'), Map.entry("3,13", '0'), Map.entry("3,14", '0'), Map.entry("3,15", '0'),
            Map.entry("3,16", '0'), Map.entry("3,17", '1'), Map.entry("3,18", '0'), Map.entry("3,19", '1'),

            // Row 4
            Map.entry("4,0", '1'), Map.entry("4,1", '0'), Map.entry("4,2", '1'), Map.entry("4,3", '1'),
            Map.entry("4,4", '1'), Map.entry("4,5", '1'), Map.entry("4,6", '1'), Map.entry("4,7", '1'),
            Map.entry("4,8", '1'), Map.entry("4,9", '1'), Map.entry("4,10", '1'), Map.entry("4,11", '1'),
            Map.entry("4,12", '1'), Map.entry("4,13", '1'), Map.entry("4,14", '1'), Map.entry("4,15", '1'),
            Map.entry("4,16", '0'), Map.entry("4,17", '1'), Map.entry("4,18", '0'), Map.entry("4,19", '1'),

            // Row 5
            Map.entry("5,0", '1'), Map.entry("5,1", '0'), Map.entry("5,2", '0'), Map.entry("5,3", '0'),
            Map.entry("5,4", '0'), Map.entry("5,5", '0'), Map.entry("5,6", '0'), Map.entry("5,7", '0'),
            Map.entry("5,8", '0'), Map.entry("5,9", '0'), Map.entry("5,10", '0'), Map.entry("5,11", '0'),
            Map.entry("5,12", '0'), Map.entry("5,13", '0'), Map.entry("5,14", '0'), Map.entry("5,15", '1'),
            Map.entry("5,16", '0'), Map.entry("5,17", '1'), Map.entry("5,18", '0'), Map.entry("5,19", '1'),

            // Row 6
            Map.entry("6,0", '1'), Map.entry("6,1", '1'), Map.entry("6,2", '1'), Map.entry("6,3", '1'),
            Map.entry("6,4", '1'), Map.entry("6,5", '1'), Map.entry("6,6", '1'), Map.entry("6,7", '1'),
            Map.entry("6,8", '1'), Map.entry("6,9", '1'), Map.entry("6,10", '1'), Map.entry("6,11", '1'),
            Map.entry("6,12", '1'), Map.entry("6,13", '1'), Map.entry("6,14", '0'), Map.entry("6,15", '1'),
            Map.entry("6,16", '0'), Map.entry("6,17", '1'), Map.entry("6,18", '0'), Map.entry("6,19", '1'),

            // Row 7
            Map.entry("7,0", '1'), Map.entry("7,1", '0'), Map.entry("7,2", '0'), Map.entry("7,3", '0'),
            Map.entry("7,4", '0'), Map.entry("7,5", '0'), Map.entry("7,6", '0'), Map.entry("7,7", '0'),
            Map.entry("7,8", '0'), Map.entry("7,9", '0'), Map.entry("7,10", '0'), Map.entry("7,11", '0'),
            Map.entry("7,12", '0'), Map.entry("7,13", '0'), Map.entry("7,14", '0'), Map.entry("7,15", '1'),
            Map.entry("7,16", '0'), Map.entry("7,17", '1'), Map.entry("7,18", '0'), Map.entry("7,19", '1'),

            // Row 8
            Map.entry("8,0", '1'), Map.entry("8,1", '0'), Map.entry("8,2", '1'), Map.entry("8,3", '1'),
            Map.entry("8,4", '1'), Map.entry("8,5", '1'), Map.entry("8,6", '1'), Map.entry("8,7", '1'),
            Map.entry("8,8", '1'), Map.entry("8,9", '0'), Map.entry("8,10", '1'), Map.entry("8,11", '1'),
            Map.entry("8,12", '0'), Map.entry("8,13", '1'), Map.entry("8,14", '0'), Map.entry("8,15", '1'),
            Map.entry("8,16", '0'), Map.entry("8,17", '1'), Map.entry("8,18", '0'), Map.entry("8,19", '1'),

            // Row 9
            Map.entry("9,0", '1'), Map.entry("9,1", '0'), Map.entry("9,2", '1'), Map.entry("9,3", '0'),
            Map.entry("9,4", '0'), Map.entry("9,5", '0'), Map.entry("9,6", '0'), Map.entry("9,7", '0'),
            Map.entry("9,8", '0'), Map.entry("9,9", '0'), Map.entry("9,10", '0'), Map.entry("9,11", '1'),
            Map.entry("9,12", '0'), Map.entry("9,13", '1'), Map.entry("9,14", '0'), Map.entry("9,15", '1'),
            Map.entry("9,16", '0'), Map.entry("9,17", '1'), Map.entry("9,18", '0'), Map.entry("9,19", '1'),

            // Row 10
            Map.entry("10,0", '1'), Map.entry("10,1", '0'), Map.entry("10,2", '1'), Map.entry("10,3", '0'),
            Map.entry("10,4", '1'), Map.entry("10,5", '1'), Map.entry("10,6", '1'), Map.entry("10,7", '1'),
            Map.entry("10,8", '1'), Map.entry("10,9", '1'), Map.entry("10,10", '0'), Map.entry("10,11", '1'),
            Map.entry("10,12", '0'), Map.entry("10,13", '1'), Map.entry("10,14", '0'), Map.entry("10,15", '1'),
            Map.entry("10,16", '0'), Map.entry("10,17", '1'), Map.entry("10,18", '0'), Map.entry("10,19", '1'),

            // Row 11
            Map.entry("11,0", '1'), Map.entry("11,1", '0'), Map.entry("11,2", '1'), Map.entry("11,3", '0'),
            Map.entry("11,4", '1'), Map.entry("11,5", '0'), Map.entry("11,6", '0'), Map.entry("11,7", '0'),
            Map.entry("11,8", '0'), Map.entry("11,9", '1'), Map.entry("11,10", '0'), Map.entry("11,11", '1'),
            Map.entry("11,12", '0'), Map.entry("11,13", '1'), Map.entry("11,14", '0'), Map.entry("11,15", '0'),
            Map.entry("11,16", '0'), Map.entry("11,17", '1'), Map.entry("11,18", '0'), Map.entry("11,19", '1'),

            // Row 12
            Map.entry("12,0", '1'), Map.entry("12,1", '0'), Map.entry("12,2", '1'), Map.entry("12,3", '0'),
            Map.entry("12,4", '1'), Map.entry("12,5", '0'), Map.entry("12,6", '1'), Map.entry("12,7", '1'),
            Map.entry("12,8", '0'), Map.entry("12,9", '1'), Map.entry("12,10", '0'), Map.entry("12,11", '0'),
            Map.entry("12,12", '0'), Map.entry("12,13", '0'), Map.entry("12,14", '0'), Map.entry("12,15", '1'),
            Map.entry("12,16", '0'), Map.entry("12,17", '1'), Map.entry("12,18", '0'), Map.entry("12,19", '1'),

            // Row 13
            Map.entry("13,0", '1'), Map.entry("13,1", '0'), Map.entry("13,2", '1'), Map.entry("13,3", '0'),
            Map.entry("13,4", '1'), Map.entry("13,5", '0'), Map.entry("13,6", '1'), Map.entry("13,7", '0'),
            Map.entry("13,8", '0'), Map.entry("13,9", '1'), Map.entry("13,10", '0'), Map.entry("13,11", '1'),
            Map.entry("13,12", '0'), Map.entry("13,13", '1'), Map.entry("13,14", '0'), Map.entry("13,15", '1'),
            Map.entry("13,16", '0'), Map.entry("13,17", '1'), Map.entry("13,18", '0'), Map.entry("13,19", '1'),

            // Row 14
            Map.entry("14,0", '1'), Map.entry("14,1", '0'), Map.entry("14,2", '1'), Map.entry("14,3", '0'),
            Map.entry("14,4", '1'), Map.entry("14,5", '0'), Map.entry("14,6", '1'), Map.entry("14,7", '1'),
            Map.entry("14,8", '1'), Map.entry("14,9", '1'), Map.entry("14,10", '0'), Map.entry("14,11", '1'),
            Map.entry("14,12", '0'), Map.entry("14,13", '1'), Map.entry("14,14", '0'), Map.entry("14,15", '1'),
            Map.entry("14,16", '0'), Map.entry("14,17", '1'), Map.entry("14,18", '0'), Map.entry("14,19", '1'),

            // Row 15
            Map.entry("15,0", '1'), Map.entry("15,1", '0'), Map.entry("15,2", '1'), Map.entry("15,3", '0'),
            Map.entry("15,4", '1'), Map.entry("15,5", '0'), Map.entry("15,6", '0'), Map.entry("15,7", '0'),
            Map.entry("15,8", '0'), Map.entry("15,9", '0'), Map.entry("15,10", '0'), Map.entry("15,11", '1'),
            Map.entry("15,12", '0'), Map.entry("15,13", '1'), Map.entry("15,14", '0'), Map.entry("15,15", '1'),
            Map.entry("15,16", '0'), Map.entry("15,17", '1'), Map.entry("15,18", '0'), Map.entry("15,19", '1'),

            // Row 16
            Map.entry("16,0", '1'), Map.entry("16,1", '0'), Map.entry("16,2", '1'), Map.entry("16,3", '0'),
            Map.entry("16,4", '1'), Map.entry("16,5", '1'), Map.entry("16,6", '1'), Map.entry("16,7", '1'),
            Map.entry("16,8", '1'), Map.entry("16,9", '1'), Map.entry("16,10", '1'), Map.entry("16,11", '1'),
            Map.entry("16,12", '0'), Map.entry("16,13", '1'), Map.entry("16,14", '0'), Map.entry("16,15", '1'),
            Map.entry("16,16", '0'), Map.entry("16,17", '1'), Map.entry("16,18", '0'), Map.entry("16,19", '1'),

            // Row 17
            Map.entry("17,0", '1'), Map.entry("17,1", '0'), Map.entry("17,2", '1'), Map.entry("17,3", '0'),
            Map.entry("17,4", '0'), Map.entry("17,5", '0'), Map.entry("17,6", '0'), Map.entry("17,7", '0'),
            Map.entry("17,8", '0'), Map.entry("17,9", '0'), Map.entry("17,10", '0'), Map.entry("17,11", '0'),
            Map.entry("17,12", '0'), Map.entry("17,13", '1'), Map.entry("17,14", '0'), Map.entry("17,15", '1'),
            Map.entry("17,16", '0'), Map.entry("17,17", '1'), Map.entry("17,18", '0'), Map.entry("17,19", '1'),

            // Row 18
            Map.entry("18,0", '1'), Map.entry("18,1", '0'), Map.entry("18,2", '1'), Map.entry("18,3", '1'),
            Map.entry("18,4", '1'), Map.entry("18,5", '1'), Map.entry("18,6", '1'), Map.entry("18,7", '1'),
            Map.entry("18,8", '1'), Map.entry("18,9", '1'), Map.entry("18,10", '1'), Map.entry("18,11", '1'),
            Map.entry("18,12", '1'), Map.entry("18,13", '0'), Map.entry("18,14", '0'), Map.entry("18,15", '1'),
            Map.entry("18,16", '0'), Map.entry("18,17", '1'), Map.entry("18,18", '0'), Map.entry("18,19", '1'),

            // Row 19
            Map.entry("19,0", '1'), Map.entry("19,1", '0'), Map.entry("19,2", '0'), Map.entry("19,3", '0'),
            Map.entry("19,4", '0'), Map.entry("19,5", '0'), Map.entry("19,6", '0'), Map.entry("19,7", '0'),
            Map.entry("19,8", '0'), Map.entry("19,9", '0'), Map.entry("19,10", '0'), Map.entry("19,11", '0'),
            Map.entry("19,12", '0'), Map.entry("19,13", '0'), Map.entry("19,14", '0'), Map.entry("19,15", '0'),
            Map.entry("19,16", '0'), Map.entry("19,17", '0'), Map.entry("19,18", '0'), Map.entry("19,19", 'E')
    );
    private final Map<String, Character> defaultMaze15 = Map.ofEntries(
            // Row 0
            Map.entry("0,0", 'S'), Map.entry("0,1", '0'), Map.entry("0,2", '1'), Map.entry("0,3", '1'),
            Map.entry("0,4", '1'), Map.entry("0,5", '1'), Map.entry("0,6", '1'), Map.entry("0,7", '1'),
            Map.entry("0,8", '1'), Map.entry("0,9", '1'), Map.entry("0,10", '1'), Map.entry("0,11", '1'),
            Map.entry("0,12", '1'), Map.entry("0,13", '1'), Map.entry("0,14", '1'),

            // Row 1
            Map.entry("1,0", '1'), Map.entry("1,1", '0'), Map.entry("1,2", '0'), Map.entry("1,3", '0'),
            Map.entry("1,4", '0'), Map.entry("1,5", '0'), Map.entry("1,6", '0'), Map.entry("1,7", '0'),
            Map.entry("1,8", '1'), Map.entry("1,9", '0'), Map.entry("1,10", '0'), Map.entry("1,11", '0'),
            Map.entry("1,12", '0'), Map.entry("1,13", '0'), Map.entry("1,14", '1'),

            // Row 2
            Map.entry("2,0", '1'), Map.entry("2,1", '1'), Map.entry("2,2", '1'), Map.entry("2,3", '1'),
            Map.entry("2,4", '1'), Map.entry("2,5", '1'), Map.entry("2,6", '1'), Map.entry("2,7", '0'),
            Map.entry("2,8", '1'), Map.entry("2,9", '0'), Map.entry("2,10", '1'), Map.entry("2,11", '1'),
            Map.entry("2,12", '1'), Map.entry("2,13", '0'), Map.entry("2,14", '1'),

            // Row 3
            Map.entry("3,0", '1'), Map.entry("3,1", '0'), Map.entry("3,2", '0'), Map.entry("3,3", '0'),
            Map.entry("3,4", '0'), Map.entry("3,5", '0'), Map.entry("3,6", '0'), Map.entry("3,7", '0'),
            Map.entry("3,8", '1'), Map.entry("3,9", '0'), Map.entry("3,10", '0'), Map.entry("3,11", '0'),
            Map.entry("3,12", '1'), Map.entry("3,13", '0'), Map.entry("3,14", '1'),

            // Row 4
            Map.entry("4,0", '1'), Map.entry("4,1", '0'), Map.entry("4,2", '1'), Map.entry("4,3", '1'),
            Map.entry("4,4", '1'), Map.entry("4,5", '1'), Map.entry("4,6", '1'), Map.entry("4,7", '1'),
            Map.entry("4,8", '1'), Map.entry("4,9", '1'), Map.entry("4,10", '1'), Map.entry("4,11", '0'),
            Map.entry("4,12", '1'), Map.entry("4,13", '0'), Map.entry("4,14", '1'),

            // Row 5
            Map.entry("5,0", '1'), Map.entry("5,1", '0'), Map.entry("5,2", '0'), Map.entry("5,3", '0'),
            Map.entry("5,4", '0'), Map.entry("5,5", '0'), Map.entry("5,6", '0'), Map.entry("5,7", '0'),
            Map.entry("5,8", '0'), Map.entry("5,9", '0'), Map.entry("5,10", '1'), Map.entry("5,11", '0'),
            Map.entry("5,12", '1'), Map.entry("5,13", '0'), Map.entry("5,14", '1'),

            // Row 6
            Map.entry("6,0", '1'), Map.entry("6,1", '0'), Map.entry("6,2", '1'), Map.entry("6,3", '1'),
            Map.entry("6,4", '1'), Map.entry("6,5", '1'), Map.entry("6,6", '1'), Map.entry("6,7", '1'),
            Map.entry("6,8", '1'), Map.entry("6,9", '0'), Map.entry("6,10", '1'), Map.entry("6,11", '0'),
            Map.entry("6,12", '0'), Map.entry("6,13", '0'), Map.entry("6,14", '1'),

            // Row 7
            Map.entry("7,0", '1'), Map.entry("7,1", '0'), Map.entry("7,2", '0'), Map.entry("7,3", '0'),
            Map.entry("7,4", '0'), Map.entry("7,5", '0'), Map.entry("7,6", '0'), Map.entry("7,7", '0'),
            Map.entry("7,8", '1'), Map.entry("7,9", '0'), Map.entry("7,10", '1'), Map.entry("7,11", '0'),
            Map.entry("7,12", '1'), Map.entry("7,13", '0'), Map.entry("7,14", '1'),

            // Row 8
            Map.entry("8,0", '1'), Map.entry("8,1", '0'), Map.entry("8,2", '1'), Map.entry("8,3", '1'),
            Map.entry("8,4", '1'), Map.entry("8,5", '1'), Map.entry("8,6", '1'), Map.entry("8,7", '0'),
            Map.entry("8,8", '1'), Map.entry("8,9", '0'), Map.entry("8,10", '1'), Map.entry("8,11", '0'),
            Map.entry("8,12", '1'), Map.entry("8,13", '0'), Map.entry("8,14", '1'),

            // Row 9
            Map.entry("9,0", '1'), Map.entry("9,1", '0'), Map.entry("9,2", '0'), Map.entry("9,3", '0'),
            Map.entry("9,4", '0'), Map.entry("9,5", '0'), Map.entry("9,6", '1'), Map.entry("9,7", '0'),
            Map.entry("9,8", '1'), Map.entry("9,9", '0'), Map.entry("9,10", '1'), Map.entry("9,11", '0'),
            Map.entry("9,12", '1'), Map.entry("9,13", '0'), Map.entry("9,14", '1'),

            // Row 10
            Map.entry("10,0", '1'), Map.entry("10,1", '1'), Map.entry("10,2", '1'), Map.entry("10,3", '1'),
            Map.entry("10,4", '1'), Map.entry("10,5", '0'), Map.entry("10,6", '1'), Map.entry("10,7", '0'),
            Map.entry("10,8", '1'), Map.entry("10,9", '0'), Map.entry("10,10", '1'), Map.entry("10,11", '0'),
            Map.entry("10,12", '1'), Map.entry("10,13", '0'), Map.entry("10,14", '1'),

            // Row 11
            Map.entry("11,0", '1'), Map.entry("11,1", '0'), Map.entry("11,2", '0'), Map.entry("11,3", '0'),
            Map.entry("11,4", '0'), Map.entry("11,5", '0'), Map.entry("11,6", '1'), Map.entry("11,7", '0'),
            Map.entry("11,8", '1'), Map.entry("11,9", '0'), Map.entry("11,10", '1'), Map.entry("11,11", '0'),
            Map.entry("11,12", '1'), Map.entry("11,13", '0'), Map.entry("11,14", '1'),

            // Row 12
            Map.entry("12,0", '1'), Map.entry("12,1", '0'), Map.entry("12,2", '1'), Map.entry("12,3", '1'),
            Map.entry("12,4", '1'), Map.entry("12,5", '1'), Map.entry("12,6", '1'), Map.entry("12,7", '0'),
            Map.entry("12,8", '0'), Map.entry("12,9", '0'), Map.entry("12,10", '1'), Map.entry("12,11", '0'),
            Map.entry("12,12", '1'), Map.entry("12,13", '0'), Map.entry("12,14", '1'),

            // Row 13
            Map.entry("13,0", '1'), Map.entry("13,1", '0'), Map.entry("13,2", '0'), Map.entry("13,3", '0'),
            Map.entry("13,4", '0'), Map.entry("13,5", '0'), Map.entry("13,6", '0'), Map.entry("13,7", '0'),
            Map.entry("13,8", '1'), Map.entry("13,9", '0'), Map.entry("13,10", '0'), Map.entry("13,11", '0'),
            Map.entry("13,12", '1'), Map.entry("13,13", '0'), Map.entry("13,14", '1'),

            // Row 14
            Map.entry("14,0", '1'), Map.entry("14,1", '1'), Map.entry("14,2", '1'), Map.entry("14,3", '1'),
            Map.entry("14,4", '1'), Map.entry("14,5", '1'), Map.entry("14,6", '1'), Map.entry("14,7", '1'),
            Map.entry("14,8", '1'), Map.entry("14,9", '1'), Map.entry("14,10", '1'), Map.entry("14,11", '1'),
            Map.entry("14,12", '1'), Map.entry("14,13", '0'), Map.entry("14,14", 'E')
    );

    public int getRows() {
        return rows;
    }

    public MazeHashMap(int size) {
        this.rows = size;
        this.cols = size;
        // Initialize maze with all '0's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze.put(key(i, j), '0');
            }
        }
    }

    public void loadDefaultMaze() {
        maze.clear();
        if (rows == 10) {
            maze.putAll(defaultMaze10);
        } else if (rows == 20) {
            maze.putAll(defaultMaze20);
        } else if (rows == 15) {
            maze.putAll(defaultMaze15);
        } else {
            System.out.println("Unsupported maze size. Initialized with empty maze.");
        }
    }

    public void addWall(int row, int col) {
        if (isValidPosition(row, col)) {
            maze.put(key(row, col), '1');
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void removeWall(int row, int col) {
        if (isValidPosition(row, col)) {
            maze.put(key(row, col), '0');
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void setStart(int row, int col) {
        if (!isValidPosition(row, col)) {
            System.out.println("Invalid position.");
            return;
        }

        for (int i=0;i<rows;i++){  //checks to see if another End exists, if so it replaces it with 0
            for(int j=0;j<cols;j++){
                if(maze.get(key(i,j))=='S'){
                    maze.put(key(i,j),'0');
                }
            }
        }
        maze.put(key(row, col), 'S');
    }

    public void setEnd(int row, int col) {
        if (!isValidPosition(row, col)) {
            System.out.println("Invalid position.");
            return;
        }

        for (int i=0;i<rows;i++){  //checks to see if another End exists, if so it replaces it with 0
            for(int j=0;j<cols;j++){
                if(maze.get(key(i,j))=='E'){
                    maze.put(key(i,j),'0');
                }
            }
        }

        maze.put(key(row, col), 'E');
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze.get(key(i, j)) + " ");
            }
            System.out.println();
        }
    }

    private String key(int row, int col) {
        return row + "," + col;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    public Map<String, Character> getMaze() {
        return maze;
    }

}
