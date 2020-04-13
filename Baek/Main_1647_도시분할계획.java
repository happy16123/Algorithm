package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {

	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge>[] list = new ArrayList[V + 1];
		ans = 0;
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Edge(v1, v2, w));
			list[v2].add(new Edge(v2, v1, w));
		}

		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V + 1];
		pq.offer(new Edge(1, 1, 0));
		int max = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (!visited[cur.v1]) {
				visited[cur.v1] = true;
				ans += cur.w;
				if(cur.w > max) {
					max = cur.w;
				}

				for (Edge next : list[cur.v1]) {
					if (!visited[next.v2]) {
						pq.offer(new Edge(next.v2, next.v2, next.w));
					}
				}
			}
		}

		System.out.println(ans - max);
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
