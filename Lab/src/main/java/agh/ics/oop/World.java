package agh.ics.oop;
import java.util.Arrays;
import java.util.Objects;

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
        Animal a = new Animal();
        OptionsParser o  = new OptionsParser();
        MoveDirection[] moves = o.parse(new String[]{"f","x","forward","l","eooo","backward"});
        for (MoveDirection move : moves){
            a.move(move);
        }
        System.out.println((a));
    }
}

class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        return direction.toString() + ", " + position.toString();
    }
    private boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    private void moveForward(){
        switch(this.direction){
            case NORTH -> this.position = new Vector2d(this.position.x,this.position.y+1);
            case EAST -> this.position = new Vector2d(this.position.x+1,this.position.y);
            case SOUTH -> this.position = new Vector2d(this.position.x,this.position.y-1);
            case WEST -> this.position = new Vector2d(this.position.x-1,this.position.y);
        }}
    private void moveBackward(){
        switch(this.direction){
            case NORTH -> this.position = new Vector2d(this.position.x,this.position.y-1);
            case EAST -> this.position = new Vector2d(this.position.x-1,this.position.y);
            case SOUTH -> this.position = new Vector2d(this.position.x,this.position.y+1);
            case WEST -> this.position = new Vector2d(this.position.x+1,this.position.y);
        }}
    private Integer offMap(Integer c){
        if(c>4) return 4;
        if(c<0) return 0;
        return c;
    }
    public void move(MoveDirection direction){

        switch(direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> this.moveForward();
            case BACKWARD -> this.moveBackward();
        }
        this.position = new Vector2d(offMap(this.position.x),offMap(this.position.y));
    }

}
class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
    }

    boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) {
            return true;
        }
        return false;
    }

    boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) {
            return true;
        }
        return false;
    }

    Vector2d add(Vector2d other) {
        int x = this.x + other.x;
        int y = this.y + other.y;
        Vector2d v = new Vector2d(x, y);
        return v;
    }

    Vector2d subtract(Vector2d other) {
        int x = this.x - other.x;
        int y = this.y - other.y;
        Vector2d v = new Vector2d(x, y);
        return v;
    }

    Vector2d upperRight(Vector2d other) {
        int x = other.x;
        int y = other.y;
        if (this.x > other.x) {
            x = this.x;
        }
        if (this.y > other.y) {
            y = this.y;
        }
        Vector2d v = new Vector2d(x, y);
        return v;
    }

    Vector2d lowerLeft(Vector2d other) {
        int x = other.x;
        int y = other.y;
        if (this.x < other.x) {
            x = this.x;
        }
        if (this.y < other.y) {
            y = this.y;
        }
        Vector2d v = new Vector2d(x, y);
        return v;
    }

    Vector2d opposite() {
        int x = -1 * this.x;
        int y = -1 * this.y;
        Vector2d v = new Vector2d(x, y);
        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}



