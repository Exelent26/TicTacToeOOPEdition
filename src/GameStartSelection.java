import Dialogs.Dialog;
import Dialogs.IntegerDialog;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameStartSelection{
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAY = "да";
    private static final String CHOOSE_GAME_MODE_VERSUS_WHO_PLAY = """
            Выберите режим игры:
            1 - Игрок против игрока
            2 - Игрок против компьютера
            3 - Компьютер против компьютера (режим наблюдателя)""";
    private static final String CHOOSE_GAME_MODE_VERSUS_WHO_PLAY_FACTORY_PATTERN = """
            Выберите режим игры:
            %d - Игрок против игрока
            %d - Игрок против компьютера
            %d - Компьютер против компьютера (режим наблюдателя)""";
    private static final String CHOOSE_GAME_MODE_SIZE_OF_BOARD = """
            Выберите размер игрового поля:
            1 - Классический размер 3x3
            2 - Ввести пользовательский размер""";
    private static final String DO_YOU_WANNA_PLAY = "Хотите сыграть в крестики-нолики? Введите \"да\" для старта или любой другой символ для выхода.";
    private static final String WRONG_INPUT = "Неправильный ввод, попробуйте еще раз.";
    private static final String DO_YOU_WANNA_PLAY_AGAIN = "Хотите сыграть еще раз? Введите \"да\" для продолжения или любой другой символ для выхода.";
    private static final String INPUT_SIZE_OF_BOARD = "Введите размер поля (целое число больше 0):";
    private static final String WRONG_INPUT_TEMPLATE = "Неверный ввод. Установлен размер 3x3.";
    private static final String WELCOME_MESSAGE = """
            Перед вами классический вариант крестиков-ноликов.
            Первыми ходят крестики.""";
    private static final String WELCOME_MESSAGE_FOR_CUSTOM_RULES = """
            Перед вами вариант крестиков-ноликов с размерами поля %d x %d.
            Первыми ходят крестики.""";

    public boolean askToPlayFirstTime() {
        System.out.println(DO_YOU_WANNA_PLAY);
        return SCANNER.next().equalsIgnoreCase(PLAY);
    }

    public int chooseBoardSizeByUser() {
        System.out.println(CHOOSE_GAME_MODE_SIZE_OF_BOARD);

        int boardSize = 3;

        try {
            int choice = SCANNER.nextInt();
            if (choice == 1) {
                System.out.println();
                System.out.println(WELCOME_MESSAGE);
                return boardSize;
            } else if (choice == 2) {
                System.out.println(INPUT_SIZE_OF_BOARD);
                int customSize = SCANNER.nextInt();
                if (customSize > 0) {
                    System.out.printf(WELCOME_MESSAGE_FOR_CUSTOM_RULES, customSize, customSize);
                    return customSize;
                } else {
                    System.out.println(INPUT_SIZE_OF_BOARD);
                    System.out.println(WELCOME_MESSAGE);
                }
            } else {
                System.out.println(WRONG_INPUT_TEMPLATE);
                System.out.println(WELCOME_MESSAGE);
            }
        } catch (InputMismatchException e) {
            System.out.println(WRONG_INPUT_TEMPLATE);
            SCANNER.nextLine();
        }

        return boardSize;
    }
    public List<Player> ChooseGameModeByFactoryPattern() {
        String title = CHOOSE_GAME_MODE_VERSUS_WHO_PLAY_FACTORY_PATTERN.formatted(PlayersFactory.MODE_PLAYER_VERSUS_PLAYER,
                PlayersFactory.MODE_PLAYER_VERSUS_COMPUTER,PlayersFactory.MODE_COMPUTER_PLAYER_VERSUS_COMPUTER);
        String failMessage = "WRONG_INPUT";
        List<Integer> players = List.of(PlayersFactory.MODE_PLAYER_VERSUS_PLAYER,PlayersFactory.MODE_PLAYER_VERSUS_COMPUTER,PlayersFactory.MODE_COMPUTER_PLAYER_VERSUS_COMPUTER);
        Dialog<Integer> dialog = new IntegerDialog(title, failMessage, players);
        int mode = dialog.input();
        PlayersFactory.Pair pair = PlayersFactory.get(mode);
        return List.of(pair.firstPlayer(), pair.secondPlayer());
    }

    public List<Player> chooseGameMode() {
        System.out.println(CHOOSE_GAME_MODE_VERSUS_WHO_PLAY);
        List<Player> players = new ArrayList<>();

        while (true) {
            try {
                int mode = SCANNER.nextInt();
                switch (mode) {
                    case 1 -> {
                        players.add(new HumanPlayer(Symbol.X));
                        players.add(new HumanPlayer(Symbol.O));
                        return players;
                    }
                    case 2 -> {
                        players.add(new HumanPlayer(Symbol.X));
                        players.add(new ComputerPlayer(Symbol.O));
                        return players;
                    }
                    case 3 -> {
                        players.add(new ComputerPlayer(Symbol.X));
                        players.add(new ComputerPlayer(Symbol.O));
                        return players;
                    }
                    default -> System.out.println(WRONG_INPUT);
                }
            } catch (InputMismatchException e) {
                System.out.println(WRONG_INPUT);
                SCANNER.nextLine();
            }
        }
    }

    public boolean askToPlayAgain() {
        System.out.println(DO_YOU_WANNA_PLAY_AGAIN);
        return SCANNER.next().equalsIgnoreCase(PLAY);
    }
}