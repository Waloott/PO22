package agh.ics.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {
    @Test
    public void testNext(){
        MapDirection n = MapDirection.NORTH;
        MapDirection w = MapDirection.WEST;
        MapDirection e = MapDirection.EAST;
        MapDirection s = MapDirection.SOUTH;

        Assertions.assertEquals(n.next(),MapDirection.EAST);
        Assertions.assertEquals(w.next(),MapDirection.NORTH);
        Assertions.assertEquals(s.next(),MapDirection.WEST);
        Assertions.assertEquals(e.next(),MapDirection.SOUTH);
    }
    @Test
    public void testPrevious(){
        MapDirection n = MapDirection.NORTH;
        MapDirection w = MapDirection.WEST;
        MapDirection e = MapDirection.EAST;
        MapDirection s = MapDirection.SOUTH;

        Assertions.assertEquals(n.previous(),MapDirection.WEST);
        Assertions.assertEquals(w.previous(),MapDirection.SOUTH);
        Assertions.assertEquals(s.previous(),MapDirection.EAST);
        Assertions.assertEquals(e.previous(),MapDirection.NORTH);
    }
}
