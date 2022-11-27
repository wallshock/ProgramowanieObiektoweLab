package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    protected Map<Vector2d,Animal> animalMap= new HashMap<Vector2d,Animal>();
    private final MapVisualizer mapVisualizer;
    private final Vector2d lowerBound;
    private final Vector2d upperBound;

    public RectangularMap(int width, int height){
        this.mapVisualizer = new MapVisualizer(this);
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
       return animalMap.get(position);
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }


}