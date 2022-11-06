package agh.ics.oop;

public class Animal {
    private IWorldMap map;
    private MapDirection direction;
    private Vector2d position;
    public Animal() {}
    public Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2,2);
        this.direction= MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
    }

    public String toString() {
        return switch (this.direction) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
            case OTHER -> "none";
        };
    }
    public Vector2d getPosition() {
        return position;
    }
    public MapDirection getDirection() {
        return direction;
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    public void move(MoveDirection direction) {
        Vector2d next_pos = position.add(this.direction.toUnitVector());
        switch (direction) {
            case FORWARD -> {
                if (map.canMoveTo(next_pos)) {
                    position = position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(next_pos)) {
                    position = position.subtract(this.direction.toUnitVector());
                }
            }
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case NONE -> {}
        }
    }
}
