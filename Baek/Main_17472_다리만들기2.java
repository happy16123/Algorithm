package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {

	public static int R;
	public static int C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] parent;
	public static int[] rank;
	public static ArrayList<Edge> list;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		list = new ArrayList<Edge>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					change(i, j, cnt++);
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						dfs(i, j, d, map[i][j], 0);
					}
				}
			}
		}

		Collections.sort(list);

		parent = new int[cnt + 1];
		rank = new int[cnt + 1];
		for (int i = 0; i < cnt + 1; i++) {
			parent[i] = i;
		}

		int ans = 0;
		int v = 1;
		for (int i = 0; i < list.size(); i++) {
			int v1 = list.get(i).v1;
			int v2 = list.get(i).v2;

			if (find(v1) != find(v2)) {
				union(v1, v2);
				ans += list.get(i).w;
				v++;
			}
		}

		if (cnt - 1 == v) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else {
			parent[y] = x;
			if (rank[x] == rank[y]) {
				rank[x]++;
			}
		}
	}

	public static void dfs(int r, int c, int d, int n, int cnt) {
		int nr = r + dir[d][0];
		int nc = c + dir[d][1];
		if (nr > -1 && nc > -1 && nr < R && nc < C) {
			if (map[nr][nc] == n) {
				return;
			}
			if (map[nr][nc] == 0) {
				dfs(nr, nc, d, n, cnt + 1);
			} else {
				if (cnt >= 2) {
					list.add(new Edge(n, map[nr][nc], cnt));
				}
			}
		}
	}

	public static void change(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		map[r][c] = cnt;
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if (!visited[nr][nc] && map[nr][nc] != 0) {
						map[nr][nc] = cnt;
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
		}

	}
}
