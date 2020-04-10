package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {

	static class Edge implements Comparable<Edge> {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}

	public static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<List<Edge>> adj = new ArrayList<List<Edge>>();

		for (int i = 0; i < V + 1; i++) {
			adj.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(v1).add(new Edge(v2, w));
		}

		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V + 1];
		int[] D = new int[V + 1];

		Arrays.fill(D, INF);

		D[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().v;
			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (Edge next : adj.get(cur)) {
				if (D[next.v] > D[cur] + next.w) {
					D[next.v] = D[cur] + next.w;
					pq.offer(new Edge(next.v, D[next.v]));
				}
			}
		}
		for (int i = 1; i < V + 1; i++) {
			bw.write(D[i] == INF ? "INF\n" : D[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
