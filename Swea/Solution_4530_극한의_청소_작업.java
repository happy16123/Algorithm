package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4530_극한의_청소_작업 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			boolean boolA = false;
			boolean boolB = false;

			if (A < 0) {
				boolA = true;
				A = Math.abs(A);
			}
			if (B < 0) {
				boolB = true;
				B = Math.abs(B);
			}

			long noA = toNine(A);
			long noB = toNine(B);
			long resA = toTen(noA);
			long resB = toTen(noB);
			if (boolA) {
				resA *= -1;
			}
			if (boolB) {
				resB *= -1;
			}
			long ans = resB - resA;
			if (boolA != boolB) {
				ans = ans - 1;
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	public static long toNine(long num) {
		String data = num + "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) - '0' > 4) {
				sb.append(data.charAt(i) - '1');
			} else {
				sb.append(data.charAt(i) - '0');
			}
		}
		return Long.parseLong(sb.toString());
	}

	public static long toTen(long num) {
		String data = num + "";
		long res = 0;
		int cnt = 0;
		for (int i = data.length() - 1; i >= 0; i--) {
			res += (data.charAt(i) - '0') * (long) (Math.pow(9, cnt++));
		}
		return res;
	}
}
