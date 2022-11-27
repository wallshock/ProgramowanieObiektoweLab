package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] arguments = {"f","b","r","l","left","right","backward","forward"};
        String[] arguments2 = {"a","b","c"};
        MoveDirection[] moveDirections = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,
                MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD};

        MoveDirection[] correctD = moveDirections;
        MoveDirection[] directions = OptionsParser.parse(arguments);
        assertArrayEquals(correctD,directions);
        assertThrows(IllegalArgumentException.class,()->OptionsParser.parse(arguments2));
    }
}