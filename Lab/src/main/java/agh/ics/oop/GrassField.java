package agh.ics.oop;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
   public Map<Vector2d, Grass> grasses;
    public GrassField(int number) {

        grasses = new HashMap<>();
        this.width = (int) Math.sqrt(number * 10);
        this.height = (int) Math.sqrt(number * 10);
        int x;
        int y;
        for (int i = 0; i < number; i++) {
            x = (int) Math.floor(Math.random() * (width + 1));
            y = (int) Math.floor(Math.random() * (width + 1));
            while (objectAt(new Vector2d(x, y)) != null) {
                x = (int) Math.floor(Math.random() * (width + 1));
                y = (int) Math.floor(Math.random() * (width + 1));
            }
            System.out.println(new Vector2d(x,y));
            Grass grass = new Grass(new Vector2d(x, y));
            grasses.put(grass.getPosition(), grass);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object returned_object = super.objectAt(position);
        if (returned_object != null) {
            return returned_object;
        }
            return grasses.get(position);
    }

        public Vector2d[] getBounds () {
            Vector2d upperBound = new Vector2d(-999999,-999999);
            Vector2d lowerBound = new Vector2d(999999,999999);
            for (Vector2d position : animals.keySet()) {
                lowerBound = lowerBound.lowerLeft(position);
                upperBound = upperBound.upperRight(position);
            }
            for (Vector2d position : grasses.keySet()) {
                lowerBound = lowerBound.lowerLeft(position);
                upperBound = upperBound.upperRight(position);
            }
            return new Vector2d[]{lowerBound, upperBound};
        }
}

