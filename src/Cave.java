import java.util.HashMap;
import java.util.Map;

public class Cave {
    public Map<Integer, int[]> rooms = new HashMap<Integer, int[]>();

    // This is a constructor
    public Cave() {
        rooms.put(Integer.valueOf(1), new int[] { 5, 8, 2 });
        rooms.put(Integer.valueOf(2), new int[] { 1, 10, 3 });
        rooms.put(Integer.valueOf(3), new int[] { 2, 12, 4 });

    }

    public int[] getPaths(int roomID) {
        return rooms.get(Integer.valueOf(roomID));
    }

    public boolean isPathValid(int fromID, int toID) {
        int[] paths = rooms.get(fromID);

        if (paths == null) {
            return false;
        }

        // destination : paths gives one at a time
        for (int destination : paths) {
            if (destination == toID)
                return true;
        }
        return false;
    }
}
