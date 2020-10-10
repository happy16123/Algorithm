package test;

public class 쿠팡1 {

	public static void main(String[] args) {
		solution(99);
	}

	public static int[] solution(int N) {
		int max = 0;
		int index = 0;
		for (int i = 2; i <= 9; i++) {
			int cal = N;
			int res = 1;
			while (cal >= i) {
				if (cal % i != 0) {
					res = res * (cal % i);
				}
				cal = cal / i;
			}
			if (cal != 0) {
				res = res * (cal % i);
			}
			if(max <= res) {
				max = res;
				index = i;
			}
		}
		System.out.println(index + " " + max);
		return new int[] {index, max};
	}
}
