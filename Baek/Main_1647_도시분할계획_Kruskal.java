package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획_Kruskal {
	public static int V;
	public static int E;
	public static ArrayList<Edge> list;
	public static int min;
	public static int[] root;
	public static int[] rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		min = 0;
		root = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			root[i] = i;
		}

		list = new ArrayList<Edge>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(v1, v2, w));
		}

		Collections.sort(list);
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge temp = list.get(i);
			if (find(temp.v1) != find(temp.v2)) {
				min += temp.w;
				cnt++;
				if (cnt == V - 2) {
					break;
				}
				union(temp.v1, temp.v2);
			}
		}

		System.out.println(min);
	}

	public static int find(int x) {
		if (x == root[x]) {
			return x;
		} else {
			return root[x] = find(root[x]);
		}
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

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}
}
