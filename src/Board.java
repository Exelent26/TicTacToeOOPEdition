import java.util.HashMap;

public class Board {

    private static final int[][][] WINNING_COMBINATIONS = {{{1, 1}, {1, 2}, {1, 3}}, // Горизонтальная 1
            {{2, 1}, {2, 2}, {2, 3}}, // Горизонтальная 2
            {{3, 1}, {3, 2}, {3, 3}}, // Горизонтальная 3
            {{1, 1}, {2, 1}, {3, 1}}, // Вертикальная 1
            {{1, 2}, {2, 2}, {3, 2}}, // Вертикальная 2
            {{1, 3}, {2, 3}, {3, 3}}, // Вертикальная 3
            {{1, 1}, {2, 2}, {3, 3}}, // Диагональ 1
            {{1, 3}, {2, 2}, {3, 1}}  // Диагональ 2
    };
    private static final String X_WIN = "Победили Крестики";
    private static final String O_WIN = "Победили Нолики";
    private static final String DRAW = "Ничья";

    private static final HashMap<Coordinates, Symbol> board = new HashMap<>();

    public void setSymbol(Coordinates coordinates, Symbol symbol) {
        board.put(coordinates, symbol);
    }

    public Symbol getSymbol(Coordinates coordinates) {
        return board.get(coordinates);
    }

    public Symbol getSymbol(int x, int y) {
        return board.get(new Coordinates(x, y));
    }

    private void createDefaultBoard() {
        for (int x = 1; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                board.put(coordinates, Symbol.empty);
            }
        }
    }

    public void createFirstStateOfGame() {
        Board firstState = new Board();
        firstState.createDefaultBoard();
    }

    public boolean isPositionFreeCheck(Coordinates coordinates) {
        return !getSymbol(coordinates).equals(Symbol.empty);
    }

    protected boolean isGameEnd() {
        Board board = new Board();
        if (board.isWinner(Symbol.x)) {
            return true;
        } else if (board.isWinner(Symbol.o)) {
            return true;
        } else if (board.isDraw()) {
            return true;

        }
        return false;
    }

    protected String printEndGameStatus() {

        if (isWinner(Symbol.x)) {
            return X_WIN;

        } else if (isWinner(Symbol.o)) {
            return O_WIN;

        } else if (isDraw()) {
            return DRAW;
        }
        return null;
    }

    private boolean isWinner(Symbol symbol) {
        Board board = new Board();
        for (int[][] combination : WINNING_COMBINATIONS) {
            Symbol first = board.getSymbol(combination[0][0], combination[0][1]);
            Symbol second = board.getSymbol(combination[1][0], combination[1][1]);
            Symbol third = board.getSymbol(combination[2][0], combination[2][1]);
            if (first.equals(symbol) && second.equals(symbol) && third.equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDraw() {

        Board board = new Board();
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (board.getSymbol(coordinates) == Symbol.empty) {
                    return false;
                }
            }
        }
        return true;
    }

}
