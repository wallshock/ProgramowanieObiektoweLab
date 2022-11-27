package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {return "(%d, %d)".formatted(x, y);}
    boolean precedes(Vector2d other){ return x <= other.x && y <= other.y; }
    boolean follows(Vector2d other){return x >= other.x && y >= other.y;}
    public Vector2d add(Vector2d other){return new Vector2d(x + other.x, y + other.y);}
    public Vector2d subtract(Vector2d other){return new Vector2d(x - other.x, y - other.y);}
    public Vector2d opposite(){return new Vector2d(-this.x, -this.y);}

    public Vector2d upperRight(Vector2d other){
        int tempx;
        int tempy;
        if(other.x>x){tempx = other.x;}
        else{tempx = x;}

        if(other.y>y){tempy = other.y;}
        else{tempy = y;}

        return new Vector2d(tempx, tempy);
    }
    public Vector2d lowerLeft(Vector2d other){
        int tempx;
        int tempy;
        if(other.x<x){tempx = other.x;}
        else{tempx = x;}

        if(other.y<y){tempy = other.y;}
        else{tempy = y;}

        return new Vector2d(tempx, tempy);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d vec2)) return false;
        return this.x == vec2.x && this.y == vec2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}