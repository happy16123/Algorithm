package swea.d3;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new FileReader("res/lecture/암호문1.txt"));
		Scanner scan = new Scanner(new File("res/lecture/암호문1.txt"));

		LinkedList<String> list;
		for (int k = 0; k < 10; k++) {
			int N = Integer.parseInt(scan.nextLine());
			list = new LinkedList<>();
			String[] pass = scan.nextLine().split(" ");
			for (int i = 0; i < N; i++) {
				list.add(pass[i]);
			}

			int comCnt = Integer.parseInt(scan.nextLine());
			for(int j =0; j<comCnt; j++) {
				if (scan.next().equals("I")) {
					int x = scan.nextInt();
					int y = scan.nextInt();
					for (int i = 0; i < y; i++) {
						list.add(x + i, scan.nextInt()+"");
					}
				}
			}
			System.out.print("#" + (k+1) + " ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			list.clear();
			scan.nextLine();
		}
	}
}
