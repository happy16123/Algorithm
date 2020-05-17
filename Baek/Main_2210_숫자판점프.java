package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {

	public static int[][] map;
	public static ArrayList<String> list;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		list = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, map[i][j] + "");
			}
		}

		System.out.println(list.size());
	}

	public static void dfs(int r, int c, int d, String prev) {
		if (d == 5) {
			if (!list.contains(prev)) {
				list.add(prev);
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < 5 && nc < 5) {
				dfs(nr, nc, d + 1, prev + map[nr][nc]);
			}
		}
	}
}
