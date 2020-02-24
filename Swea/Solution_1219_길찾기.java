package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {
	
	public static GraphNode[] list;
	public static boolean[] visited;
	public static int ans;
	
		
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			list = new GraphNode[100];
			visited = new boolean[100];
			ans = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			int node, ad;
			for(int i=0; i<N; i++) {
				node = Integer.parseInt(st.nextToken());
				ad = Integer.parseInt(st.nextToken());
				list[node] = new GraphNode(ad, list[node]);
			}
			
//		for(int i=0; i<100; i++) {
//			System.out.printf("%d:%s\n", i, list[i]);
//		}
			
			dfs(0);
			System.out.println("#" + T + " " + ans);
			
		}
		
	}
	
	public static void dfs(int cur) {
		GraphNode temp = list[cur];
		while(temp != null) {
			if(temp.vertex == 99) {
				ans = 1;
				return;
			}
			if(!visited[temp.vertex]) {
				visited[cur] = true;
				dfs(temp.vertex);
				visited[cur] = false;
			}
			temp = temp.link;
		}
	}
	
}

class GraphNode{
	int vertex;
	GraphNode link;
	public GraphNode(int vertex, GraphNode link) {
		this.vertex = vertex;
		this.link = link;
	}
}
