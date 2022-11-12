package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private final MoveDirection[] moveDirectionList;
    private final List<Animal> animalList;

    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions){
        this.map = map;
        this.moveDirectionList = moveDirectionList;
        this.animalList = new ArrayList<Animal>();

        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);
            if(map.place(animal)){
                animalList.add(animal);
            }
        }
    }
    @Override
    public void run() {
        System.out.println(map);
        for (int i = 0; i < moveDirectionList.length; i++){
            animalList.get(i % animalList.size()).move(moveDirectionList[i]);
            System.out.println(map);
        }
    }
}