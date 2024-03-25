import static java.lang.System.out;

public class PadString {

  public static void main(String[] args) {
    if (args.length < 4) {
      out.println("Usage: PadString string minLength fillChar position");
      out.println("Parameter position is either left, right or both");
      return;
    }

    String s = args[0];
    int minLength = Integer.parseInt(args[1]);
    char fillChar = args[2].charAt(0);
    String position = args[3].toLowerCase();

    String padded = switch (position) {
      case "left" -> padLeft(s, minLength, fillChar);
      case "right" -> padRight(s, minLength, fillChar);
      case "both" -> padBoth(s, minLength, fillChar);
      default -> throw new IllegalArgumentException("Invalid position: %s".formatted(position));
    };

    out.println(padded);
  }

  public static String padLeft(String s, int minLength, char fill) {
    return getPadding(s, minLength, fill) + s;
  }

  public static String padRight(String s, int minLength, char fill) {
    return s + getPadding(s, minLength, fill);
  }

  public static String padBoth(String s, int minLength, char fill) {
    String padding = getPadding(s, minLength, fill);
    int paddingLength = padding.length();
    return switch (paddingLength) {
      case 0 -> s;
      case 1 -> padding + s;
      default -> {
        // Wenn das Padding ungerade Länge hat,
        // soll von links ein Zeichen mehr aufgefüllt werden,
        // als von rechts.
        int half = paddingLength % 2 == 0
          ? paddingLength / 2
          : paddingLength / 2 + 1;
        yield padding.substring(0, half) + s + padding.substring(half);
      }
    };
  }

  public static String getPadding(String s, int minLength, char fill) {
    return s.length() >= minLength
      ? ""
      : String.valueOf(fill).repeat(minLength - s.length());
  }

}