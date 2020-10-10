package test;

import java.util.ArrayList;
import java.util.HashMap;

public class 쿠팡4 {
	static HashMap<String, ArrayList<String>> adj = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		String[][] s = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" }, { "SEOUL", "DAEJEON" },
				{ "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" }, { "DAEGU", "GWANGJU" },
				{ "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" }, { "BUSAN", "YEOSU" } };
		sol("SEOUL", "DAEGU", "YEOSU", s);
	}

	public static int sol(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		int len = roads.length;
		ArrayList<String> temp = null;
		for (int i = 0; i < len; i++) {
			if (adj.get(roads[i][0]) == null) {
				adj.put(roads[i][0], new ArrayList<String>());
				temp = adj.get(roads[i][0]);
				temp.add(roads[i][1]);
				adj.put(roads[i][0], temp);
			} else {
				temp = adj.get(roads[i][0]);
				temp.add(roads[i][1]);
				adj.put(roads[i][0], temp);
			}
		}

		answer = (path(depar, hub) * path(hub, dest)) % 10007;
		System.out.println(answer);
		return answer;
	}

	public static int path(String from, String to) {
		ArrayList<String> cur = adj.get(from);
		int res = 0;
		if (cur != null) {
			for (int i = 0; i < cur.size(); i++) {
				if (cur.get(i).equals(to)) {
					res += 1;
				} else {
					res += path(cur.get(i), to);
				}
			}
		}
		return res;
	}
}
