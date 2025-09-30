import java.util.HashMap;
import java.util.Map;

// The cave is a dodecahedren with rooms 0-20. Each room will be empty, have bats, a bottomless hole, or the Wumpus.
public class Cave {
    private Map<Integer, int[]> rooms = new HashMap<Integer, int[]>();

    public Cave() {
        rooms.put(Integer.valueOf(1), new int[] { 2, 7, 11 });
        rooms.put(Integer.valueOf(2), new int[] { 1, 4, 8 });
        rooms.put(Integer.valueOf(3), new int[] { 9, 20, 5 });
    }

    public int[] getPaths(int roomID) {
        return rooms.get(roomID);
    }

    public boolean isPathValid(int fromID, int toID) {
        int[] paths = rooms.get(fromID);

        if (paths == null) {
            return false;
        }

        for (int destination : paths) {
            if (destination == toID)
                return true;
        }

        return false;
    }

    public int[] getAllRooms() {
        int[] result = new int[rooms.size()];
        int index = 0;
        for (Integer roomID : rooms.keySet()) {
            result[index++] = roomID.intValue();
        }
        return result;
    }
}
