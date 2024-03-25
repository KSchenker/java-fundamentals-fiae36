import static java.lang.System.out;

public class DecimalToRoman {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("Usage: DecimalToRoman integer");
      out.println("The integer must be in the range 0 - 3999.");
      return;
    }

    int decimal = Integer.parseInt(args[0]);

    int thousands = decimal / 1000;
    int hundreds = (decimal % 1000) / 100;
    int tens = (decimal % 100) / 10;
    int ones = decimal % 10;

    var roman = new StringBuilder();
    roman.append("m".repeat(thousands));
    // 900 wird als CM dargestellt, 400 als CD und 500 als D.
    // Ansonsten werden die 100er einfach als Folge von C's
    // dargestellt und ggf. ein D vorangestellt. 800 ist z.B.
    // DCCC und 300 ist CCC.
    switch (hundreds) {
      case 9 -> roman.append("cm");
      case 4 -> roman.append("cd");
      case 5 -> roman.append("d");
      default -> {
        if (hundreds > 5) roman.append("d");
        roman.append("c".repeat(hundreds % 5));
      }
    }
    // 90 wird als XC, 40 als XL, und 50 als L dargestellt. Ansonsten
    // werden die 10er als Folge von X mit ggf. voranstehendem
    // L dargestellt. Bsp.: 30 ist XXX und 70 ist LXX.
    switch (tens) {
      case 9 -> roman.append("xc");
      case 4 -> roman.append("xl");
      case 5 -> roman.append("l");
      default -> {
        if (tens > 5) roman.append("l");
        roman.append("x".repeat(tens % 5));
      }
    }
    // 9 wird als IX, 4 als IV und 5 als V dargestellt.
    // Ansonsten werden die Einer als Folge von I mit ggf.
    // vorangestelltem V dargestellt. Bsp: 3 ist III und 8 ist
    // VIII.
    switch (ones) {
      case 9 -> roman.append("ix");
      case 4 -> roman.append("iv");
      case 5 -> roman.append("v");
      default -> {
        if (ones > 5) roman.append("v");
        roman.append("i".repeat(ones % 5));
      }
    }

    out.printf("m=%d c=%d x=%d i=%d\n", thousands, hundreds, tens, ones);
    out.println(roman.toString());

  }

}