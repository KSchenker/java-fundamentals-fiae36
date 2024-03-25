import static java.lang.System.out;

public class DurationBetween {

  public static void main(String[] args) {
    if (args.length < 2) {
      out.println("Usage: DurationBetween start-time end-time");
      out.println("A time has format hh:mm");
      return;
    }

    final int MINUTES_PER_HOUR = 60;

    String startTime = args[0];
    String endTime = args[1];

    String[] startTimeComponents = startTime.split(":");
    String[] endTimeComponents = endTime.split(":");

    int startTimeHours = Integer.parseInt(startTimeComponents[0]);
    int startTimeMinutes = Integer.parseInt(startTimeComponents[1]);

    int endTimeHours = Integer.parseInt(endTimeComponents[0]);
    int endTimeMinutes = Integer.parseInt(endTimeComponents[1]);

    boolean startIsAfterEnd = startTimeHours > endTimeHours
      || startTimeHours == endTimeHours && startTimeMinutes > endTimeMinutes;

    // Wenn die Endzeit vor der Startzeit liegt, gehen wir davon aus,
    // dass sich die Endzeit auf den Folgetag bezieht. Beispiel:
    // Startzeit: 19:15 Endzeit: 05:45.
    // Die Zeit 05:45 kann man zur Berechnung als "24:00 + 5:45" betrachten,
    // also "29:45". Davon zieht man nun die Startzeit ab.
    if (startIsAfterEnd) {
      endTimeHours += 24;
    }
    int totalHours = endTimeHours - startTimeHours;
    int totalMinutes = endTimeMinutes - startTimeMinutes;
    // Beim Abziehen der Minuten kann ein negativer Wert entstehen, z.B. -20 Minuten.
    // Das entspricht dann -1h und +40 Minuten.
    if (totalMinutes < 0) {
      totalHours--;
      totalMinutes += MINUTES_PER_HOUR;
    }

    out.printf("%dh %dm\n", totalHours, totalMinutes);
  }


}