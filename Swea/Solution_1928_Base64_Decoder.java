package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1928_Base64_Decoder {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] data = new int[64];
		int N = Integer.parseInt(br.readLine());
		char ch = 'A';
		for(int i=0; i<26; i++) {
			data[i] = ch++;
		}
		ch = 'a';
		for(int i=26; i<52; i++) {
			data[i] = ch++;
		}
		ch = '0';
		for(int i=52; i<62; i++) {
			data[i] = ch++;
		}
		data[62] = '+';
		data[63] = '/';
		
		
		for(int t=0; t<N; t++) {
			String[] s = br.readLine().split("");
			String str = "";
			char temp;
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<s.length; j++) {
				temp = s[j].charAt(0);
				cnt++;
				for(int i=0; i<64; i++) {
					if(data[i] == temp) {
						str += String.format("%6s", Integer.toBinaryString(i)).replace(' ', '0');
					}
				}
				if(cnt == 4) {
					for(int i=0; i<3; i++) {
						int e = Integer.parseInt(str.substring(8 * i, 8 * (i + 1)), 2);
						sb.append((char)e);
					}
					cnt = 0;
					str = "";
				}
			}
			System.out.println("#" + (t+1) + " " + sb);
		}
	}
}
