package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private IWorldMap map;
    private MapDirection direction;
    private Vector2d position;
    public Animal() {
        this.position = new Vector2d(2,2);
        this.direction= MapDirection.NORTH;
    }
    public Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2,2);
        this.direction= MapDirection.NORTH;
    }

    private List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

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

    public void move(MoveDirection direction){
        if(direction==MoveDirection.RIGHT){
            this.direction=this.direction.next();
        } else if (direction==MoveDirection.LEFT) {
            this.direction=this.direction.previous();
        }
        else if (direction==MoveDirection.FORWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.add(temp);
            if (map.canMoveTo(beforeTest)) {
                positionChanged(this.position,beforeTest);
                this.position=beforeTest;
            }
        }
        else if (direction==MoveDirection.BACKWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.subtract(temp);
            if (map.canMoveTo(beforeTest)) {
                positionChanged(this.position,beforeTest);
                this.position=beforeTest;
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver Observer: this.observers) {
            Observer.positionChanged(oldPosition,newPosition);
        }
    }

}
