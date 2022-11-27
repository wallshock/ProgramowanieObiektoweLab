package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private IWorldMap map;
    private SortedSet<Vector2d> xAxis = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    private SortedSet<Vector2d> yAxis = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public MapBoundary(IWorldMap map) {
        this.map = map;
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
        for(Vector2d number : xAxis){
            System.out.println(number);
        }
        System.out.println("endof");
        for(Vector2d number : yAxis){
            System.out.println(number);
        }
        System.out.println("endof");
        return new Vector2d[]{new Vector2d(minX, minY), new Vector2d(maxX, maxY)};
    }
}
