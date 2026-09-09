import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        double total = 0;

        System.out.println("===== RESTAURANT ORDERING SYSTEM =====");

        System.out.println("\nMenu:");
        System.out.println("1. Pizza     - Rs. 200");
        System.out.println("2. Burger    - Rs. 120");
        System.out.println("3. Biryani   - Rs. 180");
        System.out.println("4. Coffee    - Rs. 80");

        System.out.print("\nEnter your choice: ");
        choice = sc.nextInt();

        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();

        switch (choice) {
            case 1:
                total = 200 * quantity;
                System.out.println("You ordered Pizza.");
                break;

            case 2:
                total = 120 * quantity;
                System.out.println("You ordered Burger.");
                break;

            case 3:
                total = 180 * quantity;
                System.out.println("You ordered Biryani.");
                break;

            case 4:
                total = 80 * quantity;
                System.out.println("You ordered Coffee.");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        if (choice >= 1 && choice <= 4) {
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Bill: Rs. " + total);
            System.out.println("Thank you for your order!");
        }

        sc.close();
    }
}
