package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5658_보물상자_비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cut = N / 4;
			char[] data = new char[N + cut - 1];
			ArrayList<String> list = new ArrayList<String>();
			String sec = br.readLine();
			for (int i = 0; i < N; i++) {
				data[i] = sec.charAt(i);
			}

			int temp = 0;
			for (int i = N; i < N + cut - 1; i++) {
				data[i] = data[temp++];
			}

			for (int i = 0; i < cut; i++) {
				temp = 0;
				String str = "";
				for (int j = i; j < N + i; j++) {
					temp++;
					str += data[j];
					if (temp == cut) {
						if (!list.contains(str)) {
							list.add(str);
						}
						temp = 0;
						str = "";
					}
				}
			}
			int ans[] = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				ans[i] = Integer.parseInt(list.get(i), 16);
			}

			Arrays.sort(ans);
			System.out.println(ans.length);

			sb.append("#" + t + " " + ans[ans.length - K] + "\n");
		}
		System.out.println(sb.toString());
	}
}
