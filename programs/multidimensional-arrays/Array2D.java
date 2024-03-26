import java.util.Arrays;
import java.util.Random;

public class Array2D {

    public static void main(String[] args) {

        // Unser Elementdatentyp ist int[].
        int[][] data = {
            { 5, 14, 11, 10 }, // data[0]
            { 2, 22, 19, 15 }, // data[1]
            { 0, 3, 5 },       // data[2]
        };

        // Datentyp von data ist int[3][].
        // Datentyp von data[0] ist int[4].
        // Datentyp von data[1] ist int[4].
        // Datentyp von data[2] ist int[3].
        // Datentyp von data[2][1] ist int.

        System.out.println(data[2][1]); // 3
        System.out.println(data[2].length); // 3
        System.out.println(data[1].length); // 4
        System.out.println(data.length); // 3

        int[][] dynamicData = generateData(4);
        for (int i = 0; i < dynamicData.length; i++) {
            System.out.println(Arrays.toString(dynamicData[i]));
        }

    }

    public static int[][] generateData(int totalRows) {
        var generator = new Random();
        int[][] data = new int[totalRows][];
        for (int i = 0; i < totalRows; i++) {
            // Generiere Zufallszahl im Bereich 0 - 9.
            int totalCols = generator.nextInt(10);
            // Erzeuge ein neues Array mit totalCols
            // Elementen. Alle Elemente haben den Wert 0.
            data[i] = new int[totalCols];
            // Fülle die Zellen des neuen Arrays mit
            // Zufallszahlen im Bereich von 0 - 19.
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = generator.nextInt(20 + 1);
            }
        }
        return data;
    }


}