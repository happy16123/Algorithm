package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기 {
	
	 public static void main(String[] args) throws Exception {
//		 BufferedInputStream bs = new BufferedInputStream(new FileInputStream(new File("C:\\SSAFY\\01_java\\algorithm\\algor\\resources\\swea\\d3\\1289_원재의메모리복구하기.txt")));
		 System.setIn(new FileInputStream("resources/swea/d3/1289_원재의메모리복구하기.txt"));
		 Scanner scan = new Scanner(System.in);
		 int T = scan.nextInt();
		 
		 for(int test_case = 1; test_case <= T; test_case++) {
			 int cnt = 1;  // 메모리 복구 횟수
			 String data = scan.next();
			 int size = data.length();
			 
			 StringBuilder nData = new StringBuilder(data);
			 // 첫 1의 위치를 찾기
			 int idx = data.indexOf("1");
			 for(int i=idx; i<size;) {
				 change(nData, i, size, " " + (cnt%2));
				 if(data.equals(nData.toString())) {
					 break;
				 }
				 
				 for(int j=i+1; j<size; j++) {
					 if(data.charAt(j) != nData.charAt(j)) {
						 i = j;
						 break;
					 }
				 }
				 cnt++;
			 }
			 System.out.println("#" + test_case + " " + cnt);
		 }
	 }

	private static void change(StringBuilder nData, int start, int end, String fill) {
		for(int i=start; i<end; i++) {
			nData.replace(i, i+1, fill);
		}
	}
	 
	 
}
	