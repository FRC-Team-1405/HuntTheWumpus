public class HuntTheWumpus {
    public static void main(String[] args) {
        Cave cave = new Cave();
        Pit pit = new Pit(cave, 1);
        Wumpus wumpus = new Wumpus(cave, 3);
        Bat bat = new Bat(cave, 2);

        System.out.println(pit);
        pit.move();
        System.out.println(pit);
        
        System.out.println(wumpus);
        wumpus.move();
        System.out.println(wumpus);
        
        System.out.println(bat);
        bat.move();
        System.out.println(bat);

    }
}