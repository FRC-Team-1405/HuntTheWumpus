import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HuntTheWumpus {
    public static void main(String[] args) {
        Cave cave = new Cave();
        int[] rooms = cave.getPaths(1);

        boolean pathExists = cave.isPathValid(1, 3);
        System.out.println(pathExists);
        System.out.println(rooms[0]);
        System.out.println(rooms[1]);
        System.out.println(rooms[2]);
    }
}
