import java.util.Random;

/**
 * The Wumpus can be sleeping, awake, or dead.
 * When awake it will move to a random room or stay put.
 */
public class Wumpus extends Hazard {
    public enum Status {
        Sleeping,
        Awake,
        Dead,
    }

    /** current status of the Wumpus */
    private Status status = Status.Sleeping;

    /** add to a random room */
    public Wumpus(Cave cave) {
        super(cave);
    }

    /** add to a given room */
    public Wumpus(Cave cave, int roomID) {
        super(cave, roomID);
    }

    /** set the state to dead */
    public void shotByArrow() {
        status = Status.Dead;
    }

    /** true if awake */
    public boolean isAwake() {
        return status == Status.Sleeping;
    }

    /** true if alive */
    public boolean isAlive() {
        return status != Status.Dead;
    }

    /**
     * If it is sleeping there is a 75% chance
     * it will wake up.
     */
    public void wakeUp() {
        if (status == Status.Sleeping) 
            status = (new Random().nextInt(100) < 25) ? Status.Awake : Status.Sleeping;

        if (status == Status.Awake)
            move();
    }

    /**
     * If asleep stay put.
     * If wake stay put or move to a random room.
     */
    public void move() {
        if (status != Status.Awake)
            return;

        boolean move = new Random().nextBoolean();
        if (move) {
            int[] rooms = cave.getPaths(roomID);
            setRoomID(rooms[new Random().nextInt(rooms.length)]);
        }
    }

    /**
     * If a hunter is in the same room and the Wumpus
     * is a wake then eat the hunter.
     * If it's asleep then wakeup.
     */
    public void encounter(Hunter hunter) {
        if (hunter.getRoomID() == roomID) {
            if (isAwake()) {
                hunter.eatenByWumpus();
            } else {
                wakeUp();
            }
        }
    }

    /** used for debugging */
    public String toString() {
        return String.format("Wumpus: %3d", roomID);
    }

}
