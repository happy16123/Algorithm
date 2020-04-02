package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9760_Poker_Game {

	public static int[] shape;
	public static int[] number;
	public static final int S = 0, D = 1, H = 2, C = 3, A = 0, T = 9, J = 10, Q = 11, K = 12;
	public static String ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			shape = new int[4];
			number = new int[13];
			ans = "High card";

			for (int i = 0; i < 5; i++) {
				String[] temp = st.nextToken().split("");
				switch (temp[0]) {
				case "S":
					shape[S]++;
					break;
				case "D":
					shape[D]++;
					break;
				case "H":
					shape[H]++;
					break;
				case "C":
					shape[C]++;
					break;
				}
				switch (temp[1]) {
				case "A":
					number[A]++;
					break;
				case "2":
					number[1]++;
					break;
				case "3":
					number[2]++;
					break;
				case "4":
					number[3]++;
					break;
				case "5":
					number[4]++;
					break;
				case "6":
					number[5]++;
					break;
				case "7":
					number[6]++;
					break;
				case "8":
					number[7]++;
					break;
				case "9":
					number[8]++;
					break;
				case "T":
					number[9]++;
					break;
				case "J":
					number[10]++;
					break;
				case "Q":
					number[11]++;
					break;
				case "K":
					number[12]++;
					break;
				}
			}

			Onepair();
			Twopair();
			ThreeofaKind();
			Straight();
			Flush();
			FullHouse();
			FourofaKind();
			StraightFlush();

			System.out.println("#" + t + " " + ans);
		}
	}

	public static void StraightFlush() {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			if (shape[i] == 5) {
				flag = true;
			}
		}
		if (!flag) {
			return;
		}
		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < 13; i++) {
			cnt = 0;
			for (int j = i; j < i + 5; j++) {
				if (j >= 13) {
					temp = j - 13;
				} else {
					temp = j;
				}
				if (number[temp] == 1) {
					cnt++;
				} else {
					break;
				}
				if (cnt == 5) {
					ans = "Straight Flush";
					return;
				}
			}
		}
	}

	public static void FourofaKind() {
		for (int i = 0; i < 13; i++) {
			if (number[i] == 4) {
				ans = "Four of a Kind";
				return;
			}
		}
	}

	public static void FullHouse() {
		int threeCnt = 0;
		int twoCnt = 0;
		for (int i = 0; i < 13; i++) {
			if (number[i] == 3) {
				threeCnt=1;
			}
			if (number[i] == 2) {
				twoCnt=1;
			}
		}
		ans = threeCnt + twoCnt == 2 ? "Full House" : ans;
	}

	public static void Flush() {
		for (int i = 0; i < 4; i++) {
			if (shape[i] == 5) {
				ans = "Flush";
				return;
			}
		}
	}

	public static void Straight() {
		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < 13; i++) {
			cnt = 0;
			for (int j = i; j < i + 5; j++) {
				if (j >= 13) {
					temp = j - 13;
				} else {
					temp = j;
				}
				if (number[temp] == 1) {
					cnt++;
				} else {
					break;
				}
				if (cnt == 5) {
					ans = "Straight";
					return;
				}
			}
		}
	}

	public static void ThreeofaKind() {
		for (int i = 0; i < 13; i++) {
			if (number[i] == 3) {
				ans = "Three of a kind";
				return;
			}
		}
	}

	public static void Twopair() {
		int cnt = 0;
		for (int i = 0; i < 13; i++) {
			if (number[i] == 2) {
				cnt++;
			}
			if (cnt == 2) {
				ans = "Two pair";
				return;
			}
		}
	}

	public static void Onepair() {
		int cnt = 0;
		for (int i = 0; i < 13; i++) {
			if (number[i] == 2) {
				cnt++;
			}
			if (cnt == 1) {
				ans = "One pair";
				return;
			}
		}
	}

}
