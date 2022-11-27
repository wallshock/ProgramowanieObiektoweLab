package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private MapBoundary limits = new MapBoundary(this);
    public GrassField(int p) {
        this.grassMap = new HashMap<>();
        this.lowerBound = new Vector2d(0, 0);
        this.upperBound = new Vector2d((int) Math.sqrt(p * 10), (int) Math.sqrt(p * 10));
        placeGrass(p);
        updateMap();
    }

    private void placeGrass(int grassLimit) {
        Random rand = new Random();
        int Max = (int) Math.sqrt(10 * grassLimit) + 1;
        int i = 0;
        while (i < grassLimit) {
            int randX = rand.nextInt(Max);
            int randY = rand.nextInt(Max);
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (objectAt(grassPosition) == null) {
                grassMap.put(grassPosition, new Grass(grassPosition));
                limits.addElement(grassPosition);
                i++;
            }
        }
    }


    public void updateMap() {
        Vector2d[] pos= limits.getBoundaries();
        this.lowerBound = pos[0];
        this.upperBound = pos[1];
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
        return grassMap.containsKey(position) || super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object o = super.objectAt(position);
        if (o != null) {
            return o;
        }
        return grassMap.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        if (obj instanceof Grass) {
            grassMap.remove(position);
            placeGrass(1);
        }
        return obj ==null||obj instanceof Grass;
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
}

