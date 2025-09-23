public class HuntTheWumpus {
    public static void main(String[] args) {
        // This is an instansiation of cave
        Cave cave = new Cave();

        // getting room ID before for the defined room
        int[] rooms = cave.getPaths(3);

        boolean pathExists = cave.isPathValid(1, 5);
        System.out.println(rooms);

        System.out.println(rooms[0] + "/t");
        System.out.println(rooms[1] + "/t");
        System.out.println(rooms[2]);

        // getting paths on a different room

        // getPaths returns an array of integers
        // System.out.println(cave.getPaths(1));
        // System.out.println(cave.getPaths(2));
        // System.out.println(cave.getPaths(3));
    }
}
