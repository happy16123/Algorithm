package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3356_라디오전송 {

	public static int[] pi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		getPi(br.readLine());

		System.out.println(L - pi[L - 1]);
	}

	public static void getPi(String pattern) {
		pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pi.length; i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
	}
}
