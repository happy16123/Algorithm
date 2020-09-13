package line;

import java.util.ArrayList;
import java.util.List;

public class no5 {

	public static List<Integer> player = new ArrayList<Integer>();
	public static List<Integer> dealer = new ArrayList<Integer>();
	public static List<Integer> dealerHidden = new ArrayList<Integer>();
	public static int WIN = 1;
	public static int LOSE = -1;
	public static int DRAW = 1;
	public static int res = 0;
	public static int index = 0;

	public static void main(String[] args) {
		int[] card = { 12, 7, 11, 6, 2, 12 };
	}

	public static int solution(int[] cards) {
		int answer = 0;
		int size = cards.length;

		for (int i = 0; i < size; i++) {
			if (cards[i] >= 11) {
				cards[i] = 10;
			}
		}

		while (index < size) {
			if (!start(cards)) {
				index += 4;
				player.clear();
				dealer.clear();
				dealerHidden.clear();
				continue;
			} else {

			}
		}

		return answer;
	}

	public static boolean start(int[] cards) {
		player.add(cards[index]);
		dealerHidden.add(cards[index + 1]);
		player.add(cards[index + 2]);
		dealer.add(cards[index + 3]);

		int p1 = playerSum(true);
		int p2 = playerSum(false);
		int deal = dealerSum();

		if (p1 == 21 || p2 == 21) {
			if (deal != 21) {
				res += 3;
				return false;
			}
		} else if (p1 > 21 || p2 > 21) {
			res -= 2;
			return false;
		}
		return true;
	}

	public static int playerSum(boolean change) {
		int sum = 0;
		for (int i = 0; i < player.size(); i++) {
			if (change && player.get(i) == 1) {
				sum += 11;
				change = false;
			} else {
				sum += player.get(i);
			}
		}
		return sum;
	}

	public static int dealerSum() {
		int sum = 0;
		for (int i = 0; i < dealer.size(); i++) {
			sum += dealer.get(i);
		}

		for (int i = 0; i < dealerHidden.size(); i++) {
			sum += dealerHidden.get(i);
		}
		return sum;
	}

	public static int check(int p, int d) {
		if (p > d) {
			return WIN;
		} else if (p == d) {
			return DRAW;
		} else {
			return LOSE;
		}
	}
}
