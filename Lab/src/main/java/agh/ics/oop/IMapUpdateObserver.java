package agh.ics.oop;

import java.io.FileNotFoundException;

public interface IMapUpdateObserver {
    void updateMap(IWorldMap map) throws FileNotFoundException;
}
