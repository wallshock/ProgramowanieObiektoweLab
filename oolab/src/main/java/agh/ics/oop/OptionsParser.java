package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public static MoveDirection [] parse(String[] directions) {
        return Arrays.stream(directions).map(instruction -> switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default ->throw new IllegalArgumentException(instruction + " is illegal move");
                })
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }}
