package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    @Test
    void moveTest() {
        String[] args = {"f", "r", "b", "l", "b", "left", "right", "backward", "forward", "for", "back", "bi", "ri", "test", " ", ""};
        MoveDirection[] directions = OptionsParser.parse(args);

        for (MoveDirection direction : directions) {animal.move(direction);}

        assertAll(
                () -> assertEquals(MapDirection.NORTH, animal.getDirection()),
                () -> assertTrue(animal.isAt(new Vector2d(1, 2)))
        );
    }

    @Test
    void goingOutMap() {
        // given
        String[] args1 = {"f", "f", "f", "f", "f"};
        String[] args2 = {"b", "b", "b", "b", "b", "b", "b"};
        String[] args3 = {"r", "f", "f", "f", "f"};
        String[] args4 = {"l", "f", "f", "f", "f", "f"};

        MoveDirection[] directions1 = OptionsParser.parse(args1);
        MoveDirection[] directions2 = OptionsParser.parse(args2);
        MoveDirection[] directions3 = OptionsParser.parse(args3);
        MoveDirection[] directions4 = OptionsParser.parse(args4);

        Animal test2 = new Animal();
        Animal test3 = new Animal();
        Animal test4 = new Animal();

        //when
        for (MoveDirection direction : directions1) {
            animal.move(direction);
        }
        for (MoveDirection direction : directions2) {
            test2.move(direction);
        }
        for (MoveDirection direction : directions3) {
            test3.move(direction);
        }
        for (MoveDirection direction : directions4) {
            test4.move(direction);
        }
        //then
        assertAll(
                () -> assertEquals(new Vector2d(2, 4), animal.getPosition()),
                () -> assertEquals(new Vector2d(2, 0), test2.getPosition()),
                () -> assertEquals(new Vector2d(4, 2), test3.getPosition()),
                () -> assertEquals(new Vector2d(0, 2), test4.getPosition())
        );

    }
    @Test
    void orientationTest(){
        List<MapDirection> orientations = new ArrayList<>();
        MapDirection[] answer = {MapDirection.NORTH,MapDirection.EAST,MapDirection.SOUTH,MapDirection.WEST,MapDirection.NORTH,MapDirection.NORTH,MapDirection.WEST,MapDirection.SOUTH,MapDirection.EAST,MapDirection.NORTH};
        for(int i=0;i<5;++i) {
            orientations.add(animal.getDirection());
            animal.move(MoveDirection.RIGHT);
        }
        for(int i=0;i<5;++i){
            animal.move(MoveDirection.LEFT);
            orientations.add(animal.getDirection());
        }
        assertEquals(Arrays.asList(answer),orientations);
    }


}