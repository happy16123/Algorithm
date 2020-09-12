package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class no2 {

	public static int[] res;
	public static Map<String, Integer> map;

	public static void main(String[] args) {
//		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3,4 };
		for(int i=0; i<orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			orders[i] = String.valueOf(ch);
		}
		solution(orders, course);
	}

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			for (int j = 0; j < orders.length; j++) {
				combi(0, 0, course[i], "", orders[j]);
			}

			List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return Integer.compare(o2.getValue(), o1.getValue());
				}
			});
			
			if(list.size() == 0) {
				continue;
			}
			int max = list.get(0).getValue();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getValue() < max) {
					break;
				} else {
					if (list.get(j).getValue() > 1) {
						ans.add(list.get(j).getKey());
					}
				}
			}
		}
		
		Collections.sort(ans);
		answer = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		
		return answer;
	}

	public static void combi(int cnt, int index, int course, String res, String data) {
		if (course == cnt) {
			boolean[] check = new boolean[26];
			for (int i = 0; i < data.length(); i++) {
				check[data.charAt(i) - 'A'] = true;
			}
			for (int i = 0; i < res.length(); i++) {
				if (!check[res.charAt(i) - 'A']) {
					return;
				}
			}
			if (map.get(res) == null) {
				map.put(res, 1);
			} else {
				map.put(res, map.get(res) + 1);
			}
		}

		for (int i = index; i < data.length(); i++) {
			combi(cnt + 1, i + 1, course, res + data.charAt(i), data);
		}
	}
}
