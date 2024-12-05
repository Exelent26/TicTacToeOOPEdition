public class PlayersFactory {
    public static final int MODE_PLAYER_VERSUS_PLAYER = 1;
    public static final int MODE_PLAYER_VERSUS_COMPUTER = 2;
    public static final int MODE_COMPUTER_PLAYER_VERSUS_COMPUTER = 3;

    private PlayersFactory(){
    }
    public static Pair get(int mode){
        return switch(mode){
            case MODE_PLAYER_VERSUS_PLAYER -> new Pair(new HumanPlayer(Symbol.X),new HumanPlayer(Symbol.O));
            case MODE_PLAYER_VERSUS_COMPUTER -> new Pair(new HumanPlayer(Symbol.X),new ComputerPlayer(Symbol.O));
            case MODE_COMPUTER_PLAYER_VERSUS_COMPUTER -> new Pair(new ComputerPlayer(Symbol.X),new ComputerPlayer(Symbol.O));
            default -> throw new IllegalArgumentException("Invalid mode");
        };
    }
    public record Pair(Player firstPlayer, Player secondPlayer){

    }
}
