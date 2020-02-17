package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1006_로봇 {

	public static int R;
	public static int C;
	public static int startR;
	public static int startC;
	public static int startD;
	public static int endR;
	public static int endC;
	public static int endD;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;
		startD = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		endR = Integer.parseInt(st.nextToken()) - 1;
		endC = Integer.parseInt(st.nextToken()) - 1;
		endD = Integer.parseInt(st.nextToken());

		bfs(startR, startC);
		System.out.println(map[endR][endC]);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + "   ");
			}
			System.out.println();
		}
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
	}

	public static void bfs(int r, int c) {
		LinkedList<int[]> q = new LinkedList<>();
		int cnt = 0;
		int nr, nc, curD, temp = 0;
		visited[r][c] = true;
		curD = startD;
		q.offer(new int[] { r, c, curD, cnt });
		int[] cur;

		if (startR == endR && startC == endC) {
			if (Math.abs(startD - endD) == 1) {
				cnt += 2;
			} else {
				cnt++;
			}
			map[endR][endC] = cnt;
			return;
		}
		
		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			curD = cur[2];
			cnt = cur[3];
			if(r == endR && c == endC) {
				if(endD != curD) {
					if ((curD == 1 && endD == 2) || (curD == 2 && endD == 1) || (curD == 3 && endD == 4) || (curD == 4 && endD == 3)) {
						System.out.println("dd");
						map[endR][endC] += 2;
					} else {
						map[endR][endC] += 1;
					}
				}
				return;
			}
			cnt++;
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 3; j++) {
					nr = r + dir[i-1][0] * j;
					nc = c + dir[i-1][1] * j;
					if (nr > -1 && nc > -1 && nr < R && nc < C) {
						if (map[nr][nc] == 1) {
							break;
						}
						if (map[nr][nc] == 0 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							map[nr][nc] = cnt;
							if(curD == i) {
								q.offer(new int[] {nr, nc, i, cnt});
							} else if ((curD == 1 && i == 2) || (curD == 2 && i == 1) || (curD == 3 && i == 4) || (curD == 4 && i == 3)) {
								q.offer(new int[] {nr, nc, i, cnt+2});
							} else {
								q.offer(new int[] {nr, nc, i, cnt+1});
							}
						}
					}
				}
			}
		}
	}
}
