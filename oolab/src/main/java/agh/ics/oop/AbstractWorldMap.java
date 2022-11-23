package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d,Animal> animalMap= new HashMap<Vector2d,Animal>();
    protected Map<Vector2d,Grass> grassMap= new HashMap<Vector2d,Grass>();
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    abstract public void updateMap();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animalMap.containsKey(position));
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animalMap.remove(oldPosition);
            animalMap.put(newPosition, a);
        }
    }
    public List<Animal> getAnimals() {
        return this.animalsList;
    }
    @Override
    public boolean place(Animal animal) {
        if(this.animalMap.get(animal.getPosition()) != null){
            return false;
        }
        this.animalsList.add(animal);
        this.animalMap.put(animal.getPosition(),animal);
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

    @Override
    public String toString(){
        updateMap();
        System.out.println(lowerBound);
        System.out.println(upperBound);
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }


}
