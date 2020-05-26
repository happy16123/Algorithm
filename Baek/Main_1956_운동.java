package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956_운동 {

	public static int V;
	public static int E;
	public static int[][] D;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		D = new int[V][V];
		ans = 98765432;

		for (int i = 0; i < V; i++) {
			Arrays.fill(D[i], 987654321);
			D[i][i] = 0;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			D[v1][v2] = w;
		}
		

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V ; j++) {
					if(D[i][j] > D[i][k] + D[k][j])
						D[i][j] = D[i][k] + D[k][j];
				}
			}
		}
		
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				if(i == j ){
					continue;
				}
				if(D[i][j] != 987654321 && D[j][i] != 987654321) {
					ans = Math.min(ans, D[i][j] + D[j][i]);
				}
			}
		}

		System.out.println(ans == 98765432 ? -1 : ans);
	}
}
