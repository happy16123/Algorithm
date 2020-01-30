package jungol.bank;

import java.util.Scanner;
import java.util.Stack;

public class Main_1809_탑_김현수 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		Stack<Integer> s = new Stack<>();
		Stack<Integer> id = new Stack<>();
		int[] ans = new int[N];
		for(int i=0; i<N; i++) {
			int top = scan.nextInt();
			// 스택 마지막 값보다 들어오는 값이 클 때 
			while(!s.isEmpty() && s.peek() < top) {
				s.pop();  // 현재 값보다 작은 애는 필요 없으므로 뺌
				id.pop();  // 인덱스도 같이 빠짐
			}
			// 스택 마지막 값보다 들어오는 값이 작을 때
			if(!s.isEmpty() && s.peek() > top) {  
				ans[i] = id.peek();  // 현재 가장 큰 값이 있는 인덱스를 넣어줌
			}
			s.push(top);  // 탑 숫자와 인덱스를 함께 가져감
			id.push(i+1);
		}
		
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
