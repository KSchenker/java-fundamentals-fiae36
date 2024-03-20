public class IfStatement {


	public static void main(String[] args) {
		if (args.length >= 3) {
			System.out.printf("Name mit Anrede: %s %s %s\n", args[0], args[1], args[2]);
		} else if (args.length >= 2) {
			System.out.printf("Name: %s %s\n", args[0], args[1]);
		} else if (args.length >= 1) {
			System.out.printf("Vorname: %s\n", args[0]);
		} else {
			System.out.println("Rufen Sie das Program wie folgt auf: [Anrede] Vorname Nachname");
		}

	}
}