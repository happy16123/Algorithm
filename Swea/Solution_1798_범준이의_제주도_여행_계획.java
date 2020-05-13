package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1798_범준이의_제주도_여행_계획 {

	public static int N;
	public static int M;
	public static int airport;
	public static int[][] map;
	public static int[] visited;
	public static ArrayList<Pos> pos;
	public static int ans;
	public static String finalPath;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new int[N];
			ans = 0;
			pos = new ArrayList<Pos>();
			finalPath = "";

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = i + 1; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					map[j][i] = temp;
				}
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String p = st.nextToken();
				if (p.equals("A")) {
					pos.add(new Pos(p, 0, 0));
					airport = i;
					visited[i] = 1;
				} else if (p.equals("P")) {
					pos.add(new Pos(p, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
					visited[i] = 0;
				} else if (p.equals("H")) {
					pos.add(new Pos(p, 0, 0));
					visited[i] = 2;
				}
			}
			dfs(airport, 0, 0, 1, "");
			sb.append("#" + t + " " + ans + finalPath + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int start, int total, int good, int day, String path) {
		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				if (total + map[start][i] + pos.get(i).time <= 540) {
					visited[i] = -1;
					dfs(i, total + map[start][i] + pos.get(i).time, good + pos.get(i).good, day, path + " " + (i + 1));
					visited[i] = 0;
				}
			}
		}

		if (day != M) {
			for (int i = 0; i < N; i++) {
				if (visited[i] == 2 && total + map[start][i] <= 540) {
					dfs(i, 0, good, day + 1, path + " " + (i + 1));
				}
			}
		} else {
			if (total + map[start][airport] <= 540) {
				if (ans < good) {
					ans = good;
					finalPath = path + " " + (airport + 1);
				}
				return;
			}
		}
	}

	static class Pos {
		String place;
		int time;
		int good;

		public Pos(String place, int time, int good) {
			this.place = place;
			this.time = time;
			this.good = good;
		}
	}
}
