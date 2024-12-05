public class ComputerPlayer extends Player {

    public ComputerPlayer(Symbol symbol) {
        super(symbol);
    }


    @Override
    public void makeMove(Board board) {
        Coordinates computerCoordinate = ComputerPlayerTurn.makeComputerCoordinate(board);
        board.setSymbol(computerCoordinate, symbol);
    }
}