package swea.d4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution_1233_사칙연산유효성검사{
	public static int N;
	public static String[] data;
	public static String[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/lecture/1233.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			data = new String[N+1];
		for(int i=1; i<=N; i++) {
			data[i] = br.readLine().split(" ")[1]; 
		}
//		inorder(1);
//		System.out.println(Arrays.toString(tree));
		
		int flag = 1;
		for(int i=1; i<=N/2; i++) {
			String a = data[i];
			if(a.equals("-") || a.equals("*") || a.equals("/") || a.equals("+")) {
				continue;
			} else {
				flag = 0;
			}
		}
		System.out.println("#"+ (t+1) + " " + flag);
		}
	}
	
	public static void inorder(int index) {
		if (index <= N && data[index] != null) {
			inorder(index << 1);
			tree[index] = data[index];
			inorder((index << 1) + 1);
		}
	}
}
