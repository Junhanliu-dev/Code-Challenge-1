package test.com.junhanliu.pacmanSimulator;

import com.junhanliu.pacmanSimulator.exception.PacmanException;
import com.junhanliu.pacmanSimulator.utilities.Direction;
import com.junhanliu.pacmanSimulator.utilities.Orientation;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    Direction leftSide = Direction.LEFT;
    Direction rightSide = Direction.RIGHT;

    @Test
    void turnWhenFacingEAST() {
        Orientation orientation = Orientation.EAST;

        Assert.assertEquals(Orientation.NORTH,orientation.turn(orientation,leftSide));
        Assert.assertEquals(Orientation.SOUTH, orientation.turn(orientation,rightSide));
    }

    @Test
    void turnWhenFacingSOUTH() {
        Orientation orientation = Orientation.SOUTH;

        Assert.assertEquals(Orientation.EAST,orientation.turn(orientation,leftSide));
        Assert.assertEquals(Orientation.WEST, orientation.turn(orientation,rightSide));
    }

    @Test
    void turnWhenFacingWEST() {
        Orientation orientation = Orientation.WEST;

        Assert.assertEquals(Orientation.SOUTH,orientation.turn(orientation,leftSide));
        Assert.assertEquals(Orientation.NORTH, orientation.turn(orientation,rightSide));
    }

    @Test
    void turnWhenFacingNORTH() {
        Orientation orientation = Orientation.NORTH;

        Assert.assertEquals(Orientation.WEST,orientation.turn(orientation,leftSide));
        Assert.assertEquals(Orientation.EAST, orientation.turn(orientation,rightSide));
    }

    @Test
    void parseOrientation() throws PacmanException {
        assertEquals(Orientation.NORTH, Orientation.parseOrientation("NORTH"));
        assertEquals(Orientation.SOUTH, Orientation.parseOrientation("SOUTH"));
        assertEquals(Orientation.WEST, Orientation.parseOrientation("WEST"));
        assertEquals(Orientation.EAST, Orientation.parseOrientation("EAST"));
    }

    @Test
    void parseOrientationWithError(){
        Throwable error = null;

        try{
            Orientation.parseOrientation("invalid");
        } catch (Throwable e) {
            error = e;
        }

        assertTrue(error instanceof PacmanException);

    }
}