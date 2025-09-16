public class HuntTheWumpus {
    public static void main(String[] args) {
        // create the cave
        Cave cave = new Cave();

        IO.outputInstructions();

        IO.outputRoom(1, cave.getPaths(1));

        char action = IO.inputAction();
        if (action == 'M') {
            int roomID = IO.inputMoveTo(cave.getPaths(1));
            System.out.println("Player wants to move to " + roomID);
        } else if (action == 'S') {
            int[] path = IO.inputArrowPath();
            System.out.println("Player wants to shoot and arrow:");
            for (int roomID : path) {
                System.out.println("Room " + roomID);
            }
            System.out.println();
        }

        IO.outputKilledTheWumpus(20);

    }
}
