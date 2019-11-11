package utilities;

public class Position {

    private Coordination coord;
    private Orientation orientation;

    public Position(Coordination coordination, Orientation orientation){
        this.coord = coordination;
        this.orientation = orientation;
    }

    /**
     * checked nextPosition by the simulator, the move forward is safe
     */

    public void moveFoward(){
        this.setCoord(nextPosition());
    }


    /**
     * Calculates next coordinates based on current Pacman`s orientation and coordination
     * @return next step the Pacman will step through
     */

    public Coordination nextPosition(){
        int currentX = coord.getX();
        int currentY = coord.getY();

        switch (orientation){
            case NORTH:
                currentY +=1;
                break;
            case SOUTH:
                currentY -=1;
                break;
            case EAST:
                currentX +=1;
                break;
            case WEST:
                currentX -=1;
                break;
        }

        return new Coordination(currentX,currentY);
    }

    public void setOrientation(Direction direction) {
        this.orientation = orientation.turn(this.orientation, direction);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setCoord(Coordination coord) {
        this.coord = coord;
    }

    public Coordination getCoord()
    {
        return coord;
    }
}
