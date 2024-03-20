public class ForLoop {


    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.printf("Argument %d: %s\n", i + 1, args[i]);
        }

        System.out.println("\n\n"); // Leerzeilen einfügen.
        for (int a = 0, b = 5 ; b >= 0 ; a++, b--) {
            System.out.printf("a = %d und b = %d\n", a, b);
        }

    }


}