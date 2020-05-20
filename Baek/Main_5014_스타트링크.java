package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {

	public static int F; // 전체 층수
	public static int S; // 현재 위치
	public static int G; // 목적지
	public static int U;
	public static int D;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		bfs(S);
		if (ans == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}

	public static void bfs(int start) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[1000001];
		q.offer(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			start = cur[0];
			int cnt = cur[1];
			if (start == G) {
				ans = Math.min(ans, cnt);
				return;
			}
			if (start + U <= F && !visited[start + U] && U != 0) {
				visited[start + U] = true;
				q.offer(new int[] { start + U, cnt + 1 });
			}
			if (start - D > 0 && !visited[start - D] && D != 0) {
				visited[start - D] = true;
				q.offer(new int[] { start - D, cnt + 1 });
			}
		}
	}
}
