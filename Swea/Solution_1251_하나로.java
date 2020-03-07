package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

	public static int[] X;
	public static int[] Y;
	public static int[] parent;
	public static int[] rank;
	public static int N;
	public static double E;
	public static ArrayList<Edge> list;
	public static double ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		for (int t = 1; t <= T; t++) {
			list = new ArrayList<Edge>();
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			Y = new int[N];
			parent = new int[N];
			rank = new int[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			double price;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					price = Math.pow(Math.sqrt(Math.pow(Math.abs(X[i] - X[j]), 2) + Math.pow(Math.abs(Y[i] - Y[j]), 2)), 2) * E;
					list.add(new Edge(i, j, price));
				}
			}

			Collections.sort(list, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					if (o1.cost < o2.cost) {
						return -1;
					} else if (o1.cost == o2.cost) {
						return 0;
					} else {
						return 1;
					}
				}
			});

			Edge temp;
			for (int i = 0; i < list.size(); i++) {
				temp = list.get(i);
				if(!check(temp.v1, temp.v2)) {
					ans += temp.cost;
					union(temp.v1, temp.v2);
				}
			}
			System.out.println("#" + t + " " + f.format(Math.round(ans)));

//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).v1);
//				System.out.println(list.get(i).v2);
//				System.out.println(list.get(i).cost);
//				System.out.println("====================");
//			}
		}
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return;
		}
		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else {
			parent[y] = x;
			if (rank[x] == rank[y]) {
				rank[x]++;
			}
		}
	}

	public static boolean check(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return true;
		} else {
			return false;
		}
	}

}

class Edge {
	int v1;
	int v2;
	double cost;

	Edge(int v1, int v2, double cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
}