package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러 {

	static ArrayList<int[]> ans = new ArrayList<>();
	static boolean[] visited;
	static int list[][];
	static int N;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		list = new int[21][2];
		visited = new boolean[21];

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Long.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[i] = new int[] { r, c };
			}
			dfs(0, 0);
			System.out.println("#" + t + " " + min);
		}


	}

	public static void dfs(int index, int cnt) {
		if (cnt == N / 2)
	    {
	        long x = 0, y = 0;
	        for (int i = 0; i < N; i++)
	        {
	            if (!visited[i])
	            {
	                x += list[i][0];
	                y += list[i][1];
	            }
	            else
	            {
	                x -= list[i][0];
	                y -= list[i][1];
	            }
	        }
	        min = Math.min(min,  x*x+y*y);
	        return;
	    }
	 
	    for (int i = index; i < N; i++)
	    {
	        if (!visited[i])//이미 짝이 있는 지렁이는 패스
	        {
	            visited[i] = true;
	            dfs(i + 1, cnt + 1);
	            visited[i] = false;
	        }
	    }
	}
}
