package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_4366_정식이의_은행업무 {

	public static ArrayList<Integer> list;
	public static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			list = new ArrayList<Integer>();
			StringBuilder bin = new StringBuilder();
			StringBuilder ter = new StringBuilder();
			bin.append(br.readLine());
			ter.append(br.readLine());
			String initB = bin.toString();
			String initT = ter.toString();
			ans = 0;

			for (int i = 0; i < bin.length(); i++) {
				if (bin.charAt(i) == '0') {
					bin.setCharAt(i, '1');
				} else if (bin.charAt(i) == '1') {
					bin.setCharAt(i, '0');
				}
				list.add(Integer.parseInt(bin.toString(), 2));
				bin.replace(0, bin.length(), initB);
			}

			for (int i = 0; i < ter.length(); i++) {
				if (ter.charAt(i) == '0') {
					ter.setCharAt(i, '1');
					if (check(ter.toString())) {
						break;
					}
					ter.setCharAt(i, '2');
					if (check(ter.toString())) {
						break;
					}
				} else if (ter.charAt(i) == '1') {
					ter.setCharAt(i, '0');
					if (check(ter.toString())) {
						break;
					}
					ter.setCharAt(i, '2');
					if (check(ter.toString())) {
						break;
					}
				} else if (ter.charAt(i) == '2') {
					ter.setCharAt(i, '1');
					if (check(ter.toString())) {
						break;
					}
					ter.setCharAt(i, '0');
					if (check(ter.toString())) {
						break;
					}
				}
				ter.replace(0, ter.length(), initT);
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean check(String data) {
		int target = Integer.parseInt(data, 3);
		if (list.contains(target)) {
			ans = target;
			return true;
		}
		return false;
	}
}
