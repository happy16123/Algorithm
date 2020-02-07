package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100;
		int T = 10;
		int[] data;
		int dump;
		String[] temp;
		int max;
		int min;
		int maxIdx;
		int minIdx;
		for (int t = 1; t <= 10; t++) {
			max = 1;
			min = 100;
			maxIdx = 0;
			minIdx = 0;
			dump = Integer.parseInt(br.readLine());
			data = new int[N];
			temp = br.readLine().split(" ");
			int num;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(temp[i]);
				data[i] = num;
				if (num >= max) {
					max = num;
					maxIdx = i;
				}
				if (num <= min) {
					min = num;
					minIdx = i;
				}
			}
			for (int i = 0; i < dump; i++) {
				data[maxIdx]--;
				data[minIdx]++;
				max--;
				min++;
				
				for (int j = 0; j < N; j++) {
					num = data[j];
					if (num >= max) {
						max = num;
						maxIdx = j;
					} 
					if (num <= min) {
						min = num;
						minIdx = j;
					}
				}
			}
			System.out.println("#" + t + " " + (max - min));
		}
	}

}
