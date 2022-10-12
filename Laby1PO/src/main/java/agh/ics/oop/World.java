package agh.ics.oop;

public class World {
    public static void run(Direction[] directions) {
        for (Direction direction : directions) {
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
    public static Direction[] toEnum(String[] directions) {
        Direction[] directionsEnum = new Direction[directions.length];
        for (int i=0; i<directions.length;i++){
            switch(directions[i]) {
                case "f" -> directionsEnum[i] = Direction.FORWARD;
                case "b" -> directionsEnum[i] = Direction.BACKWARD;
                case "l" -> directionsEnum[i] = Direction.LEFT;
                case "r" -> directionsEnum[i] = Direction.RIGHT;
                default -> directionsEnum[i] = Direction.UNKNOWN;
             }
        }
        return directionsEnum;
    }

    public static void main(String[] args) {
        Direction[] argsEnum = toEnum(args);
        run(argsEnum);
    }
}

