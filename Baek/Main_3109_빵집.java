package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	public static int X;
	public static int Y;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] dir = {{-1,1}, {0,1}, {1,1}};
	public static ArrayList<Integer> ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new char[X][Y];
		visited = new boolean[X][Y];
		ans = new ArrayList<>();

		for (int i = 0; i < X; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<X; i++) {
			dfs(i, 0, 0);
		}
		System.out.println(ans.size());
	}
	
	public static boolean dfs(int x, int y, int cnt) {
		int nx, ny;
		visited[x][y] = true;
		boolean b = false;
		for(int i=0; i<3; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			if(nx > -1 && ny > -1 && nx < X && ny < Y && map[nx][ny] == '.' && !visited[nx][ny]) {
				if(ny == Y-1) {
					visited[nx][ny] = true;
					ans.add(cnt);
					return true;
				}
				b = dfs(nx, ny, cnt+1);
				if(b) {
					return true;
				}
			}
		}
		return b;

	}
}
