import java.util.Random;

/**
 * When a player enters a room with a bat. The bat
 * moves the player to a random room, then the bat
 * moves to another random room.
 */
public class Bat extends Hazard {
    /** add to a random room */
    public Bat(Cave cave) {
        super(cave);
    }

    /** add to a given room */
    public Bat(Cave cave, int roomID) {
        super(cave, roomID);
    }

    /** move the hunter to a random room */
    protected void moveHunter(Hunter hunter) {
        int[] rooms = cave.getAllRooms();

        // move the hunter to a new random room;
        hunter.setRoomID(rooms[new Random().nextInt(rooms.length)]);

        // fly to a new random room
        roomID = rooms[new Random().nextInt(rooms.length)];

        IO.outputMovedByBats();
    }

    /** move the bat to a random room */
    public void move() {
        int[] rooms = cave.getAllRooms();
        setRoomID(rooms[new Random().nextInt(rooms.length)]);
    }

    /**
     * If a hunter enters the same room,
     * move the hunter to a random room then
     * move to a random room.
     */
    public void encounter(Hunter hunter) {
        if (hunter.getRoomID() == roomID) {
            moveHunter(hunter);
            move();
        }
    }

    /** used for debugging */
    public String toString() {
        return String.format("Bat:    %3d", roomID);
    }

}
