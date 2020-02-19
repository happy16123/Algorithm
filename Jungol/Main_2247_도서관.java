package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2247_도서관 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(time[i]));
//		}
		
		int last = time[0][0];
		int useTime = 0;
		int idleTime = 0;
		int start = time[0][0];
		
		for(int i=0; i<N; i++) {
			if(last >= time[i][0]) {
				last = Math.max(last, time[i][1]);
				useTime = Math.max(useTime, last - start);
			} else {
				start = time[i][0];
				idleTime = Math.max(idleTime, start - last);
				last = time[i][1];
			}
		}
		
		System.out.print(useTime + " " + idleTime);
	}
}
