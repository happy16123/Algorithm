package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출 {

	public static int X;
	public static int Y;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static ArrayList<int[]> fire;
	public static int[] solider;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new char[X][Y];
		visited = new boolean[X][Y];
		fire = new ArrayList<>();

		for (int i = 0; i < X; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if (map[i][j] == '*') {
					fire.add(new int[] { i, j });
				}
				if (map[i][j] == 'S') {
					solider = new int[] { i, j };
				}
			}
		}
		bfs(fire, solider[0], solider[1]);

		if (min == Integer.MAX_VALUE) {
			System.out.println("impossible");
		} else {
			System.out.println(min - 1);
		}

	}

	public static void bfs(ArrayList<int[]> fire, int sx, int sy) {
		LinkedList<int[]> fq = new LinkedList<>();
		LinkedList<int[]> sq = new LinkedList<>();
		int cnt = 0;
		sq.offer(new int[] { sx, sy, ++cnt });
		visited[sx][sy] = true;
		int snx, sny;
		int[] sCur;
		snx = sx;
		sny = sy;
		int fx, fy;
		for (int i = 0; i < fire.size(); i++) {
			fx = fire.get(i)[0];
			fy = fire.get(i)[1];
			visited[fx][fy] = true;
			fq.offer(new int[] { fx, fy });
		}
		int fnx, fny;
		int[] fCur;
		while (true) {
			if (sq.isEmpty()) {
				return;
			}
			if (!fq.isEmpty()) {
				int t = fq.size();
				for (int k = 0; k < t; k++) {

					fCur = fq.poll();
					fx = fCur[0];
					fy = fCur[1];
					for (int i = 0; i < 4; i++) {
						fnx = fx + dir[i][0];
						fny = fy + dir[i][1];
						if (fnx > -1 && fny > -1 && fnx < X && fny < Y) {
							if (map[fnx][fny] == '.' && !visited[fnx][fny]) {
								map[fnx][fny] = '*';
								visited[fnx][fny] = true;
								fq.offer(new int[] { fnx, fny });
							}
						}
					}
				}
			}

			if (!sq.isEmpty()) {
				int t = sq.size();
				for (int k = 0; k < t; k++) {
					sCur = sq.poll();
					sx = sCur[0];
					sy = sCur[1];
					cnt = sCur[2];
					cnt++;
					for (int i = 0; i < 4; i++) {
						snx = sx + dir[i][0];
						sny = sy + dir[i][1];
						if (snx > -1 && sny > -1 && snx < X && sny < Y) {
							if (map[snx][sny] == '.' && !visited[snx][sny]) {
								visited[snx][sny] = true;
								sq.offer(new int[] { snx, sny, cnt });
							}
							if (map[snx][sny] == 'D') {
								min = cnt;
								return;
							}
						}
					}
				}
			}
		}
	}

}