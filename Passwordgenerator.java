import java.util.Scanner;
import java.security.SecureRandom;

public class Passwordgenerator {

     private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
     private static final String DIGITS = "0123456789";
     private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

     public static String generatePassword(int length) {
          String allCharacters = UPPER + LOWER + DIGITS + SPECIAL;
          SecureRandom random = new SecureRandom();

          StringBuilder password = new StringBuilder(length);
          for (int i = 0; i < length; i++) {
               int randomIndex = random.nextInt(allCharacters.length());
               password.append(allCharacters.charAt(randomIndex));
          }

          return password.toString();
     }

     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Enter the length of the password:");
          int passwordLength = scanner.nextInt();

          System.out.println("Generating Password...");
          String generatedPassword = generatePassword(passwordLength);
          System.out.println("Generated Password: " + generatedPassword);

          scanner.close();
     }
}
