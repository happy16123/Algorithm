package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {

	static int N, K; // 수빈위치, 동생위치 
	static boolean[] visited;
	static int[] path;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001]; // 0 ~ 100000
		path = new int[100001];
		Arrays.fill(path, -1);
		
		System.out.println(bfs());
		Stack<Integer> stack = new Stack<Integer>();
		int temp = K;
		do {
			stack.push(temp);
			temp = path[temp];
		}while(temp != -1);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());

	}
	
	private static int bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[N] = true; //수빈이 위치 
		queue.offer(new int[] {N,0});
		
		int nx;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[0] == K) return cur[1];
				
			// 걷는 경우
			// 위
			nx = cur[0]-1;
			if(nx>=0 && !visited[nx]) {
				visited[nx] = true;
				path[nx] = cur[0];
				queue.offer(new int[] {nx,cur[1]+1});
			}
			// 아래
			nx = cur[0]+1;
			if(nx<=100000 && !visited[nx]) {
				visited[nx] = true;
				path[nx] = cur[0];
				queue.offer(new int[] {nx,cur[1]+1});
			}			
			
			// 순간이동 하는 경우 
			nx = cur[0]<<1;
			if(nx<=100000 && !visited[nx]) {
				visited[nx] = true;
				path[nx] = cur[0];
				queue.offer(new int[] {nx,cur[1]+1});
			}						
			
		}	
		return -1;			
		
	}

}
