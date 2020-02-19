package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1370_회의실배정 {

	public static int[][] time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		time = new int[N][3];
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
			time[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(time[i]));
//		}

		int last = 0;
		int res = 0;
		for (int i = 0; i < N; i++) {
			if (last <= time[i][1]) {
				last = time[i][2];
				res++;
				ans.add(time[i][0]);
			}
		}
		System.out.println(res);
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
