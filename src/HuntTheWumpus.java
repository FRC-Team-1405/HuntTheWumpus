public class HuntTheWumpus {

    public static void main(String[] args) {
        Cave cave = new Cave();
        int[] rooms = cave.getPaths(1);

        boolean pathExists = cave.isPathValid(1, 5);
        System.out.println(rooms[0]);
        System.out.println(rooms[1]);
        System.out.println(rooms[2]);

        System.out.println(cave.getPaths(0));
        System.out.println(cave.getPaths(1));
        System.out.println(cave.getPaths(2));

        System.out.println("Hello World");

    }
}
