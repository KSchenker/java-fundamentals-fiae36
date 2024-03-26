import java.util.Random;

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

    int[][][] dynamicData = generateData(3);
    for (int layer = 0; layer < dynamicData.length; layer++) {
      System.out.printf("Layer %02d:\n", layer);
      for (int stripe = 0; stripe < dynamicData[layer].length; stripe++) {
        System.out.printf("  Stripe %02d: ", stripe);
        for (int piece = 0; piece < dynamicData[layer][stripe].length; piece++) {
          int pieceValue = dynamicData[layer][stripe][piece];
          System.out.printf("%02d ", pieceValue);
        }
        System.out.println();
      }
    }


  }

  public static int[][][] generateData(int totalLayers) {
    // rng bedeutet Random Number Generator
    var rng = new Random();
    int[][][] data = new int[totalLayers][][]; // layers
    for (int i = 0; i < data.length; i++) {
      data[i] = new int[rng.nextInt(5) + 1][]; // stripes per layer
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = new int[rng.nextInt(5) + 1]; // pieces per stripe
        for (int k = 0; k < data[i][j].length; k++) {
          data[i][j][k] = rng.nextInt(20); // value of piece
        }
      }
    }
    return data;
  }


}