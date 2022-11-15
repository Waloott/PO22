package agh.ics.oop;

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
        String[] args2 = new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args2);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);

        Animal a = new Animal(map, new Vector2d(3,3));
        map.place(a);
        System.out.println(map);
    }
}





