package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	public static int N;
	public static int M;
	public static ArrayList<int[]> chi;
	public static ArrayList<int[]> home;
	public static int[] select;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chi = new ArrayList<int[]>();
		home = new ArrayList<int[]>();
		select = new int[M];
		ans = 987654321;

		int temp = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					home.add(new int[] { i, j });
				} else if (temp == 2) {
					chi.add(new int[] { i, j });
				}
			}
		}
		combi(0, 0);
		System.out.println(ans);
	}

	public static void combi(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = 987654321;
				int[] h = home.get(i);
				for (int j = 0; j < M; j++) {
					int[] c = chi.get(select[j]);
					int dis = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
					min = Math.min(dis, min);
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = start; i < chi.size(); i++) {
			select[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
