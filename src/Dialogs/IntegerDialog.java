package Dialogs;

import java.util.List;
import java.util.Scanner;

public class IntegerDialog implements Dialog<Integer> {
    private final String title;
    private final String failMessage;
    private final List<Integer> keys;

    public IntegerDialog(String title, String failMessage, List<Integer> keys) {
        this.title = title;
        this.failMessage = failMessage;
        this.keys = keys;
    }

    @Override
    public Integer input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(title);
            String userInput = scanner.nextLine();

            try {
                int choice = Integer.parseInt(userInput);
                if (keys.contains(choice)) {
                    return choice;
                } else {
                    System.out.println(failMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(failMessage);
            }
        }
    }
}
