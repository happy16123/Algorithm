package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_3190_뱀 {

	public static int N;
	public static int K;
	public static int L;
	public static int ans;
	public static int[][] map;
	public static int[][] rotation;
	public static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = 1;
			}
		}

		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}

		L = Integer.parseInt(br.readLine());
		rotation = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotation[i][0] = Integer.parseInt(st.nextToken());
			if (st.nextToken().equals("L")) {
				rotation[i][1] = 1;
			} else {
				rotation[i][1] = -1;
			}
		}
		ans = 0;
		bfs(1, 1);

		System.out.println(ans);
	}

	public static void bfs(int r, int c) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { r, c, 3, 0 });
		int t = 0;

		while (!q.isEmpty()) {
			int[] cur = q.peekLast();
			r = cur[0];
			c = cur[1];
			int d = cur[2];
			int time = cur[3];

			if (t < L && rotation[t][0] == time) {
				if (rotation[t][1] == 1) {
					if (d == 3) {
						d = 0;
					} else {
						d++;
					}
				} else {
					if (d == 0) {
						d = 3;
					} else {
						d--;
					}
				}
				t++;
			}

			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if (map[nr][nc] == 0 || map[nr][nc] == 3) {
				ans = time + 1;
				return;
			}

			if (map[nr][nc] == 1) {
				int[] move = q.pollFirst();
				if (move != null) {
					map[move[0]][move[1]] = 1;
				}
				q.addLast(new int[] { nr, nc, d, time + 1 });
				map[nr][nc] = 3;
			} else if (map[nr][nc] == 2) {
				q.addLast(new int[] { nr, nc, d, time + 1 });
				map[nr][nc] = 3;
			}
		}
	}
}
