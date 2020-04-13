package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1774_우주신과의_교감 {

	public static int[] root;
	public static int[] rank;
	public static int[] X;
	public static int[] Y;
	public static double ans;
	public static List<Edge> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		root = new int[N + 1];
		rank = new int[N + 1];
		X = new int[N + 1];
		Y = new int[N + 1];
		list = new ArrayList<Edge>();

		for (int i = 0; i < N + 1; i++) {
			root[i] = i;
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				double w = Math.sqrt(Math.pow(Math.abs(X[i] - X[j]), 2) + Math.pow(Math.abs(Y[i] - Y[j]), 2));
				list.add(new Edge(i, j, w));
			}
		}

		Collections.sort(list, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.w, o2.w);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Edge cur = list.get(i);
			if (find(cur.v1) != find(cur.v2)) {
				ans += cur.w;
				union(cur.v1, cur.v2);
			}
		}
		System.out.printf("%.2f", ans);
	}

	public static int find(int x) {
		if (x == root[x]) {
			return x;
		}
		return root[x] = find(root[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (rank[x] < rank[y]) {
			root[x] = y;
		} else {
			root[y] = x;
			if (rank[x] == rank[y]) {
				rank[x]++;
			}
		}
	}

	static class Edge {
		int v1;
		int v2;
		double w;

		public Edge(int v1, int v2, double w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
}
