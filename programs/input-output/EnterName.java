import java.util.Scanner;
import java.util.Locale;

public class EnterName {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Gib deinen Vornamen ein: ");
        String firstName = scanner.nextLine();
        System.out.print("Gib deinen Nachnamen ein: ");
        String lastName = scanner.nextLine();
        System.out.printf("Hallo %s %s!\n", firstName, lastName);

        // Verwende zum Einlesen die regionallen Einstellungen
        // von Deutschland, selbst wenn im Betriebssystem
        // etwas anderes konfiguriert ist.
        // scanner.useLocale(Locale.GERMANY);
        System.out.println(scanner.locale());

        String input;
        
        // Verwende den Punkt (.) als Dezimaltrenner wegen parseDouble.
        System.out.print("Gib eine Zahl ein: ");
        input = scanner.nextLine();
        double firstNumber = Double.parseDouble(input);
        
        // Verwende den Punkt (.) als Dezimaltrenner wegen parseDouble.
        System.out.print("Gib eine zweite Zahl ein: ");
        input = scanner.nextLine();
        double secondNumber = Double.parseDouble(input);
        
        double sum = firstNumber + secondNumber;
        // Verwende den Punkt (.) als Dezimaltrenner statt des Kommas (,).
        // Wir erzwingen das durch Verwendung von Locale.US
        System.out.printf(Locale.US, "%.2f + %.2f = %.2f!\n", firstNumber, secondNumber, sum);

        scanner.close();
    }


}