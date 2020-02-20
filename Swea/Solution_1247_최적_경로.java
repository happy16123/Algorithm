package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1247_최적_경로 {

	public static int N;
	public static int startX;
	public static int startY;
	public static int endX;
	public static int endY;
	public static ArrayList<Pos> map;
	public static int[] index;
	public static boolean[] checked;
	public static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new ArrayList<>(N);
			index = new int[N];
			checked = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());;
			endX = Integer.parseInt(st.nextToken());;
			endY = Integer.parseInt(st.nextToken());;
			for (int i = 0; i < N; i++) {
				map.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			dfs(0);
			System.out.println("#" + t + " " + min);
		}

//		for(int i=0; i<map.size(); i++) {
//			System.out.println(map.get(i).x + " " + map.get(i).y);
//		}
	}

	public static void dfs(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(index));
			int tempX, tempY;
			int res = 0;
			int cur;
			int next;
			cur = index[0];
			tempX = Math.abs(startX - map.get(cur).x); 
			tempY = Math.abs(startY - map.get(cur).y); 
			res = tempX + tempY;
			for(int i=0; i<N-1; i++) {
				cur = index[i];
				next = index[i+1];
				tempX = Math.abs(map.get(cur).x - map.get(next).x);
				tempY = Math.abs(map.get(cur).y - map.get(next).y);
				res += tempX + tempY;
				if(min < res) {
					return;
				}
			}
			next = index[N-1];
			tempX = Math.abs(map.get(next).x - endX); 
			tempY = Math.abs(map.get(next).y - endY); 
			res += tempX + tempY;
			min = res < min ? res : min;
			
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!checked[i]) {
				checked[i] = true;
				index[cnt] = i;
				dfs(cnt + 1);
				checked[i] = false;
			}
		}
	}
}

class Pos {
	public int x;
	public int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
