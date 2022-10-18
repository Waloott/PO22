package agh.ics.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(-1,3);
        Vector2d v3 = new Vector2d(2,5);
        Assertions.assertTrue(v1.equals(v2));
        Assertions.assertTrue(v1.equals(v1));
        Assertions.assertFalse(v1.equals(v3));
    }
    @Test
    public void testToString(){
        Vector2d v1 = new Vector2d(2,8);
        Assertions.assertEquals(v1.toString(),"(2,8)");
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(2,4);
        Assertions.assertTrue(v1.precedes(v2));
        Assertions.assertTrue(v1.precedes(v1));
        Assertions.assertFalse(v2.precedes(v1));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(-2,-4);
        Vector2d v2 = new Vector2d(1,-2);
        Assertions.assertTrue(v2.follows(v1));
        Assertions.assertTrue(v2.follows(v2));
        Assertions.assertFalse(v1.follows(v2));
    }
    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertEquals(v1.upperRight(v2),new Vector2d(1,3));
    }
    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertEquals(v1.lowerLeft(v2),new Vector2d(-1,2));
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertEquals(v1.add(v2),new Vector2d(0,5));
    }
    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertEquals(v1.subtract(v2),new Vector2d(-2,1));
    }
    @Test
    public void testOpposite(){
        Vector2d v1 = new Vector2d(-3,4);
        Assertions.assertEquals(v1.opposite(),new Vector2d(3,-4));
    }
}
