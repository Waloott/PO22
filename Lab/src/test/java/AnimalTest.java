package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.NamingEnumeration;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void AnimalMapMovement() {
        String[] args = new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Animal a = new Animal(map,new Vector2d(2,0));
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.LEFT);
        Assertions.assertEquals(a.position, ((Animal) map.objectAt(new Vector2d(2, 0))).position);

        Animal a2 = new Animal(map,new Vector2d(3,5));
        Assertions.assertEquals(a2.position, ((Animal) map.objectAt(new Vector2d(3, 5))).position);


        for (int w=0; w<=10; w++)
            for (int h = 0; h <= 5; h++) {
                if (!(h == 0 && w == 2) && !(h == 5 && w == 3)) {
                    assertNull(map.objectAt(new Vector2d(w, h)));
                    Assertions.assertFalse(map.isOccupied(new Vector2d(w, h)));
                    Assertions.assertTrue(map.canMoveTo(new Vector2d(w, h)));
                }
            }
        IWorldMap map2 = new RectangularMap(4,5);
        Animal a3 = new Animal(map2,new Vector2d(1,2));
        Animal a4 = new Animal(map2,new Vector2d(1,2));
        map2.place(a3);
        Assertions.assertEquals(map2.objectAt(new Vector2d(1,2)),a3);
        a3.move(MoveDirection.FORWARD);
        map2.place(a4);
        Assertions.assertEquals(map2.objectAt(new Vector2d(1,2)),a4);
        a4.move(MoveDirection.FORWARD);
        Assertions.assertEquals(map2.objectAt(new Vector2d(1,2)),a4);
        a3.move(MoveDirection.FORWARD);
        a3.move(MoveDirection.FORWARD);
        a3.move(MoveDirection.FORWARD);
        Assertions.assertEquals(map2.objectAt(new Vector2d(1,5)),a3);
        a4.move(MoveDirection.FORWARD);
        a4.move(MoveDirection.FORWARD);
        a4.move(MoveDirection.FORWARD);
        Assertions.assertEquals(map2.objectAt(new Vector2d(1,4)),a4);
    }

}
