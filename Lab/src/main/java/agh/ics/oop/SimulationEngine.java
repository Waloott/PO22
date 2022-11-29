package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private Vector2d[] vectors;
    private IWorldMap map;
    private ArrayList<Animal> animals = new ArrayList<>();
    public SimulationEngine(MoveDirection[] moves_, IWorldMap map_, Vector2d[] vectors_) {
        moves = moves_;
        map = map_;
        vectors = vectors_;
        for (Vector2d vector : vectors) {
            map.place(new Animal(map, vector));
            animals.add(new Animal(map,vector));
        }
    }
    public void run(){
        int i = 0;
        for (MoveDirection move : moves){
            Animal a = (Animal) map.objectAt(vectors[i]);
            a.move(move);
            //System.out.println(map);
            vectors[i] = a.getPosition();
            i+=1;
            if(i==vectors.length){
                i = 0;
            }
        }
}
}


