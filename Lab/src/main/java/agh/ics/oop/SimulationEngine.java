package agh.ics.oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimulationEngine implements IEngine,Runnable {
    private MoveDirection[] moves;
    private Vector2d[] vectors;
    private ArrayList<IMapUpdateObserver> observers = new ArrayList<>();
    private IWorldMap map;
    private ArrayList<Animal> animals = new ArrayList<>();
    private int moveDelay = 300;

    public SimulationEngine(MoveDirection[] moves_, IWorldMap map_, Vector2d[] vectors_) {
        moves = moves_;
        map = map_;
        vectors = vectors_;
        for (Vector2d vector : vectors) {
            map.place(new Animal(map, vector));
            animals.add(new Animal(map, vector));

        }
    }

    public void addObserver(IMapUpdateObserver observer) {
        this.observers.add(observer);
    }

    public void setDirections(MoveDirection[] directions) {
        this.moves = directions;
    }

    public void notifyObservers(IWorldMap map) throws FileNotFoundException {
        for (IMapUpdateObserver observer : observers) {
            observer.updateMap(map);
        }
    }
    public void run(){
        int i = 0;
        for (MoveDirection move : moves) {
            Animal a = (Animal) map.objectAt(vectors[i]);
            a.move(move);
            try {
                notifyObservers(map);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            vectors[i] = a.getPosition();
            i += 1;
            if (i == vectors.length) {
                i = 0;
            }
        }

    }
}

