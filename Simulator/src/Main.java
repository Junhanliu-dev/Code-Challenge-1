import exception.SimulationException;
import exception.TableBuildException;

public class Main {
    public static void main(String[] args){

        Simulator simulator = new Simulator();

        try {
            simulator.setTable(5,5);

            simulator.start();

        }
        catch (SimulationException | TableBuildException e){
            e.printStackTrace();
        }
    }
}
