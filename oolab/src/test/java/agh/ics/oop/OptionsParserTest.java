package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] arguments = {"f","b","n"," ","","r","l","left","rig","lef","s","right","backward","forward"};

        MoveDirection[] moveDirections = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,
                MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD};

        MoveDirection[] correctD = moveDirections;
        MoveDirection[] directions = OptionsParser.parse(arguments);
        assertArrayEquals(correctD,directions);
    }
}