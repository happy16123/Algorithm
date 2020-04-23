package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] data = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(data[j] < data[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int index = 0;
		for(int i=0; i<N; i++) {
			if(dp[index] < dp[i]) {
				index = i;
			}
		}
		
		System.out.println(dp[index]);
	}
}
