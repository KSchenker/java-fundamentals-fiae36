// Importiere die Klasse Arrays aus dem Package java.util
// Nach dem Import können wir die Klasse Arrays ohne
// Angabe ihres vollqualifizierten Namen ansprechen.
import java.util.Arrays;

public class ForEachLoop {

    public static void main(String[] args) {

        // Wiederhole einen Anweisungsblock für jedes Element,
        // das sich im Array args befindet. Es wird mit dem ersten Element begonnen.
        // Um das Element im Schleifenrumpf anzusprechen, wird die Laufvariable
        // argument definiert.
        for (String argument : args) {
            System.out.printf("Argument: %s\n", argument);
        }

        // Der Datentyp der Laufvariable ist abhängig vom Datentyp der
        // durchzulaufenden Datenmenge.
        int[] primes = { 2, 3, 5, 7, 11, 13 };
        for (int prime : primes) {
            System.out.println(prime);
        }

        // Zeichenketten sind nicht direkt "durchlaufbar". Sie müssen vorher
        // in einen Array oder in einen Stream umgewandelt werden.
        for (char c : "Alice".toCharArray()) {
            System.out.printf("%c ", c);
        }
        System.out.println(); // Zeilenumbruch ausgeben

        // Die Laufvariable kann nicht dazu benutzt werden, Elemente
        // im Array zu überschreiben! Die Laufvariable ist lediglich
        // eine Kopie des Elements.
        int[] numbers = { 1, 2, 3 };
        for (int n : numbers) {
            n = n * 2; // Kein Effekt auf numbers!
        }

        // Ausgabe ist unleserlich.
        System.out.println(numbers);
        // Leserliche Ausgabe mit der Hilfsklasse Arrays.
        System.out.println(Arrays.toString(numbers));
    }


}