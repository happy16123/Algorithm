package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516_게임개발 {

	public static int N;
	public static int[] indegree;
	public static ArrayList<Integer>[] adj;
	public static int[] time;
	public static int[] prev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N];
		time = new int[N];
		prev = new int[N];
		indegree = new int[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			int size = st.countTokens();
			for (int k = 0; k < size; k++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == -1) {
					break;
				}
				adj[cur - 1].add(i);
				indegree[i]++;
			}
		}
		toSort();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(prev[i] + time[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void toSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			Iterator<Integer> it = adj[cur].iterator();
			while (it.hasNext()) {
				int next = it.next();
				// 다음 건물 시작 가능 시간 = 이전 건물이 지어지기 까지의 시간 + 이전 건물이 지어지는 시간
				prev[next] = Math.max(prev[next], prev[cur] + time[cur]);
				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
