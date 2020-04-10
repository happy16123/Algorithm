package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1916_최소비용_구하기 {

	public static int N;
	public static int M;
	public static List<List<Edge>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList<List<Edge>>();

		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<Edge>());
		}
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(v1).add(new Edge(v2, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}

	public static int dijkstra(int start, int end) {
		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[N + 1];
		int[] D = new int[N + 1];

		Arrays.fill(D, Integer.MAX_VALUE);

		D[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().v;
			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;
			
			for(Edge next : adj.get(cur)) {
				if(D[next.v] > D[cur] + next.w) {
					D[next.v] = D[cur] + next.w;
					pq.offer(new Edge(next.v, D[next.v]));
				}
			}
		}
		return D[end];
	}

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
}
