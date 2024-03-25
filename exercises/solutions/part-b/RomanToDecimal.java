import static java.lang.System.out;

public class RomanToDecimal {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("Usage: RomanToDecimal roman-numeral");
      return;
    }

    String roman = args[0].toLowerCase();
    if (!isValid(roman)) {
      out.printf("The roman numeral %s is not valid!\n", roman);
      return;
    }

    int total = 0;

    for (int i = 0; i < roman.length() - 1; i++) {
      char digit = roman.charAt(i);
      char nextDigit = roman.charAt(i + 1);
      boolean isLowerThanNext = compareDigits(digit, nextDigit) < 0;
      // Wenn die Folgeziffer einen höheren Wert besitzt, ist
      // der Wert dieser Ziffer abzuziehen, also mit einem negativen
      // Vorzeichen zu versehen.
      int sign = isLowerThanNext ? -1 : 1;
      total += sign * digitToDecimal(digit);
      // Falls wir an der vorletzten Ziffer angekommen sind,
      // addieren wir noch die letzte Ziffer hinzu, da diese
      // von der Schleife nicht mehr berücksichtigt wird.
      if (i == roman.length() - 2) {
        total += digitToDecimal(nextDigit);
      }
    }

    out.println(total);
  }

  public static int digitToDecimal(char digit) {
    return switch (digit) {
        case 'i' -> 1;
        case 'v' -> 5;
        case 'x' -> 10;
        case 'l' -> 50;
        case 'c' -> 100;
        case 'd' -> 500;
        case 'm' -> 1000;
        default -> throw new IllegalArgumentException("Invalid roman digit: %c".formatted(digit));
      };
  }

  public static int compareDigits(char first, char second) {
    return digitToDecimal(first) - digitToDecimal(second);
  }

  public static boolean isValid(String roman) {
    // Diese Validierung ist nicht vollständig, aber fängt die meisten
    // Fehler ab. iviii wird zum Beispiel nicht als Fehler erkannt.

    // Die Ziffern v, l und d dürfen nicht mehrfach vorkommen.
    if (count(roman, 'v') > 1 || count(roman, 'l') > 1 || count(roman, 'd') > 1) {
      return false;
    }

    // Alle sonstigen Ziffern dürfen nicht mehr als dreimal nacheinander erscheinen.
    // Die einzig gültigen Subtraktionen sind iv, ix, xl, xc, cd und cm.
    String[] invalidPatterns = {
      "iiii", "xxxx", "cccc", "mmmm",
      "il", "ic", "id", "im",
      "vx", "vl", "vc", "vd", "vm",
      "xd", "xm",
      "lc", "ld", "lm",
      "dm"
    };
    for (String pattern : invalidPatterns) {
      if (roman.contains(pattern)) {
        return false;
      }
    }
    return true;
  }

  public static int count(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) count++;
    }
    return count;
  }



}