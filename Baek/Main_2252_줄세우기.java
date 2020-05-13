package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {

	public static int N;
	public static int E;
	public static ArrayList<Integer>[] list;
	public static int[] indegree;
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		list = new ArrayList[N + 1];
		indegree = new int[N + 1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			indegree[v2]++;
		}
		
		sort();
		System.out.println(sb.toString());
	}

	public static void sort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			Iterator<Integer> it = list[cur].iterator();
			while (it.hasNext()) {
				int next = it.next();
				indegree[next]--;
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
