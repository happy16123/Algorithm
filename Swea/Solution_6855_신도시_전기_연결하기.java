package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6855_신도시_전기_연결하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] list = new int[N];
			int[] gap = new int[N];
			int ans = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<N; i++) {
				gap[i] = list[i] - list[i-1];
			}
			
			Arrays.sort(gap);
			
			for(int i=1; i<=N-K; i++) {
				ans += gap[i];
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
