package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_8931_제로 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int data, sum;
		Stack<Integer> s;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			sum = 0;
			s = new Stack<>();
			for(int i=0; i<N; i++) {
				data = Integer.parseInt(br.readLine());
				if(data != 0) {
					s.push(data);
				} else {
					s.pop();
				}
			}
			
			for(int i=0; i<s.size(); i++) {
				sum += s.get(i);
			}
			
			System.out.println("#"+ t + " " + sum);
		}
	}
}
