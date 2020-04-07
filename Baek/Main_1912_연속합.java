package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		int[] memo = new int[N];
		
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		memo[0] = data[0];
		for(int i=1; i<N; i++) {
			memo[i] = Math.max(data[i], memo[i-1] + data[i]);
		}
		
		System.out.println(Arrays.stream(memo).max().getAsInt());
	}
}
