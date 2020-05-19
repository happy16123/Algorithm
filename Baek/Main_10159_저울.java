package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10159_저울 {

	public static int N;
	public static int M;
	public static int[][] D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		D = new int[N][N];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			D[a][b] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k == i) {
					continue;
				}
				for (int j = 0; j < N; j++) {
					if(k == j || i == j) {
						continue;
					}
					if(D[i][k] != 0 && D[k][j] != 0) {
						D[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int cnt= 0;
			for(int j=0; j<N; j++) {
				if(i== j) {
					continue;
				}
				if( D[i][j] == 0 && D[j][i] == 0) {
					cnt ++;
				}
			}
			System.out.println(cnt);
		}
	}
}
