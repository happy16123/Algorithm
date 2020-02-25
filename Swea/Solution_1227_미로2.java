package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1227_미로2 {
	
	public static int[][] map;
	public static int ans;
	public static boolean[][] visited;
	public static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=0; t<10; t++) {
			int startR = 0;
			int startC = 0;
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];
			ans = 0;
			int data;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					data = br.read() - '0';
					map[i][j] = data;
					if(data == 2) {
						startR = i;
						startC = j;
					}
				}
				br.readLine();
			}
			
			visited[startR][startC] = true;
			dfs(startR, startC);
			
			System.out.println("#" + T + " " + ans);
			
		}
		
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<100; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void dfs(int r, int c) {
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if(nr > -1 && nc > -1 && nr < 100 && nc < 100) {
				if(map[nr][nc] == 3) {
					ans = 1;
					return;
				}
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc);
					visited[nr][nc] = false;
				}
			}
		}
	}
}
