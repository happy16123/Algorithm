package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

	public static int M;
	public static int A;
	public static int[][] P;
	public static int ans;
	public static BC[] arrBC;
	public static int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			P = new int[2][M];
			arrBC = new BC[A];
			ans = 0;

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					P[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				arrBC[i] = new BC(r, c, range, power);
			}
			move();
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void move() {
		int ar = 0;
		int ac = 0;
		int br = 9;
		int bc = 9;
		ans += select(ar, ac, br, bc);
		for (int i = 0; i < M; i++) {
			ar += dir[P[0][i]][0];
			ac += dir[P[0][i]][1];
			br += dir[P[1][i]][0];
			bc += dir[P[1][i]][1];
			ans += select(ar, ac, br, bc);
		}
	}

	public static int select(int ar, int ac, int br, int bc) {
		int max = 0;
		for (int i = 0; i < A; i++) {
			BC t1 = arrBC[i];
			boolean chkA = false;
			if (getD(ar, ac, t1.r, t1.c) <= t1.range) {
				chkA = true;
			}
			for (int j = 0; j < A; j++) {
				BC t2 = arrBC[j];
				boolean chkB = false;
				if (getD(br, bc, t2.r, t2.c) <= t2.range) {
					chkB = true;
				}
				int sum = 0;
				if (chkA) {
					sum += t1.power;
				}
				if (chkB) {
					sum += t2.power;
				}
				if (chkA && chkB && i == j) {
					sum = t1.power / 2;
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	public static int getD(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static class BC {
		int r;
		int c;
		int range;
		int power;

		public BC(int r, int c, int range, int power) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}

	}
}
