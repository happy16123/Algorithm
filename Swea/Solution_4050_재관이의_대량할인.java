package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_4050_재관이의_대량할인 {
	
	public static Integer[] data;
	public static int[] ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			data = new Integer[N];
			ans = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(data, Collections.reverseOrder());
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(i % 3 != 2) {
					sum += data[i];
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
