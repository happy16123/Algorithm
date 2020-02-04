package jungol.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1161_하노이1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		hanoi(N, 1, 2, 3);
	}
	
	public static void hanoi(int n, int a, int b, int c) {  // a에서 b를 통해 c로 이동
		if(n == 1) {
			move(n, a, c);
		} else {
			hanoi(n-1, a, c, b);  // 두번쨰 기둥으로 이동
			move(n, a, c);
			hanoi(n-1, b, a, c);  // 세번쨰 기둥으로 이동
		}
	}
	 
	public static void move(int n, int from, int to) {
		System.out.println(n + " : " + from + " -> " + to);
	}
}
