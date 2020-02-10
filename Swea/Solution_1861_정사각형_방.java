package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861_정사각형_방 {
	
	public static int[][] map;
	public static int N; 
	public static int max;
	public static int min;
	public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int temp;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp = find(i, j);
					if(temp > max) {
						max = temp;
						min = Integer.MAX_VALUE;
						min = map[i][j] > min ? min : map[i][j];
					} else if(temp == max) {
						min = map[i][j] > min ? min : map[i][j];
					}
				}
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					int temp = find(i, j);
//					if(temp == max) {
//						min = map[i][j] > min ? min : map[i][j];
//					}
//				}
//			}
			
			System.out.println("#" + t + " " + min + " " + max);
		}
	}
	
	public static int find(int x, int y) {
		int cnt = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[nx][ny] == (map[x][y] + 1)) {
					cnt += find(nx, ny);
				}
			}
		}
		return cnt;
	}
}
