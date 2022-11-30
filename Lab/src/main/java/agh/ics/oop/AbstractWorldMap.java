package agh.ics.oop;
import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals = new ArrayList<>();

    int width;
    int height;
    public abstract Vector2d[] getBounds();
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }
    public boolean place(Animal animal) {
        if (canMoveTo((animal.getPosition()))) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    abstract public boolean canMoveTo(Vector2d position);

    public String toString() {
        return new MapVisualizer(this).draw(getBounds()[0], getBounds()[1]);
    }

}

