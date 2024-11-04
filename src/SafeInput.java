import java.util.Scanner;

public class SafeInput {

    public static String getRegExString(Scanner scanner, String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches(regEx)) {
                return input;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static String getNonZeroLenString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    public static int getRangedInt(Scanner scanner, String prompt, int low, int high) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input >= low && input <= high) {
                    return input;
                } else {
                    System.out.printf("Enter a number between %d and %d.%n", low, high);
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
}
