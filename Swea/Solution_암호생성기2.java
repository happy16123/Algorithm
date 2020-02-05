package swea.d3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_암호생성기2 {
	
	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int T = 10;
		System.setIn(new FileInputStream("res/lecture/암호생성기.txt"));
		Scanner scan = new Scanner(System.in);
		
		int N = 8;
		for(int t=1; t<=T; t++) {
			scan.nextInt();
			for(int i=0; i<N; i++) {
				q.offer(scan.nextInt());
			}
			
			boolean isDone = false;
			top:
			while(!isDone) {
				for(int i=1; i<=5; i++) {
					int num = q.poll() - i;
					if(num <= 0) {
						num = 0;
						isDone = true;
					}
					q.offer(num);
					if(isDone) {
						break top;
					}
				}
			}
			System.out.println("#" + t + " ");
			for(Integer n : q) {
				System.out.print(n + " ");
			}
			q.clear();
			System.out.println();
		}
	}
}
