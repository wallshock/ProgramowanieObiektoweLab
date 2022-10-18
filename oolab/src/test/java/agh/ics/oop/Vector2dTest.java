package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d a = new Vector2d(2, 4);
        Vector2d b = new Vector2d(2, 4);
        Vector2d c = new Vector2d(1, 1);
        assertEquals(a, b); //assertEquals(a.equals(b), true);
        assertEquals(b, b);
        assertNotEquals(c, b);

    }
    @Test
    public void toStringTest(){
        Vector2d a = new Vector2d(2, 3);
        String str = "(2, 3)";
        String str2 = "(3, 4)";
        assertEquals(str.toString(), str);
        assertNotEquals(str.toString(), str2);
    }
    @Test
    public void precedesTest(){
        Vector2d a = new Vector2d(5, 9);
        Vector2d b = new Vector2d(5, 9);
        Vector2d c = new Vector2d(0, 1);
        assertTrue(a.precedes(b));
        assertTrue(c.precedes(a));
        assertFalse(a.precedes(c));
    }
    @Test
    public void followsTest(){
        Vector2d a = new Vector2d(6, 2);
        Vector2d b = new Vector2d(6, 2);
        Vector2d c = new Vector2d(0, 1);
        assertTrue(a.follows(b));
        assertFalse(c.follows(a));
        assertTrue(a.follows(c));
    }
    @Test
    public void upperRightTest(){
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(3, 0);
        Vector2d c = new Vector2d(1, 2);
        Vector2d ans = new Vector2d(3, 2);
        assertEquals(a.upperRight(b), ans);
        assertEquals(a.upperRight(c), a);
    }
    @Test
    public void lowerLeftTest(){
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(3, 0);
        Vector2d c = new Vector2d(1, 2);
        Vector2d ans = new Vector2d(1, 0);
        assertEquals(a.lowerLeft(b), ans);
        assertEquals(a.lowerLeft(c), a);
    }
    @Test
    public void addTest(){
        Vector2d a = new Vector2d(2, 3);
        Vector2d b = new Vector2d(4, 4);
        Vector2d c = new Vector2d(-6, -7);
        Vector2d a1 = new Vector2d(6, 7);
        Vector2d b1 = new Vector2d(-4, -4);
        assertEquals(a.add(b), a1);
        assertEquals(a.add(c), b1);
    }
    @Test
    public void substractTest() {
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(3, 4);
        Vector2d c = new Vector2d(-1, -2);
        Vector2d a1 = new Vector2d(-2, -2);
        Vector2d b1 = new Vector2d(-2, -4);
        Vector2d c1 = new Vector2d(2, 4);
        assertEquals(a.subtract(b), a1);
        assertEquals(a.subtract(c), c1);
        assertEquals(c.subtract(a), b1);
    }
    @Test
    public void oppositeTest(){
        Vector2d a = new Vector2d(4, 2);
        Vector2d b = new Vector2d(1, 1);
        Vector2d c = new Vector2d(-4, -2);
        Vector2d a1 = new Vector2d(-1, -1);
        assertEquals(a.opposite(), c);
        assertEquals(b.opposite(), a1);
        assertEquals(c.opposite(), a);
    }



}
