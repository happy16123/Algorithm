package beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {
	
	public static int N;
	public static int K;
	public static int[] dp;
	public static int[] num;
	public static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[N];
		dp = new int[K + 1];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=num[i]; j<K+1; j++) {
				dp[j] += dp[j - num[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}
