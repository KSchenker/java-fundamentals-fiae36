import java.util.Arrays;

public class RomanToDecimal {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Verwendung: RomanToDecimal roman-number");
            return;
        }

        // Argument in Kleinbuchstaben umwandeln und ggf. Leerzeichen am
        // Anfang und Ende entfernen.
        String romanNumber = args[0].toLowerCase().trim();
        if (!isValid(romanNumber)) {
            System.out.printf("%s ist keine gültige römische Zahl!\n", romanNumber);
            return;
        }
        System.out.printf("Die römische Zahl %s entspricht der Dezimalzahl %d\n", 
            romanNumber, toDecimal(romanNumber));

        // String digits = "ivxlcdm";
        // for (char digit : digits.toCharArray()) {
        //     System.out.printf("Römische Ziffer %c hat Dezimalwert %d\n", digit, toDecimal(digit));
        // }
    }

    // Method Syntax: Return-Type Function-Name Parameter-List Block
    // Parameter-List Syntax: ( Parameter-List-Syntax )
    // Block Syntax: { list-of-statements; }
    // Parameter-List Syntax: Data-Type Name-of-Parameter [, Data-Type Name-of-Parameter]*
    // [] bedeutet optional und * bedeutet beliebige Wiederholung
    public static int toDecimal(char romanDigit) {
        return switch (Character.toLowerCase(romanDigit)) {
            case 'i' -> 1;
            case 'v' -> 5;
            case 'x' -> 10;
            case 'l' -> 50;
            case 'c' -> 100;
            case 'd' -> 500;
            case 'm' -> 1000;
            default -> {
                String message = "%c ist keine römische Ziffer!".formatted(romanDigit);
                throw new IllegalArgumentException(message);
            }
        };
    }

    // Diese Methode ist eine _Überladung_ (Overloading) der obigen Methode. Der Compiler muss
    // bei jedem Methodenaufruf eindeutig feststellen können, welche Überladung
    // bzw. Variante der Methode gemeint ist. Andernfalls gibt er einen Fehler aus.
    public static int toDecimal(String romanNumber) {
        int sum = 0;

        for (int i = 0; i < romanNumber.length() - 1; i++) {
            char digit = romanNumber.charAt(i);
            char nextDigit = romanNumber.charAt(i + 1);
            boolean isLower = compareDigits(digit, nextDigit) < 0;
            // Falls die römische Ziffer kleiner als ihre Nachfolgerziffer
            // ist, subtrahieren wir ihren Dezimalwert, andernfalls
            // addieren wir ihn.
            int sign = isLower ? -1 : 1;
            // sum = sum + sign * toDecimal(digit);
            sum += sign * toDecimal(digit);
        }
        // Addiere nun noch die letzte Ziffer der römischen Zahl.
        // Diese wurde in der obigen Schleife nicht berücksichtigt.
        sum += toDecimal(romanNumber.charAt(romanNumber.length() - 1));

        return sum;
    }

    // Konvention: Ist der Rückgabewert dieser Methode 0, sind first und second
    // gleichwertig. Falls der Rückgabewert negativ ist, gilt first < second.
    // Falls Rückgabewert > 0, gilt first > second.
    public static int compareDigits(char first, char second) {
        return toDecimal(first) - toDecimal(second);
    }

    public static boolean isValid(String romanNumber) {
        if (containsInvalidChars(romanNumber)) return false;
        if (containsInvalidRepetitions(romanNumber)) return false;
        if (containsInvalidSubtractions(romanNumber)) return false;
        // Es wurden keine ungültigen Muster gefunden.
        return true;
    }

    public static boolean containsInvalidChars(String romanNumber) {
        romanNumber = romanNumber.toLowerCase();
        String digits = "ivxlcdm";
        for (char c : romanNumber.toCharArray()) {
            if (!digits.contains("" + c)) return true;
        }
        return false;
    }

    public static boolean containsInvalidSubtractions(String romanNumber) {
        // Erlaubte Subtraktionen: iv, ix, xl, xc, cd, cm. Alle anderen
        // sind ungültig.
        String[] validSubtractions = { "iv", "ix", "xl", "xc", "cd", "cm" };
        Arrays.sort(validSubtractions);
        for (int i = 0; i < romanNumber.length() - 1; i++) {
            char digit = romanNumber.charAt(i);
            char nextDigit = romanNumber.charAt(i + 1);
            boolean isLower = compareDigits(digit, nextDigit) < 0;
            if (!isLower) continue;
            // An dieser Stelle wissen wir, dass isLower true ist.
            String subtraction = "" + digit + nextDigit;
            if (Arrays.binarySearch(validSubtractions, subtraction) < 0) {
                // Ungültige Subtraktion entdeckt.
                return true;
            }
        }
        return false;
    }

    public static boolean containsInvalidRepetitions(String romanNumber) {
        romanNumber = romanNumber.toLowerCase();

        // Die Ziffern v, l und d dürfen höchstens einmal in der gesamten Zahl erscheinen.
        int vCount = 0, lCount = 0, dCount = 0;
        for (char digit : romanNumber.toCharArray()) {
            switch (digit) {
                case 'v' -> vCount++;
                case 'l' -> lCount++;
                case 'd' -> dCount++;
                default -> {}
            }
        }
        if (vCount > 1 || lCount > 1 || dCount > 1) {
            return true;
        }

        // Prüfe, ob die Ziffern i, x, c, m mehr als dreimal nacheinander vorkommen.
        String[] invalidRepetitions = { "iiii", "xxxx", "cccc", "mmmm" };
        for (String pattern : invalidRepetitions) {
            if (romanNumber.contains(pattern)) return true;
        }

        return false;
    }


}