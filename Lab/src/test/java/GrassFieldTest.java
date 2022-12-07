package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GrassFieldTest {
    @Test
    public void IWorldMapMethods(){
        Vector2d position = new Vector2d(3,5);
        IWorldMap map1 = new GrassField(6);
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
    public void GrassFieldMovement() {
        IWorldMap map = new GrassField(10);
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertTrue(map.objectAt(new Vector2d(2, -1)) instanceof Animal);
        Assertions.assertTrue(map.objectAt(new Vector2d(3, 7)) instanceof Animal);

        for (int w = -10; w <= 10; w++) {
            for (int h = -10; h <= 10; h++) {
                if (!(h == -1 && w == 2) && !(h == 7 && w == 3)) {
                    Assertions.assertFalse(map.objectAt(new Vector2d(w, h)) instanceof Animal);
                }
            }
        }

    }
}
