package line;

import java.util.Arrays;

public class line1 {

	public static void main(String[] args) {
		int[][] box = { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
//		int[][] box = {{1,2},{3,4},{5,6}};
//		int[][] box = {{1,2},{2,3},{3,1},{3,4}};

		solution(box);
	}

	public static int solution(int[][] boxes) {
		int answer = 0;
		int size = boxes.length;
		int[] data = new int[1000001];

		int even = 0;
		int odd = 0;
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 2; j++) {
				data[boxes[i][j]] += 1;
			}
		}

		int dataSize = data.length;
		for (int i = 0; i < dataSize; i++) {
			if (data[i] != 0) {
				if (data[i] % 2 == 0) {
					even += data[i] / 2;
				} else {
					if (data[i] == 1) {
						odd += 1;
					} else {
						even += data[i] / 2;
						odd += 1;
					}
				}
			}
		}
		if(size - even == 0) {
			return 0;
		}
		while(size != even) {
			answer += 1;
			even += 1;
			odd -= 1;
		}
		return answer;
	}
}
