package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private final MoveDirection[] moveDirectionList;
    protected Map<Vector2d,Animal> animalMap;

    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions){
        this.map = map;
        this.moveDirectionList = moveDirectionList;
        this.animalMap= new HashMap<Vector2d,Animal>();

        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);
            animal.addObserver((IPositionChangeObserver) map);
            if(map.place(animal)){
                animalMap.put(position,animal);
            };
        }
    }
    @Override
    public void run() {
        int i = 0;
        while (i < moveDirectionList.length) {
            for (Animal a : animalMap.values()) {
                if (i == moveDirectionList.length) break;
                a.move(moveDirectionList[i]);
                try {
                    Thread.sleep(1000);
                    System.out.println(map);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // handle the exception...
                    // For example consider calling Thread.currentThread().interrupt(); here.
                }
                i++;
            }
        }
    }
}