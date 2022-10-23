package agh.ics.oop;

import static agh.ics.oop.Direction.RIGHT;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Vector2d getPosition() {
        return position;
    }
    public MapDirection getDirection() {
        return direction;
    }


    public String toString(){
        return "(" + position.getX() + ", " + position.getY() + ") " + direction;
    }
    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }
    private boolean canMoveForward() {
        return ((this.direction == MapDirection.NORTH) && (this.position.getY() < 4)) ||
                ((this.direction == MapDirection.EAST) && (this.position.getX() < 4)) ||
                ((this.direction == MapDirection.SOUTH) && (this.position.getY() > 0)) ||
                ((this.direction == MapDirection.WEST) && (this.position.getX() > 0));
    }

    private boolean canMoveBackward() {
        return ((this.direction == MapDirection.NORTH) && (this.position.getY() > 0)) ||
                ((this.direction == MapDirection.EAST) && (this.position.getX() > 0)) ||
                ((this.direction == MapDirection.SOUTH) && (this.position.getY() < 4)) ||
                ((this.direction == MapDirection.WEST) && (this.position.getX() < 4));
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> {
                if (canMoveForward()) {
                    position = position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (canMoveBackward()) {
                    position = position.subtract(this.direction.toUnitVector());
                }
            }
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case NONE -> {}
        }
    }
}
