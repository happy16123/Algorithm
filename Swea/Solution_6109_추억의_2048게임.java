package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6109_추억의_2048게임 {

	public static int[][] map;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			String com = st.nextToken();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (com) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "left":
				left();
				break;
			case "right":
				right();
				break;
			}
			sb.append("#" + t + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static void up() {
		int[] temp = new int[N];
		int index = 0;
		for (int c = 0; c < N; c++) {
			Arrays.fill(temp, 0);
			index = 0;
			for (int r = 0; r < N; r++) {
				int cnt = 1;
				while (r + cnt < N && map[r + cnt][c] == 0) {
					cnt++;
				}
				if (r + cnt < N && map[r][c] == map[r + cnt][c]) {
					temp[index++] = map[r][c] + map[r + cnt][c];
					r += cnt;
				} else {
					if (map[r][c] != 0) {
						temp[index++] = map[r][c];
					}
				}
			}
			for (int r = 0; r < N; r++) {
				map[r][c] = temp[r];
			}
		}
	}

	public static void down() {
		int[] temp = new int[N];
		int index = 0;
		for (int c = N - 1; c >= 0; c--) {
			Arrays.fill(temp, 0);
			index = 0;
			for (int r = N - 1; r >= 0; r--) {
				int cnt = 1;
				while (r - cnt > -1 && map[r - cnt][c] == 0) {
					cnt++;
				}
				if (r - cnt > -1 && map[r][c] == map[r - cnt][c]) {
					temp[index++] = map[r][c] + map[r - cnt][c];
					r -= cnt;
				} else {
					if (map[r][c] != 0) {
						temp[index++] = map[r][c];
					}
				}
			}
			index = 0;
			for (int r = N - 1; r >= 0; r--) {
				map[r][c] = temp[index++];
			}
		}
	}

	public static void left() {
		int[] temp = new int[N];
		int index = 0;
		for (int r = 0; r < N; r++) {
			Arrays.fill(temp, 0);
			index = 0;
			for (int c = 0; c < N; c++) {
				int cnt = 1;
				while (c + cnt < N && map[r][c + cnt] == 0) {
					cnt++;
				}
				if (c + cnt< N  && map[r][c] == map[r][c + cnt]) {
					temp[index++] = map[r][c] + map[r][c + cnt];
					c += cnt;
				} else {
					if (map[r][c] != 0) {
						temp[index++] = map[r][c];
					}
				}
			}
			for (int c = 0; c < N; c++) {
				map[r][c] = temp[c];
			}
		}
	}

	public static void right() {
		int[] temp = new int[N];
		int index = 0;
		for (int r = N - 1; r >= 0; r--) {
			Arrays.fill(temp, 0);
			index = 0;
			for (int c = N - 1; c >= 0; c--) {
				int cnt = 1;
				while (c - cnt > -1 && map[r][c - cnt] == 0) {
					cnt++;
				}
				if (c - cnt > -1 && map[r][c] == map[r][c - cnt]) {
					temp[index++] = map[r][c] + map[r][c - cnt];
					c -= cnt;
				} else {
					if (map[r][c] != 0) {
						temp[index++] = map[r][c];
					}
				}
			}
			index = 0;
			for (int c = N - 1; c >= 0; c--) {
				map[r][c] = temp[index++];
			}
		}
	}

}
