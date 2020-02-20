package jungol.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기_영역구분 {

	public static int[][] map;
	public static int[] ans = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N - 1, N - 1);
		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}

	public static void divide(int r, int c, int endR, int endC) {
		
		if(check(r, c, endR, endC)) {
			int midR = (r + endR) >> 1;
			int midC = (c + endC) >> 1;
			divide(r, c, midR, midC);
			divide(midR + 1, c, endR, midC);
			divide(r, midC + 1, midR, endC);
			divide(midR + 1, midC + 1, endR, endC);
		}
	}

	public static boolean check(int r, int c, int endR, int endC) {
		int color = map[r][c];
		for (int i = r; i <= endR; i++) {
			for (int j = c; j <= endC; j++) {
				if (map[i][j] != color) {
					return true;
				}
			}
		}
		ans[color] +=1;
		return false;
	}
}
