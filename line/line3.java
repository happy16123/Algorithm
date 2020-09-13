package line;

public class line3 {

	public static void main(String[] args) {
		solution(73425);
		solution(10007);
//		solution(9);
	}

	public static int[] solution(int n) {
		int[] answer = new int[2];
		String data = n + "";
		int res = 100;

		String n1 = "";
		String n2 = "";

		if (n < 10) {
			answer[0] = 0;
			answer[1] = n;
			return answer;
		}

		int cnt = 0;

		while (res > 9) {
			int mid = data.length() / 2;
			n1 = data.substring(0, mid);
			n2 = data.substring(mid, data.length());

			for (int i = 0; i < n2.length(); i++) {
				if (n2.charAt(i) == '0') {
					n1 += 0;
				} else {
					n2 = n2.substring(i, n2.length());
					break;
				}
			}

			res = Integer.parseInt(n1) + Integer.parseInt(n2);
			data = res + "";
			cnt++;
		}
		answer[0] = cnt;
		answer[1] = res;

		return answer;
	}
}
