import static java.lang.System.out;

public class MergeStrings {

    public static void main(String[] args) {
        if (args.length < 2) {
            out.println("Usage: program word1 word2 ... wordN");
            return;
        }

        // Bestimme die maximale Wortlänge unter den gegebenen Wörtern.
        int maxLength = args[0].length();
        for (int i = 1; i < args.length; i++) {
            int wordLength = args[i].length();
            maxLength = wordLength > maxLength ? wordLength : maxLength;
        }

        var result = new StringBuilder();
        // Wir schauen uns jede mögliche Zeichenposition an.
        // Sofern ein Wort an dieser Position noch ein Zeichen hat,
        // hängen wir es an den Ergebnis-String an.
        for (int i = 0; i < maxLength; i++) {
            for (String word : args) {
                if (i >= word.length()) continue;
                result.append(word.charAt(i));
            }
        }

        out.println(result.toString());
    }

}