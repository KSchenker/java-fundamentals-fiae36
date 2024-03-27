import de.iad.utils.ArrayUtils;
import java.util.Arrays;

public class MainApp {

  public static void main(String[] args) {
    int[] primes = { 2, 3, 5, 7, 11 };
    System.out.println(Arrays.toString(primes));
    System.out.println(ArrayUtils.get(primes, -1));
    System.out.println(ArrayUtils.get(primes, -2));
    System.out.println(ArrayUtils.get(primes, 1));
    
    ArrayUtils.reverse(primes);
    System.out.println(Arrays.toString(primes));

  }

}