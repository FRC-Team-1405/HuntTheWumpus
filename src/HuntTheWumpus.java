public class HuntTheWumpus {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Cave cave = new Cave();
        GamePiece piece = new GamePiece(cave, 0);

        System.out.println(piece);
        piece.setRoomID(3);
        System.out.println(piece);
        System.out.println(piece.getRoomID());

        int[] rooms = cave.getPaths(1);
        int[] rooms2 = cave.getAllRooms();
        for (int roomID : rooms) {
            System.out.println(roomID);
        }

        // boolean pathExists = cave.isPathValid(1, 5);
        // System.out.println(rooms[0]);
        // System.out.println(rooms[1]);
        // System.out.println(rooms[2]);

        // System.out.println(cave.getPaths(0));
        // System.out.println(cave.getPaths(1));
        // System.out.println(cave.getPaths(2));

        // System.out.println("Hello World");

    }
}
