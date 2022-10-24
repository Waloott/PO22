package agh.ics.oop;

import javax.print.DocFlavor;

enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
        };
    public MapDirection next() {
        return switch (this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
        }

    public MapDirection previous(){
        return switch (this) {
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case NORTH -> WEST;
            case EAST -> NORTH;
    };
    }
    public Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }
    }

