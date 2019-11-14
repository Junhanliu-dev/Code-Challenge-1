package utilities;

/**
 * Providing the basic direction for robot to turn left or right.
 */

public enum  Direction {

    LEFT(1),RIGHT(-1);

    private final int val;
    
    Direction(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
