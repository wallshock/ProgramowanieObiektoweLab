package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
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
        for (int i = 0; i < moveDirectionList.length; i++){
            animalList.get(i % animalList.size()).move(moveDirectionList[i]);
            area.setText("");
            area.setText(map.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // handle the exception...
                // For example consider calling Thread.currentThread().interrupt(); here.
            }
            System.out.println(map);
        }
    }
}