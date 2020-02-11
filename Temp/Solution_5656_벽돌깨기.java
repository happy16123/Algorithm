package dd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	public static int N;
	public static int W;
	public static int H;
	public static int min;
	public static int[][] defaultMap;
	public static int[][] map;
	public static int[] pos;
	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static ArrayList<Integer> down;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			defaultMap = new int[H][W];
			pos = new int[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int data = Integer.parseInt(st.nextToken());
					map[i][j] = data;
					defaultMap[i][j] = data;
				}
			}
			position(0);

			System.out.println("#" + t + " " + min);
		}

	}

	public static void position(int cnt) {
		if (cnt == N) {
			for (int h = 0; h < H; h++) {
				map[h] = defaultMap[h].clone();
			}
			for (int i = 0; i < pos.length; i++) {
				int y = pos[i];
				for (int j = 0; j < H; j++) {
					if (map[j][y] != 0) {
						run(j, y);
						sort();
						break;
					}
				}
			}
			min = Math.min(min, getSum());
			return;
		}
		for (int i = 0; i < W; i++) {
			pos[cnt] = i;
			position(cnt + 1);
		}
	}

	public static void run(int x, int y) {
		int boom = map[x][y];
		int nx = x;
		int ny = y;
		map[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < boom; j++) {
				nx = x + (dir[i][0] * j);
				ny = y + (dir[i][1] * j);
				if (nx > -1 && ny > -1 && nx < H && ny < W) {
					if (map[nx][ny] > 1) {
						run(nx, ny);
					} else {
						map[nx][ny] = 0;
					}
				}
			}
		}
	}

	public static void sort() {
		for (int y = 0; y < W; y++) {
			down = new ArrayList<Integer>();
			int cnt = 0;
			for (int x = H - 1; x >= 0; x--) {
				if (map[x][y] != 0) {
					down.add(map[x][y]);
					map[x][y] = 0;
				}
			}
			for (int i = H - 1; i > H - down.size(); i--) {
				map[i][y] = down.get(cnt++);
			}
		}
//		System.out.println("==================");
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static int getSum() {
		int sum = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) {
					sum += 1;
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
}
