package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	
	public static int M;
	public static int N;
	public static int ans;
	public static int[][] map;	
	public static boolean[][] visited;	
	public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static ArrayList<int[]> tomato;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		tomato = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					tomato.add(new int[] {i, j});
				}
			}
		}
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(ans);
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	
	public static void bfs() {
		LinkedList<int[]> q = new  LinkedList<>();
		int r, c; 
		int nr, nc;
		int cnt = 0;
		for(int i=0; i<tomato.size(); i++) {
			r = tomato.get(i)[0];
			c = tomato.get(i)[1];
			visited[r][c] = true;
			q.offer(new int[] {r, c, cnt});
		}
		int[] cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			cnt = cur[2];
			cnt++;
			for(int i=0; i<4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				if(nr > -1 && nc > -1 && nr < N && nc < M) {
					if(map[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						map[nr][nc] = cnt;
						q.offer(new int[] {nr, nc, cnt});
					}
				}
			}
		}
		ans = cnt - 1;
	}
}
