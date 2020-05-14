package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	public static int N;
	public static int high;
	public static int low;
	public static int[][] map;
	public static boolean[][] visited;

	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		high = -1;
		low = 101;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > high) {
					high = map[i][j];
				}
				if (map[i][j] < low) {
					low = map[i][j];
				}
			}
		}

		int ans = 1;
		for (int t = low; t <= high; t++) {
			flood(t);
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > t) {
						dfs(i, j);
//						bfs(i, j);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

	public static void flood(int target) {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= target) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	public static void dfs(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N) {
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}
}
