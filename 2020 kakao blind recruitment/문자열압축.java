package temp;

public class 문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

	public static int solution(String s) {
		if (s.length() == 1)
			return 1;

		int answer = 1001;
		for (int i = 1; i <= s.length() / 2; i++) {
			String prev, cur = "", result = "";
			int hit = 1;
			for (int j = 0; j < s.length(); j += i) {
				int end = j + i > s.length() ? s.length() : j + i;
				prev = cur;
				cur = s.substring(j, end);

				if (prev.equals(cur)) {
					hit++;
				} else {
					result += (processHit(hit) + prev);
					hit = 1;
				}
			}
			result += (processHit(hit) + cur);
			answer = Math.min(answer, result.length());
		}

		return answer;
	}

	private static String processHit(int hit) {
		return hit > 1 ? String.valueOf(hit) : "";
	}
}
