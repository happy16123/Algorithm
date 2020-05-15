package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	public static int R;
	public static int C;
	public static int[][] map;
	public static ArrayList<int[]> border;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R + 2][C + 2];

		border = new ArrayList<int[]>();

		for (int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < C + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int remain = 0;
		while (true) {
			int cheese = 0;
			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {
					if (map[i][j] == 1) {
						cheese++;
					}
				}
			}
			if (cheese == 0) {
				break;
			}

			if (cheese > 0) {
				bfs(0, 0);
				remain = cheese;
				time++;
			}
		}
		System.out.println(time);
		System.out.println(remain);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[R + 2][C + 2];
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < R + 2 && nc < C + 2) {
					if (!visited[nr][nc]) {
						if (map[nr][nc] == 1) {
							border.add(new int[] { nr, nc });
						}
						if (map[nr][nc] == 0) {
							q.offer(new int[] { nr, nc });
						}
						visited[nr][nc] = true;
					}
				}
			}
		}

		for (int i = 0; i < border.size(); i++) {
			r = border.get(i)[0];
			c = border.get(i)[1];
			map[r][c] = 0;
		}

		border.clear();
	}

}
