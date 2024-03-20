public class SwitchStatement {

    public static void main(String[] args) {

        String month = "january";
        int daysInMonth = 0;

        if (month.equalsIgnoreCase("january")) {
            daysInMonth = 31;
        } else if (month.equalsIgnoreCase("february")) {
            daysInMonth = 28; // Wir ignorieren Schaltjahr ;-)
        } else if (month.equalsIgnoreCase("march")) {
            daysInMonth = 31;
        }

        // Mehrfachauswahl
        switch (month) {
            case "january":
                daysInMonth = 31;
                break; // Verlässt den switch-Block sofort.
            
            case "february":
                daysInMonth = 28;
                break;

            case "march":
                daysInMonth = 31;
                break;

            default:
                daysInMonth = 30;
                break;
        }

        char letter = 'e';
        switch (letter) {
            case 'a':
            case 'e':
                System.out.println("The letter e is used very often!");
                // break; // Fall-Through!!!
            case 'i':
            case 'o':
            case 'u':
                System.out.printf("Letter %c is a vowel\n", letter);
                break;
            default:
                System.out.printf("Letter %c is a consonant\n", letter);
                break;

        }

        // Modernes switch-Statement mit implizitem break und mehreren Konstanten pro case.
        letter = 'i';
        switch (letter) {
            // Wenn nach dem case ein -> erscheint, wird break automatisch eingefügt.
            case 'a', 'e', 'i', 'o', 'u' -> { 
                System.out.printf("Letter %c is a vowel\n", letter);
                System.out.printf("Vowels are a, e, i, o, u.\n");
            }

            // {} nur notwendig, wenn mehrere Anweisungen nach -> ausgeführt werden sollen.
            default -> System.out.printf("Letter %c is a consonant\n", letter);
        }

        // Das switch Statement gibt es nun auch als switch-Expression.
        month = "March";
        daysInMonth = switch (month.toLowerCase()) {
            case "january", "march", "may", "july", "august", "october", "december" -> 31;
            case "february" -> {
                // Führe Schaltjahrprüfung durch
                // ...
                yield 28; // Rückgabewert
            }
            default -> 30;
        }; // <- Semikolon notwendig, da eine Zuweisung eine Anweisung ist.
        System.out.printf("The month \"%s\" has %d days\n", month, daysInMonth);
    }



}