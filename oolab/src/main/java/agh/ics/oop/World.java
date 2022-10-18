package agh.ics.oop;

public class World {
    public static void main (String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }

    public static Direction[] change(String[] directions) {
        Direction tab[] = new Direction[directions.length];
        for (int i = 0; i < directions.length; i++) {
            Direction move = switch (directions[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.OTHER;
            };

            tab[i] = move;


        }
        return tab;

    }

    public static void run(Direction[] directions) {

        for (Direction direction : directions) {
            String text = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie w tył";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> null;
            };
            if (text != null) {
                System.out.println(text);
            }
        }
    }
}
