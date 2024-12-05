import java.util.Scanner;

public class PlayerInputHandler {

    private static final String DIGIT_IN_PARAMETERS = "Введите цифру от 1 до %d";
    private static final String DIGIT_NOT_LEGIT = "Введено неверное число";
    private static final String ENTER_DIGIT = "Пожалуйста введите число";
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE_OF_FIELD_MIN = 1;

    private static int playerInput() {
        return scanner.nextInt();
    }
    public static int checkPlayerInputByBoardSize(Board board) {
        int inputCoordinate;
        while (true) {
            System.out.printf(DIGIT_IN_PARAMETERS,board.getBoardSize());
            System.out.println();
            if (scanner.hasNextInt()) {
                inputCoordinate = playerInput();
                if (inputCoordinate >= SIZE_OF_FIELD_MIN && inputCoordinate <= board.getBoardSize()) {
                    break;
                } else {
                    System.out.println(DIGIT_NOT_LEGIT);
                }
            } else {
                System.out.println(ENTER_DIGIT);
                System.out.println();
                scanner.next();
            }
        }
        return inputCoordinate;
    }






}
