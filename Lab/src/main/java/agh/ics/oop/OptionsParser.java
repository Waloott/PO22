package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

public class OptionsParser {
    MoveDirection[] newDirections = new MoveDirection[0];
    public MoveDirection[] parse(String[] directions) {
        for (int i = 0; i < directions.length; i++) {
            MoveDirection direction = switch (directions[i]) {
                case "forward","f" ->  MoveDirection.FORWARD;
                case "backward","b" ->  MoveDirection.BACKWARD;
                case "left","l" -> MoveDirection.LEFT;
                case "right","r" -> MoveDirection.RIGHT;
                default -> MoveDirection.UNKNOWN;
            };
            if(direction != MoveDirection.UNKNOWN){
            newDirections = Arrays.copyOf(newDirections,newDirections.length+1);
            newDirections[newDirections.length-1] = direction;
        }}
        return newDirections;
    }
}