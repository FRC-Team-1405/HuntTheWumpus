public class Pit extends GamePiece {
    public Pit(Cave cave, int roomID) {
        super(cave, roomID);
    }

    public void move() {
        //pits don't move//
    }
        //for debuging//
    public String toString() {
        return String.format("Pit:   %3d", roomID);
    }
}
