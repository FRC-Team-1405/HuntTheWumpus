public class Hunter extends GamePiece {
    private int arrowCount = 5;

    private enum Status {
        Alive,
        EatenByWumpus,
        FellIntoPit,
        ShotByArrow,
    };

    private Status status = Status.Alive;

    // constructor
    public Hunter(Cave cave, int roomID) {
        super(cave, roomID);
    }

}
