package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution_7701_염라대왕의_이름정렬 {

	public static Set<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			list = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}
			});
			
			for (int i = 0; i < N; i++) {
				list.add(br.readLine());
			}
			
			System.out.println("#" + t);
			Iterator<String> iter = list.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
		}
	}
}
