package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬_들여쓰기 {

	public static int p;
	public static int q;
	public static int[] ans;
	public static ArrayList<String> pList;
	public static ArrayList<String> qList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			ans = new int[q];
			pList = new ArrayList<String>(p);
			qList = new ArrayList<String>(q);

			for (int i = 0; i < p; i++) {
				pList.add(br.readLine());
			}

			for (int i = 0; i < q; i++) {
				qList.add(br.readLine());
			}

//			pList.forEach(el -> System.out.println(el));
//			qList.forEach(el -> System.out.println(el));

			Arrays.fill(ans, -2);
			for (int r = 1; r < 21; r++) {
				for (int c = 1; c < 21; c++) {
					for (int s = 1; s < 21; s++) {
						if(check(r, c, s)) {
							System.out.println(r + " " + c + " " + s);
							intent(r, c, s);
						}
					}
				}
			}

			System.out.print("#" + t);
			for (int i = 0; i < q; i++) {
				System.out.print(" " + ans[i]);
			}
			System.out.println();
		}
	}

	public static void intent(int r, int c, int s) {
		int rL = 0;
		int rR = 0;
		int cL = 0;
		int cR = 0;
		int sL = 0;
		int sR = 0;
		String temp;
		for (int i = 0; i < q; i++) {
			if(ans[i] == -2) {
				ans[i] = (r * (rL - rR)) + (c * (cL - cR)) + (s * (sL - sR));
			} else {
				if(ans[i] != (r * (rL - rR)) + (c * (cL - cR)) + (s * (sL - sR))){
					ans[i] = -1;
				}
			}
			temp = qList.get(i);
			for(int j=0; j<temp.length(); j++) {
				switch(temp.charAt(j)) {
				case '(' : rL++; break;
				case ')' : rR++; break;
				case '{' : cL++; break;
				case '}' : cR++; break;
				case '[' : sL++; break;
				case ']' : sR++; break;
				}
			}
		}
	}

	public static boolean check(int r, int c, int s) {
		int rL = 0;
		int rR = 0;
		int cL = 0;
		int cR = 0;
		int sL = 0;
		int sR = 0;
		String temp;
		for (int i = 0; i < p; i++) {
			temp = pList.get(i);
			int cnt = 0;
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j) == '.') {
					cnt++;
				} else {
					break;
				}
			}
			
			if(cnt != (r * (rL - rR)) + (c * (cL - cR)) + (s * (sL - sR))){
				return false;
			}
			
			for(int j=0; j<temp.length(); j++) {
				switch(temp.charAt(j)) {
				case '(' : rL++; break;
				case ')' : rR++; break;
				case '{' : cL++; break;
				case '}' : cR++; break;
				case '[' : sL++; break;
				case ']' : sR++; break;
				}
			}
		}
		
		return true;
	}
}
