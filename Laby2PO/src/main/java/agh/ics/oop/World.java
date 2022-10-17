package agh.ics.oop;

import java.util.Map;

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
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
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
        Vector2d position1 = new Vector2d(1,2);
        MapDirection M = MapDirection.NORTH;
        System.out.println(M.toUnitVector());
    }
}

class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+ Integer.toString(this.x) + "," + Integer.toString(this.y)+")";
    }
    boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y){
        return true;}
        return false;
    }
    boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y){
        return true;}
        return false;
    }
    Vector2d add(Vector2d other){
        int x = this.x+other.x;
        int y = this.y+other.y;
        Vector2d v = new Vector2d(x,y);
        return v;
    }
    Vector2d subtract(Vector2d other){
        int x = this.x-other.x;
        int y = this.y-other.y;
        Vector2d v = new Vector2d(x,y);
        return v;
    }
    Vector2d upperRight(Vector2d other){
        int x = other.x;
        int y = other.y;
        if(this.x>other.x){
            x = this.x;
        }
        if(this.y>other.y){
            y = this.y;
        }
        Vector2d v = new Vector2d(x,y);
        return v;
    }
    Vector2d lowerLeft(Vector2d other){
        int x = other.x;
        int y = other.y;
        if(this.x<other.x){
            x = this.x;
        }
        if(this.y<other.y){
            y = this.y;
        }
        Vector2d v = new Vector2d(x,y);
        return v;
    }
    Vector2d opposite(){
        int x = -1*this.x;
        int y = -1*this.y;
        Vector2d v = new Vector2d(x,y);
        return v;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Vector2d)){
            return false;
        }
        Vector2d v = (Vector2d) other;
        if(this.x==v.x && this.y==v.y){
            return true;
        }
        return false;
    }

}
