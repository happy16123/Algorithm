package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {

	public static int N;
	public static int M;
	public static int ans;
	public static int zero;
	public static int[][] oriMap;
	public static boolean[] visited;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oriMap = new int[N][N];
		zero = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				oriMap[i][j] = Integer.parseInt(st.nextToken());
				if (oriMap[i][j] == 2) {
					list.add(new int[] { i, j, 0, 0});
				} else if(oriMap[i][j] == 0) {
					zero++;
				}
			}
		}
		if(zero == 0) {
			System.out.println(0);
			return;
		}
		visited = new boolean[list.size()];
		ans = 987654321;
		solve(0, 0);
		System.out.println(ans == 987654321 ? -1 : ans);
	}

	public static void solve(int cnt, int start) {
		if (cnt == M) {
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				temp[i] = Arrays.copyOf(oriMap[i], N);
			}
			int res = bfs(temp);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] == 0) {
						return;
					}
				}
			}
			ans = Math.min(ans, res);
			return;
		}

		for (int i = start; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	public static int bfs(int[][] map) {  // 0 : 빈칸, 1 : 벽, 2 : 바이러스, 3 : 비활성 바이러스, 4 : 바이러스 지나감, 5 :
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < list.size(); i++) {
			if (visited[i]) {
				q.offer(list.get(i));
			} else {
				map[list.get(i)[0]][list.get(i)[1]] = 3;
			}
		}
		int max = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			int t = 0;
			int dead = cur[3];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (map[nr][nc] == 0) {
						t += 1;
						q.offer(new int[] { nr, nc, cnt + 1, 0});
						map[nr][nc] = 4;
					} else if (map[nr][nc] == 3) {
						q.offer(new int[] { nr, nc, cnt + 1, dead + 1});
						map[nr][nc] = 5;
					}
				}
			}
			if(map[r][c] == 5 && t == 0) {
				cnt -= dead;
			}
			max = Math.max(cnt, max);
		}
		return max;
	}
}
