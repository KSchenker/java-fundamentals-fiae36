import static java.lang.System.out;

public class Dividability {

    public static void main(String[] args) {
        if (args.length < 2) {
            out.printf("Usage: program number divider\n");
            return;
        }

        int number = Integer.parseInt(args[0]);
        int divider = Integer.parseInt(args[1]);
        int modulo = number % divider;
        
        if (modulo == 0) {
            out.printf(
                "Teilbar, denn %d = %d * %d.\n", 
                number, number / divider, divider);
        } else {
            out.printf(
                "Nicht teilbar, denn %d = %d * %d + %d.\n",
                number, number / divider, divider, modulo);
        }
    }
}