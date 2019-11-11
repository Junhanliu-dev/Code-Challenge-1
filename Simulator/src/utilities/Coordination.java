package utilities;

/**
 * Coordination class contains basic x and y axis for Pacman
 */
public class Coordination {

    private int x;
    private int y;

    public Coordination(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
