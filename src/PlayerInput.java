import java.util.Scanner;

public class PlayerInput {
    private static final String INPUT_COORDINATES = "Введите координаты поочереди, сначала впишите номер строки, нажмите подтвердить, а следом номер столбца";
    private static final String POSITION_ALREADY_CLOSE = "Данная позиция занята, выберите другую";
    private static final String DIGIT_IN_PARAMETERS = "Введите цифру от 1 до 3";
    private static final String DIGIT_NOT_LEGIT = "Введено число не в параметрах";
    private static final String ENTER_DIGIT = "Пожалуйста введите число";

    public static Coordinates makeAvailableCoordinate(Board board) {
        int x;
        int y;
        Coordinates coordinates;
        do {
            System.out.println(INPUT_COORDINATES);
            x = playerInputWithParameters();
            y = playerInputWithParameters();
            coordinates = new Coordinates(x, y);
            if (board.isPositionFreeCheck(coordinates)) {
                System.out.println(POSITION_ALREADY_CLOSE);
                System.out.println();
            }

        } while (board.isPositionFreeCheck(coordinates));
        return coordinates;

    }

    private static int playerInputWithParameters() {
        Scanner scanner = new Scanner(System.in);
        int r;
        while (true) {
            System.out.println(DIGIT_IN_PARAMETERS);
            if (scanner.hasNextInt()) {
                r = scanner.nextInt();
                if (r >= 1 && r <= 3) {
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
        return r;
    }
}
