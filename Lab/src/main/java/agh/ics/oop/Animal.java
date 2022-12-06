package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private Vector2d position;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
    private MapDirection direction;
    private final IWorldMap map;
    public Animal(IWorldMap map){
    this(map,new Vector2d(2,2));
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map= map;
        addObserver(map);
        position = initialPosition;
        direction = MapDirection.NORTH;
    }
    public String toString() {
        return switch(direction){
             case NORTH ->"^";
             case WEST-> "<";
             case EAST -> ">";
             case SOUTH -> "v";
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
            positionChanged(position,newPosition);
            this.position = newPosition;
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer :observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
}

