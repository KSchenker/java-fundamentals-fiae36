import static java.lang.System.out;

public class ReverseString {

    public static void main(String[] args) {
        if (args.length < 1) {
            out.println("Usage: program string");
            return;
        }

        String s = args[0];
        for (int i = s.length() - 1; i >= 0; i--) {
            out.print(s.charAt(i));
        }

        out.println();
    }
}