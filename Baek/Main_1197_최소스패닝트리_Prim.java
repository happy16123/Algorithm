package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_Prim {

	public static int V;
	public static int E;
	public static ArrayList<Edge>[] list;
	public static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<Edge>();
		}
		min = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Edge(v1, v2, w));
			list[v2].add(new Edge(v2, v1, w));
		}
		prim();
		System.out.println(min);
	}

	public static void prim() {
		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V + 1];
		pq.offer(new Edge(1, 1, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (!visited[cur.v1]) {
				visited[cur.v1] = true;
				min += cur.w;

				for (int i = 0, size = list[cur.v1].size(); i < size; i++) {
					Edge temp = list[cur.v1].get(i);
					if (!visited[temp.v2]) {
						pq.offer(new Edge(temp.v2, temp.v2, temp.w));
					}
				}
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
