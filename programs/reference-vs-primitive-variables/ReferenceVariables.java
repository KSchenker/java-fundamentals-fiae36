import java.util.Arrays;
import static java.lang.System.out;

public class ReferenceVariables {

    public static void main(String[] args) {
        // copyPrimitiveArray();
        // copyReferenceArray();
        // copyReferences();
        // copyPrimitives();

        // Wird ein Argument an eine Methode übergeben,
        // dann wird dieses Argument in den zugehörigen
        // Parameter der Methode kopiert. Das bedeutet
        // für Referenzdatentypen: nur die Referenz wird kopiert,
        // nicht aber das Datenobjekt.
        int[] primes = { 2, 3, 5, 7, 11 };
        printReverse(primes);
    }

    public static void printReverse(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            out.printf("%d ", numbers[i]);
        }
        out.println();
    }

    public static void copyPrimitiveArray() {
        // double ist ein primitiver Datentyp.
        double[] numbers = { 2.5, 3.1, 9.0, 2e8 };
        double[] copy = numbers.clone();
        double[] copy2 = Arrays.copyOf(numbers, numbers.length);

        out.println(Arrays.toString(numbers));
        out.println(Arrays.toString(copy));
        out.println(Arrays.toString(copy2));

        numbers[2] = 33.3;
        copy[0] = 99.9;
        copy2[1] = 66.6;

        out.println(Arrays.toString(numbers));
        out.println(Arrays.toString(copy));
        out.println(Arrays.toString(copy2));
    }

    public static void copyReferenceArray() {
        var alice = new StringBuilder("alice");
        var bob = new StringBuilder("bob");
        var charlie = new StringBuilder("charlie");
        
        StringBuilder[] names = { alice, alice, bob, charlie, null };
        // Copy ist ein neues Array mit eigenen "Zellen".
        // In den Zellen stehen dieselben Referenzen wie in names.
        StringBuilder[] copy = names.clone();

        out.println(Arrays.toString(names));
        out.println(Arrays.toString(copy));

        // Überschreibe erste "Zelle" der Kopie.
        // Das Original bleibt davon unberührt.
        copy[0] = new StringBuilder("damian");
        out.println(Arrays.toString(names));
        out.println(Arrays.toString(copy));

        // Modifiziere das StringBuilder-Obekt alice.
        // Die Modifikation ist im Original sichtbar.
        copy[1].append(" wonderland");
        out.println(Arrays.toString(names));
        out.println(Arrays.toString(copy));

        // Modifiziere das StringBuilder-Objekt bob.
        // Die Modifikation ist in der Kopie sichtbar.
        names[2].append(" Ross");
        out.println(Arrays.toString(names));
        out.println(Arrays.toString(copy));
    }

    public static void copyReferences() {
        var x = new StringBuilder("alice");
        // Der Wert von Variable x wird nach y kopiert.
        // Hier wird jedoch nicht das StringBuilder-Objekt kopiert,
        // sondern nur die Referenz / ID dieses Objekts.
        StringBuilder y = x;

        out.println(x);
        out.println(y);

        // Die Modifikation durch y ist auch durch x
        // sichtbar, da beide auf dasselbe Objekt verweisen.
        y.append(" wonderland");
        out.println(x);
        out.println(y);
    }

    public static void copyPrimitives() {
        int x = 123;
        // Kopiere Wert von x in Variable y.
        // Hier wird tatsächlich die Zahl 123 kopiert.
        int y = x;

        out.println(x);
        out.println(y);

        // Modifikation von y hat keinerlei Effekt auf x.
        y++;
        out.println(x);
        out.println(y);
    }


}