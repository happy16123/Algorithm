package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	public static int[] visited;
	public static int N;
	public static int K;
	public static int min;
	public static int size;
	public static int[] move = { -1, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		size = 100001;
		min = Integer.MAX_VALUE;
		visited = new int[size];
		Arrays.fill(visited, Integer.MAX_VALUE);
		bfs(N);
		min = min == Integer.MAX_VALUE ? 0 : min;
		System.out.println(min);
	}

	public static void bfs(int start) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		int n, cnt = 0;
		int[] cur;
		q.offer(new int[] { start, cnt });
		while (!q.isEmpty()) {
			cur = q.poll();
			start = cur[0];
			cnt = cur[1];
			if (start == K) {
				min = visited[K];
				return;
			}
			for (int i = 0; i < 3; i++) {
				if (i != 2) {
					n = start + move[i];
				} else {
					n = start * move[i];
				}

				if (n > -1 && n < size) {
					if (visited[n] > cnt + 1) {
						visited[n] = cnt + 1;
						q.offer(new int[] { n, cnt + 1 });
					}
				}
			}
		}
	}
}
