package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_1249_보급로 {

	public static int N;
	public static int min;
	public static int[][] map;
	public static int[][] visited;
	public static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = br.read() - 48;
				}
				br.readLine();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = Integer.MAX_VALUE;
				}
			}

			visited[0][0] = 0;
			bfs(0, 0);

			System.out.println("#" + t + " " + visited[N-1][N-1]);
		}

//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static void bfs(int r, int c) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		int nr, nc;
		int[] cur;
		q.offer(new int[] { r, c});
		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (map[nr][nc] + visited[r][c] < visited[nr][nc]) {
						visited[nr][nc] = map[nr][nc] + visited[r][c];
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}
}
