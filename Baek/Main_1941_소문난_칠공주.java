package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난_칠공주 {

	public static char[][] map;
	public static boolean[] visited;
	public static int ans;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		visited = new boolean[25];
		ans = 0;

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 25; i++) {
			combi(i, 1, 0);
		}
		System.out.println(ans);
	}

	public static void combi(int start, int cnt, int scnt) {
		if (map[start / 5][start % 5] == 'S') {
			scnt += 1;
		}
		visited[start] = true;
		
		if (cnt == 7) {
			if (scnt >= 4) {
				if (check(start / 5, start % 5)) {
					ans++;
				}
			}
			visited[start] = false;
			return;
		}
		
		for (int i = start + 1; i < 25; i++) {
			if (!visited[i]) {
				combi(i, cnt + 1, scnt);
			}
		}
		visited[start] = false;
	}

	public static boolean check(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] checked = new boolean[5][5];
		q.offer(new int[] { r, c });
		checked[r][c] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < 5 && nc < 5) {
					if (!checked[nr][nc] && visited[nr * 5 + nc]) {
						checked[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						cnt++;
					}
				}
			}
		}
		return cnt == 7 ? true : false;
	}

}
