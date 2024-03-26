public class Array3D {

  public static void main(String[] args) {

    int[][][] data = {
      // data[0]
      {
        { 1, 2, 3}, // data[0][0]
        { 99 },     // data[0][1]
      },
      // data[1]
      { 
        { 11, 5 },  // data[1][0]
        null,       // data[1][1]
      },
      // data[2]
      {  
        null,        // data[2][0]
        { 7, 10 },   // data[2][1]
        null,        // data[2][2]
      },
    };

    System.out.printf("data[2][1][1] ist %d\n", data[2][1][1]);
    System.out.printf("data[2][0] ist %s\n", data[2][0]);


  }


}