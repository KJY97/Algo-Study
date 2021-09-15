package 스터디2;

import java.util.Scanner;

public class 백준1463_1로만들기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] D = new int[n+1];
		D[1] = 0;
		
		for(int i = 2 ;i<=n ;i++) {
			
	
			if(i%3 == 0 && i%2 !=0)
			D[i]=Math.min(D[i-1], D[i/3])+1;
			else if (i%2 ==0 && i%3 !=0)
			D[i]=Math.min(D[i-1], D[i/2])+1;
			else if(i%6 == 0)
			D[i] = Math.min(D[i/3], D[i/2])+1;
			else if(i%2!=0 && i%3 !=0)
			D[i] = D[i-1]+1;
				
				
		}
		

		System.out.println(D[n]);
		
		
	}
	
	
	
	
}
