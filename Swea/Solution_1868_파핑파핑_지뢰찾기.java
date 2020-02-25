package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1868_파핑파핑_지뢰찾기 {

	public static int N;
	public static int ans;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '*') {
						visited[i][j] = true;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						dfs(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '0' && !visited[i][j]) {
						check(i, j);
						ans++;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						ans++;
					}
				}
			}

			System.out.println("#" + t + " " + ans);

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
	}

	public static void dfs(int r, int c) {
		int mine = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N) {
				if (map[nr][nc] == '*') {
					mine++;
				}
			}
		}
		map[r][c] = (char) (mine + 48);
	}

	public static void check(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N) {
				if(map[nr][nc] == '0' && !visited[nr][nc]) {
					check(nr, nc);
				}
				visited[nr][nc] = true;
			}
		}
	}
}
