import utilities.Direction;
import utilities.Orientation;
import utilities.Position;

public class Pacman {

    private Position currentPosition;
    public Pacman(Position position){
        this.currentPosition = position;
    }

    public void move(){
        currentPosition.moveFoward();
    }

    public void turnLeft(){
        this.currentPosition.setOrientation(Direction.LEFT);
    }

    public void turnRight(){
        this.currentPosition.setOrientation(Direction.RIGHT);
    }

    public Position getCurrentPosition(){
        return currentPosition;
    }

    public Orientation getCurrentOrientation(){
        return this.currentPosition.getOrientation();
    }
}
