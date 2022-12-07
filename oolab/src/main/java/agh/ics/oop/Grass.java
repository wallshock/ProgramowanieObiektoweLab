package agh.ics.oop;

public class Grass implements IMapElement{
    private final Vector2d position;
    public Grass(Vector2d InitialPosition) {this.position = InitialPosition;}
    public Vector2d getPosition() {return this.position;}
    @Override
    public String toString(){
        return "*";
    }

    @Override
    public String getImagePath() {
        return "C:\\Users\\rudy7\\IdeaProjects\\ProgramowanieObiektoweLab\\oolab\\src\\main\\resources\\grass.jpg";
    }
}
