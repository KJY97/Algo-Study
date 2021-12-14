import java.util.*;
import java.io.*;

public class boj2442 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine().trim());
      for (int i = 1; i <= N; ++i) {
         for (int j = N - i; j > 0; --j) {
            System.out.print(" ");
         }
         for (int k = 1; k <= (2 * i) - 1; ++k) {
            System.out.print("*");
         }
         System.out.println();
      }
      for (int i = 1; i < N; ++i) {
         for (int j = 0; j < i; ++j) {
            System.out.print(" ");
         }
         for (int k = 1; k <= ((2 * N) - (2 * (i+1)) + 1); ++k) {
            System.out.print("*");
         }
         
            System.out.println();
            
      }
   }
}
