package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_11444_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long moduler = 1000000007L;

        long xM1 = 0L;
        long x = 1L;
        long temp;

        while (n-- > 1) {
            temp = x;
            x = (x + xM1) % moduler;
            xM1 = temp;
        }

        System.out.println(x);
    }
}
