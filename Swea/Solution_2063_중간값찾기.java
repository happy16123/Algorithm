package test;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] data = new int[t];
		for (int i = 0; i < t; i++) {
			data[i] = sc.nextInt();
		}
		int index = data.length / 2;
		Arrays.sort(data);
		System.out.println(data[index]);
	}
}