package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5604_구간합 {
	
	public static long A;
	public static long B;
	public static long[] ans; 
	public static long res; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			ans = new long[10];
			res = 0;
			find(A, B, 1);
			for(int i=0; i<10; i++) {
				res += ans[i] * i;
			}
			System.out.println("#" + t + " " + res);
		}
	}
	
	public static void cal(long n, long pos) {
		while(n > 0) {
			ans[(int) (n % 10)] += pos;
			n = n / 10;
		}
	}
	
	public static void find(long start, long end, long pos) {
		while(start % 10 != 0 && start <= end) {
			cal(start, pos);
			start += 1;
		}
		if(start > end) {
			return;
		}
		while(end % 10 != 9 && start <= end) {
			cal(end, pos);
			end -= 1;
		}
		if(end < 0) {
			return;
		}
		long cnt = (end / 10) - (start / 10) + 1;
		for(int i=0; i<10; i++) {
			ans[i] += cnt * pos;
		}
		find(start / 10, end / 10, pos * 10);
	}
}
