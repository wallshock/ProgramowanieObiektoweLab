package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class World {
    public static void main (String[] args){
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        JFrame frame = new JFrame();
        frame.setTitle("zwierzaki na polu");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(Color.yellow);
        JLabel label = new JLabel();
        engine.run();
    }
}
