package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            String message = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> "Nieznana komenda";
            };
            System.out.println(message);
        }
    }
    public static MoveDirection[] toEnum(String[] directions) {
        MoveDirection[] directionsEnum = new MoveDirection[directions.length];
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
                case "f" -> directionsEnum[i] = MoveDirection.FORWARD;
                case "b" -> directionsEnum[i] = MoveDirection.BACKWARD;
                case "l" -> directionsEnum[i] = MoveDirection.LEFT;
                case "r" -> directionsEnum[i] = MoveDirection.RIGHT;
                default -> directionsEnum[i] = MoveDirection.UNKNOWN;
            }
        }
        return directionsEnum;
    }

    public static void main(String[] args) {

        Application.launch(App.class, args);

    }
}



