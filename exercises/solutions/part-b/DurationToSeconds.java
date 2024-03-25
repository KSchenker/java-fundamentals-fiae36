import static java.lang.System.out;

public class DurationToSeconds {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("Usage: DurationToSeconds duration...");
      out.println("A duration must either end with d, h, m or s.");
      out.println("A duration can start with a minus sign -.");
      return;
    }

    final int SECONDS_PER_MINUTE = 60;
    final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
    final int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;
    double totalSeconds = 0;

    for (String argument : args) {

      argument = argument.toLowerCase();
      char unit = argument.charAt(argument.length() - 1);
      argument = argument.substring(0, argument.length() - 1);

      int sign = 1;

      if (argument.startsWith("-")) {
        sign = -1;
        argument = argument.substring(1);
      }

      double value = Double.parseDouble(argument);
      totalSeconds += sign * value * switch (unit) {
        case 'd' -> SECONDS_PER_DAY;
        case 'h' -> SECONDS_PER_HOUR;
        case 'm' -> SECONDS_PER_MINUTE;
        case 's' -> 1;
        default -> throw new IllegalArgumentException("Invalid unit: %c".formatted(unit));
      };
    }

    out.println(totalSeconds);
  }


}