package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] arguments = {"f","b","n"," ","","r","l","left","rig","lef","s","right","backward","forward"};
        MoveDirection[] moveDirections = {MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.FORWARD};
        List<MoveDirection> correctD = Arrays.asList(moveDirections);
        List <MoveDirection> directions = parse(arguments);
        assertEquals(correctD,directions);
    }
}