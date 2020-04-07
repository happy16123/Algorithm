package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932_정수_삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N+1][N+2];
		int[][] memo = new int[N+1][N+1];
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int len = st.countTokens();
			for(int j=1; j<=len; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo[1][1] = data[1][1];
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				memo[i][j] = Math.max(memo[i-1][j-1] + data[i][j], memo[i-1][j] + data[i][j]);
			}
		}
		
		System.out.println(Arrays.stream(memo[N]).max().getAsInt());
	}
}
