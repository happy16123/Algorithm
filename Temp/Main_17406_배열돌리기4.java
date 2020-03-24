package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int N, M, R, MIN;
	static int[][] map, original, command;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		original = new int[N][M];
		command = new int[R][3];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] p = new int[R]; // R:3 ==> 0 0 0
		// 0 1 2
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			command[i][0] = Integer.parseInt(st.nextToken()) - 1; // R
			command[i][1] = Integer.parseInt(st.nextToken()) - 1; // C
			command[i][2] = Integer.parseInt(st.nextToken()); // S
			p[i] = i;
		}

		do {
			// 0. 직전에 회전한 배열의 상태를 초기상태로 초기화
			for (int i = 0; i < N; i++) {
				System.arraycopy(original[i], 0, map[i], 0, M);
			}

			// 1. 현 순열의 상태로 회전 (순서대로 R번)
			for (int i = 0; i < R; i++) {
				int k = p[i];
				rotate(command[k][0], command[k][1], command[k][2]);
			}
			// 2. 배열의 값을 구함
			int temp = getMin();
			// 3. 최소값 갱신
			if (MIN > temp)
				MIN = temp;

		} while (np(p));
		System.out.println(MIN);
	}

	private static int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			if (min > sum)
				min = sum;
		}
		return min;
	}

	private static void rotate(int r, int c, int s) {

		for (int k = s; k > 0; --k) {
			int start = map[r - k][c - k];

			// 맨 왼쪽열
			// ^
			// |
			for (int i = r - k; i < r + k; i++) {
				map[i][c - k] = map[i + 1][c - k];
			}

			// 맨 아래행
			// <--
			for (int j = c - k; j < c + k; j++) {
				map[r + k][j] = map[r + k][j + 1];
			}

			// 맨 오른쪽 열
			// |
			// v
			for (int i = r + k; i > r - k; i--) {
				map[i][c + k] = map[i - 1][c + k];
			}

			// 맨 윗행
			// -->
			for (int j = c + k; j > c - k; j--) {
				map[r - k][j] = map[r - k][j - 1];
			}

			map[r - k][c - k + 1] = start;
		}

	}

	private static boolean np(int[] p) {

		// 찾찾교교
		// 1. 꼭대기(i) 찾기 ==> i-1 위치 찾기(교환 자리)
		int i = p.length - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;

		// 2. i-1위치값과 교환할 j 위치 찾기
		int j = p.length - 1;
		while (p[i - 1] >= p[j])
			--j;

		// 3. i-1위치값과 j위치값 교환
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;

		// 4. i - 끝까지 오름차순으로 교환
		int k = p.length - 1;
		while (i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		return true;
	}

}