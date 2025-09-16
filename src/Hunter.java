import java.util.Random;

/**
 * The Hunter is a game piece representing the player.
 * The Hunter can be alive or dead. When dead we need
 * to keep track if the player was eaten, fell into a pit
 * or shot by an arrow.
 * We also need to keep track of the number of arrows.
 * The Hunter needs to be able to move or shoot an arrow.
 */
public class Hunter extends GamePiece {
    /** the game is over if we run out of arrows */
    private int arrowCount = 5;

    private enum Status {
        Alive,
        EatenByWumpus,
        FellIntoPit,
        ShotByArrow,
    };

    /* the current status of the player */
    private Status status = Status.Alive;

    /** Place in a random room. */
    public Hunter(Cave cave) {
        super(cave);
    }

    /** Place in a specific room. */
    public Hunter(Cave cave, int roomID) {
        super(cave, roomID);
    }

    /**
     * @return true when hunter has arrows (but may also be dead)
     */
    public boolean hasArrows() {
        return arrowCount > 0;
    }

    /**
     * @return true when hunter is still alive (but my have arrows)
     */
    public boolean isAlive() {
        return status == Status.Alive;
    }

    /**
     * @return true when hunter was eaten by Wumpus.
     */
    public boolean wasEatenByWumpus() {
        return status == Status.EatenByWumpus;
    }

    /**
     * @return true when hunter was shot by an arrow.
     */
    public boolean wasShotByArrow() {
        return status == Status.ShotByArrow;
    }

    /**
     * @return true if hunter died in a pit.
     */
    public boolean fellIntoPit() {
        return status == Status.FellIntoPit;
    }

    /** Call when the player is shot by an arrow. */
    public void shotByArrow() {
        status = Status.ShotByArrow;
    }

    /** Call when the player falls into a pit. */
    public void walkedIntoPit() {
        status = Status.FellIntoPit;
    }

    /** Call when the player is eaten by the Wumpus. */
    public void eatenByWumpus() {
        status = Status.EatenByWumpus;
    }

    /**
     * Ask the player where they want to move to
     * and move the player to that room.
     */
    public void move() {
        int destination = IO.inputMoveTo(cave.getPaths(roomID));

        if (cave.isPathValid(this.roomID, destination))
            setRoomID(destination);
    }

    /**
     * Ask the player for the path the arrow will
     * attempt to travel.
     * 
     * @return the arrow's path
     */
    public int[] shootArrow() {
        if (arrowCount <= 0)
            return new int[0];

        arrowCount -= 1;
        int[] path = IO.inputArrowPath();

        int pathStart = roomID;
        for (int index = 0; index < path.length; index++) {
            if (!cave.isPathValid(pathStart, path[index])) {
                // invalid destination so pick a new one
                int[] rooms = cave.getPaths(pathStart);
                path[index] = rooms[new Random().nextInt(rooms.length)];
            }
            pathStart = path[index];
        }
        return path;
    }

    /** Used for debugging. */
    public String toString() {
        return String.format("Hunter: %3d", roomID);
    }

}
