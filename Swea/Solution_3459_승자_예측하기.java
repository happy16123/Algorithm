package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_3459_승자_예측하기 {
	
	public static long target;
	public static String ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			long temp = 1;
			long sum = 1;
			boolean check = false;
			target = Long.parseLong(br.readLine());

			while(sum < target) {
				if(!check) {
					temp *= 4;
				}
				sum += temp;
				check = !check;
			}
			ans = check ? "Alice" : "Bob";
			System.out.println("#" + t + " " + ans);
		}
	}
	
	
}
