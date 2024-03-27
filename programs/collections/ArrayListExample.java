// List ist eine Schnittstelle, die eine Reihe von Methoden
// definiert, die alle Listenimplementierungen anbieten sollten.
import java.util.List;
// ArrayList und LinkedList sind zwei Implementierungen
// der Schnittstelle List.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class ArrayListExample {

  public static void main(String[] args) {
    // Eine Liste ist eine Sequenz von Elementen. Die Elemente
    // lassen sich über ihren Index auswählen, d.h. wir haben
    // wahlfreien Zugriff auf die Elemente (random-access).
    // Im Gegensatz zu einem Array, kann eine Liste wachsen und
    // schrumpfen. Man kann also Elemente einfügen und entfernen.

    // Erstelle eine leere Liste, die int Werte speichern kann.
    // Achtung: Hier muss als Datentyp nicht int, sondern die
    // Wrapper-Klasse Integer verwendet werden.
    var numbers = new ArrayList<Integer>(); // Liste von int
    var characters = new ArrayList<Character>(); // Liste von char
    var flags = new ArrayList<Boolean>(); // Liste von boolean
    var factors = new ArrayList<Double>(); // Liste von double
    var names = new ArrayList<String>(); // Liste von String

    numbers.add(2); // Hänge 2 an das Ende der Liste.
    numbers.add(3); // Hänge 3 an das Ende der Liste.
    numbers.add(5); // ...
    numbers.add(7); 
    numbers.add(11); 
    // Nun sieht die Liste so aus:
    // [2, 3, 5, 7, 11]
    // Füge das Element 23 zwischen den Elementen 3 und 5 ein.
    // Element 3 hat Index 1 und Element 5 Index 2
    numbers.add(2, 23);
    // Nun sieht die Liste so aus:
    // [2, 3, 23, 5, 7, 11]
    // Füge Element 29 an den Anfang der Liste ein.
    numbers.add(0, 29);
    // Nun sieht die Liste so aus:
    // [29, 2, 3, 23, 5, 7, 11]
    // Füge Element 31 an das Ende der Liste an.
    numbers.add(numbers.size(), 31);
    // Im Moment sieht unsere Liste so aus:
    // [29, 2, 3, 23, 5, 7, 11, 31]
    // Lösche das Element an Position 3, d.h. das Element 23.
    numbers.remove(3);
    // Nun sieht die Liste so aus:
    // [29, 2, 3, 5, 7, 11, 31]
    // Lies das Element an Position 4, d.h. Element 7.
    System.out.println(numbers.get(4));
    // Überschreibe Element an Position 4 mit Wert 37.
    numbers.set(4, 37);
    // Nun sieht die Liste so aus:
    // [29, 2, 3, 5, 37, 11, 31]
    // Die Länge der Liste kann mit Methode size ermittelt werden.
    System.out.println(numbers.size()); // 7
    // Mit indexOf suchen wir nach dem Element 11.
    // Hinweis: Es wird von links nach rechts gesucht. Nur das
    // erste Vorkommen wird gefunden. Falls Element nicht existiert,
    // gibt indexOf den Wert -1 zurück.
    System.out.printf("Element 11 befindet sich an Position %d\n", numbers.indexOf(11)); // 5
    // Liste leeren mit clear.
    numbers.clear();
    // Nun sieht die Liste so aus:
    // []
    // Wir können mit addAll die Elemente einer anderen Collection zu unserer Liste
    // hinzufügen. Hier verwenden wir die statische Methode "of" des Interfaces List,
    // um eine solche Collection zu erstellen.
    numbers.addAll(List.of(2, 3, 5, 7, 11));
    // Nun sieht die Liste so aus:
    // [2, 3, 5, 7, 11]
    // Hänge weitere Elemente an unsere Liste an. (List-Konkatenation)
    numbers.addAll(List.of(13, 17, 19, 23));
    // Nun sieht die Liste so aus:
    // [2, 3, 5, 7, 11, 13, 17, 19, 23]
    int[] primes = { 2, 3, 5, 7, 11 };
    // Die Elemente eines Arrays fügen wir mit einer for-Schleife hinzu.
    for (int p : primes) numbers.add(p);
    // Alternativ können wir das int[] Array in ein IntStream konvertieren.
    // Der IntStream muss dann mittels boxed in ein Stream<Integer>
    // transformiert und schlussendlich in eine List<Integer> konvertiert werden.
    numbers.addAll(Arrays.stream(primes).boxed().toList());
    // Liste sieht nun so aus:
    // [2, 3, 5, 7, 11, 13, 17, 19, 23, 2, 3, 5, 7, 11, 2, 3, 5, 7, 11]
    // Wir weisen der Variable numbers ein komplett neues ArrayList-Objekt zu.
    // Außerdem fügen wir der Liste gleich die Elemente 2,3,5,7 und 11 hinzu.
    numbers = new ArrayList<Integer>(List.of(2, 3, 5, 7, 11));
    // Nun sieht die Liste so aus:
    // [2, 3, 5, 7, 11]
    // Selektiere die Elemente an den Indizes 1, 2 und 3.
    // Achtung: Modifikationen von range wirken sich auf das Original aus.
    // Mit anderen Worten: range ist keine Teilkopie der Liste, sondern
    // eine sogenannte View.
    List<Integer> range = numbers.subList(1, 4);
    // range ist nun [3, 5, 7]
    range.add(13); // range: [3, 5, 7, 13]
    range.add(0, 17); // range: [17, 3, 5, 7, 13]
    System.out.println(numbers); // numbers: [2, 17, 3, 5, 7, 13, 11]
    range.clear(); // range: [] numbers: [2, 11]
    System.out.println(numbers); // numbers: [2, 11]
    range.add(3); // range: [3] numbers: [2, 3, 11]

    // Wir bauen eine subList, die lediglich aus dem Element 8
    // besteht. Dann nutzen wir addAll, um Elemente nach der 8
    // einzufügen.  
    numbers = new ArrayList<Integer>(List.of(9, 8, 7, 6, 5));
    range = numbers.subList(1, 2); // 8 hat Index 1.
    // range: [8] numbers: [9, |8|, 7, 6, 5]
    range.addAll(List.of(1, 2, 3)); // range: [8, 1, 2, 3]
    // numbers: [9, 8, 1, 2, 3, 7, 6, 5]


    characters.add('x');
    flags.add(true);
    factors.add(2.5);
    names.add("Alice Wonderland");

    System.out.println(numbers);
    System.out.println(characters);
    System.out.println(flags);
    System.out.println(factors);
    System.out.println(names);


  }


}