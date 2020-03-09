package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	public static int N;
	public static int A;
	public static int[] temp;
	public static int B;
	public static int min;
	public static boolean[] visited;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N/2];
			min = Integer.MAX_VALUE;
			temp = new int[2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			subset();
			System.out.println("#" + t + " " + min);
		}
	}

	public static void subset() {
		int size = 1 << N;
		int[] select = new int[N];
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> bList = new ArrayList<Integer>();
		
		for(int i=0; i<size; i++) {
			int cnt  = 0;
			for(int j=0; j<N; j++) {
				if((i & 1 << j) != 0) {
					select[j] = 1;
					cnt++;
				}
			}
			if(cnt == N/2) {
				for(int j=0; j<N; j++) {
					if(select[j] == 0) {
						aList.add(j);
					} else {
						bList.add(j);
					}
				}
				A = per(0, aList);
				B = per(0, bList);
				min = Math.min(min, Math.abs(A-B));
				A = 0;
				B = 0;
				aList.clear();
				bList.clear();
			}
			Arrays.fill(select, 0);
		}
	}
	
	public static int per(int cnt, ArrayList<Integer> list) {
		int data = 0;
		if(cnt == 2) {
			return map[temp[0]][temp[1]];
		}
		for(int i=0; i<N/2; i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = list.get(i);
				data += per(cnt + 1, list);
				visited[i] = false;
			}
		}
		return data;
	}
}
