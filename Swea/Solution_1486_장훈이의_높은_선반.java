package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의_높은_선반 {

	public static int N;
	public static int[] top;
	public static int B;
	public static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			top = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				top[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + (min - B));
		}
	}
	
	
	public static void dfs(int cnt, int sum) {
		if(cnt == N) {
			if(sum >= B) {
				min = Math.min(sum, min);
			}
			return;
		}
		
		dfs(cnt + 1, sum + top[cnt]);
		dfs(cnt + 1, sum);
		
	}
}
