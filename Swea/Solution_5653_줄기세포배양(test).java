package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

	public static int R;
	public static int C;
	public static int K;
	public static int[][] map;
	public static Queue<Cell> q;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[500][500];
			q = new LinkedList<Cell>();
			for (int i = 250; i < 250 + R; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 250; j < 250 + C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						q.offer(new Cell(i, j, map[i][j], map[i][j]));
					}
				}
			}
			Collections.sort((List<Cell>) q, new Comparator<Cell>() {
				@Override
				public int compare(Cell o1, Cell o2) {
					return o2.time - o1.time;
				}
			});
			bfs();
			System.out.println("#" + t + " " + q.size());
		}
	}

	public static void bfs() {
		for (int k = 0; k < K; k++) {
			int size = q.size();
			for (int l = 0; l < size; l++) {
				Cell cell = q.poll();
				int r = cell.r;
				int c = cell.c;
				int init = cell.init;
				int time = cell.time;
				if (time == 0) {
					if ((time - 1) != -init) {
						q.offer(new Cell(r, c, init, time - 1));
					}
					for (int i = 0; i < 4; i++) {
						int nr = r + dir[i][0];
						int nc = c + dir[i][1];
						if (nr > -1 && nc > -1 && nr < 500 && nc < 500 && map[nr][nc] == 0) {
							map[nr][nc] = init;
							q.offer(new Cell(nr, nc, init, init));
						}
					}
				} else {
					if ((time - 1) != -init) {
						q.offer(new Cell(r, c, init, time - 1));
					}
				}
			}
		}
	}

	static class Cell {
		int r;
		int c;
		int init;
		int time;

		public Cell(int r, int c, int init, int time) {
			this.r = r;
			this.c = c;
			this.init = init;
			this.time = time;
		}

	}
}