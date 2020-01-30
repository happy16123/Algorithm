package jungol.bank;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날_김현수2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/im/1141_불쾌한날.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long cnt = 0;
		// 현재 소를 볼수 있는 소들만 담아 놓기
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int cow = scan.nextInt();
			// 현재 소를 볼 수 없는 (작거나 같은 키의 소) 모두뺌
			while(!s.isEmpty() && s.peek() <= cow) {
				s.pop();
			}
			// 남아있는 소는 현재 소를 볼 수 있는 소들
			cnt += s.size();
			s.push(cow);
		}
		System.out.println(cnt);
	}
}
