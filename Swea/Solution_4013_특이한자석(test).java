package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {

	public static int[][] map;
	public static int[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());

			map = new int[4][8];
			checked = new int[4];
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int target = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				sol(target, dir);
				Arrays.fill(checked, 0);
			}
			int ans = 0;
			for(int i=0; i<4; i++) {
				if(map[i][0] == 1) {
					ans += Math.pow(2, i);
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void sol(int target, int dir) {
		checked[target] = dir;
		check(target);
		for(int i=0; i<4; i++) {
			rotation(i, checked[i]);
		}
	}

	public static void rotation(int target, int dir) {
		if (dir == 1) {
			int temp = map[target][7];
			for (int i = 7; i >= 1; i--) {
				map[target][i] = map[target][i - 1];
			}
			map[target][0] = temp;
		} else if(dir == -1){
			int temp = map[target][0];
			for (int i = 0; i <= 6; i++) {
				map[target][i] = map[target][i + 1];
			}
			map[target][7] = temp;
		}
	}

	public static void check(int target) {
		for (int i = target; i > 0; i--) {
			if (map[i][6] != map[i - 1][2]) {
				checked[i - 1] = checked[i] * -1;
			} else {
				break;
			}
		}
		for (int i = target; i < 3; i++) {
			if (map[i][2] != map[i + 1][6]) {
				checked[i + 1] = checked[i] * -1;
			} else {
				break;
			}
		}
	}
}
