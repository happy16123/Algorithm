package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class no4 {

	public static int[][] res;
	public static ArrayList<Edge>[] adj;
	public static int N;

	public static void main(String[] args) {
//		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
//				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
//		solution(6, 4, 6, 2, fares);
		
//		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
//		solution(7, 3, 4, 1, fares);
		int[][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
		solution(6, 4, 5, 6, fares);
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 987654321;
		N = n;
		res = new int[N + 1][N + 1];
		int size = fares.length;
		adj = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < size; i++) {
			int[] cur = fares[i];
			adj[cur[0]].add(new Edge(cur[1], cur[2]));
			adj[cur[1]].add(new Edge(cur[0], cur[2]));
		}

		for (int i = 1; i <= N; i++) {
			res[i] = dijkstra(i);
		}
		
		for (int i = 1; i <= N; i++) {
			if(res[s][i] + res[i][a] + res[i][b] > 0) {
				answer = Math.min(answer, res[s][i] + res[i][a] + res[i][b]);
			}
		}

		System.out.println(answer);

		return answer;
	}

	public static int[] dijkstra(int start) {
		Queue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[N + 1];
		int[] D = new int[N + 1];
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
	}
}
