public class TryCatchFinally {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Es fehlen zwei Zahlenargumente!");
            System.out.println("Synopsis: number number");
            return;
        }

        // Der Anweisungsblock wird auf Exceptions überwacht. Sobald eine Exception auftritt,
        // wird die Ausführung des Anweisungsblocks abgebrochen und ein passender Exception-Handler
        // gesucht. Exception-Handler können mit dem Schlüsselwort catch definiert werden.
        try {
            int numerator = Integer.parseInt(args[0]);
            int denominator = Integer.parseInt(args[1]);
            double result = divide(numerator, denominator);
            System.out.printf("Ergebnis: %d geteilt durch %d ergibt %f\n", numerator, denominator, result);
        } catch (NumberFormatException e) {
            // Hier können wir NumberFormatExceptions behandeln.
            System.out.printf("Ein Fehler ist aufgetreten, weil ein Argument nicht konvertiert werden konnte.\n");
            System.out.printf("Details: %s\n", e.getMessage());
            e.printStackTrace();
        } catch (DivideByZeroException e) {
            System.out.println("Eine Division durch Null ist nicht möglich.");
            System.out.printf("Details: %s\n", e.getMessage());
        }
        // catch (IllegalArgumentException e) {
        //     System.out.printf("Da wurde offensichtlich ein falsches Argument beim Aufruf verwendet.\n");
        //     System.out.printf("Details: %s\n", e.getMessage());
        // } catch (Exception e) {
        //     System.out.printf("Unerwarteter Fehler aufgetreten. Details: %s\n", e.getMessage());
        // }

        System.out.println("Programmende");
    }

    public static double divide(int numerator, int denominator) {
        if (denominator == 0) {
            // Wir lösen selbst eine Exception aus, die vom Aufrufer
            // dieser Methode zu behandeln ist.
            // Die throw-Anweisung beendet die Methode sofort und springt zum Aufrufer,
            // da sie nicht in einem try Block enthalten ist.
            throw new DivideByZeroException("Kann nicht dividieren. Nenner ist 0!");
        }
        // Hinweis: Cast in double ist notwendig, um Gleitkommadivision durchzuführen.
        return numerator / (double)denominator;
    }
}

// Eine RuntimException ist eine unchecked Exception.
// Java stellt es uns frei, ob wir eine solche Exception per catch
// abfangen oder nicht.
class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}