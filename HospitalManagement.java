import java.util.Scanner;

public class HospitalManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Hospital Management System =====");

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        System.out.println("\n===== Patient Details =====");
        System.out.println("Patient Name : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Disease      : " + disease);
        System.out.println("Doctor       : " + doctor);

        System.out.println("\nAppointment booked successfully!");

        sc.close();
    }
}
