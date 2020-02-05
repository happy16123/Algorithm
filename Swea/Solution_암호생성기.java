package swea.d3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Solution_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("res/lecture/암호생성기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = "";
		int testcase;
		ArrayDeque<Integer> q;
		while((t = br.readLine()) != null) {
			testcase = Integer.parseInt(t);
			q = new ArrayDeque<>();
			String[] data = new String[8];
			data = br.readLine().split(" ");
			
			for(int i=0; i<data.length; i++) {
				q.offer(Integer.parseInt(data[i]));
			}
			
			int temp = 0;
			int cnt = 1;
			while(true) {
				temp = q.poll() - cnt;
				cnt++;
				if(cnt == 6) {
					cnt = 1;
				}
				if(temp <= 0) {
					q.offer(0);
					break;
				} else {
					q.offer(temp);
				}
			}
			System.out.print("#" + testcase + " ");
			q.stream().forEach(el -> System.out.print(el + " "));
			System.out.println();
		}
	}
}
