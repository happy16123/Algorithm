package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

	static class Shark {
		int speed, dir, size;

		public Shark(int speed, int dir, int size) {
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

	}

	static int R, C, M, sum, col;
	static Shark[][] map;
	static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		col = 0;
		map = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		while (col < C) {
			col++;
		}
	}

	public static void move() {
		Shark[][] temp = new Shark[R][C];
		int k = 0;
		int s = 0;
		int a = 0;
		int x, y, d;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Shark cur = map[i][j];
				if (cur == null) {
					continue;
				}
				if (cur.dir == UP || cur.dir == DOWN) {
					k = i;
					s = cur.speed % (2 * (R - 1));
					a = cur.dir == UP ? -1 : 1;
					while (s-- > 0) {
						if (k + a < 0 || k + a >= R) {
							a = -a;
						}
						k += a;
					}
					x = k;
					y = j;
					d = a < 0 ? UP : DOWN;
				} else {
					k = j;
					s = cur.speed % (2 * (C - 1));
					a = cur.dir == LEFT ? -1 : 1;
					while (s-- > 0) {
						if (k + a < 0 || k + a >= C) {
							a = -a;
						}
						k += a;
					}
					x = i;
					y = k;
					d = a < 0 ? LEFT : RIGHT;

				}
				cur.dir = d;
				if (temp[x][y] != null) {
					if (temp[x][y].size < cur.size) {
						temp[x][y] = cur;
					}
				} else {
					temp[x][y] = cur;
				}
			} // end j
		} // end i

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	public static void take() {
		for (int i = 0; i < R; i++) {
			if (map[i][col] != null) {
				sum += map[i][col].size;
				map[i][col] = null;
				break;
			}
		}
	}
}
