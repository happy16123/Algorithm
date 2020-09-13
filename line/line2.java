package line;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class line2 {

	public static void main(String[] args) {
		int[] ball = { 1, 2, 3, 4, 5, 6 };
		int[] order = { 6, 2, 5, 1, 4, 3 };
		
		solution(ball, order);

	}

	public static int[] solution(int[] ball, int[] order) {
		int[] answer = {};

		Deque<Integer> dq = new ArrayDeque<Integer>();
		List<Integer> command = new ArrayList<Integer>();
		int ballSize = ball.length;
		int orderSize = order.length;
		answer = new int[ballSize];
		int index = 0;
		for (int i = 0; i < ballSize; i++) {
			dq.offer(ball[i]);
		}

		for (int i = 0; i < orderSize; i++) {
			int cur = order[i];
			int first = dq.peekFirst();
			int last = dq.peekLast();
			for (int j = 0; j < command.size(); j++) {
				if (command.contains(first)) {
					answer[index++] = dq.removeFirst();

				} else if (command.contains(last)) {
					answer[index++] = dq.removeLast();
				}
			}
			if (cur == first) {
				answer[index++] = dq.removeFirst();
			} else if (cur == last) {
				answer[index++] = dq.removeLast();
			} else {
				command.add(cur);
			}
		}
		
		System.out.println(Arrays.toString(answer));

		return answer;
	}
}
