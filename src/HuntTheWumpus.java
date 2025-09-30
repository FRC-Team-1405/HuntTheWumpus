public class HuntTheWumpus {
    public static void main(String[] args) {

        Cave cave = new Cave();
        GamePiece piece = new GamePiece(cave, 0);

        System.out.println(piece);
        piece.setRoomID(3);
        System.out.println(piece);
        System.out.println(piece.getRoomID());

        int[] rooms = cave.getPaths(1);

        int[] roomTotal = cave.getAllRooms();

        for (int roomsID : roomTotal) {
            System.out.println(roomTotal);
        }

    }
}
