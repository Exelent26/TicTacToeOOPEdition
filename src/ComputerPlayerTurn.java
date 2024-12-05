import java.util.Random;

public class ComputerPlayerTurn {
    private static final Random rand = new Random();

    public static Coordinates makeComputerCoordinate(Board board) {
        Coordinates computerTurnCoordinate;
        do{
            int generateXCoordinateForTurn = rand.nextInt(board.getBoardSize())+1;
            int generateYCoordinateForTurn = rand.nextInt(board.getBoardSize())+1;
            computerTurnCoordinate = new Coordinates(generateXCoordinateForTurn, generateYCoordinateForTurn);
        }while (!board.isPositionFreeCheck(computerTurnCoordinate));

        return computerTurnCoordinate;
    }
}
