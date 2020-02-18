package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1027_좋은수열 {
	public static int N;
	public static boolean stop;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stop = false;
		dfs(1, "1");
	}

	public static void dfs(int cnt, String s) {
		
		if(stop) {
			return;
		}

		if (cnt == N) {
			stop = true;
			System.out.println(s);
			return;
		} else {

			for (int i = 1; i <= 3; i++) {
				if (check(s + i)) {
					dfs(cnt + 1, s + i);
				}
			}
		}
	}

	public static boolean check(String s) {
		int len = s.length();
		int start = len - 1;
		int end = len;
		for (int i = 1; i <= len/2; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start--;
		}
		return true;
	}
}
