package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

	public static int day;
	public static int o_month;
	public static int t_month;
	public static int year;
	public static int[] plan;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			day = Integer.parseInt(st.nextToken());
			o_month = Integer.parseInt(st.nextToken());
			t_month = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			plan = new int[12];
			ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			ans = year;
			solve(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void solve(int cnt, int sum) {
		if (cnt >= 12) {
			ans = Math.min(ans, sum);
			return;
		}

		if(plan[cnt] == 0) {
			solve(cnt + 1, sum);
		} else {
			solve(cnt + 1, sum + plan[cnt] * day);
			solve(cnt + 1, sum + o_month);
			solve(cnt + 3, sum + t_month);
		}

		
	}

}
