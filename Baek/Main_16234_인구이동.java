package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {

	public static int N;
	public static int L;
	public static int R;
	public static int ans;
	public static int[][] map;
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(ans-1);
	}

	public static void bfs() {
		boolean stop = true;
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> change = new ArrayList<int[]>();
		while (stop) {
			boolean[][] visited = new boolean[N][N];
			stop = false;
			ans+=1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) {
						continue;
					}
					q.offer(new int[] { i, j });
					change.add(new int[] { i, j });
					int sum = map[i][j];
					visited[i][j] = true;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						for (int l = 0; l < 4; l++) {
							int nr = r + dir[l][0];
							int nc = c + dir[l][1];
							if (nr > -1 && nc > -1 && nr < N && nc < N) {
								int gap = Math.abs(map[nr][nc] - map[r][c]);
								if (!visited[nr][nc] && gap >= L && gap <= R) {
									stop = true;
									visited[nr][nc] = true;
									sum += map[nr][nc];
									change.add(new int[] { nr, nc });
									q.offer(new int[] { nr, nc });
								}
							}
						}
					}

					int avg = sum / change.size();
					for (int k = 0; k < change.size(); k++) {
						int[] temp = change.get(k);
						map[temp[0]][temp[1]] = avg;
					}
					change.clear();
				}
			}
		}
	}
}
