package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7197_화섭이의_미생물배양 {

	public static int s;
	public static int e;
	public static int a;
	public static int b;
	public static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			if (b == 1) {
				if((e - s) % a == 0) {
					min = (e - s) / a;
				}
			} else {
				dfs(e, 0);
			}
			System.out.println("#" + t + " " + (min == Integer.MAX_VALUE ? -1 : min));
		}
	}

	public static void dfs(int cur, int cnt) {
		if (cur == s) {
			min = Math.min(cnt, min);
			return;
		}
		if (cur < s) {
			return;
		}
		if (cur % b == 0 && cur / b >= s) {
			dfs(cur / b, cnt + 1);
		} else {
			dfs(cur - a, cnt + 1);
		}
	}
}
