package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇 {
	
	public static int[][] map;
	public static int[][] visited;
	public static int X;
	public static int Y;
	public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	
	// 배열 선언시 => 좌표 1~N 보정
	// 공백 x - ' 0'
	// bfs
	// 1. 시작점 방문표시 1, 큐에 넣기
	// 2. 큐가 empty가 아닐때 까지 반복
	// 2.1 큐에서 데이터 추출, x, y, cnt
	// 2.3 경계 검사, 갈 수 있는 길인지 amp[nx][ny] == 0, 방문 검사 까지 함
	// 2.3.1 갈 수 있는 길이면 nx, ny가 도착인지 확인
	// 2.3.1.1 도착했으면 return, break 2;
	// 2.3.2 갈 수 있다면 nx, ny를 큐에 넣는다
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
		
		
		bfs(startX, startY);
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(visited[endX][endY]);
		
	}
	
	public static void bfs(int x, int y) {
		LinkedList<int[]> q = new LinkedList<>();
		int cnt = 0;
		q.offer(new int[] {x, y, cnt});
		visited[x][y] = 1;
		int[] cur;
		int nx;
		int ny;

		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0];
			y = cur[1];
			cnt = cur[2];
			cnt++;
			for(int i=0; i<4; i++) {
				nx = x + dir[i][0];
				ny = y + dir[i][1];
				if(nx > -1 && ny > -1 && nx < X && ny < Y) {
					if(map[nx][ny] == -1) {
						visited[nx][ny] = cnt;
						return;
					}
					if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
						visited[nx][ny] = cnt;
						q.offer(new int[] {nx, ny, cnt});
					}
				}
			}
		}
		
	}
}
