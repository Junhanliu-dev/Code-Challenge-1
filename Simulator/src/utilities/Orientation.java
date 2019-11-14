package utilities;
import exception.PacmanException;

import java.util.LinkedList;
import java.util.List;

/**
 * The Orientation class that allows Pacman to recognise their oriantation
 */
public enum  Orientation {
    NORTH,
    WEST,
    SOUTH,
    EAST;

    private static LinkedList<Orientation> orientationList = new LinkedList<>(List.of(NORTH,WEST,SOUTH,EAST));

    /**
     *
     * @param currentOrientation Pacman current facing
     * @param direction Left or Right the Pacman wants to turn
     * @return new direction based on current orientation and intended direction
     */
    public Orientation turn(Orientation currentOrientation, Direction direction){

        int newTurnIndex = orientationList.indexOf(currentOrientation) + (direction.getVal());

        if(newTurnIndex >= orientationList.size()){
            return orientationList.get(0);
        }

        if (newTurnIndex < 0){

            return orientationList.getLast();
        }

        return  orientationList.get(newTurnIndex);
    }

    /**
     *
     * @param orientationString Parse orientation string to enum Orientation
     * @return Orientation enum
     * @throws PacmanException exceptions when parsed incorrectly
     */
    public static Orientation parseOrientation(String orientationString) throws PacmanException {

        try {
            return Orientation.valueOf(orientationString.toUpperCase());
        }
        catch (Exception e){
            throw new PacmanException("Invalid Orientation input.");
        }

    }

}
