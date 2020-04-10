package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_찾기 {

	public static int cnt;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		sb = new StringBuilder();
		kmp(br.readLine(), br.readLine());
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		char[] data = pattern.toCharArray();
		int j = 0;

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && data[i] != data[j]) {
				j = pi[j - 1];
			}
			if (data[i] == data[j]) {
				pi[i] = ++j;
			}
		}

		return pi;
	}

	public static void kmp(String origin, String pattern) {
		int[] pi = getPi(pattern);
		char[] ori = origin.toCharArray();
		char[] pat = pattern.toCharArray();
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			while (j > 0 && ori[i] != pat[j]) {
				j = pi[j - 1];
			}
			if (ori[i] == pat[j]) {
				if (j == pat.length - 1) {
					cnt += 1;
					sb.append(i - pat.length + 2 + "\n");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}
}
