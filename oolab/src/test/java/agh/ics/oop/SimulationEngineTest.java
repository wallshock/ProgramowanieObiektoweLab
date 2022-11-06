package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    public void isOccupiedTest() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertAll(
                () -> assertTrue(map.isOccupied(new Vector2d(2, 4))),
                () -> assertTrue(map.isOccupied(new Vector2d(3, 0))),
                () -> assertFalse(map.isOccupied(new Vector2d(3, 1))),
                () -> assertFalse(map.isOccupied(new Vector2d(2, 3)))
        );
    }

    @Test
    public void placeTest() {
        String[] args = {};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Animal zwierz = new Animal(map, new Vector2d(2,2));
        Animal zwierz2 = new Animal(map, new Vector2d(2,4));
        Animal zwierz3 = new Animal(map, new Vector2d(3,17));
        Animal zwierz4 = new Animal(map, new Vector2d(12,0));

        assertAll(
                () -> assertFalse(map.place(zwierz)),
                () -> assertTrue(map.place(zwierz2)),
                () -> assertFalse(map.place(zwierz3)),
                () -> assertFalse(map.place(zwierz4))
        );
    }

    @Test
    public void canMoveToTest() {
        String[] args = {};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertAll(
                () -> assertFalse(map.canMoveTo(new Vector2d(1,6))),
                () -> assertFalse(map.canMoveTo(new Vector2d(2,2))),
                () -> assertTrue(map.canMoveTo(new Vector2d(3,2))),
                () -> assertTrue(map.canMoveTo(new Vector2d(3,3)))
        );
    }

    @Test
    public void objectAtTest() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertAll(
                () -> assertTrue(map.objectAt(new Vector2d(2,4)) instanceof Animal),
                () -> assertFalse(map.objectAt(new Vector2d(3,1)) instanceof Animal),
                () -> assertTrue(map.objectAt(new Vector2d(3,0)) instanceof Animal),
                () -> assertFalse(map.objectAt(new Vector2d(2,2)) instanceof Animal)
        );
    }
}