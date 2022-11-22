package agh.ics.oop;
import java.lang.Math;
import java.util.ArrayList;


public class GrassField extends AbstractWorldMap
{
    private int fieldsAmount;
    private Vector2d upperBound;
    private Vector2d lowerBound;
    private ArrayList<Grass> grasses;
    private void setBounds(Vector2d position){
        this.upperBound = upperBound.upperRight(position);
        this.lowerBound = lowerBound.lowerLeft(position);
    }
    public GrassField(int number){

        grasses /* :) */ = new ArrayList<>();
        fieldsAmount = number;
        this.width = (int) Math.sqrt(number*10);
        this.height = (int) Math.sqrt(number*10);
        this.upperBound = new Vector2d(0,0);
        this.lowerBound = new Vector2d(width,height);
        int x;
        int y;
        for (int i=0;i<number;i++) {
            x = (int) Math.floor(Math.random() * (width + 1));
            y = (int) Math.floor(Math.random() * (width + 1));
            while (objectAt(new Vector2d(x, y)) != null) {
                 x = (int) Math.floor(Math.random() * (width + 1));
                 y = (int) Math.floor(Math.random() * (width + 1));
            }
            Grass grass = new Grass(new Vector2d(x,y));
            grasses.add(grass);
            setBounds(grass.getPosition());
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(objectAt(position) instanceof Animal)){
            setBounds(position);
        }
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        if(super.place(animal)){
            setBounds(animal.getPosition());
        }
        return super.place(animal);
    }
    @Override
    public Object objectAt(Vector2d position) {
        Object returned_object = super.objectAt(position);
        if(returned_object!=null){return returned_object;}
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                returned_object = grass;
            }
            }
        return returned_object;
    }
    public Vector2d[] getBounds() {
        return new Vector2d[] {lowerBound,upperBound};
    }
}
