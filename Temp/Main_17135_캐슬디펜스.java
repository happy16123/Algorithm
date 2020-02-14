package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

	public static int N;
	public static int M;
	public static int D;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] defaultMap;
	public static int[] archer;
	public static int[][] dir = {{0,-1}, {1,0}, {0,1}};
	public static ArrayList<int[]> attack;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		visited = new boolean[N + 1][M];
		defaultMap = new int[N + 1][M];
		archer = new int[3];
		attack = new ArrayList<>();

		int data;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				data = Integer.parseInt(st.nextToken());
				map[i][j] = data;
				defaultMap[i][j] = data;
			}
		}

//		down();
//		for (int i = 0; i < N + 1; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < N + 1; i++) {
//			System.out.println(Arrays.toString(defaultMap[i]));
//		}
//		System.out.println();

		combi(0, 0);

		System.out.println(max);

	}

	public static void combi(int cnt, int start) {
		if (cnt == 3) {
			int cycle = 0;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				map[i] = defaultMap[i].clone();
			}

			while (cycle != N) {
				cycle++;
				for (int i = 0; i < 3; i++) {
					dfs(archer[i]);
				}
				visited = new boolean[N+1][M];
				for(int j=0; j<attack.size(); j++) {
					int r1 = attack.get(j)[0];
					int c1 = attack.get(j)[1];
					if(map[r1][c1] != 0) {
						map[r1][c1] = 0;
						ans++;
					}
				}
				for (int i = 0; i < N + 1; i++) {
				System.out.println(Arrays.toString(map[i]));
				}
				System.out.println(ans);
				attack.clear();
				down();
			}
			max = Math.max(ans, max);
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	public static void dfs(int index) {
		LinkedList<int[]> q = new LinkedList<>();
		int r = N - 1;
		int c = index;
		int d = 1;
		int nr, nc;
		int[] cur;
		q.offer(new int[] {r, c, d});
		if(map[r][c] == 1) {
			visited[r][c] = true;
			attack.add(new int[] {r, c});
			return;
		}
		while(!q.isEmpty()) {
			cur = q.poll();
			r = cur[0];
			c = cur[1];
			d = cur[2];
			d++;
			if(d <= D) {
				for (int i = 0; i < 3; i++) {
					nr = r + dir[i][0];
					nc = c + dir[i][1];
					if (nr > -1 && nc > -1 && nr < N && nc < M) {
						if (map[nr][nc] == 1 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							attack.add(new int[] {nr, nc});
							return;
						}if(map[nr][nc] == 0) {
							q.offer(new int[] {nr, nc, d});
						}
					}
				}
			}
		}
	}

	public static void down() {
		for (int i = N - 1; i > 0; i--) {
			map[i] = map[i - 1].clone();
		}
		map[0] = new int[M];
	}
}
