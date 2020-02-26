package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2740_행렬곱셈 {

	public static int[][] A;
	public static int[][] B;
	public static int[][] ans;
	public static int aR;
	public static int aC;
	public static int bR;
	public static int bC;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		aR = Integer.parseInt(st.nextToken());
		aC = Integer.parseInt(st.nextToken());
		A = new int[aR][aC];
		
		for(int i=0; i<aR; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<aC; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		bR = Integer.parseInt(st.nextToken());
		bC = Integer.parseInt(st.nextToken());
		B = new int[bR][bC];
		
		for(int i=0; i<bR; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<bC; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = new int[aR][bC];
		matrix();
		
		for(int i=0; i<aR; i++) {
			for(int j=0; j<bC; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void matrix() {
		for(int i=0; i<aR; i++) {
			for(int j=0; j<bC; j++) {
				for(int k=0; k<aC; k++) {
					ans[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
}
