package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_5948_새샘이의735게임 {
	
	public static int[] data;
	public static int[] index;
	public static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=T; t++) {
			data = new int[7];
			index = new int[3];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<7; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0);
			
			Collections.sort(ans, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			int max = ans.get(0);
			int fifth = 1;
			for(int i=0; i<ans.size(); i++) {
				if(max > ans.get(i)) {
					max = ans.get(i);
					fifth++;
					if(fifth == 5) {
						System.out.println("#" + t + " " + ans.get(i));
						break;
					}
				}
			}
		}
	}
	
	public static void combi(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += data[index[i]];
			}
			ans.add(sum);
			return;
		}
		for(int i=start; i<7; i++) {
			index[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
}
