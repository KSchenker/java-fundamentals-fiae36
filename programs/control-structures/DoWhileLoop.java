public class DoWhileLoop {


    public static void main(String[] args) {
        int index = 0;

        if (args.length == 0) {
            System.out.println("Keine Argumente.");
            return;
        }

        do {
            System.out.printf("Argument %d: %s\n", index + 1, args[index]);
            index++;
        } while (index < args.length); // <- Semikolon!

        System.out.println("Programmende");

    }


}