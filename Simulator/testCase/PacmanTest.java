import org.junit.jupiter.api.Test;
import utilities.Coordination;
import utilities.Orientation;
import utilities.Position;

import static org.junit.jupiter.api.Assertions.*;

class PacmanTest {
    Coordination coordination = new Coordination(2,2);
    Orientation orientation = Orientation.NORTH;
    Position position = new Position(coordination,orientation);

    Pacman pacman = new Pacman(position);

    @Test
    void move() {
        int expectedX = 2;
        int expectedY = 3;
        pacman.move();

        assertEquals(expectedY,pacman.getCurrentPosition().getCoord().getY());
        assertEquals(expectedX,pacman.getCurrentPosition().getCoord().getX());
        assertEquals(Orientation.NORTH,pacman.getCurrentOrientation());
    }

    @Test
    void turnLeft() {
        pacman.turnLeft();

        assertEquals(Orientation.WEST,pacman.getCurrentOrientation());
    }

    @Test
    void turnRight() {
        pacman.turnRight();

        assertEquals(Orientation.EAST,pacman.getCurrentOrientation());
    }

}