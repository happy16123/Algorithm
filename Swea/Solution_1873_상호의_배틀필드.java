package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_1873_상호의_배틀필드 {

	public static char[][] map;
	public static HashMap<Character, int[]> set;
	public static int H;
	public static int W;
	public static int startX;
	public static int startY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashMap<>();
		set.put('<', new int[] { 0, -1 });
		set.put('^', new int[] { -1, 0 });
		set.put('v', new int[] { 1, 0 });
		set.put('>', new int[] { 0, 1 });
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			startX = 0;
			startY = 0;

			String[] size = br.readLine().split(" ");
			H = Integer.parseInt(size[0]);
			W = Integer.parseInt(size[1]);
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						startX = i;
						startY = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String[] command = br.readLine().split("");

			for (int i = 0; i < N; i++) {
				switch (command[i]) {
				case "U":
					move(startX, startY, '^');
					break;
				case "D":
					move(startX, startY, 'v');
					break;
				case "L":
					move(startX, startY, '<');
					break;
				case "R":
					move(startX, startY, '>');
					break;
				case "S":
					shoot(startX, startY);
					break;
				}
//				System.out.println();
//				System.out.println("command " + command[i]);
//				System.out.print("#" + t + " ");
//				for (int k = 0; k < H; k++) {
//					for (int j = 0; j < W; j++) {
//						System.out.print(map[k][j] + "");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
			System.out.print("#" + t + " ");
			for (int k = 0; k < H; k++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[k][j] + "");
				}
				System.out.println();
			}
		}
	}

	public static void shoot(int x, int y) {
		int[] dir = set.get(map[x][y]);
		int nx = x;
		int ny = y;
		while (true) {
			nx = nx + dir[0];
			ny = ny + dir[1];
			if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
				if (map[nx][ny] == '*') {
					map[nx][ny] = '.';
					break;
				} else if (map[nx][ny] == '#') {
					break;
				}
			} else {
				break;
			}
		}
	}

	public static void move(int x, int y, char command) {
		int[] dir = set.get(command);
		int nx = x;
		int ny = y;
		map[nx][ny] = command;
		nx = nx + dir[0];
		ny = ny + dir[1];
		if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
			if (map[nx][ny] == '.') {
				map[x][y] = '.';
				map[nx][ny] = command;
				startX = nx;
				startY = ny;
			} else {
				map[x][y] = command;
			}
		} else {
			map[x][y] = command;
		}
	}
}
