package org.example.agh.ics.oop;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean precedes(Vector2d other){

        return x <= other.x && y <= other.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    boolean follows(Vector2d other){
        return x >= other.x && y >= other.y;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x, y);  //%d -> int
    }


}
