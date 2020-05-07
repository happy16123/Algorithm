package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {

	public static int N;
	public static int min;
	public static int[][] map;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int n = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, n++);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					find(i, j);
				}
			}
		}

		System.out.println(min);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	public static void find(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, map[r][c], 0 });
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			int n = cur[2];
			int d = cur[3];
			if (d > min) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(map[nr][nc] == n) {
						continue;
					}
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc, n, d + 1 });
					} else if (map[nr][nc] != n) {
						min = Math.min(d, min);
					}
				}
			}
		}

	}

	public static void bfs(int r, int c, int n) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		map[r][c] = n;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (map[nr][nc] == 1) {
						map[nr][nc] = n;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}
}
