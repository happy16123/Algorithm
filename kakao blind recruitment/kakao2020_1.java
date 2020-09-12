package coding;

public class no1 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y...abcdefghijklm";
		new_id = step1(new_id);
		new_id = step2(new_id);
		new_id = step3(new_id);
		new_id = step4(new_id);
		new_id = step5(new_id);
		new_id = step6(new_id);
		new_id = step7(new_id);
		System.out.println(new_id);
	}

	public static String solution(String new_id) {
		String answer = "";
		return answer;
	}

	public static String step1(String id) {
		return id.toLowerCase();
	}

	public static String step2(String id) {
		return id.replaceAll("[^a-z0-9\\.\\-\\_]", "");
	}

	public static String step3(String id) {
		return id.replaceAll("\\.{2,}", ".");
	}

	public static String step4(String id) {
		String res = id.replaceAll("^\\.+", "");
		res = res.replaceAll("\\.+$", "");
		return res;
	}

	public static String step5(String id) {
		if (id.equals("")) {
			return "a";
		}
		return id;
	}

	public static String step6(String id) {
		String res = id.toString();
		if (res.length() >= 16) {
			res = id.substring(0, 15);
			res = res.replaceAll("\\.+$", "");
		}
		return res;
	}

	public static String step7(String id) {
		String res = id.toString();
		char ch = res.charAt(res.length() - 1);
		while (res.length() <= 2) {
			res += ch + "";
		}
		return res;
	}
}
