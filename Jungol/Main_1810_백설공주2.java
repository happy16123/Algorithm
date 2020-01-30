package jungol.bank;

import java.util.Scanner;

public class Main_1810_백설공주_김현수 {

	public static int[] arr;
	public static int[] idx;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		arr = new int[9];
		idx = new int[7];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		combi(0, 1);
	}

	public static void combi(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < idx.length; i++) {
				sum += arr[idx[i]-1];
			}
			if(sum == 100) {
				for(int i=0; i<idx.length; i++) {
					System.out.println(arr[idx[i]-1]);
				}
			}
			return;
		}
		for (int i = start; i <= arr.length; i++) {
			idx[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
