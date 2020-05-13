package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13459_구슬탈출 {

	public static int R;
	public static int C;
	public static int holeR;
	public static int holeC;
	public static int ans;
	public static char[][] map;
	public static boolean[][][][] visited;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int redR = 0;
		int redC = 0;
		int blueR = 0;
		int blueC = 0;
		holeR = 0;
		holeC = 0;
		ans = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'R') {
					redR = i;
					redC = j;
				}
				if (map[i][j] == 'B') {
					blueR = i;
					blueC = j;
				}
				if (map[i][j] == 'O') {
					holeR = i;
					holeC = j;
				}
			}
		}
		bfs(redR, redC, blueR, blueC);
		if(ans > 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void bfs(int rr, int rc, int br, int bc) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[rr][rc][br][bc] = true;
		q.offer(new int[] { rr, rc, br, bc, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			rr = cur[0];
			rc = cur[1];
			br = cur[2];
			bc = cur[3];
			int cnt = cur[4];
			if (cnt > 10) {
				return;
			}
			if (rr == holeR && rc == holeC) {
				ans = cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nrr = rr + dir[i][0];
				int nrc = rc + dir[i][1];
				int nbr = br + dir[i][0];
				int nbc = bc + dir[i][1];
				if (nrr > -1 && nrc > -1 && nbr > -1 && nbc > -1 && nrr < R && nrc < C && nbr < R && nbc < C) {
					while (true) {
						if (map[nrr][nrc] == '#') {
							nrr -= dir[i][0];
							nrc -= dir[i][1];
							break;
						}
						if (map[nrr][nrc] == 'O') {
							break;
						}
						nrr += dir[i][0];
						nrc += dir[i][1];
					}
					while (true) {
						if (map[nbr][nbc] == '#') {
							nbr -= dir[i][0];
							nbc -= dir[i][1];
							break;
						}
						if (map[nbr][nbc] == 'O') {
							break;
						}
						nbr += dir[i][0];
						nbc += dir[i][1];
					}
					if (nbr == holeR && nbc == holeC) {
						continue;
					}
					if (nrr == nbr && nrc == nbc) {
						switch (i) {
						case 0:
							if (rr > br) {
								nrr++;
							} else {
								nbr++;
							}
							break;
						case 1:
							if (rr < br) {
								nrr--;
							} else {
								nbr--;
							}
							break;
						case 2:
							if (rc > bc) {
								nrc++;
							} else {
								nbc++;
							}
							break;
						case 3:
							if (rc < bc) {
								nrc--;
							} else {
								nbc--;
							}
							break;
						}
					}

					if (!visited[nrr][nrc][nbr][nbc]) {
						visited[nrr][nrc][nbr][nbc] = true;
						q.offer(new int[] { nrr, nrc, nbr, nbc, cnt + 1 });
					}
				}
			}
		}
	}
}
