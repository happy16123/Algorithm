package test;

import java.util.Scanner;

public class Water_Pour {

	static boolean[][][] visited = new boolean[100][100][100];
	static int a, b, c, d, ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		d = scan.nextInt();
		ans = 987654321;

		dfs(0, 0, 0, 0);
		if (ans == 987654321) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}

	public static void dfs(int va, int vb, int vc, int depth) {
		if (visited[va][vb][vc]) { // a, b, c 리터 별 물이 채워졌을 때 반복하지 않기 위한 체크
			return;
		}

		if (va == d || vb == d || vc == d) { // 어느 비커에서 목표가 되었을 때 최소값 리턴
			ans = Math.min(ans, depth);
			return;
		}
		visited[va][vb][vc] = true;

		if (va == 0) {
			dfs(a, vb, vc, depth + 1); // a비커 물 채우기
		}
		if (vb == 0) {
			dfs(va, b, vc, depth + 1); // b비커 물 채우기
		}
		if (vc == 0) {
			dfs(va, vb, c, depth + 1);  // c비커 물 채우기
		}

		// a --> b
		if (va + vb > b) { // b에 물이 있을 경우 남은 만큼만 옮김
			dfs((va + vb) - b, b, vc, depth + 1);
		} else {
			dfs(0, va + vb, vc, depth + 1);
		}

		// a --> c
		if (va + vc > c) {
			dfs((va + vc) - c, vb, c, depth + 1);
		} else {
			dfs(0, vb, va + vc, depth + 1);
		}

		// b --> a
		if (vb + va > a) {
			dfs(a, (vb + va) - a, vc, depth + 1);
		} else {
			dfs(vb + va, 0, vc, depth + 1);
		}

		// b --> c
		if (vb + vc > c) {
			dfs(va, (vb + vc) - c, c, depth + 1);
		} else {
			dfs(va, 0, vb + vc, depth + 1);
		}

		// c --> a
		if (vc + va > a) {
			dfs(a, vb, (vc + va) - a, depth + 1);
		} else {
			dfs(vc + va, vb, 0, depth + 1);
		}

		// c --> b
		if (vc + vb > b) {
			dfs(va, b, (vc + vb) - b, depth + 1);
		} else {
			dfs(va, vc + vb, 0, depth + 1);
		}

	}
}
