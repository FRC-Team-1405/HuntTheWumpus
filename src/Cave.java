import java.util.HashMap;
import java.util.Map;

/**
 * Each room in the cave has a unique ID (1-20) and is arranged
 * in the shape of a dodecahedron.
 */
public class Cave {
    private Map<Integer, int[]> rooms = new HashMap<Integer, int[]>();

    public Cave() {
        rooms.put(Integer.valueOf(1), new int[] { 5, 8, 2 });
        rooms.put(Integer.valueOf(2), new int[] { 1, 10, 3 });
        rooms.put(Integer.valueOf(3), new int[] { 2, 12, 4 });
        rooms.put(Integer.valueOf(4), new int[] { 3, 14, 5 });
        rooms.put(Integer.valueOf(5), new int[] { 4, 6, 1 });

        rooms.put(Integer.valueOf(6), new int[] { 15, 5, 7 });
        rooms.put(Integer.valueOf(7), new int[] { 6, 17, 8 });
        rooms.put(Integer.valueOf(8), new int[] { 7, 1, 9 });
        rooms.put(Integer.valueOf(9), new int[] { 8, 18, 10 });
        rooms.put(Integer.valueOf(10), new int[] { 9, 2, 11 });
        rooms.put(Integer.valueOf(11), new int[] { 10, 19, 12 });
        rooms.put(Integer.valueOf(12), new int[] { 11, 3, 13 });
        rooms.put(Integer.valueOf(13), new int[] { 12, 20, 14 });
        rooms.put(Integer.valueOf(14), new int[] { 13, 4, 15 });
        rooms.put(Integer.valueOf(15), new int[] { 14, 16, 6 });

        rooms.put(Integer.valueOf(16), new int[] { 20, 15, 17 });
        rooms.put(Integer.valueOf(17), new int[] { 16, 7, 18 });
        rooms.put(Integer.valueOf(18), new int[] { 17, 9, 19 });
        rooms.put(Integer.valueOf(19), new int[] { 18, 11, 20 });
        rooms.put(Integer.valueOf(20), new int[] { 19, 13, 16 });
    }

    /**
     * Validate if a path between 2 rooms is valid.
     * 
     * @param fromID - a valid roomID (1-20)
     * @param toID   - a valid roomID (1-20)
     * @return true if the 2 rooms are directly connected.
     */
    public boolean isPathValid(int fromID, int toID) {
        int[] paths = rooms.get(Integer.valueOf(fromID));

        if (paths == null)
            return false;

        for (int destination : paths) {
            if (destination == toID)
                return true;
        }

        return false;
    }

    /**
     * Return a list of all of the roomID(s).
     * 
     * @return a list of valid roomID(s)
     */
    public int[] getAllRooms() {
        return rooms.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * Return the tunnels going out of a given room.
     * 
     * @param roomID - ID of the room
     * @return list of roomID(s) connected to the given room
     */
    public int[] getPaths(int roomID) {
        return rooms.get(Integer.valueOf(roomID));
    }

}