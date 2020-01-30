package jungol.bank;

import java.util.Scanner;

public class Main_1175_주사위던지기2_김현수 {
	
	public static int N;
	public static int M;
	public static int[] numbers;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		numbers = new int[N];
		permutation(0);
	}
	
	public static void permutation(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0; i<numbers.length; i++) {
				sum += numbers[i];
			}
			if(sum == M) {
				for(int i=0; i<N; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
			}
			sum = 0;
			return;
		}		
		
		for(int i=1; i<=6; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
}
