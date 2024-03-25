import static java.lang.System.out;

public class LeapYearGenerator {

    public static void main(String[] args) {
        if (args.length < 2) {
            out.println("Usage: program start-year end-year");
            return;
        }

        int startYear = Integer.parseInt(args[0]);
        int endYear = Integer.parseInt(args[1]);

        for (int year = startYear; year <= endYear; year++) {
            boolean isLeapYear = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
            if (isLeapYear) {
                out.printf("%d\n", year);
            }
        }

    }
}