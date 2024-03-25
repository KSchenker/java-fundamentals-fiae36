import static java.lang.System.out;

public class SecondsToDuration {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("Usage: SecondsToDuration seconds");
      return;
    }

    final int SECONDS_PER_MINUTE = 60;
    final int SECONDS_PER_HOUR = 60 * SECONDS_PER_MINUTE;
    final int SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;

    int totalSeconds = Integer.parseInt(args[0]);
    int totalDays = totalSeconds / SECONDS_PER_DAY;
    int totalHours = (totalSeconds % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
    int totalMinutes = (totalSeconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    int remainingSeconds = totalSeconds % SECONDS_PER_MINUTE;

    out.printf("%ds = %dd %dh %dm %ds\n",
      totalSeconds, totalDays, totalHours, totalMinutes, remainingSeconds);

  }

}