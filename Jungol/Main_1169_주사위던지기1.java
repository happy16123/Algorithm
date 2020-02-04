package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1169_주사위던지기1 {

	public static int N;
	public static int[] index;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		int M = Integer.parseInt(data[1]);
		index = new int[N];
		
		switch(M) {
		case 1:
			per(0);
			break;
		case 2:
			per2(0,0);
			break;
		case 3:
			perOverLap(0,0);
			break;
		/*case 4:
			perOverLap2(0,0,0);
			break;*/
		}
	}
	
	public static void per(int cnt) {  // 순열 6개 중에 N개를 뽑아 출력
		if(cnt == N) {				   // 중복 가능 순서 상관 없음
			print();
			return;
		}
		for(int i=0; i<6; i++) {
			index[cnt] = i+1;
			per(cnt+1);
		}
	}
	
	public static void per2(int cnt, int start) {  // 순열 6개 중에 N개를 뽑아 출력
		if(cnt == N) {							   // 중복 가능 순서 상관 있음
			print();
			return;
		}
		for(int i=start; i<6; i++) {
			index[cnt] = i+1;
			per2(cnt+1, i);
		}
	}
	
	public static void perOverLap(int cnt, int flag) {  // 순열 6개 중에 N개를 뽑아 출력
		if(cnt == N) {									// 중복 불가능 순서 상관 없음
			print();
			return;
		}
		for(int i=0; i<6; i++) {
			if((flag & 1 << i) == 0) {
				index[cnt] = i+1;
				perOverLap(cnt+1, flag | 1 << i);
			}
		}
	}
	
/*	public static void perOverLap2(int cnt, int flag, int start) {  // 순열 6개 중에 N개를 뽑아 출력
		if(cnt == N) {												// 중복 불가능 순서 상관 있음
			print();
			return;
		}
		for(int i=start; i<6; i++) {
			if((flag & 1 << i) == 0) {
				index[cnt] = i+1;
				perOverLap2(cnt+1, flag | 1 << i, i);
			}
		}
	}*/
	
	public static void print() {
		for(int i=0; i<index.length; i++) {
			System.out.print(index[i] + " ");
		}
		System.out.println();
	}
	
}
