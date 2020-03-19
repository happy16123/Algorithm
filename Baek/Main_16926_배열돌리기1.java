package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	public static int R;
	public static int C;
	public static int cycle;
	public static int[][] map;
	public static int[][] dir = { { 0, 1 },  { 1, 0 }, { 0, -1 }, { -1, 0 }};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cycle = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = Math.min(R, C) / 2;

		for (int i = 0; i < cycle; i++) {
			spin(cnt);
		}

		for (int i = 0; i < R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void spin(int cnt) {
		for (int i = 0; i < cnt; i++) {
			int r = i;
			int c = i;
			int temp = map[r][c];
			int d = 0;
			while (d < 4) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];

				if (nr < R - i && nc < C - i && nr > i - 1 && nc > i - 1) {
					map[r][c] = map[nr][nc];
					r = nr;
					c = nc;
				} else {
					d++;
				}
			}
			map[i + 1][i] = temp;
		}
	}
}
