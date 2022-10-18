package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    void MapDirectionNext_WhenMapDirectionEast_ShouldReturnSouth(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH,mapDirection.next());
        mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST,mapDirection.next());
        mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.NORTH,mapDirection.next());
        mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.EAST,mapDirection.next());
    }

    @Test
    void MapDirectionPrevious_WhenMapDirectionEast_ShouldReturnNorth(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.NORTH,mapDirection.previous());
        mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST,mapDirection.previous());
        mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH,mapDirection.previous());
        mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.WEST,mapDirection.previous());
    }
}
