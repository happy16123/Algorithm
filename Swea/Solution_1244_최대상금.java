package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1244_최대상금 {

	public static int max;
	public static int cycle;
	public static char[] target;
	public static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			target = st.nextToken().toCharArray();
			cycle = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			dfs(0, 0);
			System.out.println("#" + t + " " + max);
		}
	}

	public static void dfs(int cnt, int start) {
		if (cycle == cnt) {
			max = Math.max(Integer.parseInt(new String(target)), max);
			return;
		}
		for (int i = 0, size = target.length; i < size; i++) {
			for(int j = i+1; j<size; j++) {
				if(target[i] <= target[j]) {
					swap(i, j);
					dfs(cnt + 1, i);
					swap(i, j);
				}
			}
		}
	}
	
	public static void swap(int i, int j) {
		char temp = target[i];
		target[i] = target[j];
		target[j] = temp;
	}
}
