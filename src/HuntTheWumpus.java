public class HuntTheWumpus {
    public static void main(String[] args) {
        // create the cave
        Cave cave = new Cave();
        Hunter hunter = new Hunter(cave, 1);

        IO.outputInstructions();

        IO.outputRoom(1, cave.getPaths(1));

        char action = IO.inputAction();
        if (action == 'M') {
            hunter.move();
            int roomID = hunter.getRoomID();
            IO.outputRoom(roomID, cave.getPaths(roomID));
        } else if (action == 'S') {
            int[] path = hunter.shootArrow();
            System.out.println("Player wants to shoot and arrow:");
            for (int roomID : path) {
                System.out.println("Room " + roomID);
            }
            System.out.println();
        }

        hunter.eatenByWumpus();
        if (!hunter.isAlive() && hunter.wasEatenByWumpus())
            IO.outputEatenByWumpus();

    }
}
