public class HumanPlayer extends Player {

    public HumanPlayer(Symbol symbol) {
        super(symbol);
    }

    public void makeMove(Board board){

        Coordinates playerCoordinates = PlayerInput.makeAvailableCoordinate(board);

        board.setSymbol(playerCoordinates, symbol);
    }
}
