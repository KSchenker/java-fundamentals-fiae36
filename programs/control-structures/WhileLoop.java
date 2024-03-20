public class WhileLoop {

    public static void main(String[] args) {
        int index = 0;

        if (args.length == 0) {
            System.out.println("Keine Argumente angegeben!");
            return;
        }

        // Gib alle an das Programm übergebene Argumente aus.
        while (index < args.length) {
            System.out.printf("Argument %d: %s\n", index + 1, args[index]);
            index++; // index = index + 1
        }

        System.out.println("Programmende");
        
    }

}