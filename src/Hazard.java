/**
 * A hazard is an abstract game piece that can encounter
 * the player and change the state of the player.
 */
public abstract class Hazard extends GamePiece {
    /** add to a random place */
    public Hazard(Cave cave) {
        super(cave);
    }

    /** add to a given room */
    public Hazard(Cave cave, int roomID) {
        super(cave, roomID);
    }

    /** Encounter a player if they are in the same room. */
    public abstract void encounter(Hunter hunter);
}
