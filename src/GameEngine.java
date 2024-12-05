import java.util.List;

public class GameEngine {

    private static final String PLAYER_ONE_TURN = "Ходят крестики";
    private static final String PLAYER_TWO_TURN = "Ходят нолики";



    public void play() {
        GameStartSelection gameSelector = new GameStartSelection();
        boolean playGame = gameSelector.askToPlayFirstTime();
        GameStatusChecker gameStatusChecker = new GameStatusChecker();
        if (!playGame) {
            return;
        }


        while (playGame) {
            int boardSize = gameSelector.chooseBoardSizeByUser();
            Board board = new Board(boardSize);
            List<Player> players = gameSelector.ChooseGameModeByFactoryPattern();
            BoardRender render = new BoardRender();
            render.render(board);

            while (!gameStatusChecker.isGameEnd(board)) {
                makePlayerTurn(players.get(0), board, PLAYER_ONE_TURN, render);
                if (gameStatusChecker.isGameEnd(board)) {
                    break;
                }
                makePlayerTurn(players.get(1), board, PLAYER_TWO_TURN, render);
            }

            System.out.println();
            System.out.println(gameStatusChecker.getGameStatus(board));
            playGame = gameSelector.askToPlayAgain();
        }
    }

    private void makePlayerTurn(Player player, Board board, String turnMessage, BoardRender render) {
        System.out.println();
        System.out.println(turnMessage);
        player.makeMove(board);
        render.render(board);
    }
}
