package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.*;

public class World {
    public static void main (String[] args) {
        MoveDirection[] directions;

        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        IWorldMap map = new GrassField(10);
        Vector2d[] positions;

        try {
            positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
        } catch (IllegalArgumentException e) {
            throw e;
        }

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}


