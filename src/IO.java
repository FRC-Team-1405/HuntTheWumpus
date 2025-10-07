public class IO {
    /**
     * Ask the user if they need instructions. If they type a
     * 'Y' or 'y' print the instructions.
     * Repeat the question if they type an invalid response.
     */
    static void outputInstructions() {
        do {
            String input = System.console().readLine("Instructions? (Y/N) ");
            System.out.println();

            char choice = input.toUpperCase().charAt(0);
            switch (choice) {
                case 'N':
                    return;
                case 'Y':
                    System.out.println("""
                            Welcome to 'Hunt the Wumpus'

                            The Wumpus lives in a cave of 20 rooms: each room has 3 tunnels leading to other
                            rooms. (look at a dodecahedron to see how this works. if you don't know what a
                            dodecahedron is, ask someone)
                            """);
                    return;
                default:
                    ;
            }
        } while (true);
    }

    /**
     * Ask the user if they want to Move or Shot (M/S).
     * 
     * @return 'M' for move or 'S' for shoot.
     */
    public static char inputAction() {
        char choice;

        do {
            String input = System.console().readLine("Shoot or Move? (S/M) ");

            choice = input.toUpperCase().charAt(0);
            if (choice == 'S' || choice == 'M')
                return choice;
        } while (true);
    }

    /**
     * Ask the user where they want to move to and only alow a valid
     * path out of that room.
     * 
     * @param tunnels a list of the valid roomID(s)
     * @return the selected roomID
     */
    public static int inputMoveTo(int[] tunnels) {
        int choice;
        do {
            String input = System.console().readLine("Move to? ");
            choice = Integer.parseInt(input);
            for (int roomID : tunnels) {
                if (roomID == choice) {
                    return choice;
                }
            }
        } while (true);
    }

    /**
     * Print out the current roomID and the list of roomsID
     * that the player can move into.
     * 
     * @param roomID  the current roomID
     * @param tunnels list of roomID the player can move into
     */
    public static void outputRoom(int roomID, int[] tunnels) {
        System.out.println("You are in room " + roomID);
        System.out.print("Tunnels lead to \t");
        for (int tunnel : tunnels) {
            System.out.print(tunnel + "\t");
        }
        System.out.println();
    }

    /**
     * Get from the player the distance (1-5) the arrow will
     * travel and a list of the roomID that make the arrow's path.
     * 
     * @return list of roomID(s) the arrow will travel
     */
    public static int[] inputArrowPath() {
        int distance = inputArrowDistance();
        int[] path = new int[distance];
        for (int index = 0; index < distance; index++) {
            path[index] = inputRoomID(index + 1);
        }
        return path;
    }

    /**
     * Get from the player the distance (1-5) the arrow will travel.
     * 
     * @return the distance
     */
    private static int inputArrowDistance() {
        int choice;
        do {
            String input = System.console().readLine("Number of rooms? (1-5) ");
            choice = Integer.parseInt(input);
            if (choice < 1 || choice > 6)
                continue;

            return choice;
        } while (true);
    }

    /**
     * Ask the user for a roomID for the arrow's path.
     * 
     * @param index the arrow path index
     * @return
     */
    private static int inputRoomID(int index) {
        int choice;
        do {
            String input = System.console().readLine("\t Room # " + index + "\t");
            choice = Integer.parseInt(input);
            if (choice < 1 || choice > 20)
                continue;

            return choice;
        } while (true);
    }

    /**
     * Output that the player was moved by bats.
     */
    public static void outputMovedByBats() {
        System.out.println();
        System.out.println("A bat carried you away to a new room!");
        System.out.println();
    }

    /**
     * Output that the player was killed by an arrow.
     */
    public static void outputKilledByArrow() {
        System.out.println("--------------------------------");
        System.out.println("You shot yourself with an arrow!");
        System.out.println("--------------------------------");
        System.out.println();
    }

    /**
     * Output that the player fell into a pit.
     */
    public static void outputFellIntoPit() {
        System.out.println("--------------------");
        System.out.println("You fell into a pit!");
        System.out.println("--------------------");
        System.out.println();
    }

    /**
     * Output that the player was eaten by the Wumpus.
     */
    public static void outputEatenByWumpus() {
        System.out.println("-----------------------------");
        System.out.println("You were eaten by the Wumpus!");
        System.out.println("-----------------------------");
        System.out.println();
    }

    /**
     * Output that the player has run out of arrows.
     */
    public static void outputOutOfArrows() {
        System.out.println("-------------------------------");
        System.out.println("You don't have any arrows left!");
        System.out.println("-------------------------------");
        System.out.println();
    }

    /**
     * Output that the player has killed the Wumpus.
     */
    public static void outputKilledTheWumpus(int roomID) {
        System.out.println("----------------------");
        System.out.println("You killed the Wumpus!");
        System.out.println("It was in room " + roomID);
        System.out.println("----------------------");
        System.out.println();
    }

    /**
     * Output that the Wumpus is in a nearby room.
     */
    public static void outputWumpusWarning() {
        System.out.println("You smell a horrid stench...");
    }

    /**
     * Output that a bat is in a nearby room.
     */
    public static void outputBatWarning() {
        System.out.println("Bats nearby...");
    }

    /**
     * Output tha a pit is in a nearby room.
     */
    public static void outputPitWarning() {
        System.out.println("You feel a draft...");
    }
}
