package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	
	public static int R;
	public static int C;
	public static int N;
	public static int[][] map;
	public static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	public static int[][] visited;
	public static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visited = new int[R][C];
			ans = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == 1 && visited[i][j] == 0) {
						ans++;
						dfs(i, j, ans);
					}
				}
			}
			
			System.out.println(ans);
			
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++){
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}
	
	public static void dfs(int r, int c, int cnt) {
		visited[r][c] = cnt;
		for(int i=0; i<4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr > -1 && nc > -1 && nr < R && nc < C) {
				if(map[nr][nc] == 1 && visited[nr][nc] == 0){
					visited[nr][nc] = cnt;
					dfs(nr, nc, cnt);
				}
			}
		}
	}
}
