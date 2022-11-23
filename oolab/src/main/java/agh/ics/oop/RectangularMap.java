package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;
    private final List<Animal> animalList;
    private final MapVisualizer mapVisualizer;
    private final Vector2d lowerBound;
    private final Vector2d upperBound;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.mapVisualizer = new MapVisualizer(this);
        this.animalList = new ArrayList<Animal>();
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(width - 1, height - 1);
    }

    @Override
    public void updateMap() {

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerBound) && position.precedes(upperBound) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalList){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }


}