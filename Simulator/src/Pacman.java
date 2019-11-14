import utilities.Coordination;
import utilities.Direction;
import utilities.Orientation;
import utilities.Position;

import	java.time.Period;
public class Pacman {

    private Position currentPosition;
    public Pacman(Position position){
        this.currentPosition = position;
    }

    public void move(){
        currentPosition.setCoord(peekNextPosition());
    }


    public void turnLeft(){
        this.currentPosition.setOrientation(Direction.LEFT);
    }

    public void turnRight(){
        this.currentPosition.setOrientation(Direction.RIGHT);
    }
    public Coordination peekNextPosition(){
        return this.currentPosition.nextPosition();
    }

    public Position getCurrentPosition(){
        return currentPosition;
    }

    public Orientation getCurrentOrientation(){
        return this.currentPosition.getOrientation();
    }
}
