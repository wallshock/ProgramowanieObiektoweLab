package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected Map<Vector2d,Animal> animalMap= new HashMap<Vector2d,Animal>();
    protected Map<Vector2d,Grass> grassMap= new HashMap<Vector2d,Grass>();
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    protected MapBoundary limits;
    abstract public void updateMap();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animalMap.containsKey(position));
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animalMap.remove(oldPosition);
            limits.removeElement(oldPosition);
            animalMap.put(newPosition, a);
            limits.addElement(newPosition);
            updateMap();
        }
    }
    @Override
    public boolean place(Animal animal) {
        if(this.animalMap.get(animal.getPosition()) != null){
            throw new IllegalArgumentException(animal.getPosition().toString() + " is not valid position");
        }
        this.animalMap.put(animal.getPosition(),animal);
        limits.addElement(animal.getPosition());
        return true;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animalMap.get(position) != null || this.grassMap.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animalMap.get(position) != null){
            return this.animalMap.get(position);
        }
        if(this.grassMap.get(position) != null){
            return this.grassMap.get(position);
        }
        return null;
    }
    public Vector2d getdown(){
        return limits.getLowerLeft();
    };

    public Vector2d getup(){
        return limits.getUpperRight();
    };

    @Override
    public String toString(){
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }


}
