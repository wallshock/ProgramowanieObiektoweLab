package agh.ics.oop;

import static agh.ics.oop.Direction.RIGHT;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private final Vector2d position = new Vector2d(2,2);

    public String toString(){
        return "(" + position.x + ", " + position.y + ") " + direction;
    }
    boolean isAt(Vector2d position1){
        return (position1.x==position.x && position1.y==position.y);
    }
    public void move(MoveDirection arg){
        switch(arg) {
            case RIGHT -> direction = direction.next();
            case LEFT -> direction = direction.previous();
            case FORWARD -> if(position.x)
            default -> direction = MapDirection.OTHER;

        }
    }
}
