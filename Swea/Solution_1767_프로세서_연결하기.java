package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1767_프로세서_연결하기 {

	public static int N;
	public static int ans;
	public static int maxSelect;
	public static int[][] map;
	public static ArrayList<int[]> list;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			ans = 987654321;
			maxSelect = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && j != 0 && i != N - 1 && j != N - 1 && map[i][j] == 1) {
						list.add(new int[] { i, j });
					}
				}
			}
			dfs(0, 0, 0);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int index, int cnt, int select) {
		if(list.size() - index + select < maxSelect) {
			return;
		}
		if (index == list.size()) {
			if (select > maxSelect) {
				maxSelect = select;
				ans = cnt;
			} else if(select == maxSelect) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		ArrayList<int[]> put = new ArrayList<int[]>();
		int[] cur = list.get(index);
		for (int i = 0; i < 4; i++) {
			boolean check = false;
			int nr = cur[0];
			int nc = cur[1];
			while (!check) {
				nr += dir[i][0];
				nc += dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (map[nr][nc] == 1 || map[nr][nc] == 2) {
						break;
					}
					if (nr == N - 1 || nc == N - 1 || nr == 0 || nc == 0) {
						check = true;
					}
					if (map[nr][nc] == 0) {
						put.add(new int[] { nr, nc });
					}
				} else {
					break;
				}
			}
			if (check) {
				for (int j = 0; j < put.size(); j++) {
					int[] temp = put.get(j);
					map[temp[0]][temp[1]] = 2;
				}
				dfs(index + 1, cnt + put.size(), select + 1);
				for (int j = 0; j < put.size(); j++) {
					int[] temp = put.get(j);
					map[temp[0]][temp[1]] = 0;
				}
			} else {
				dfs(index + 1, cnt, select);
			}
			put.clear();
		}

	}
}
