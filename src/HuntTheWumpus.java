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

        System.out.println();

        System.out.println("Testing wumpus encounter.");
        Wumpus wumpus = new Wumpus(cave, 20);
        hunter.setRoomID(20);
        wumpus.encounter(hunter);
        if (hunter.wasEatenByWumpus())
            IO.outputEatenByWumpus();

        System.out.println("Testing pit encounter.");
        Pit pit = new Pit(cave, 2);
        hunter.setRoomID(2);
        pit.encounter(hunter);
        if (hunter.fellIntoPit())
            IO.outputFellIntoPit();

        System.out.println("Testing bat encounter.");
        Bat bat = new Bat(cave, 5);
        hunter.setRoomID(5);
        bat.encounter(hunter);
        IO.outputRoom(hunter.getRoomID(), cave.getPaths(hunter.getRoomID()));
    }
}
