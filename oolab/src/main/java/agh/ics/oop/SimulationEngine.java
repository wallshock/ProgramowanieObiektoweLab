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

    public static JFrame createAndShowGui(String panel) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000,1000);
        return frame;
    }
    @Override
    public void run() {
        JFrame gui = createAndShowGui(map.toString());
        JTextArea area = new JTextArea();
        area.setVisible(true);
        area.setFont(area.getFont().deriveFont(30f));
        area.setBounds(400,400,1000,1000);
        gui.add(area);
        Font font = new Font("Sans Serif", Font.ITALIC, 20);
        area.setFont(font);
        try {
            Thread.sleep(1500);
            System.out.println(map);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // handle the exception...
            // For example consider calling Thread.currentThread().interrupt(); here.
        }
        int i = 0;
        while (i < moveDirectionList.length) {
            for (Animal a : animalMap.values()) {
                if (i == moveDirectionList.length) break;
                a.move(moveDirectionList[i]);
                area.setText(map.toString());
                try {
                    Thread.sleep(500);
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