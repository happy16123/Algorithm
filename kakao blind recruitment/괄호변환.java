package temp;

public class 괄호변환 {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
		String answer = "";
		if(p.equals("")) {
			return answer;
		}
		for (int i = 0; i < p.length(); i++) {
			answer = "";
			String u = p.substring(0, i * 2);
			String v = p.substring(i * 2, p.length());
			if(checkBalance(u)) {
				if(checkCorrect(u)) {
					answer = u + solution(v);
					return answer;
				} else {
					answer += "(";
					answer += solution(v);
					answer += ")";
					answer += change(u);
					return answer;
				}
			}
		}
		return answer;
	}

	public static boolean checkBalance(String p) {
		if(p.equals("")) {
			return false;
		}
		int cnt = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}
		}
		return cnt == 0 ? true : false;
	}

	public static boolean checkCorrect(String p) {
		if(p.equals("")) {
			return false;
		}
		int cnt = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}
			if (cnt < 0) {
				break;
			}
		}
		return cnt == 0 ? true : false;
	}

	public static String change(String p) {
		String res = "";
		p = p.substring(1, p.length() - 1);
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(') {
				res += ")";
			} else {
				res += "(";
			}
		}
		
		return res;
	}
}
