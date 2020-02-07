package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물_수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] farm;

		for (int t = 1; t <= T; t++) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] = br.read() - 48;
				}
				br.readLine();
			}


			for (int i = 0; i <= N/2; i++) {
				for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
					ans += farm[i][j];
					System.out.print(farm[i][j]);
				}
				System.out.println();
			}
			
			for (int i = 1; i <= N/2; i++) {
				for (int j = i; j < N - (i); j++) {
					ans += farm[N/2 + i][j];
					System.out.print(farm[N/2 + i][j]);
				}
				System.out.println();
			} 

			System.out.println("#" + t + " " + ans);
		}
	}
}
