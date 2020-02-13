package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_DFS {
	
	public static int[][] map;
	public static int[][] visited;
	public static int X;
	public static int Y;
	public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/im/1661.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[X][Y];
		visited = new int[X][Y];
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int startY = Integer.parseInt(st.nextToken()) - 1; 
		int startX = Integer.parseInt(st.nextToken()) - 1; 
		int endY = Integer.parseInt(st.nextToken()) - 1; 
		int endX = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i=0; i<X; i++) {
			String line = br.readLine();
			for(int j=0; j<Y; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		map[endX][endY] = -1;
		
		dfs(startX, startY, 0);
		
//		
//		for(int i=0; i<X; i++) {
//			for(int j=0; j<Y; j++) {
//				System.out.print(visited[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(min);
		
	}
	
	public static void dfs(int x, int y, int cnt) {
		int nx;
		int ny;
		for(int i=0; i<4; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			if(nx > -1 && ny > -1 && nx < X && ny < Y) {
				if(map[nx][ny] == -1) {
					min = Math.min(min, cnt+1);
					return;
				}
				if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
					visited[x][y] = 1;
					dfs(nx, ny, cnt+1);
					visited[x][y] = 0;
				}
			}
		}
	}
}
