import static java.lang.System.out;

public class PalindromTest {

    public static void main(String[] args) {
        if (args.length < 1) {
            out.println("Usage: program string");
            return;
        }

        String word = args[0].toLowerCase();
        if (word.length() < 2) {
            out.printf("%s ist kein Palindrom\n", word);
            return;
        }

        boolean isPalindrom = true;
        for (int left = 0, right = word.length() - 1; left < right; left++, right--) {
            if (word.charAt(left) != word.charAt(right)) {
                isPalindrom = false;
                break;
            }
        }

        out.printf("%s ist %s Palindrom\n", word, isPalindrom ? "ein" : "kein");

    }
}