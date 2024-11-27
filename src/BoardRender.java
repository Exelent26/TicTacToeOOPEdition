
public class BoardRender {

    public void render(Board board) {
        System.out.println();
        for (int x = 1; x <= 3; x++) {
            StringBuilder builder = new StringBuilder();
            for (int y = 1; y <= 3; y++) {
                Coordinates coordinates = new Coordinates(x, y);

                Symbol symbol = board.getSymbol(coordinates);
                switch (symbol) {
                    case x -> builder.append(" x ");
                    case o -> builder.append(" o ");
                    case empty -> builder.append("   ");
                    case null -> builder.append("   ");
                }

                if (y < 3) builder.append("|");
            }
            System.out.println(builder);
            if (x < 3) System.out.println("---|---|---");
        }
    }
}
