import java.util.ArrayList;
import java.util.Scanner;

public class Tracker  {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     INCOME & EXPENSE TRACKER");
        System.out.println("=================================");

        while (true) {

            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Summary");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addIncome();
                    break;

                case 2:
                    addExpense();
                    break;

                case 3:
                    viewTransactions();
                    break;

                case 4:
                    showSummary();
                    break;

                case 5:
                    System.out.println("Thank you for using the tracker!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add income
    static void addIncome() {

        System.out.print("Enter income amount: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter income source: ");
        String source = scanner.nextLine();

        transactions.add(
                new Transaction("Income", source, amount)
        );

        System.out.println("Income added successfully!");
    }

    // Add expense
    static void addExpense() {

        System.out.print("Enter expense amount: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        transactions.add(
                new Transaction("Expense", category, amount)
        );

        System.out.println("Expense added successfully!");
    }

    // Display all transactions
    static void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.println("\n------------- TRANSACTIONS -------------");

        for (int i = 0; i < transactions.size(); i++) {

            Transaction t = transactions.get(i);

            System.out.println(
                    (i + 1) + ". " +
                    t.getType() + " | " +
                    t.getCategory() + " | ₹" +
                    t.getAmount()
            );
        }
    }

    // Display financial summary
    static void showSummary() {

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {

            if (t.getType().equals("Income")) {
                totalIncome += t.getAmount();
            } else {
                totalExpense += t.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        System.out.println("\n------------- FINANCIAL SUMMARY -------------");

        System.out.println("Total Income  : ₹" + totalIncome);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Balance       : ₹" + balance);

        if (balance > 0) {
            System.out.println("Status        : You are saving money.");
        } else if (balance < 0) {
            System.out.println("Status        : You are spending more than your income.");
        } else {
            System.out.println("Status        : No remaining balance.");
        }
    }
}

// Transaction class
class Transaction {

    private String type;
    private String category;
    private double amount;

    public Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
