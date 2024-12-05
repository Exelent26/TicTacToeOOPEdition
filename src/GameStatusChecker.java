public class GameStatusChecker {

    private static final String X_WIN = "Победили Крестики";
    private static final String O_WIN = "Победили Нолики";
    private static final String DRAW = "Ничья";


    public boolean isGameEnd(Board board) {

        return isWinner(Symbol.X,board) || isWinner(Symbol.O,board) || isDraw(board);
    }

    public String getGameStatus(Board board) {

        if (isWinner(Symbol.X,board)) {
            return X_WIN;

        } else if (isWinner(Symbol.O,board)) {
            return O_WIN;

        } else if (isDraw(board)) {
            return DRAW;
        }
        return "Игра продолжается";
    }

    private boolean isWinner(Symbol symbol, Board board) {

        for (int i = 1; i <= board.getBoardSize(); i++) {
            if (isRowWin(i, symbol, board) || isColumnWin(i, symbol, board)) {
                return true;
            }
        }
        return isDiagonalWin(symbol, board);
    }

    private boolean isDraw(Board board) {
        for (int x = 1; x <= board.getBoardSize(); x++) {
            for (int y = 1; y <= board.getBoardSize(); y++) {
                if (board.isPositionFreeCheck(new Coordinates(x, y))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isRowWin(int row, Symbol symbol, Board board) {
        for (int column = 1; column <= board.getBoardSize(); column++) {
            if (!symbol.equals(board.getSymbol(row, column))) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnWin(int column, Symbol symbol, Board board) {
        for (int row = 1; row <= board.getBoardSize(); row++) {
            if (!symbol.equals(board.getSymbol(row, column))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(Symbol symbol, Board board) {
        boolean mainDiagonalWin = true;
        boolean secondDiagonalWin = true;

        for (int i = 1; i <= board.getBoardSize(); i++) {
            if (!symbol.equals(board.getSymbol(i, i))) {
                mainDiagonalWin = false;
            }
            if (!symbol.equals(board.getSymbol(i, board.getBoardSize() - i + 1))) {
                secondDiagonalWin = false;
            }
        }

        return mainDiagonalWin || secondDiagonalWin;
    }
}
