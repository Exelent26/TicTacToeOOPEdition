public class ComputerPlayer extends Player {

    public ComputerPlayer(Symbol symbol) {
        super(symbol);
    }


    @Override
    public void makeMove(Board board) {
        Coordinates computerCoordinate = ComputerPlayerTern.MakeComputerCoordinate(board);
        board.setSymbol(computerCoordinate, symbol);
    }
}