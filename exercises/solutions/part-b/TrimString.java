import static java.lang.System.out;

public class TrimString {

  public static final String ELLIPSIS = "...";

  public static void main(String[] args) {
    if (args.length < 3) {
      out.println("Usage: TrimString string maxLength position");
      out.println("Parameter position can be any of left, right, both and center.");
      return;
    }

    String s = args[0];
    int maxLength = Integer.parseInt(args[1]);
    String position = args[2].toLowerCase();

    // Falls s kurz genug ist, einfach ausgeben und beenden.
    if (s.length() <= maxLength) {
      out.println(s);
      return;
    }
    // Ab hier gilt: s.length() > maxLength.
    // Gib nur Punkte aus, wenn die geforderte Länge
    // höchstens ELLIPSIS Zeichen lang ist.
    if (maxLength <= ELLIPSIS.length()) {
      out.println(ELLIPSIS.substring(0, maxLength));
      return;
    }

    // Hier sollte folgendes gelten: s.length() > maxLength && maxLength > ELLIPSIS.length()
    // Mit Assertions können wir unsere Erwartungen prüfen und das Programm mit einer Exception
    // abbrechen, sofern unsere Erwartungen nicht erfüllt sind.
    // Assertions sind kein Ersatz für Parametervalidierung!
    assert
      s.length() > maxLength && maxLength > ELLIPSIS.length()
      : "Condition ELLIPSIS.length() < maxLength < s.length() not met!";

    String result = switch (position) {
      case "left" -> trimLeft(s, maxLength);
      case "right" -> trimRight(s, maxLength);
      case "both" -> trimBoth(s, maxLength);
      case "center" -> trimCenter(s, maxLength);
      default -> throw new IllegalArgumentException("Invalid position: %s".formatted(position));
    };

    out.println(result);
  }

  public static String trimLeft(String s, int maxLength) {
    // Nimm die letzten (maxLength - 3) Zeichen von s.
    String suffix = s.substring(s.length() - maxLength + ELLIPSIS.length());
    return ELLIPSIS + suffix;
  }

  public static String trimRight(String s, int maxLength) {
    // Nimm die ersten (maxLength - 3) Zeichen von s.
    String prefix = s.substring(0, maxLength - ELLIPSIS.length());
    return prefix + ELLIPSIS;
  }

  public static String trimBoth(String s, int maxLength) {
    if (s.length() <= maxLength) return s;
    if (maxLength <= 2 * ELLIPSIS.length()) return ELLIPSIS.repeat(2).substring(0, maxLength);

    int remainingLength = maxLength - 2 * ELLIPSIS.length();
    int infixStart = s.length() / 2 - remainingLength / 2;
    String infix = s.substring(infixStart, infixStart + remainingLength);
    return ELLIPSIS + infix + ELLIPSIS;
  }

  public static String trimCenter(String s, int maxLength) {
    int remainingLength = maxLength - ELLIPSIS.length();
    // Teile die die von s auszugebenden Zeichen in einen Präfix und einen Suffix.
    // Bei ungerader Zeichenzahl soll der Präfix ein Zeichen mehr als der Suffix
    // bekommen.
    int prefixLength = halve(remainingLength)[0];
    int suffixLength = halve(remainingLength)[1];
    return s.substring(0, prefixLength) + ELLIPSIS + s.substring(s.length() - suffixLength);
  }

  public static int[] halve(int n) {
    int half = n / 2;
    boolean isEven = n % 2 == 0;
    return isEven
      ? new int[] { half, half }
      : new int[] { half + 1, half };
  }


}