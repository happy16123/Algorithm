package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬 {
	
	public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static int[][] visited;
	public static char[][] map;
	public static int X;
	public static int Y;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new char[X][Y];
		visited = new int[X][Y];
		
		for(int i=0; i<X; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
					visited = new int[X][Y];
				}
			}
		}
		System.out.println(max-1);
	}
	
	public static void bfs(int x, int y) {
		LinkedList<int[]> q = new LinkedList<>();
		int cnt = 0;
		q.offer(new int[] {x, y, cnt});
		visited[x][y] = cnt;
		int nx;
		int ny;
		int[] temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			x = temp[0];
			y = temp[1];
			cnt = temp[2];
			cnt++;
			for(int i=0; i<4; i++) {
				nx = x + dir[i][0];
				ny = y + dir[i][1];
				if(nx > -1 && ny > -1 && nx < X && ny < Y) {
					if(map[nx][ny] == 'L' && visited[nx][ny] == 0) {
						visited[nx][ny] = cnt;
						q.offer(new int[] {nx, ny, cnt});
					} 
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
