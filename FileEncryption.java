import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Scanner;

public class FileEncryption {

    static String key = "1234567890123456";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== FILE ENCRYPTION TOOL =====");
        System.out.println("1. Encrypt File");
        System.out.println("2. Decrypt File");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter output file name: ");
        String outputFile = sc.nextLine();

        if (choice == 1) {
            encrypt(fileName, outputFile);
            System.out.println("File encrypted successfully!");
        } 
        else if (choice == 2) {
            decrypt(fileName, outputFile);
            System.out.println("File decrypted successfully!");
        } 
        else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }

    static void encrypt(String input, String output) throws Exception {
        processFile(input, output, Cipher.ENCRYPT_MODE);
    }

    static void decrypt(String input, String output) throws Exception {
        processFile(input, output, Cipher.DECRYPT_MODE);
    }

    static void processFile(String input, String output, int mode)
            throws Exception {

        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, secretKey);

        FileInputStream in = new FileInputStream(input);
        FileOutputStream out = new FileOutputStream(output);

        byte[] data = in.readAllBytes();
        byte[] result = cipher.doFinal(data);

        out.write(result);

        in.close();
        out.close();
    }
}
