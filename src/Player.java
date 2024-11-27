public abstract class Player {
    protected Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }


    public abstract void makeMove(Board board);
}

