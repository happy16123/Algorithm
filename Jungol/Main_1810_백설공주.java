package jungol.bank;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1810_백설공주 {
	
	public static int n = 9;
	public static int r = 7; 
	public static int[] numbers;
	public static int[] result;
	public static int target = 100;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("/res/jungol/bank/1810_백설공주.txt"));
		Scanner scan = new Scanner(System.in);
		numbers = new int[n];
		result = new int[r];
		for(int i=0; i<n; i++) {
			numbers[i] = scan.nextInt();
		}
		
		combination(0, 0, 0);
	}
	
	/*
	 * 조합을 구하는 함수
	 * @param cnt 배열의 index
	 * @param start 조합을 시작할 수
	 * @param sum 난쟁이 숫자 합
	 */
	public static void combination(int cnt, int start, int sum) {
		if(cnt == r) {
			if(sum == target) {
				for(int s : result) {
					System.out.println(s);
				}
			}
			return;
		}
		
		if(sum >= target) return;
		
		for(int i=start; i<n; i++) {
			result[cnt] = numbers[i];
			combination(cnt+1, i+1, sum + result[cnt]);
		}
	}
}

