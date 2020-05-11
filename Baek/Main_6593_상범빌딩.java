package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {

	public static int L;
	public static int R;
	public static int C;
	public static char map[][][];
	public static int D[][][];
	public static int dir[][] = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean t = true;

		StringBuilder sb = new StringBuilder();
		while (t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int sl = 0;
			int sr = 0;
			int sc = 0;
			int el = 0;
			int er = 0;
			int ec = 0;

			if (L == 0 && R == 0 && C == 0) {
				t = false;
				break;
			}

			map = new char[L][R][C];
			D = new int[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					map[i][j] = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						if (map[i][j][k] == 'S') {
							sl = i;
							sr = j;
							sc = k;
						} else if (map[i][j][k] == 'E') {
							el = i;
							er = j;
							ec = k;
						}
					}
				}
				br.readLine();
			}
			bfs(sr, sc, sl);
			if (D[el][er][ec] != 0) {
				sb.append("Escaped in " + D[el][er][ec] + " minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c, int l) {
		D[0][r][c] = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, l });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			l = cur[2];
			for (int i = 0; i < 6; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				int nl = l + dir[i][2];
				if (nr > -1 && nc > -1 && nl > -1 && nr < R && nc < C && nl < L) {
					if (D[nl][nr][nc] == 0 && map[nl][nr][nc] == '.') {
						q.offer(new int[] { nr, nc, nl });
						D[nl][nr][nc] = D[l][r][c] + 1;
					} else if(map[nl][nr][nc] == 'E') {
						D[nl][nr][nc] = D[l][r][c] + 1;
						return;
					}
				}
			}
		}
	}
}
