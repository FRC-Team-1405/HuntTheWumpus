public abstract class GamePiece {
    protected int roomID;
    protected Cave cave;


    public GamePiece(Cave cave, int roomID) {
        this.cave = cave;
        this.roomID = roomID;

    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
    //validate that roomID is valid
    this.roomID = roomID;
    }

    public int[] getTunnels() {
        return cave.getPaths(roomID);
    }

    public abstract void move();

    public String toString() {
        return String.format("Room:   %3d", roomID);
    }
}
