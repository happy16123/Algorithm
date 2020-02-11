package dd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {

	public static int[] root;
	public static int[] rank;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		root = new int[N + 1];
		rank = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			root[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			union(n1, n2);
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(i == root[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static int find(int x) {
		if (root[x] == x) {
			return x;
		} else {
			return find(root[x]);
		}
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (rank[x] < rank[y]) {
			root[x] = y;
		} else {
			root[y] = x;
			if (rank[x] == rank[y]) {
				rank[x]++;
			}
		}

	}
}
