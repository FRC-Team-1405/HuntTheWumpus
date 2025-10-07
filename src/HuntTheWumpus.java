import java.util.Random;

public class HuntTheWumpus {
    public static void main(String[] args) {
        HuntTheWumpus game = new HuntTheWumpus();

        Cave cave;
        cave = new Cave();
        int[] rooms = cave.getAllRooms();
        for (int i = 0; i < rooms.length; i++) {
            System.out.println(rooms[i]);
        }
    }

}