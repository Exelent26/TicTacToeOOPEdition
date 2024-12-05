
public class BoardRender {

    public void render(Board board) {
        System.out.println();
        for (int x = 1; x <= board.getBoardSize(); x++) {
            StringBuilder builder = new StringBuilder();
            for (int y = 1; y <= board.getBoardSize(); y++) {
                Coordinates coordinates = new Coordinates(x, y);

                Symbol symbol = board.getSymbol(coordinates);
                if (symbol == Symbol.X) {
                    builder.append(" X ");
                } else if (symbol == Symbol.O) {
                    builder.append(" O ");

                } else if (board.isPositionFreeCheck(coordinates)) {
                    builder.append("   ");

                }

                if (y < board.getBoardSize()) builder.append("|");
            }
            System.out.println(builder);
            StringBuilder razdelitel = new StringBuilder();
            if (x < board.getBoardSize()) {
                razdelitel.append("---|".repeat(Math.max(0, board.getBoardSize()-1)));
                razdelitel.append("---");

                System.out.println(razdelitel);
            }
        }
    }
}
