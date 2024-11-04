import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Choose an option: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(scanner);
                    break;
                case "D":
                    deleteItem(scanner);
                    break;
                case "I":
                    insertItem(scanner);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = confirmQuit(scanner);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(Scanner scanner) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add: ");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter item number to delete: ", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }

    private static void insertItem(Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding item to the start.");
            addItem(scanner);
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter position to insert item: ", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to insert: ");
        list.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, list.get(i));
            }
        }
    }

    private static boolean confirmQuit(Scanner scanner) {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
}
