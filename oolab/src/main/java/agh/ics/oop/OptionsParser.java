package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {

    public static MoveDirection [] parse(String[] directions) {

        //mamy strumień informacji i zamieniamy to na tablicę
        return Arrays.stream(directions) //strumień, najpierw zmapowaliśmy każdą instrukcję
                .map(instruction -> switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> null;
                })
                .filter(Objects::nonNull) //co ma z tego przejść a co nie -> nulle nam nie przechodzą move->move != null
                .toArray(MoveDirection[]::new); //:: coś w rodzaju wskaźnika na konstrultor tej tablicy

    }}
