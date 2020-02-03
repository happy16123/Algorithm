package jungol.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1328_빌딩 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int data;
		Stack<Integer> building = new Stack<>();
		Stack<Integer> index = new Stack<>();
		int[] ans = new int[N];
		
		for(int i=0; i<N; i++) {
			data = Integer.parseInt(br.readLine().trim());
			
			while(!building.isEmpty() && building.peek() < data) {
				building.pop();
				ans[index.pop()-1] = i+1;
			}
			
			building.push(data);
			index.push(i+1);
		}
		
//		Arrays.stream(ans).forEach(el -> System.out.println(el));
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
