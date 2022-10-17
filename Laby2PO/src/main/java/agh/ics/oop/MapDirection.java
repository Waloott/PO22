package agh.ics.oop;

import javax.print.DocFlavor;

enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        String message = switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
            return message;
        };
    public MapDirection next() {
        if (this == NORTH) {return EAST;}
        if (this == EAST) {return SOUTH;}
        if (this == SOUTH) {return WEST;}
        return NORTH;
        }

    public MapDirection previous(){
        if (this == EAST) {return NORTH;}
        if (this == SOUTH) {return EAST;}
        if (this == WEST) {return SOUTH;}
        return WEST;
    }
    public Vector2d toUnitVector(){
        switch(this){
            case NORTH: return new Vector2d(0,1);
            case EAST: return new Vector2d(1,0);
            case SOUTH: return new Vector2d(0,-1);
            case WEST: return new Vector2d(-1,0);
        };
        return new Vector2d(0,0);
    }
    }

