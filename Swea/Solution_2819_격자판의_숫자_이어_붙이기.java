package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_2819_격자판의_숫자_이어_붙이기 {

	public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static String[][] map;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			map = new String[4][4];
			list = new ArrayList<Integer>();
			for (int i = 0; i < 4; i++) {
				map[i] = br.readLine().split(" ");
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					bfs(i, j);
				}
			}
			
			System.out.println("#" + t + " " + list.size());
		}
	}

	public static void bfs(int r, int c) {
		LinkedList<Pos> q = new LinkedList<Pos>();
		String str = map[r][c];
		int nr, nc;
		Pos cur;

		q.offer(new Pos(r, c, str));
		while (!q.isEmpty()) {
			cur = q.poll();
			r = cur.r;
			c = cur.c;
			str = cur.s;
			if (str.length() != 7) {
				for (int i = 0; i < 4; i++) {
					nr = r + dir[i][0];
					nc = c + dir[i][1];
					if (nr > -1 && nc > -1 && nr < 4 && nc < 4) {
						q.offer(new Pos(nr, nc, str + map[nr][nc]));
					}
				}
			} else {
				int data = Integer.parseInt(str);
				if (!list.contains(data)) {
					list.add(data);
				}
			}
		}
	}
}

class Pos {
	int r;
	int c;
	String s;

	Pos(int r, int c, String s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}

}