import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    private final static String WELCOME_MESSAGE = """
            Перед вами классический вариант крестиков ноликов \
            
            Первыми ходят крестики""";

    private final static String CHOOSE_GAMEMODE = """
            
            Выберите режим игры:\
            
            нажмите 1 для игры игрок против игрока\
            
            нажмите 2 для игры против компьютера\
            
            нажмите 3 для выбора режима наблюдателя(будут играть 2 компьютера друг против друга)""";

    private static final String PLAY = "да";
    private static final String WRONG_INPUT = "Неправильный ввод, попробуйте еще раз";
    private static final String DO_YOU_WANNA_PLAY = "Хотите сыграть в крестики нолики? введите \"да\" для старта или любой другой символ для выхода";
    private static final String PLAYER_ONE_TURN = "Ходят крестики";
    private static final String PLAYER_TWO_TURN = "Ходят нолики";
    private static final String DO_YOU_WANNA_PLAY_AGAIN = "Хотите сыграть еще разок? введите \"да\" для старта или любой другой символ для выхода";


    public void play() {
        boolean playGame = askToPlayFirstTime();

        Board board = new Board();
        if (!playGame) {
            System.exit(0);
        }
        System.out.println(WELCOME_MESSAGE);

        while (playGame) {
            board.createFirstStateOfGame();
            List<Player> players = chooseGameMode();

            BoardRender render = new BoardRender();
            render.render(board);
            while (!board.isGameEnd()) {
                makePlayerTurn(players.getFirst(), board, PLAYER_ONE_TURN, render);
                if (board.isGameEnd()) {
                    break;
                }
                makePlayerTurn(players.get(1), board, PLAYER_TWO_TURN, render);
            }
            System.out.println();
            System.out.println(board.printEndGameStatus());

            playGame = askToPlayAgain();
        }
        System.exit(0);
    }

    private static List<Player> chooseGameMode() {
        System.out.println(CHOOSE_GAMEMODE);

        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        boolean validInput = false;

        while (!validInput) {
            try {
                int n = scanner.nextInt();
                if (n == 1) {
                    players.add(new HumanPlayer(Symbol.x));
                    players.add(new HumanPlayer(Symbol.o));
                    validInput = true;

                } else if (n == 2) {
                    players.add(new HumanPlayer(Symbol.x));
                    players.add(new ComputerPlayer(Symbol.o));
                    validInput = true;

                } else if (n == 3) {
                    players.add(new ComputerPlayer(Symbol.x));
                    players.add(new ComputerPlayer(Symbol.o));
                    validInput = true;

                } else {
                    System.out.println(WRONG_INPUT);
                }
            } catch (Exception e) {
                System.out.println(WRONG_INPUT);
            }
        }

        return players;
    }

    private void makePlayerTurn(Player player, Board board, String turnMessage, BoardRender render) {
        System.out.println();
        System.out.println(turnMessage);
        player.makeMove(board);
        render.render(board);
    }

    private boolean askToPlayFirstTime() {
        System.out.println(DO_YOU_WANNA_PLAY);
        return scanner.next().equalsIgnoreCase(PLAY);
    }

    private boolean askToPlayAgain() {
        System.out.println(DO_YOU_WANNA_PLAY_AGAIN);
        return scanner.next().equalsIgnoreCase(PLAY);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}