package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
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
                i++;
            }
        }
    }


    public void updateMap() {
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(0,0);
        for (Animal animal : animalMap.values()) {
            this.lowerBound = lowerBound.lowerLeft(animal.getPosition());
            this.upperBound = upperBound.upperRight(animal.getPosition());
        }


        for (Grass grass : grassMap.values()) {
            this.lowerBound = lowerBound.lowerLeft(grass.getPosition());
            this.upperBound = upperBound.upperRight(grass.getPosition());
        }

    }
    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
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
}

