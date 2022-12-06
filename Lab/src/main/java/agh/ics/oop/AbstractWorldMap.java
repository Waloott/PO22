package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    int width;
    int height;
    public abstract Vector2d[] getBounds();
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) !=null;
    }
    public boolean place(Animal animal) {
        if (canMoveTo((animal.getPosition()))) {
            this.animals.put(animal.getPosition(),animal);
            return true;
        }
        else{
        throw new IllegalArgumentException("Cant place animal on "+animal.getPosition());}
    }
    public String toString() {
        return new MapVisualizer(this).draw(getBounds()[0], getBounds()[1]);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition,animals.get(oldPosition));
        animals.remove(oldPosition);
    }
}


