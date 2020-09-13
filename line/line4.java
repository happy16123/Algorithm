package line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class line4 {

	public static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
//		int[][] maze = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
		System.out.println(solution(maze));
	}

	public static int solution(int[][] maze) {
		int answer = 0;
		int size = maze.length;
		int[][] map = new int[size + 2][size + 2];

		for (int i = 0; i < size + 2; i++) {
			Arrays.fill(map[i], 1);
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				map[i][j] = maze[i - 1][j - 1];
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 1, 1, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int d = cur[2];

			if (r == size && c == size) {
				return answer;
			}

			if (d == -1) {
				d = 3;
			} else if (d == 4) {
				d = 0;
			}

			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			int lr = r + dir[(d + 1) % 4][0];
			int lc = c + dir[(d + 1) % 4][1];

			if (map[nr][nc] == 0 && map[lr][lc] == 0) {
				q.offer(new int[] { lr, lc, d + 1 });
				answer += 1;
			} else if (map[nr][nc] == 0 && map[lr][lc] == 1) {
				q.offer(new int[] { nr, nc, d });
				answer += 1;
			} else if (map[nr][nc] == 1 && map[lr][lc] == 0) {
				q.offer(new int[] { lr, lc, d + 1 });
				answer += 1;
			} else if (map[nr][nc] == 1 && map[lr][lc] == 1) {
				q.offer(new int[] { r, c, d - 1 });
			}

		}

		return answer;
	}
}
