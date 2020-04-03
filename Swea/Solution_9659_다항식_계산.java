package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9659_다항식_계산 {

	public static long[] memo;
	public static int[] arrT;
	public static int[] arrA;
	public static int[] arrB;
	public static int[] arrM;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			memo = new long[N + 2];
			arrT = new int[N + 2];
			arrA = new int[N + 2];
			arrB = new int[N + 2];

			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arrT[i] = Integer.parseInt(st.nextToken());
				arrA[i] = Integer.parseInt(st.nextToken());
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			arrM = new int[M];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}
			sb.append("#" + test);
			for (int i = 0; i < M; i++) {
				memo[0] = 1;
				memo[1] = arrM[i];
				for (int j = 2; j <= N; j++) {
					switch (arrT[j]) {
					case 1:
						memo[j] = (memo[arrA[j]] + memo[arrB[j]]) % 998244353;
						break;
					case 2:
						memo[j] = (arrA[j] * memo[arrB[j]]) % 998244353;
						break;
					case 3:
						memo[j] = (memo[arrA[j]] * memo[arrB[j]]) % 998244353;
						break;
					}
				}
				sb.append(" " + memo[N]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}