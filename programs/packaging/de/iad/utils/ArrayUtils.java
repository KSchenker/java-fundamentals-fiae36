// Die Klasse in dieser Datei soll dem Package
// de.iad.utils zugeordnet werden.
package de.iad.utils;

public class ArrayUtils {


  // Kehrt die Elemente im Array um. Das Array wird
  // direkt modifiziert (in-place).
  public static int[] reverse(int[] array) {
    int n = array.length;
    for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
      // Vertausche Zahl an Position i mit Zahl an Position j
      int copy = array[i];
      array[i] = array[j];
      array[j] = copy;
    }
    return array;
  }

  // Gibt das Element an Position index zurück. Es werden
  // auch negative Indizes unterstützt.
  // Positive Indizes liegen im Bereich [0, n-1]
  // Negative Indizes liegen im Bereich [-n, -1]
  // n ist die Länge des Arrays.
  public static int get(int[] array, int index) {
    if (index >= array.length || index < -array.length) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    return index >= 0 
      ? array[index] 
      : array[array.length + index];
  }

}

