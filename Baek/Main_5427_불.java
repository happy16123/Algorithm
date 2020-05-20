package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {

	public static int R;
	public static int C;
	public static int ans;
	public static char[][] map;
	public static boolean[][] visited;
	public static Queue<int[]> q;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			ans = 987654321;
			map = new char[R][C];
			visited = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}

			q = new LinkedList<int[]>();
			int sr = 0;
			int sc = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '@') {
						sr = i;
						sc = j;
					} else if (map[i][j] == '*') {
						q.offer(new int[] { i, j, -1 });
					}
				}
			}
			bfs(sr, sc);
			if(ans == 987654321) {
				sb.append("IMPOSSIBLE\n");
			} else {
				sb.append(ans + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {
		q.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] cur = q.poll();
				r = cur[0];
				c = cur[1];
				int cnt = cur[2];
				if (cnt >= 0 && (r == R - 1 || c == C - 1 || r == 0 || c == 0)) {
					ans = Math.min(ans, cnt + 1);
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];
					if (nr > -1 && nc > -1 && nr < R && nc < C) {
						if (cnt == -1 && map[nr][nc] == '.') {
							q.offer(new int[] { nr, nc, -1 });
							map[nr][nc] = '*';
						}
						if (cnt >= 0 && !visited[nr][nc] && map[nr][nc] == '.') {
							q.offer(new int[] { nr, nc, cnt + 1 });
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	}
}
