package agh.ics.oop;
import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NavigableMap;

public class RectangularMap extends AbstractWorldMap {
    public int width;
    public int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /*
    @Override
    public ArrayList<Animal> getAnimals(){
         // return ArrayList.copyOf(animals); niewydajne
        // lepiej return Collections.unmodifiableList(animals) pamietac
    }
 */
    public Vector2d[] getBounds() {
        return new Vector2d[] {new Vector2d(0,0),new Vector2d(width,height)};
    }
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.getBounds()[0]) && position.precedes(this.getBounds()[1]) && !isOccupied(position);
    }

}