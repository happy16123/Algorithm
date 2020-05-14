package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	public static int R;
	public static int C;

	public static ArrayList<int[]> cam;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		cam = new ArrayList<int[]>();
		ans = 987654321;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] != '0' && map[i][j] != '6') {
					cam.add(new int[] { i, j, map[i][j] - '0' });
				}
			}
		}
		dfs(0, map);
		System.out.println(ans);
	}

	public static void dfs(int index, char[][] prev) {
		if (index == cam.size()) {
			int cnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (prev[i][j] == '0') {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		char[][] v = new char[R][C];
		int[] cur = cam.get(index);
		int r = cur[0];
		int c = cur[1];
		int type = cur[2];
		switch (type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < R; j++) {
					v[j] = Arrays.copyOf(prev[j], C);
				}
				move(v, i, r, c);
				dfs(index + 1, v);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < R; j++) {
					v[j] = Arrays.copyOf(prev[j], C);
				}
				move(v, i, r, c);
				move(v, i + 2, r, c);
				dfs(index + 1, v);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < R; j++) {
					v[j] = Arrays.copyOf(prev[j], C);
				}
				move(v, i, r, c);
				move(v, (i + 1) % 4, r, c);
				dfs(index + 1, v);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < R; j++) {
					v[j] = Arrays.copyOf(prev[j], C);
				}
				move(v, i, r, c);
				move(v, (i + 1) % 4, r, c);
				move(v, (i + 3) % 4, r, c);
				dfs(index + 1, v);
			}
			break;
		case 5:
			for (int j = 0; j < R; j++) {
				v[j] = Arrays.copyOf(prev[j], C);
			}
			move(v, 0, r, c);
			move(v, 1, r, c);
			move(v, 2, r, c);
			move(v, 3, r, c);
			dfs(index + 1, v);
			break;
		}

	}

	public static void move(char[][] v, int dir, int r, int c) {
		switch (dir) {
		case 0: // 상
			while (r > 0) {
				r -= 1;
				if (v[r][c] == '6') {
					break;
				}
				v[r][c] = '#';
			}
			break;
		case 1: // 좌
			while (c > 0) {
				c -= 1;
				if (v[r][c] == '6') {
					break;
				}
				v[r][c] = '#';
			}
			break;
		case 2: // 하
			while (r < R - 1) {
				r += 1;
				if (v[r][c] == '6') {
					break;
				}
				v[r][c] = '#';
			}
			break;

		case 3: // 우
			while (c < C - 1) {
				c += 1;
				if (v[r][c] == '6') {
					break;
				}
				v[r][c] = '#';
			}
			break;
		}
	}
}
