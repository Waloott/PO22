package agh.ics.oop;
import java.util.PriorityQueue;
public class MapBoundary implements IPositionChangeObserver {
    PriorityQueue<Integer> xAxis = new PriorityQueue<>();
    PriorityQueue<Integer> yAxis = new PriorityQueue<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.add(newPosition.x);
        xAxis.remove(oldPosition.x);
        yAxis.add(newPosition.y);
        yAxis.remove(oldPosition.y);
    }
}
