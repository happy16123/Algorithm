package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1504_특정한_최단경로 {

	public static int N;
	public static int E;
	public static ArrayList<Edge>[] adj;
	public static int[][] res;
	public static int ans1;
	public static int ans2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		res = new int[3][N];
		ans1 = 0;
		ans2 = 0;
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adj[v1].add(new Edge(v2, w));
			adj[v2].add(new Edge(v1, w));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int n1 = Integer.parseInt(st.nextToken()) - 1;
		int n2 = Integer.parseInt(st.nextToken()) - 1;
		res[0] = dijk(0);
		res[1] = dijk(n1);
		res[2] = dijk(n2);
		ans1 = res[0][n1] + res[1][n2] + res[2][N - 1];
		ans2 = res[0][n2] + res[2][n1] + res[1][N - 1];
		if(res[0][N-1] == 987654321) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(ans1 > ans2 ? ans2 : ans1);
	}

	public static int[] dijk(int start) {
		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[N];
		int[] D = new int[N];
		Arrays.fill(D, 987654321);
		D[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().v;
			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (Edge next : adj[cur]) {
				if (D[next.v] > D[cur] + next.w) {
					D[next.v] = D[cur] + next.w;
					pq.offer(new Edge(next.v, D[next.v]));
				}
			}
		}
		return D;
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

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

	}
}
