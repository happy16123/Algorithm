package jungol.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1106_장기 {
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int N;
	public static int M;
	public static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int capX = Integer.parseInt(st.nextToken()) - 1; 
		int capY = Integer.parseInt(st.nextToken()) - 1; 
		int jolX = Integer.parseInt(st.nextToken()) - 1; 
		int jolY = Integer.parseInt(st.nextToken()) - 1;
		
		map[capX][capY] = 1;
		map[jolX][jolY] = -1;
		
		bfs(capX, capY, 0);
		System.out.println(min);
		
	}
	
	public static void bfs(int x, int y, int cnt) {
		LinkedList<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, cnt});
		visited[x][y] = true;
		int[] temp;
		int nx;
		int ny;
		while(!q.isEmpty()) {
			temp = q.poll();
			x = temp[0];
			y = temp[1];
			cnt = temp[2];
			cnt++;
			for(int i=0; i<8; i++) {
				nx = x + dir[i][0];
				ny = y + dir[i][1];
				if(nx > -1 && ny > -1 && nx < N && ny < M) {
					if(!visited[nx][ny]) {
						q.offer(new int[] {nx, ny, cnt});
						visited[nx][ny] = true;
					}
					if(map[nx][ny] == -1) {
						min = Math.min(min, cnt);
					}
				}
			}
		}
	}
}
