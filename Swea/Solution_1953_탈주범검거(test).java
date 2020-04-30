package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

	public static int R;
	public static int C;
	public static int startR;
	public static int startC;
	public static int L;
	public static int ans;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 0:상, 1:하, 2:좌, 3:우
	public static ArrayList<int[]> tunnel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			tunnel = new ArrayList<int[]>();
			tunnel.add(new int[] {});
			tunnel.add(new int[] { 0, 1, 2, 3 });
			tunnel.add(new int[] { 0, 1 });
			tunnel.add(new int[] { 2, 3 });
			tunnel.add(new int[] { 0, 3 });
			tunnel.add(new int[] { 1, 3 });
			tunnel.add(new int[] { 1, 2 });
			tunnel.add(new int[] { 0, 2 });
			map = new int[R][C];
			visited = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 1;
			bfs(startR, startC);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 1 });
		visited[r][c] = true;
		int[] cur;
		int[] type;
		int[] next;
		int size, l;
		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			l = cur[2];
			if (l == L) {
				continue;
			}
			type = tunnel.get(map[r][c]);
			size = type.length;
			for (int i = 0; i < size; i++) {
				int nr = r + dir[type[i]][0];
				int nc = c + dir[type[i]][1];
				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if(map[nr][nc] != 0) {
						next = tunnel.get(map[nr][nc]);
						boolean ck = false;
						for(int k=0; k<next.length; k++) {
							ck = check(type[i], next[k]);
							if(ck) break;
						}
						if(!visited[nr][nc] && ck) {
							ans++;
							visited[nr][nc] = true;
							q.offer(new int[] { nr, nc, l + 1 });
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int type, int target) {
		switch(type) {
		case 0:
			if(target == 1) return true;
			break;
		case 1:
			if(target == 0) return true;
			break;
		case 2:
			if(target == 3) return true;
			break;
		case 3:
			if(target == 2) return true;
			break;
		}
		
		return false;
	}
}
