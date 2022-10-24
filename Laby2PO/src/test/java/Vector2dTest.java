package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(-1,3);
        Vector2d v3 = new Vector2d(2,5);
        assertEquals(v1, v2);
        assertEquals(v1, v1);
        assertNotEquals(v1, v3);
    }
    @Test
    public void testToString(){
        Vector2d v1 = new Vector2d(2,8);
        assertEquals("(2,8)",v1.toString());
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(2,4);
        assertTrue(v1.precedes(v2));
        assertTrue(v1.precedes(v1));
        assertFalse(v2.precedes(v1));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(-2,-4);
        Vector2d v2 = new Vector2d(1,-2);
        assertTrue(v2.follows(v1));
        assertTrue(v2.follows(v2));
        assertFalse(v1.follows(v2));
    }
    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(new Vector2d(1,3), v1.upperRight(v2));
    }
    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(new Vector2d(-1,2), v1.lowerLeft(v2));
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(new Vector2d(0,5), v1.add(v2));
    }
    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(new Vector2d(-2,1),v1.subtract(v2));
    }
    @Test
    public void testOpposite(){
        Vector2d v1 = new Vector2d(-3,4);
        assertEquals(new Vector2d(3,-4),v1.opposite());
    }
}
