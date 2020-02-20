package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2806_N_Queen {
	
	public static int[] col;
	public static int N;
	public static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			col = new int[N];
			ans = 0;
			dfs(0);
			System.out.println("#" + t + " " +ans);
		}
	}
	
	public static void dfs(int cnt) {
		if(cnt == N) {
			ans++;
			return;
		} else {
			for(int i=0; i<N; i++) {
				col[cnt] = i;
				if(isPossible(cnt)) {
					dfs(cnt+1);
				}
			}
		}
	}
	
	public static boolean isPossible(int cnt) {
		for(int i=0; i<cnt; i++) {
			if(col[cnt] == col[i] || Math.abs(cnt-i) == Math.abs(col[cnt]-col[i])) {
				return false;
			}
		}
		return true;
	}
}
