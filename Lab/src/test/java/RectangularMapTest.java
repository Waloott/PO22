package agh.ics.oop;    
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RectangularMapTest {

    @Test
    public void IWorldMapMethods(){
        Vector2d position = new Vector2d(3,5);
        IWorldMap map1 = new RectangularMap(6,15);
        Animal a1 = new Animal(map1,position);
        map1.place(a1);
        Assertions.assertTrue(map1.isOccupied(position));
        Assertions.assertTrue(map1.objectAt(position) instanceof Animal);
        Assertions.assertFalse(map1.canMoveTo(position));

        a1.move(MoveDirection.FORWARD);
        Vector2d new_position = (a1.getPosition());
        Assertions.assertFalse(map1.isOccupied(position));
        Assertions.assertTrue(map1.objectAt(new_position) instanceof Animal);
        Assertions.assertFalse(map1.canMoveTo(new_position));
        Assertions.assertTrue(map1.canMoveTo(position));
    }


    @Test
    public void RectangularMapMovement(){

        String[] args = new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Animal a = new Animal(map,new Vector2d(2,0));
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.LEFT);
        Assertions.assertEquals(a.getPosition(), ((Animal) map.objectAt(new Vector2d(2, 0))).getPosition());

        Animal a2 = new Animal(map,new Vector2d(3,5));
        Assertions.assertEquals(a2.getPosition(), ((Animal) map.objectAt(new Vector2d(3, 5))).getPosition());

        for (int w=0; w<=10; w++)
            for (int h = 0; h <= 5; h++) {
                if (!(h == 0 && w == 2) && !(h == 5 && w == 3)) {
                    assertNull(map.objectAt(new Vector2d(w, h)));
                    Assertions.assertFalse(map.isOccupied(new Vector2d(w, h)));
                    Assertions.assertTrue(map.canMoveTo(new Vector2d(w, h)));
                }
            }
    }

}
