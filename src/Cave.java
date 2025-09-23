import java.util.HashMap;
import java.util.Map;

/**
 * Each room in the cave has a unique ID (1-20) and is arranged
 * in the shape of a dodecahedron
 */
public class Cave {
    private Map<Integer, int[]> rooms = new HashMap<Integer, int[]>();

    public Cave() {
        rooms.put(Integer.valueOf(1), new int[] { 5, 8, 2 });
        rooms.put(Integer.valueOf(2), new int[] { 1, 10, 3 });
        rooms.put(Integer.valueOf(3), new int[] { 2, 12, 4 });
    }

    public int[] getpaths(int roomID) {
        return rooms.get(Integer.valueOf(roomID));
    }

    public boolean isPathValid(int fromID, int toID) {
        int[] paths = rooms.get(fromID);

        if (paths == null) {
            return false;
        }

        for (int destination : paths) {
            if (destination == toID) {
                return true;
            }
        }
        return false;
    }
}