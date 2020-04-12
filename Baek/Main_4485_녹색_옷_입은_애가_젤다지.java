package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색_옷_입은_애가_젤다지 {

	public static int[][] map;
	public static int[][] D;
	public static int N;
	public static int ans;
	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			D = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(0, 0);
			bw.write("Problem " + t++ + ": " + ans + "\n");
		}
		bw.flush();
	}
	
	public static void bfs(int r, int c) {
		Queue<Node> pq = new PriorityQueue<Node>();
		D[r][c] = map[r][c];
		pq.offer(new Node(r, c, D[r][c]));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			r = cur.r;
			c = cur.c;
			if(r == N-1 && c == N-1) {
				ans = cur.w;
				return;
			}
			
			int w = cur.w;
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) {
					if (D[nr][nc] > D[r][c] + map[nr][nc]) {
						D[nr][nc] = D[r][c] + map[nr][nc];
						pq.offer(new Node(nr, nc, w + map[nr][nc]));
					}
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int w;
		Node(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}
	}
}
