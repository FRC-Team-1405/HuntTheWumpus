import java.util.Random;

public class HuntTheWumpus {
    public static void main(String[] args) {
        HuntTheWumpus game = new HuntTheWumpus();

        game.play();
        game.results();

    }

    /** used to display the positions of the game pieces */
    private final boolean DEBUG;
    private final Cave cave = new Cave();
    private Hunter hunter;
    private Hazard[] hazards;
    private Wumpus wumpus;

    /** defaults to DEBUG off */
    public HuntTheWumpus() {
        this(false);
    }

    /* allows DEBUG to be turned on */
    public HuntTheWumpus(boolean debug) {
        this.DEBUG = debug;
        setup();
    }

    /**
     * Put the Hunter in room 1
     * Put the 2 pits in random rooms.
     * Put the 2 bats in random rooms.
     * Put the Wumpus in a random room.
     */
    private void setup() {
        Random rnd = new Random();
        int[] rooms = cave.getAllRooms();

        // shuffle the roomIDs
        for (int index = 1; index < rooms.length; index++) {
            int swap = rnd.nextInt(1, rooms.length);
            int tmp = rooms[index];

            rooms[index] = rooms[swap];
            rooms[swap] = tmp;
        }

        hunter = new Hunter(cave, rooms[0]);
        wumpus = new Wumpus(cave, rooms[1]);
        hazards = new Hazard[] {
                new Bat(cave, rooms[2]),
                new Bat(cave, rooms[3]),
                new Pit(cave, rooms[4]),
                new Pit(cave, rooms[5]),
                wumpus
        };
    }

    /** show the game piece positions */
    private void debug() {
        if (DEBUG) {
            System.out.println("\t\t\t+-------------+");
            System.out.println("\t\t\t| " + hunter.toString() + " |");
            for (GamePiece hazard : hazards) {
                System.out.println("\t\t\t| " + hazard.toString() + " |");
            }
            System.out.println("\t\t\t+-------------+");
        }
    }

    /**
     * While the Player and the Wumpus are alive, and the hunter
     * still as arrows play the game.
     * 1) output the room details
     * 2) show any warnings
     * 3) get/perform the hunter's action
     * 4) check for encounters
     */
    public void play() {
        IO.outputInstructions();

        while (wumpus.isAlive() && hunter.isAlive() && hunter.hasArrows()) {
            debug();

            IO.outputRoom(hunter.getRoomID(), cave.getPaths(hunter.getRoomID()));

            showWarnings();

            hunterAction();

            checkRooms();
        }
    }

    /**
     * Either the hunter or Wumpus is dead or
     * the hunter is out of arrows.
     * Display the result of the game.
     */
    public void results() {
        if (hunter.isAlive()) {
            if (!wumpus.isAlive())
                IO.outputKilledTheWumpus(wumpus.roomID);
            if (!hunter.hasArrows())
                IO.outputOutOfArrows();
        } else {
            if (hunter.wasEatenByWumpus())
                IO.outputEatenByWumpus();
            else if (hunter.wasShotByArrow())
                IO.outputKilledByArrow();
            if (hunter.fellIntoPit())
                IO.outputFellIntoPit();
        }
    }

    /**
     * If the player is hear any of the hazards
     * the show the warnings.
     */
    public void showWarnings() {
        for (int roomID : hunter.getTunnels()) {
            for (GamePiece hazard : hazards) {
                if (roomID != hazard.getRoomID())
                    continue;
                if (hazard instanceof Bat)
                    IO.outputBatWarning();
                if (hazard instanceof Pit)
                    IO.outputPitWarning();
                if (hazard instanceof Wumpus)
                    IO.outputWumpusWarning();
            }
        }
    }

    /**
     * Ask the player for the hunter's action
     * and perform it.
     */
    public void hunterAction() {
        if (IO.inputAction() == 'M') {
            hunter.move();
        } else {
            int[] arrowPath = hunter.shootArrow();
            for (int roomID : arrowPath) {
                if (roomID == hunter.getRoomID()) {
                    hunter.shotByArrow();
                }
            }

            for (int roomID : arrowPath) {
                if (roomID == wumpus.getRoomID()) {
                    wumpus.shotByArrow();
                }
            }
            wumpus.wakeUp();
        }
    }

    /**
     * Check and see if the hunter entered a room
     * with a hazard and perform the result.
     */
    public void checkRooms() {
        for (Hazard hazard : hazards) {
            if (hazard.getRoomID() == hunter.getRoomID())
                hazard.encounter(hunter);
        }
    }
}
