package agh.ics.oop;
import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NavigableMap;

public class RectangularMap extends AbstractWorldMap {
    public int width;
    public int height;
    public final Vector2d UPPER_BOUND;
    public final Vector2d LOWER_BOUND;
    //public Vector2d lb = new Vector2d(width, 0); //?
    public ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width_, int height_) {
        width = width_;
        height = height_;
        UPPER_BOUND = new Vector2d(width, height);
        LOWER_BOUND = new Vector2d(0,0);
   }

   /*
   @Override
   public ArrayList<Animal> getAnimals(){
        // return ArrayList.copyOf(animals); niewydajne
       // lepiej return Collections.unmodifiableList(animals) pamietac
   }
*/
    public boolean canMoveTo(Vector2d position) {
        //return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(4,4)) && !isOccupied(position);
        return position.follows(LOWER_BOUND) && position.precedes(UPPER_BOUND) && !isOccupied(position);
    }
    public boolean place(Animal animal) {
        if(canMoveTo((animal.position))){
            this.animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position) {
        //return objectAt(positiom) != null
        //optional powinien byc zamiast nulla
        //z kazdej kolekcji mozna zrobic streama
        for (Animal animal : animals) {
            if (animal.position.equals(position)) {
                return true;
            }
        }
        return false;
        }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.position.equals(position)) {
                return animal;
            }
        }
        return null;
    }
    public String toString(){
        return new MapVisualizer(this).draw(new Vector2d(0,0),new Vector2d(width,height));
    }

    @Override
    public Vector2d getBounds() {
        return null;
    }
}
