import java.util.Random;

public class Bat extends GamePiece {
    public Bat(Cave cave, int roomID) {
        super(cave, roomID);
    }

    public void move() {
        int[] rooms = cave.getAllRooms();
        setRoomID(rooms[new Random().nextInt(rooms.length)]);
    }

    public String toString() {
        return String.format("Bat:   %3d", roomID);
    }
}
