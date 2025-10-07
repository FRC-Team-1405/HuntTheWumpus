import java.util.Random;

public class Wumpus extends GamePiece {
    public enum Status {
        Sleeping,
        Awake,
        Dead,
    }

    private Status status = Status.Sleeping;

    public Wumpus(Cave cave, int roomID) {
        super(cave, roomID);
    }

    public void move() {
        if (status != Status.Awake) {
            return;
        }

        boolean move = new Random().nextBoolean();
        if (move){
            int[] rooms = cave.getPaths(roomID);

            setRoomID(rooms[new Random().nextInt(rooms.length)]);
        }
    }
        //For debuging//
    public String toString() {
        return String.format("Wumpus:   %3d", roomID);
    }
}
