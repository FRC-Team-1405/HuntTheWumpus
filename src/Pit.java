/**
 * The pit cannot move but if a Hunter enters the
 * room then it dies.
 */
public class Pit extends Hazard {
    /** add to a random room */
    public Pit(Cave cave) {
        super(cave);
    }

    /** add to a given room */
    public Pit(Cave cave, int roomID) {
        super(cave, roomID);
    }

    /** pits do not move */
    public void move() {
        ; // pits don't move
    }

    /**
     * Check if the Hunter is in the same room.
     * If it is then set the Hunter status
     * to Fell into a pit.
     */
    public void encounter(Hunter hunter) {
        if (hunter.getRoomID() == roomID) {
            hunter.walkedIntoPit();
        }
    }

    /** used for debugging */
    public String toString() {
        return String.format("Pit:    %3d", roomID);
    }

}
