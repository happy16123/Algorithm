package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1215_회문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		char[][] map = new char[8][8];
		int cnt = 0;

		for (int t = 1; t <= 10; t++) {

			int length = Integer.parseInt(br.readLine());
			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().toCharArray();
			}
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - length; j++) {
					for (int k = j; k < length + j; k++) {
						sb.append(map[i][k]);
						if (sb.length() == length) {
							if (sb.toString().equals(sb.reverse().toString())) {
								cnt++;
							}
						}
					}
					sb.delete(0, sb.length());
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - length; j++) {
					for (int k = j; k < length + j; k++) {
						sb.append(map[k][i]);
						if (sb.length() == length) {
							if (sb.toString().equals(sb.reverse().toString())) {
								cnt++;
							}
						}
					}
					sb.delete(0, sb.length());
				}
			}
			System.out.println("#" + t + " " + cnt);
			cnt = 0;
		}

	}
}
