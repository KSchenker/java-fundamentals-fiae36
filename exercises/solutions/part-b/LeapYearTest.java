import static java.lang.System.out;

public class LeapYearTest {

    public static void main(String[] args) {

        if (args.length < 1) {
            out.println("Usage: program year");
            return;
        }

        int year = Integer.parseInt(args[0]);
        boolean isLeapYear;
        if (year % 4 != 0) {
            isLeapYear = false;
        } else if (year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 100 == 0) {
            isLeapYear = false;
        } else {
            isLeapYear = true;
        }
        out.printf("%d ist %s Schaltjahr\n", year, isLeapYear ? "ein" : "kein");

        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }
        out.printf("%d ist %s Schaltjahr\n", year, isLeapYear ? "ein" : "kein");
    }

}