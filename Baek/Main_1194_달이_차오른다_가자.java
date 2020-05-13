package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이_차오른다_가자 {

	public static char[][] map;
	public static boolean[][][] visited;
	public static int R;
	public static int C;
	public static int ans;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 987654321;
		map = new char[R][C];
		visited = new boolean[R][C][1 << 6];
		int r = 0;
		int c = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = (char) br.read();
				if (map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
			br.readLine();
		}
		bfs(r, c);

		if(ans == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 0, 0 });
		visited[r][c][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			int key = cur[2];
			int cnt = cur[3];
			if (map[r][c] == '1') {
				ans = cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				int nk = key;
				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if (map[nr][nc] == '#') {
						continue;
					}
					if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
						nk |= (1 << map[nr][nc] - 'a');
					}
					if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
						if ((nk & (1 << map[nr][nc] - 'A')) == 0) {
							continue;
						}
					}
					if (visited[nr][nc][nk]) {
						continue;
					}
					visited[nr][nc][nk] = true;
					q.offer(new int[] { nr, nc, nk, cnt + 1 });
				}
			}
		}
	}
}
