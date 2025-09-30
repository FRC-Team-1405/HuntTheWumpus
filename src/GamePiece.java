public class GamePiece {
    protected int roomID;
    protected Cave cave;

    public GamePiece(Cave cave) {
    }

    public GamePiece(Cave cave, int roomID) {
        this.cave = cave;
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int[] getTunnles() {
        return cave.getPaths(roomID);
    }

    public void move() {
    }

    public String toString() {
        return String.format("Room   %3d", roomID);
    }
}
