package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {

	public static int N;
	public static int M;
	public static int K;
	public static int[][] A;
	public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 },
			{ 1, 1 } };
	public static int[][] nutri;
	public static Queue<Tree> tree;
	public static Queue<Tree> die;
	public static Queue<Tree> temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		nutri = new int[N][N];
		tree = new PriorityQueue<Tree>();
		die = new LinkedList<Tree>();
		temp = new LinkedList<Tree>();

		for (int i = 0; i < N; i++) {
			Arrays.fill(nutri[i], 5);
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			tree.offer(new Tree(r, c, age));
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(tree.size());
	}

	public static void spring() {
		while (!tree.isEmpty()) {
			Tree cur = tree.poll();
			int r = cur.r;
			int c = cur.c;
			int age = cur.age;
			if (nutri[r][c] >= age) {
				nutri[r][c] = nutri[r][c] - age;
				temp.offer(new Tree(r, c, age + 1));
			} else {
				die.offer(cur);
			}
		}

		while (!temp.isEmpty()) {
			tree.offer(temp.poll());
		}
	}

	public static void summer() {
		while (!die.isEmpty()) {
			Tree cur = die.poll();
			nutri[cur.r][cur.c] += cur.age / 2;
		}
	}

	public static void fall() {
		while (!tree.isEmpty()) {
			Tree cur = tree.poll();
			int r = cur.r;
			int c = cur.c;
			int age = cur.age;
			if (age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
					if (nr > -1 && nc > -1 && nr < N && nc < N) {
						temp.offer(new Tree(nr, nc, 1));
					}
				}
			}
			temp.offer(cur);
		}

		while (!temp.isEmpty()) {
			tree.offer(temp.poll());
		}
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutri[i][j] += A[i][j];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int r;
		int c;
		int age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(age, o.age);
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", age=" + age + "]";
		}

	}
}
