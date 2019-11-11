import exception.PacmanException;
import exception.SimulationException;
import exception.TableBuildException;
import utilities.Coordination;
import utilities.Orientation;
import utilities.Position;
import utilities.Table;
import java.util.Scanner;

//Driver for the Pacman
public class Simulator {

    private Table table;
    private Pacman pacman;

    public Simulator(){}

    public void start() throws SimulationException {

        if (table != null){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to Pacman Simulator");
            System.out.println("Please place pacman using PLACE command following with x,y and orientation." +
                    " For example: PLACE 0,0,NORTH");

            placePacman(scanner);
            simulate(scanner);
        }
        else {
            throw new SimulationException("Table must not be null");
        }
    }

    /**
     * based on user input to take action for Pacman
     * @param scanner scanner for user input
     */
    public void simulate(Scanner scanner){

        for (;;){

            try {
                Command command = Command.valueOf(scanner.nextLine().toUpperCase());

                switch (command){
                    case PLACE:
                        throw new PacmanException("You can`t place robot at this stage");

                    case LEFT:
                        pacman.turnLeft();
                        break;

                    case RIGHT:
                        pacman.turnRight();
                        break;

                    case MOVE:
                        if (table.isInsideTable(pacman.getCurrentPosition().nextPosition())){
                            pacman.move();
                        }
                        else {
                            throw new PacmanException("Pacman will be falling, invalid move");
                        }
                        break;
                    case REPORT:
                        report();
                        break;
                    case QUIT:
                        System.out.println("Bye");
                        System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * place the Pacman at the first time. It checks whether the user input is valid
     * @param scanner for user input
     */
    private void placePacman(Scanner scanner){
        boolean isValid = false;

        while (!isValid){
            String input = scanner.nextLine();

            try {
                String[] args = input.split(" ");

                if (!args[0].equalsIgnoreCase(Command.PLACE.value) || args.length !=2){
                    System.out.println("Invalid Command!");
                    System.out.println("Please enter a valid command");
                }
                else {
                    String[] coordInfo = args[1].split(",");

                    int x = Integer.parseInt(coordInfo[0]);
                    int y = Integer.parseInt(coordInfo[1]);
                    Coordination coord = new Coordination(x,y);

                    if (table.isInsideTable(coord)){
                        Orientation orientation = Orientation.parseOrientation(coordInfo[2]);
                        Position initialPosition = new Position(coord,orientation);

                        this.setPacman(new Pacman(initialPosition));
                        isValid = true;
                    }
                    else {
                        throw new PacmanException("Invalie position." + x + " " + y);
                    }

                }
            }
            catch (Exception e){
                System.out.println(e.toString());
                System.out.println("Please enter a valid command");
            }
        }
    }

    private void report(){
        int x = pacman.getCurrentPosition().getCoord().getX();
        int y = pacman.getCurrentPosition().getCoord().getY();
        String orientation = pacman.getCurrentOrientation().toString();

        String output = String.format("Output: %d, %d, %s",x,y,orientation);
        System.out.println(output);

    }

    public void setTable(int rows, int cols) throws TableBuildException {
        if (rows == cols){
            this.table = new Table(rows, cols);
        }
        else {
            throw new TableBuildException("rows and cols should be equal.");
        }
    }

    public void setPacman(Pacman  pacman){
        this.pacman = pacman;
    }

}
