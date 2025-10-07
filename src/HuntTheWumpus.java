public class HuntTheWumpus {
    public static void main(String[] args) {
        // This is an instansiation of 
        Cave cave = new Cave();
        GamePiece[] pieces = new GamePiece[]{
        new Pit(cave, 1),
        new Wumpus(cave, 3),
        new Bat(cave, 2),
        };

        for (GamePiece piece : pieces) {
            System.out.println(piece);
            piece.move();
            System.out.println(piece);
        }
    }
}
