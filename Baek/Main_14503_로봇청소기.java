package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	public static int R;
	public static int C;
	public static int ans;
	public static int[][] map;
	public static int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		ans = 0;

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(sr, sc, sd);
		System.out.println(ans);
	}

	public static void bfs(int r, int c, int d) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, d, 0, 1 });
		map[r][c] = 2;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			d = cur[2];
			int cnt = cur[3];
			int total = cur[4];
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (map[nr][nc] == 0) {
				d--;
				if (d == -1) {
					d = 3;
				}
				map[nr][nc] = 2;
				q.offer(new int[] { nr, nc, d, 0, total + 1 });
			} else if (map[nr][nc] != 0 && cnt != 4) {
				d--;
				if (d == -1) {
					d = 3;
				}
				q.offer(new int[] { r, c, d, cnt + 1, total });
			} else if (map[nr][nc] != 0 && cnt == 4) {
				switch (d) {
				case 0:
					r += 1;
					c += 0;
					break;
				case 1:
					r += 0;
					c += -1;
					break;
				case 2:
					r += -1;
					c += 0;
					break;
				case 3:
					r += 0;
					c += 1;
					break;
				}
				if (map[r][c] == 1) {
					ans = total;
					return;
				}
				q.offer(new int[] { r, c, d, 0, total });
			}
		}
	}
}
