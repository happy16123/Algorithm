package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1006_로봇 {

	public static int R;
	public static int C;
	public static int startR;
	public static int startC;
	public static int startD;
	public static int endR;
	public static int endC;
	public static int endD;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[5][R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;
		startD = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		endR = Integer.parseInt(st.nextToken()) - 1;
		endC = Integer.parseInt(st.nextToken()) - 1;
		endD = Integer.parseInt(st.nextToken());

		bfs(startR, startC);
	}

	public static void bfs(int r, int c) {
		LinkedList<Pos> q = new LinkedList<>();
		int cnt = 0;
		int nr, nc, curD;
		curD = startD;
		visited[curD][r][c] = true;
		q.offer(new Pos(r, c, curD, cnt));
		Pos cur;

		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur.r;
			c = cur.c;
			curD = cur.d;
			cnt = cur.cnt;
			if (r == endR && c == endC && curD == endD) {
				System.out.println(cnt);
				return;
			}
			for (int j = 1; j <= 3; j++) {
				nr = r + dir[curD - 1][0] * j;
				nc = c + dir[curD - 1][1] * j;
				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if (map[nr][nc] == 0) {
						if(!visited[curD][nr][nc]) {
							visited[curD][nr][nc] = true;
							q.offer(new Pos(nr, nc, curD, cnt+1));
						}
					} else {
						break;
					}
				}
			}
			
			for(int i=1; i<=4; i++) {
				if(curD != i && visited[curD][r][c]) {
					int add = 1;
					if(curD == 1) {
						if(i == 2) ++add;
					} else if(curD ==2 ) {
						if(i == 1) ++add;
					}else if(curD == 3 ) {
						if(i == 4) ++add;
					} else {
						if(i == 3) ++add;
					}
					visited[i][r][c] = true;
					q.add(new Pos(r, c, i, cnt+add));
				}
			}
		}
	}
}

class Pos{
	int r;
	int c;
	int d;
	int cnt;
	
	Pos(int r, int c, int d, int cnt){
		this.r = r;
		this.c = c;
		this.d = d;
		this.cnt = cnt;
	}
}
