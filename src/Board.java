import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Coordinates, Symbol> board;
    private final int boardSize;
    private final String WRONG_COORDINATE_MESSAGE = "Неправильные координаты";
    private static final String INPUT_COORDINATES = "Введите координаты по очереди, сначала впишите номер строки, нажмите подтвердить, а следом номер столбца";
    private static final String POSITION_ALREADY_CLOSE = "Данная позиция занята, выберите другую";

    public int getBoardSize() {
        return boardSize;
    }

    public Board(int BOARD_SIZE) {
        this.boardSize = BOARD_SIZE;
        this.board = new HashMap<>();
    }

    public void setSymbol(Coordinates coordinates, Symbol symbol) {
        if(coordinates.getX()>= 1 && coordinates.getX() <= boardSize && coordinates.getY()>=1 && coordinates.getY() <= boardSize) {
            board.put(coordinates, symbol);
        }else {
            System.out.println(WRONG_COORDINATE_MESSAGE);
        }
    }

    public Symbol getSymbol(Coordinates coordinates) {
        return board.get(coordinates);
    }

    public Symbol getSymbol(int x, int y) {
        return getSymbol(new Coordinates(x, y));
    }

    public boolean isPositionFreeCheck(Coordinates coordinates) {
        return !board.containsKey(coordinates);
    }

    public Coordinates inputAvailableCoordinate(Board board) {
        int x;
        int y;
        Coordinates coordinates;
        do {
            System.out.println(INPUT_COORDINATES);
            x = PlayerInputHandler.checkPlayerInputByBoardSize(board);
            y = PlayerInputHandler.checkPlayerInputByBoardSize(board);
            coordinates = new Coordinates(x, y);
            if (!board.isPositionFreeCheck(coordinates)) {
                System.out.println(POSITION_ALREADY_CLOSE);
                System.out.println();
            }

        } while (!board.isPositionFreeCheck(coordinates));
        return coordinates;

    }


}

