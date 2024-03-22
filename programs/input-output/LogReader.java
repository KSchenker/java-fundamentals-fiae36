import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;

public class LogReader {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Aufruf: LogReader <pfad>");
            return;
        }

        Path logPath = Path.of(args[0]);
        // if (Files.notExists(logPath)) {
        //     System.err.printf("Datei %s existiert nicht!\n", logPath);
        //     return;
        // }

        Scanner scanner = null;
        try {
            String logContent = Files.readString(logPath, StandardCharsets.UTF_8);
            scanner = new Scanner(logContent);

            for (int lineNumber = 1; scanner.hasNextLine(); lineNumber++) {
                String line = scanner.nextLine();
                formatLogLine(lineNumber, line);
            }

        } catch (AccessDeniedException e) {
            System.err.printf("Der Lesezugriff auf Datei %s wurde nicht gestattet.\n", logPath);
        } catch (NoSuchFileException e) {
            System.err.printf("Datei %s existiert nicht.\n", logPath);
        } catch (IOException ioe) {
            System.err.printf("Die Datei %s konnte aus unbekannten Gründen nicht gelesen werden.\n", logPath);
            System.err.printf("Exception: %s\n", ioe);
        } finally {
            // Dieser Block wird sowohl im Erfolgsfall als auch im
            // Fehlerfall ausgeführt.
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void formatLogLine(int lineNumber, String line) {
        var scanner = new Scanner(line);
        
        String date = scanner.next();
        String time = scanner.next();
        String message = scanner.nextLine();
        final String ruler = "=".repeat(60);
        
        System.out.println(ruler);
        System.out.printf("Ereignis am %s um %s Uhr (Zeile: %02d)\n", date, time, lineNumber);
        System.out.println(ruler);
        System.out.printf("Meldung: %s\n", message.trim());
        System.out.println();

        scanner.close();
    }


}