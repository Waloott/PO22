package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private Vector2d[] vectors;
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
        //List<Animals> = map.getAnimals();
        int i = 0;
        for (MoveDirection move : moves){
            Animal a = (Animal) map.objectAt(vectors[i]);
            a.move(move);
            //System.out.println(map);
            vectors[i] = a.position;
            i+=1;
            if(i==vectors.length){
                i = 0;
            }
        }
}
}


