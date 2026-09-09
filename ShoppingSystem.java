import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ShoppingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Mobile", 20000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Keyboard", 1500));

        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING SYSTEM =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Products ---");

                    for (Product p : products) {
                        System.out.println(
                            p.id + ". " + p.name + " - Rs." + p.price
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == id) {
                            cart.add(p);
                            System.out.println(
                                p.name + " added to cart!"
                            );
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Your Cart ---");

                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (Product p : cart) {
                            System.out.println(
                                p.name + " - Rs." + p.price
                            );
                        }
                    }
                    break;

                case 4:
                    double total = 0;

                    for (Product p : cart) {
                        total += p.price;
                    }

                    System.out.println("\n===== BILL =====");
                    System.out.println("Total Amount: Rs." + total);
                    System.out.println("Order placed successfully!");
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
