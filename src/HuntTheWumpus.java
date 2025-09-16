public class HuntTheWumpus {
    public static void main(String[] args) {
        // create the cave
        Cave cave = new Cave();

        // print out each room and it's connections
        for (int roomID : cave.getAllRooms()) {
            System.out.print("Room\t" + roomID);
            for (int path : cave.getPaths(roomID)) {
                System.out.print("\t" + path);
            }
            System.out.println();
        }
    }
}
