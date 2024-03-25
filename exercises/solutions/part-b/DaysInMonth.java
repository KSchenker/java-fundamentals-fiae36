import static java.lang.System.out;

public class DaysInMonth {

    public static void main(String[] args) {

        if (args.length < 2) {
            out.println("Usage: program month year");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> {
                boolean isLeapYear = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
                yield isLeapYear ? 29 : 28;
            }
            default -> 30;
        };

        out.printf("%d\n", days);
    }

}