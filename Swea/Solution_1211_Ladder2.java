package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1211_Ladder2 {
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] dir = {{0,1}, {0,-1}, {1,0}}; 
	public static boolean stop = false;
	public static int ans;
	public static int max;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=1; t<=10; t++) {
			br.readLine();
			ans = Integer.MAX_VALUE;
			max = Integer.MAX_VALUE;
			stop = false;
			map = new int[100][100];
			visited = new boolean[100][100];
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<100; i++) {
				if(map[0][i] == 1) {
					dfs(0, i, i, 0);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<100; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void dfs(int r, int c, int start, int cnt) {
		boolean d = false;
		for(int i=0; i<3; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr > -1 && nc > -1 && nr < 100 && nc < 100) {
				if(nr == 99) {
					if(max > cnt) {
						max = cnt;
						ans = start;
					}
					cnt=0;
					return;
				}
				if(map[nr][nc] == 1 && !visited[nr][nc] && !d) {
					visited[nr][nc] = true;
					dfs(nr, nc, start, cnt + 1);
					visited[nr][nc] = false;
					d = true;
				}
			}
		}
	}
}
