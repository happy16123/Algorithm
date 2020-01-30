package test;

import java.util.Scanner;

class Solution_1954_달팽이숫자_김현수 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int arr[] = new int[T];
		for (int test_case = 0; test_case < T; test_case++) {
			arr[test_case] = scan.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("#" + (i + 1));
			make(arr[i]);
		}
	}

	public static void make(int N) {
		int x = 0;
		int y = -1;
		int d = 1;
		int data[][] = new int[N][N];
		int cnt = 1;
		int n = data.length;

		while (n > 0) {
			for (int i = 0; i < n; i++) {
				y = y + d;
				data[x][y] = cnt++;
			}
			n--;
			for (int i = 0; i < n; i++) {
				x = x + d;
				data[x][y] = cnt++;
			}
			d *= -1;
		}
		print(data);
	}

	public static void print(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}