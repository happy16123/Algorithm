package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기 {

	public static int[][] map;
	public static int N;
	public static boolean[][] check;
	public static ArrayList<int[]> ans;
	public static int[][] dir = { { 0, 1 }, { 1, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			ans = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && !check[i][j]) {
						find(i, j);
					}
				}
			}
			
			Collections.sort(ans, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			Collections.sort(ans, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			System.out.print("#" + t + " " + ans.size());
			for(int i=0; i<ans.size(); i++) {
				System.out.print(" " + ans.get(i)[0] + " " + ans.get(i)[1]);
			}
			System.out.println();
		}
	}

	public static void find(int x, int y) {
		int row = 0;
		int col = 0;
		int nx = x;
		int ny = y;
		while (true) {
			if ( nx < N && map[nx][y] != 0 &&!check[nx][y]) {
				row++;
				nx = nx + dir[1][0];
			} else {
				break;
			}
		}

		while (true) {
			if (ny < N && map[x][ny] != 0 && !check[x][ny]) {
				col++;
				ny = ny + dir[0][1];
			} else {
				break;
			}
		}

		for (int i = x; i < x + row; i++) {
			for (int j = y; j < y + col; j++) {
				check[i][j] = true;
			}
		}
		ans.add(new int[] { row, col, row*col });
	}
}
