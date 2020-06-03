package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1965_상자넣기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lis = new int[N];
		int maxIndex = 0;
		for(int i=0; i<N; i++) {
			lis[i] = 1;
			for(int j=0; j<i; j++) {
				if(data[j] < data[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
			if(lis[maxIndex] < lis[i]) {
				maxIndex = i;
			}
		}
		
		System.out.println(lis[maxIndex]);
		/*int size = 0;
		for(int i=0; i<N; i++) {
			int temp = Arrays.binarySearch(lis, 0, size, data[i]);
			lis[-temp - 1] = data[i];
			if(-temp -1 == size) {
				size++;
			}
		}
		
		System.out.println(size);*/
	}
}
