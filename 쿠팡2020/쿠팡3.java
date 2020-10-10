package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 쿠팡3 {

	public static void main(String[] args) {
		int[] s = { 24, 22, 20, 10, 5, 3, 2, 1 };
		int[] s1 = { 1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100 };
		sol(3, s);
		sol(2, s1);
	}

	public static int sol(int k, int[] score) {
		int size = score.length;
		int[] sub = new int[size];
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		boolean[] ans = new boolean[size];
		List<Integer> check = new ArrayList<Integer>();
		sub[0] = -1;

		for (int i = 0; i < size - 1; i++) {
			sub[i + 1] = score[i] - score[i + 1];
			int res = sub[i + 1];
			if(memo.get(res) == null) {
				memo.put(res, 1);
			} else {
				memo.put(res, memo.get(res) + 1);
			}
			if (memo.get(res) >= k && !check.contains(memo.get(res))) {
				check.add(res);
			}
		}

		for(int j=0; j<check.size(); j++) {
			int cur = check.get(j);
			for (int i = 1; i < size; i++) {
				if(sub[i] == cur) {
					ans[i - 1] = true;
					ans[i] = true;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<size; i++) {
			if(!ans[i]) {
				answer +=1;
			}
		}
		
		System.out.println(answer);
		return answer;
	}
}
