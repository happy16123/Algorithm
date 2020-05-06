package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {

	public static int[][] data;
	public static int[] g1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	public static int[] g2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	public static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			data = new int[6][3];
			check = false;
			int count = 0;
			for (int i = 0; i < 6; i++) {
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
				data[i][2] = Integer.parseInt(st.nextToken());
				count += data[i][0] + data[i][1] + data[i][2];
			}
			if (count == 30) {
				solve(0);
			}
			System.out.print((check ? 1 : 0) + " ");
		}

	}

	public static void solve(int cnt) {
		if (check) {
			return;
		}

		if (cnt == 15) {
			check = true;
			return;
		}

		int t1 = g1[cnt];
		int t2 = g2[cnt];

		if (data[t1][0] > 0 && data[t2][2] > 0) {
			data[t1][0]--;
			data[t2][2]--;
			solve(cnt + 1);
			data[t1][0]++;
			data[t2][2]++;
		}
		if (data[t1][2] > 0 && data[t2][0] > 0) {
			data[t1][2]--;
			data[t2][0]--;
			solve(cnt + 1);
			data[t1][2]++;
			data[t2][0]++;
		}
		if (data[t1][1] > 0 && data[t2][1] > 0) {
			data[t1][1]--;
			data[t2][1]--;
			solve(cnt + 1);
			data[t1][1]++;
			data[t2][1]++;
		}
	}
}
