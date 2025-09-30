public class HuntTheWumpus {
    public static void main(String[] args) {
        // This is an instansiation of cave
        Cave cave = new Cave();

        GamePiece piece = new GamePiece(cave, 0);
        System.out.println(piece);
        piece.setRoomID(3);
        System.out.println(piece);
        System.out.println(piece.getRoomID());

        // getting room ID before for the defined room
        int[] rooms = cave.getPaths(1);

        boolean pathExists = cave.isPathValid(1, 5);
        for (int room : rooms) {
            System.out.println(room);
        }
        System.out.println(rooms);

        System.out.println(rooms[0] + "/t");
        System.out.println(rooms[1] + "/t");
        System.out.println(rooms[2]);
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        System.out.println("\n\n6-7\n\n");
        // getting paths on a different room
        // getPaths returns an array of integers
        // System.out.println(cave.getPaths(1));
        // System.out.println(cave.getPaths(2));
        // System.out.println(cave.getPaths(3));

        Cave cave2 = new Cave();

        int[] rooms2 = cave2.getAllRooms();
        for (int roomID : rooms2) {
            System.out.println(roomID);
        }
    }
}
