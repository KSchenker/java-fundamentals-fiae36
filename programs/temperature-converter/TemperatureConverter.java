// Wir importieren das statische Feld out der
// Klasse System im Package java.lang
// Vorteil: Wir können den Bezeichner out unqualifiziert
// verwenden.
import static java.lang.System.out;

public class TemperatureConverter {


    public static void main(String[] args) {

        if (args.length == 0) {
            out.println("Zu wenig Argumente. Es fehlt eine Temperatur in Grad Celsius (C) / Fahrenheit (F).");
            return;
        }

        // Wir haben mindestens Argument. Nun schauen wir, ob es sich um Celsius
        // oder Fahrenheit handelt.
        String temperature = args[0].toUpperCase();
        char unit = temperature.charAt(temperature.length() - 1);
        // Transformiere den Betrag in einen double, um damit zu rechnen.
        double value = Double.parseDouble(temperature.substring(0, temperature.length() - 1));
        double result = 0;

        // Variante mit if-else Anweisung
        if (unit == 'C') {
            result = 9.0 / 5 * value + 32;
            // Der Formatspezifizierer %.2f gibt
            // eine Gleitkommazahl gerundet auf 2 Nachkommastellen
            // aus.
            out.printf("%.2fF\n", result);
        } else if (unit == 'F') {
            result = (value - 32) * (5.0 / 9);
            out.printf("%.2fC\n", result);
        } else {
            throw new IllegalArgumentException("Unbekannte Einheit: %c".formatted(unit));
        }

        // Variante mit switch-Statement.
        switch (unit) {
            case 'C' -> {
                double fahrenheit = (9.0 / 5) * value + 32;
                out.printf("%.2fF\n", fahrenheit);
            }
            case 'F' -> {
                double celsius = (value - 32) * (5.0 / 9);
                out.printf("%.2fC\n", celsius);
            }
            default -> throw new IllegalArgumentException("Unbekannte Einheit: %c".formatted(unit));
        }

    }


}