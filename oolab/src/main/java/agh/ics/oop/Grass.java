package agh.ics.oop;

public class Grass {
    private final Vector2d position;
    public Grass(Vector2d InitialPosition) {this.position = InitialPosition;}
    public Vector2d getPosition() {return this.position;}
    @Override
    public String toString(){
        return "*";
    }
}
