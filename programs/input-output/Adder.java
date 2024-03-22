import java.util.Scanner;
import java.util.InputMismatchException;

public class Adder {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Gib Zahlen ein. Ich werde sie addieren.");

        int sum = 0;
        while (true) {
            try {
                int number = scanner.nextInt();
                sum += number;
            } catch (InputMismatchException e) {
                System.out.println("Fertig mit Einlesen...");
                break;
            }
        }

        System.out.printf("Summe deiner Zahlen: %d\n", sum);
        scanner.close();
    }


}