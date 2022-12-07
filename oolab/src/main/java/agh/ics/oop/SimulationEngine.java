package agh.ics.oop;
import agh.ics.oop.gui.App;

import java.util.HashMap;
import java.util.Map;

public class SimulationEngine implements IEngine,Runnable{
    private final IWorldMap map;
    private MoveDirection[] moveDirectionList;
    protected Map<Vector2d,Animal> animalMap;
    private int moveDelay;
    private App app;

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
    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions, int moveDelay, App app){
        this.map = map;
        this.moveDirectionList = moveDirectionList;
        this.animalMap= new HashMap<Vector2d,Animal>();
        this.moveDelay = moveDelay;
        this.app = app;

        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);
            animal.addObserver((IPositionChangeObserver) map);
            if(map.place(animal)){
                animalMap.put(position,animal);
            };
        }
    }

    public void setMoveDirections(MoveDirection[] moveDirectionList){
        this.moveDirectionList = moveDirectionList;
    }
    @Override
    public void run() {
        int i = 0;
        while (i < moveDirectionList.length) {
            for (Animal a : animalMap.values()) {
                if (i == moveDirectionList.length) break;
                a.move(moveDirectionList[i]);
                try {
                    Thread.sleep(moveDelay);
                    System.out.println(map);
                    app.refreshMap();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}