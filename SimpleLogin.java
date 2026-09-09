import java.util.Scanner;

public class SimpleLogin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = "admin";
        String password = "1234";

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!");
            System.out.println("Welcome, " + user);
        } else {
            System.out.println("Invalid Username or Password!");
        }

        sc.close();
    }
}
