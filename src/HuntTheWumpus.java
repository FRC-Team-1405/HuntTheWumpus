import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HuntTheWumpus {
    public static void main(String[] args) {

        Cave cave = new Cave();
        GamePiece piece = new GamePiece(cave, 3);

        System.out.println(piece);
        piece.setRoomID(1);
        System.out.println(piece);
        System.out.println(piece.getRoomID());
    }
}
