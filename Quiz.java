import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("===== JAVA QUIZ =====");

        System.out.println("\n1. Which keyword is used to create a class?");
        System.out.println("A. class");
        System.out.println("B. new");
        System.out.println("C. object");
        System.out.println("D. create");
        System.out.print("Answer: ");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("A")) {
            score++;
        }

        System.out.println("\n2. Which method is the starting point of a Java program?");
        System.out.println("A. start()");
        System.out.println("B. main()");
        System.out.println("C. run()");
        System.out.println("D. begin()");
        System.out.print("Answer: ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("B")) {
            score++;
        }

        System.out.println("\n3. Which symbol is used to end a Java statement?");
        System.out.println("A. :");
        System.out.println("B. .");
        System.out.println("C. ;");
        System.out.println("D. ,");
        System.out.print("Answer: ");
        answer = sc.nextLine();

        if (answer.equalsIgnoreCase("C")) {
            score++;
        }

        System.out.println("\n===== RESULT =====");
        System.out.println("Your Score: " + score + "/3");

        if (score == 3) {
            System.out.println("Excellent!");
        } else if (score >= 1) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Try Again!");
        }

        sc.close();
    }
}
