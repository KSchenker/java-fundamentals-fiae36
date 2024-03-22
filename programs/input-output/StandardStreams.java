import java.util.Scanner;

public class StandardStreams {

    public static void main(String[] args) {
        // Daten an den Output Stream und an den Error Stream schicken.
        System.out.println("Daten -> Standard Output Stream");
        System.err.println("Daten -> Standard Error Stream");

        // Daten vom Input Stream lesen.
        // Java unterstützt das Schlüsselwort var.
        // var bedeutet, dass der Compiler selbst den korrekten
        // Datentyp für die Variable ermittelt.
        var s = new Scanner(System.in);
        // Lies zwei Zahlen vom Dateneingabestrom (jeweils bis zum nächsten Whitespace).
        int number = s.nextInt();
        int anotherNumber = s.nextInt(); 

        System.out.printf("Eingelesene Zahl ist %d\n", number);
        System.out.printf("Zweite eingelesene Zahl ist %d\n", anotherNumber);
        // Gibt es noch weitere Daten im Input Stream?
        if (s.hasNext()) {
            System.out.println("Es gibt noch mehr Daten vom Input Stream zu lesen");
            System.out.printf("Weitere Daten: %s\n", s.next());
        }

        // Scanner "schließen" und Resourcen freigeben.
        s.close();
    }


}