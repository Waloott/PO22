package agh.ics.oop;

public class Animal {
    public Vector2d position;
    private MapDirection direction;
    private final  IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map;
        position = new Vector2d(2,2);
        direction = MapDirection.NORTH;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map= map;
        position = initialPosition;
        direction = MapDirection.NORTH;

    }

    public String toString() {
        return switch(direction){
             case NORTH ->"^";
             case WEST-> ">";
             case EAST -> "v";
             case SOUTH -> "<";
     };
    }

    private boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d newPosition = this.position;
        Vector2d orientationVector = this.direction.toUnitVector();
        switch(direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> newPosition = this.position.add(orientationVector);
            case BACKWARD -> newPosition = this.position.subtract(orientationVector);
        }
        if(map.canMoveTo(newPosition)){
            this.position = newPosition;
        }
    }

}

