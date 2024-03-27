import java.util.Arrays;

public class WeatherStatistics {

  public static void main(String[] args) {
    int[][] weatherData = {
      // 0      1       2       3
      // 7 Uhr, 9 Uhr, 11 Uhr, 13 Uhr
      { 5, 7, 9, 15 },  // 01.03.2024 Index: 0
      { 4, 7, 10, 16 }, // 02.03.2024 Index: 1
      { 1, 8 },         // 03.03.2024 Index: 2
      {},
      { 5 },
      { 3, 4, 5, 6 },
    };

    printWeatherData(weatherData);
  }

  public static void printWeatherData(int[][] data) {
    for (int day = 1; day <= 31; day++) {
      double averageTemperature = average(day, data);
      System.out.printf("Datum: %02d.03.2024 Durchschnitt: %s\n", day,
        Double.isNaN(averageTemperature) 
          ? "N/A" 
          : "%05.2f °C".formatted(averageTemperature)
      );
    }
    System.out.println("=".repeat(50));
    int[] hours = { 7, 9, 11, 13 };
    for (int i = 0; i < hours.length; i++) {
      double averageTemperature = averageHour(hours[i], data);
      System.out.printf("Stunde: %02d Durchschnitt: %s\n", hours[i],
        Double.isNaN(averageTemperature) ? "N/A" : "%05.2f °C".formatted(averageTemperature)
      );
    }
  }

  // Berechne die Durchschnittstemperatur für den Tag `day`
  // day ist der Tag es Monats, also ein Wert im Bereich 1 - 31.
  // Rückgabe ist Double.NaN falls keine Durchschnittstemperatur
  // für diesen Tag berechnet werden kann.
  public static double average(int day, int[][] data) {
    int index = day - 1;
    // Prüfe, ob Wetterdaten für den angeforderten Tag vorliegen.
    if (index < data.length && data[index].length > 0) {
      // Berechne Durchschnittstemperatur
      double sum = 0;
      int[] measurements = data[index]; 
      for (int i = 0; i < measurements.length; i++) {
        sum += measurements[i];
      }
      return sum / measurements.length;
    } else {
      return Double.NaN;
    }
  }

  // Berechne die Durchschnittstemperatur für die angegebene Uhrzeit.
  // Es sind alle Tage des Monats zu berücksichtigen. 
  public static double averageHour(int hour, int[][] data) {
    int[] validHours = { 7, 9, 11, 13 };
    // 1. Prüfe ob Argument hour gültig ist.
    boolean isValid = false;
    int hourIndex = -1;
    for (int i = 0; i < validHours.length; i++) {
      if (hour == validHours[i]) {
        isValid = true;
        hourIndex = i;
        break;
      }
    }
    if (!isValid) {
      throw new IllegalArgumentException("Für die Stunde %d werden keine Messwerte erfasst!".formatted(hour));
    }
    // 2. Berechne Durchschnittstemperatur
    double sum = 0;
    int totalDays = 0;
    for (int day = 1; day <= 31; day++) {
      int dayIndex = day - 1;
      // Existiert für den betrachteten Tag und der Uhrzeit ein Messwert?
      if (dayIndex < data.length && hourIndex < data[dayIndex].length) {
        sum += data[dayIndex][hourIndex];
        totalDays++;
      }
    }
    return totalDays > 0 ? sum / totalDays : Double.NaN;
  }


}