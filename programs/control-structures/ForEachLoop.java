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

        // Die Laufvariable kann nicht dazu benutzt werden, Elemente
        // im Array zu überschreiben! Die Laufvariable ist lediglich
        // eine Kopie des Elements.
        int[] numbers = { 1, 2, 3 };
        for (int n : numbers) {
            n = n * 2; // Kein Effekt auf numbers!
        }
        
        System.out.println(numbers);


    }


}