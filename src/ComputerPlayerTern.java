import java.util.Random;

public class ComputerPlayerTern {

    public static Coordinates MakeComputerCoordinate(Board board) {
        Random rand = new Random();
        Coordinates computerTurnCoordinate;
        do{
            int generateXCoordinateForTurn = rand.nextInt(3)+1;
            int generateYCoordinateForTurn = rand.nextInt(3)+1;
            computerTurnCoordinate = new Coordinates(generateXCoordinateForTurn, generateYCoordinateForTurn);
        }while (board.isPositionFreeCheck(computerTurnCoordinate));

        return computerTurnCoordinate;
    }
}
