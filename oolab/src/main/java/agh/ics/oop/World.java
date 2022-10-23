package agh.ics.oop;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main (String[] args){
        Animal zwierz = new Animal();
        System.out.println(zwierz.toString());
        List<MoveDirection> directions = parse(args);
        for(MoveDirection direction : directions){
            zwierz.move(direction);
        }
        System.out.println(zwierz);
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
