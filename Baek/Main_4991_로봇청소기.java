package beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {

	public static int R;
	public static int C;
	public static char[][] map;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static int[][] adj;
	public static ArrayList<int[]> pos;
	public static int ans;
	public static int vertex;
	public static int[] sequence;
	public static boolean[] perChk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0) {
				break;
			}
			map = new char[R][C];
			pos = new ArrayList<int[]>();
			ans = 987654321;
			vertex = 0;
			int startIdx = 0;
			char temp = 'a';

			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*') {
						pos.add(new int[] { i, j });
						map[i][j] = temp++;
					} else if (map[i][j] == 'o') {
						startIdx = pos.size();
						pos.add(new int[] { i, j });
						map[i][j] = temp++;
					}
				}
			}
			vertex = pos.size();
			adj = new int[vertex][vertex];
			perChk = new boolean[vertex];
			sequence = new int[vertex];
			sequence[0] = startIdx;
			perChk[startIdx] = true;
			boolean perFlag = false;
			for (int i = 0; i < vertex; i++) {
				bfs(pos.get(i)[0], pos.get(i)[1], i);
				for(int j=0; j<vertex; j++) {
					if(i != j && adj[i][j] == 0) {
						perFlag = true;
						break;
					}
				}
			}
			
			if(!perFlag) {
				per(1);
			}
			
			if(ans == 987654321) {
				sb.append("-1\n");
			} else {
				sb.append(ans + "\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void per(int cnt) {
		if(cnt == vertex) {
			int min = 0;
			for(int i=0; i<vertex - 1; i++) {
				min += adj[sequence[i]][sequence[i + 1]];
			}
			ans = Math.min(min, ans);
			return;
		}
		for(int i=0; i<vertex; i++) {
			if(!perChk[i]) {
				perChk[i] = true;
				sequence[cnt] = i;
				per(cnt + 1);
				perChk[i] = false;
			}
		}
	}

	public static void bfs(int r, int c, int index) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[R][C];
		q.offer(new int[] { r, c, 0 });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
			int cnt = cur[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < R && nc < C && !visited[nr][nc]) {
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'a' + vertex) {
						adj[index][map[nr][nc] - 'a'] = cnt + 1;
						adj[map[nr][nc] - 'a'][index] = cnt + 1;
						q.offer(new int[] {nr, nc, cnt + 1});
						visited[nr][nc] = true;
					} else if (map[nr][nc] == '.') {
						q.offer(new int[] { nr, nc, cnt + 1 });
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

}
