package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GrassFieldTest {
    private final IWorldMap map = new GrassField(10);

    @Test
    void canMoveTo(){
        this.map.place(new Animal(this.map,new Vector2d(2,4)));
        assertAll (
                () -> assertFalse(this.map.canMoveTo(new Vector2d(2, 4))),
                () -> assertTrue(this.map.canMoveTo(new Vector2d(0, 3))),
                () -> assertTrue(this.map.canMoveTo(new Vector2d(-2, 3)))
        );
    }

    @Test
    void place(){
        assertAll (
                () -> assertTrue(this.map.place(new Animal(this.map,new Vector2d(2,6)))),
                () ->assertFalse(this.map.place(new Animal(this.map,new Vector2d(2,6)))),
                ()-> assertTrue(this.map.place(new Animal(this.map,new Vector2d(5,5))))
        );
    }

    @Test
    void isOccupied(){
        this.map.place(new Animal(this.map,new Vector2d(2,3)));
        this.map.place(new Animal(this.map,new Vector2d(7,3)));
        assertAll (
                () -> assertTrue(this.map.isOccupied(new Vector2d(2,3))),
                () -> assertTrue(this.map.isOccupied(new Vector2d(7,3))),
                () -> assertFalse(this.map.isOccupied(new Vector2d(-1,3)))
        );
    }
    @Test
    void objectAt(){
        Animal animal1 = new Animal(this.map,new Vector2d(2,3));
        Animal animal2 = new Animal(this.map,new Vector2d(4,5));
        this.map.place(animal1);
        this.map.place(animal2);
        assertAll (
                () -> assertEquals(animal1,this.map.objectAt(new Vector2d(2,3))),
                () -> assertEquals(animal2,this.map.objectAt(new Vector2d(4,5))),
                () -> assertNull(this.map.objectAt(new Vector2d(-2,-2)))
        );

    }
}