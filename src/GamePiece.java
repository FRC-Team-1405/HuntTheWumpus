import java.util.Random;

/**
 * A game pice is located in a room in the cave. Either initially
 * assigned to a room or a random room. Game pieces may or may not
 * be able to move.
 */
public abstract class GamePiece {
    protected int roomID;
    protected Cave cave;

    /**
     * Add the piece to a random room in the cave.
     * 
     * @param cave - the cave of connected rooms
     */
    public GamePiece(Cave cave) {
        this.cave = cave;

        int[] rooms = cave.getAllRooms();
        setRoomID(rooms[new Random().nextInt(rooms.length)]);
    }

    /**
     * Add the piece to a given room in the cave.
     * 
     * @param cave   the cave of connected rooms
     * @param roomID a room in the cave
     */
    public GamePiece(Cave cave, int roomID) {
        this.cave = cave;
        this.roomID = roomID;
    }

    /**
     * The roomID the piece is currently located.
     * 
     * @return roomID where the piece is located
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * List the rooms directly connected to the piece.
     * 
     * @return list of roomID(s)
     */
    public int[] getTunnels() {
        return cave.getPaths(roomID);
    }

    /**
     * Set the roomID of the piece. This is to allow
     * a piece to move to a room not connected to the
     * current room.
     * 
     * @param roomID the new location
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * Move to an adjacent room.
     */
    public abstract void move();

    /**
     * Print out the roomID for debugging.
     */
    public String toString() {
        return String.format("Room:   %3d", roomID);
    }

}
