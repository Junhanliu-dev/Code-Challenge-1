//class to add commands and execute from the console.
public enum Command {

    PLACE("place"),
    MOVE("move"),
    LEFT("left"),
    RIGHT("right"),
    REPORT("report"),
    QUIT("quit");

    public final String value;

    Command(String value){
        this.value = value;
    }
}
