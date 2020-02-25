package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의_개수 {

	public static int[][] map;
	public static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = new int[3];
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(ans[2]);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public static void divide(int r, int c, int size) {

		if(!check(r, c, size)) {
			int div = size / 3;
			divide(r, c, div);
			divide(r, c + div, div);
			divide(r, c + (div * 2), div);
			divide(r + div, c, div);
			divide(r + div, c + div, div);
			divide(r + div, c + (div * 2), div);
			divide(r + (div * 2), c, div);
			divide(r + (div * 2), c + div, div);
			divide(r + (div * 2), c + (div * 2), div);
		}
	}
	
	public static boolean check(int r, int c, int size) {
		int data = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != data) {
					return false;
				}
			}
		}
		if(data == -1) {
			ans[2]++;
		} else {
			ans[data]++;
		}
		return true;
	}
}
