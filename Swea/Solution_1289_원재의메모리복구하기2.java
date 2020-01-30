package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기2 {
	
	 public static void main(String[] args) throws Exception {
//		 BufferedInputStream bs = new BufferedInputStream(new FileInputStream(new File("C:\\SSAFY\\01_java\\algorithm\\algor\\resources\\swea\\d3\\1289_원재의메모리복구하기.txt")));
		 System.setIn(new FileInputStream("resources/swea/d3/1289_원재의메모리복구하기.txt"));
		 Scanner scan = new Scanner(System.in);
		 int T = scan.nextInt();
		 
		 for(int test_case = 1; test_case <= T; test_case++) {
			 System.out.println(test_case);
			 int cnt = 0;  // 메모리 복구 횟수
			 String data = scan.next();
			 int size = data.length();
			 
			if(data.startsWith("1")) {
				cnt++;
			}
			
			for(int i=0; i<size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) {
					cnt++;
				}
			}
			 
			 System.out.println("#" + test_case + " " + cnt);
		 }
	 }
}
	