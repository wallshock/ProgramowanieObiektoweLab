package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private SortedSet<Vector2d> xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    private SortedSet<Vector2d> yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public MapBoundary(IWorldMap map) {
    }
    public void addElement(Vector2d element) {
        xAxis.add(element);
        yAxis.add(element);
    }

    public void removeElement(Vector2d element) {
        xAxis.remove(element);
        yAxis.remove(element);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.remove(oldPosition);
        yAxis.remove(oldPosition);
        xAxis.add(newPosition);
        yAxis.add(newPosition);
    }

    public Vector2d[] getBoundaries() {
        int minX = xAxis.first().x;
        int maxX = xAxis.last().x;
        int minY = yAxis.first().y;
        int maxY = yAxis.last().y;
        return new Vector2d[]{new Vector2d(minX, minY), new Vector2d(maxX, maxY)};
    }

    public Vector2d getLowerLeft(){
        int xPos = xAxis.first().x;
        int yPos = yAxis.first().y;
        return new Vector2d(xPos, yPos);
    }

    public Vector2d getUpperRight(){
        int xPos = xAxis.last().x;
        int yPos = yAxis.last().y;
        return new Vector2d(xPos, yPos);
    }
}
