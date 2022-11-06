package agh.ics.oop;

import java.util.List;


public class World {
    public static void main (String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
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
