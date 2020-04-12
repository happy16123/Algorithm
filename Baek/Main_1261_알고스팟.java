package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {

	public static int[][] map;
	public static int[][] D;
	public static int R;
	public static int C;
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		D = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = br.read() - '0';
			}
			br.readLine();
		}
		bfs(0,0);
		System.out.println(D[R-1][C-1]);
	}

	public static void bfs(int r, int c) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		D[r][c] = map[r][c];
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if (D[nr][nc] > D[r][c] + map[nr][nc]) {
						D[nr][nc] = D[r][c] + map[nr][nc];
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}
}
