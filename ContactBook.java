import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CONTACT BOOK =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("\n===== CONTACT DETAILS =====");
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);

        System.out.println("\nContact saved successfully!");

        sc.close();
    }
}
