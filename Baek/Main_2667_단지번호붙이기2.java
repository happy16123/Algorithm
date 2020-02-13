package baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main_2667_단지번호붙이기2 {

	public static int no = 1;
	public static int[][] map;
	public static int[][] visited;
	public static int N;
	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/baek/2667.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];

		// 데이터 읽기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 배열을 전체 순회하면서 아파트(1)를 찾으면 bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					dfs2(i, j);
					no++;
				}
			}
		}

		// visited 배열을 순회하면서 단지마다 아파트 수 count
		int[] count = new int[no];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] > 0) {
					count[visited[i][j]]++;
				}
			}
		}
		// count 배열 정렬 하기
		Arrays.sort(count);
		System.out.println(--no);
		for (int i = 1; i <= no; i++) {
			System.out.println(count[i]);
		}

		// 출력
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("========================");
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
	}

	public static void dfs(int r, int c) {
		Stack<int[]> s = new Stack<>();
		s.push(new int[] { r, c });
		int[] cur;
		int nr;
		int nc;
		while (!s.isEmpty()) {
			cur = s.pop();
			r = cur[0];
			c = cur[1];
			visited[r][c] = no; // visited배열에 단지번호를 부여하면 방문처리가 됨
			for (int i = 0; i < 4; i++) { // 현재 아파트에 사방으로 인접된 아파트가 있는지 확인
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < N && nc < N) { // 경계 검사
					if (map[nr][nc] > 0 && visited[nr][nc] == 0) { // 인접된 아파트
						s.push(new int[] { nr, nc });
					}
				}
			}
		}
	}

	public static void dfs2(int r, int c) {
		int nr;
		int nc;
		visited[r][c] = no; // visited배열에 단지번호를 부여하면 방문처리가 됨
		for (int i = 0; i < 4; i++) { // 현재 아파트에 사방으로 인접된 아파트가 있는지 확인
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if (nr > -1 && nc > -1 && nr < N && nc < N) { // 경계 검사
				if (map[nr][nc] > 0 && visited[nr][nc] == 0) { // 인접된 아파트
					dfs2(nr, nc);
				}
			}
		}
	}
}
