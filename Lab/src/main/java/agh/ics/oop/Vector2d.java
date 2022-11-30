package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + (this.x) + "," + (this.y) + ")";
    }

    boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
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

