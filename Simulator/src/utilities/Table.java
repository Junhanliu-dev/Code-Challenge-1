package utilities;

public class Table {

    private int rows;
    private int cols;

    /**
     *
     * @param rows table rows
     * @param cols table columns
     */
    public Table(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    /**
     *
     * @param coordination coordination wants to check if it is inside the table
     * @return false if it is outside
     */

    public boolean isInsideTable(Coordination coordination){
        int coordx = coordination.getX();
        int coordy = coordination.getY();

        return (coordx >= 0 && coordx < rows && coordy >=0 && coordy < cols);
    }

}
