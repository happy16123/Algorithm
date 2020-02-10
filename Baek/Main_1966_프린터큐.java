package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_1966_프린터큐 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new FileReader("res/back/print.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> list = new LinkedList<Integer>();
		Queue<Integer> index = new LinkedList<Integer>();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int max = 0;
			int cnt = 0; 
			String[] data = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				int temp = Integer.parseInt(data[i]);
				if(max <= temp) {
					max = temp;
				}
				list.offer(temp);
				index.offer(i);
			}

			while(!list.isEmpty()) {
				if(list.peek() == max) {
					cnt++;
					if(index.peek() == idx) {
						System.out.println(cnt);
					}
					list.poll();
					index.poll();
					max = list.stream().max(Integer::compare).orElse(-1);
				} else {
					list.offer(list.poll());
					index.offer(index.poll());
				}
			}
			list.clear();
			index.clear();
		}
	}
}