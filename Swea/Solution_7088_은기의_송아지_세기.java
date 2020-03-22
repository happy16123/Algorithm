package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7088_은기의_송아지_세기 {

	public static int N;
	public static int Q;
	public static int[] list;
	public static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			list = new int[N+1];
			memo = new int[4][N+1];
			
			for(int i=1; i<N+1; i++) {
				list[i] = Integer.parseInt(br.readLine());
				memo[1][i] = memo[1][i-1];
				memo[2][i] = memo[2][i-1];
				memo[3][i] = memo[3][i-1];
				memo[list[i]][i]++;
			}
			
			sb.append("#" + t + "\n");
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				sb.append((memo[1][end] - memo[1][start-1]) + " ");
				sb.append((memo[2][end] - memo[2][start-1]) + " ");
				sb.append((memo[3][end] - memo[3][start-1]) + "\n");
			}
		}
		System.out.print(sb.toString());
	}
}
