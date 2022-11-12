package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList = new ArrayList<Animal>();
    protected List<Grass> grassList = new ArrayList<Grass>();
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    abstract public void updateMap();
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();

        if (canMoveTo(animalPosition)) {
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public Object objectAt(Vector2d position) { //zwracam zwierzątko, które już stoi na tym miejscu
        for (Animal animal : animalList) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }

        return null;
    }

    @Override
    public String toString(){ //rysuję mapę o moich wymiarach
        updateMap();
        System.out.println(lowerBound);
        System.out.println(upperBound);
        return new MapVisualizer(this).draw(lowerBound, upperBound);
    }

}
