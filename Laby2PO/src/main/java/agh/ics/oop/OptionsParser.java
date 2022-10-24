package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

class OptionsParser {
    public MoveDirection[] parse(String[] directions) {
        MoveDirection[] newDirections = new MoveDirection[0];
        for (int i = 0; i < directions.length; i++) {
            MoveDirection direction = switch (directions[i]) {
                case "f" ->  MoveDirection.FORWARD;
                case "forward" ->  MoveDirection.FORWARD;
                case "b" ->  MoveDirection.BACKWARD;
                case "backward" ->  MoveDirection.BACKWARD;
                case "l" ->   MoveDirection.LEFT;
                case "left" -> MoveDirection.LEFT;
                case "r" ->  MoveDirection.RIGHT;
                case "right" -> MoveDirection.RIGHT;
                default -> MoveDirection.UNKNOWN;
            };
            if(direction != MoveDirection.UNKNOWN){
            newDirections = Arrays.copyOf(newDirections,newDirections.length+1);
            newDirections[newDirections.length-1] = direction;
        }}
        return newDirections;
    }
}