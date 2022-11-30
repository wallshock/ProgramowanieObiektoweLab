package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;



public class App extends Application {

    private AbstractWorldMap map;

    @Override
    public void init() throws IllegalArgumentException{
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions;

        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        map = new GrassField(10);
        Vector2d[] positions;

        try {
            positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
        } catch (IllegalArgumentException e) {
            throw e;
        }

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }

    @Override
    public void start(Stage primaryStage){

        int xMin = map.getdown().x;
        int yMin = map.getdown().y;
        int xMax = map.getup().x;
        int yMax = map.getup().y;
        int width = 30;
        int height = 30;
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.add(new Label("y/x"), 0, 0);


        for (int i = 1; i <= xMax - xMin + 1; i++){
            Label label = new Label(Integer.toString(xMin + i -1));
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            gridPane.add(label, i, 0);
        }

        for (int i = 1; i <= yMax - yMin + 1; i++){
            Label label = new Label(Integer.toString(yMax - i +1));
            GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            gridPane.add(label, 0, i);
        }


        for (int x = xMin; x <= xMax; x++){
            for (int y = yMin; y <= yMax; y++){
                Vector2d position = new Vector2d(x, y);
                if (this.map.isOccupied(position)){
                    Object objectOnMap = this.map.objectAt(position);
                    Label label = new Label(objectOnMap.toString());
                    gridPane.add(label, position.x - xMin + 1, yMax - position.y + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}