package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1904_01타일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];
		d[1] = 1;
		d[2] = 2;
		
		for(int i=3; i<=N; i++) {
			d[i] = (d[i-1] + d[i-2]) % 15746;
		}
		
		System.out.println(d[N]);
	}
	
}
