import org.junit.jupiter.api.Test;
import utilities.Coordination;
import utilities.Orientation;
import utilities.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Coordination coordination = new Coordination(2,2);
    Orientation orientation;

    @Test
    void nextPositionFacingNorth() {
        orientation = Orientation.NORTH;
        Position position = new Position(coordination,orientation);

        Coordination nextPosition = position.nextPosition();

        assertEquals(2,nextPosition.getX());
        assertEquals(3,nextPosition.getY());
    }

    @Test
    void nextPositionFacingSOUTH() {
        orientation = Orientation.SOUTH;
        Position position = new Position(coordination,orientation);

        Coordination nextPosition = position.nextPosition();

        assertEquals(2,nextPosition.getX());
        assertEquals(1,nextPosition.getY());
    }

    @Test
    void nextPositionFacingEAST() {
        orientation = Orientation.EAST;
        Position position = new Position(coordination,orientation);

        Coordination nextPosition = position.nextPosition();

        assertEquals(3,nextPosition.getX());
        assertEquals(2,nextPosition.getY());
    }

    @Test
    void nextPositionFacingWEST() {
        orientation = Orientation.WEST;
        Position position = new Position(coordination,orientation);

        Coordination nextPosition = position.nextPosition();

        assertEquals(1,nextPosition.getX());
        assertEquals(2,nextPosition.getY());
    }
}