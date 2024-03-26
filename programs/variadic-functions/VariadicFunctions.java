public class VariadicFunctions {

  public static void main(String[] args) {

    System.out.println(sum()); // 0
    System.out.println(sum(1));
    System.out.println(sum(2, 3, 5, 7, 11, 13));
    // Statt mehrere Argumente anzugeben,
    // lässt sich auch ein Array verwenden.
    System.out.println(sum(new int[] { 1, 2, 3}));

  }    

  // Variadischer Parameter values nimmt alle
  // übrig gebliebenen Argumente auf. Eine Methode
  // darf maximal einen variadischen Parameter
  // haben und er muss am Ende der Parameterliste
  // stehen.
  public static int sum(int... values) {
    int sum = 0;
    for (int v : values) {
      sum += v;
    }
    return sum;
  }


}