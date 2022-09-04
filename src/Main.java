import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>();

        choices(shoppingList);
    }

    protected static void choices(ArrayList<String> shoppingList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1 - Add an item to shopping list");
            System.out.println("2 - Show Your shopping list");
            System.out.println("3 - Delete an item from shopping list");
            System.out.println("4 - Find item in your shopping list");

            String menuInput = scanner.nextLine();
            if (menuInput.equals("end")) {
                System.out.println("Have a nice day");
                break;
            } else {
                int menuNumb = Integer.parseInt(menuInput);
                switch (menuNumb) {
                    case 1:
                        addItemToList(shoppingList);
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Your Shopping List contains: ");
                        while (true) {
                            for (int i = 0; i < shoppingList.size(); i++) {
                                System.out.println((i + 1) + ". " + shoppingList.get(i));
                            }
                            System.out.println("Your total items in shopping list: " + shoppingList.size());
                            System.out.println();
                            break;
                        }
                        break;

                    case 3:
                        delItemFromList(shoppingList);
                        break;

                    case 4:
                        searchInList(shoppingList);
                        break;
                }
            }
        }
    }

    protected static void addItemToList(ArrayList<String> shoppingList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Name of item you want to add ? ");
            System.out.println("For going back to previous menu, input 'end'. ");
            String itemName = scanner.nextLine();
            if (itemName.equals("end")) {
                System.out.println("Going Back");
                System.out.println();
                break;
            } else {
                shoppingList.add(itemName);
                System.out.println("Your Shopping List contains: ");
                for (int i = 0; i < shoppingList.size(); i++) {
                    System.out.println((i + 1) + ". " + shoppingList.get(i));
                }
            }
            System.out.println("Your total items in shopping list: " + shoppingList.size());
            System.out.println();
        }
    }

    protected static void delItemFromList(ArrayList<String> shoppingList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i));
            }
            System.out.println("Name of item you want to delete ? ");
            System.out.println("For going back to previous menu, input 'end'. ");
            String delItem = scanner.nextLine();
            if (delItem.equals("end")) {
                System.out.println("Going Back");
                break;
            } else {
                try {
                    int delItemInt = Integer.parseInt(delItem);
                    shoppingList.remove(delItemInt - 1);
                    System.out.println("item : " + shoppingList.get(delItemInt - 1) + "was successfully removed from your shopping list.");
                    System.out.println();
                } catch (NumberFormatException e) {
                    shoppingList.remove(delItem);
                    System.out.println("item : " + delItem + "was successfully removed from your shopping list.");
                    System.out.println();
                }

            }
        }
    }

    protected static void searchInList(ArrayList<String> shoppingList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Name of item you want to find in your list ? ");
            System.out.println("For going back to previous menu, input 'end'. ");
            String itemName = scanner.nextLine();
            if (itemName.equals("end")) {
                System.out.println("Going Back");
                System.out.println();
                break;
            } else {
                System.out.println("Found in your shopping list: ");
                for (String shoppingListItem : shoppingList)
                    if (shoppingListItem.toLowerCase().contains(itemName.toLowerCase())) {
                        System.out.println((shoppingList.indexOf(shoppingListItem) + 1) + " " + shoppingListItem);
                    }
            }
        }
    }
}

