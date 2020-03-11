package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7829_보물왕_태혁 {

	public static int N;
	public static int[] list;
	public static int ans;
	public static int min;
	public static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			if(N == 1) {
				ans = (int) Math.pow(list[0], 2);
			} else {
				for(int i=0; i<N; i++) {
					int temp = list[i];
					min = Math.min(temp, min);
					max = Math.max(temp, max);
				}
				
				ans = min * max;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
