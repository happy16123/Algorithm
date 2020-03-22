package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7333_한솔이의_택배_아르바이트 {
	
	public static int N;
	public static int[] list;
	public static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			ans = 0;
			int index = 0;
			for(int i=0; i<N; i++) {
				int w = Integer.parseInt(br.readLine());
				if(w >= 50) {
					ans++;
				}else {
					list[index++] = w;
				}
			}
			
			Arrays.sort(list);
			int sum = 0;
			int cnt = 1;
			int cur = N-1;
			while(index != -1) {
				if(sum >= 50) {
					ans++;
					sum = 0;
					cnt = 1;
					cur--;
				}
				sum = list[cur] * cnt;
				cnt++;
				index--;
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
}
