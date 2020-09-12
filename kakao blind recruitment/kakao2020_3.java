package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no3 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info, query);
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = {};
		List<Info> data = new ArrayList<>();
		List<Info> qu = new ArrayList<>();
		int infoSize = info.length;
		int querySize = query.length;
		String[] cur = {};
		for(int i=0; i<infoSize; i++) {
			cur = info[i].split(" ");
			data.add(new Info(cur[0], cur[1], cur[2], cur[3], Integer.parseInt(cur[4])));
		}
		
		String[] detail = {};
		for(int i=0; i<querySize; i++) {
			cur = query[i].split(" and ");
			detail = cur[3].split(" ");
			qu.add(new Info(cur[0], cur[1], cur[2], detail[0], Integer.parseInt(detail[1])));
		}

		List<Integer> ans = new ArrayList<>();
		for(int i=0; i<qu.size(); i++) {
			Info command = qu.get(i);
//			long cnt = data.stream().filter(el -> el.lang.equals(command.lang) || command.lang.equals("-"))
//				.filter(el -> el.pos.equals(command.pos) || command.pos.equals("-"))
//				.filter(el -> el.career.equals(command.career) || command.career.equals("-"))
//				.filter(el -> el.food.equals(command.food) || command.food.equals("-"))
//				.filter(el -> el.score >= command.score).count();
			long cnt = data.parallelStream().filter(el -> (el.lang.equals(command.lang) || command.lang.equals("-")) && (el.pos.equals(command.pos) || command.pos.equals("-"))
					&& (el.career.equals(command.career) || command.career.equals("-")) && (el.food.equals(command.food) || command.food.equals("-")) && (el.score >= command.score)).count();
			ans.add((int)cnt);
		}
		
		answer = new int[ans.size()];
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}

	static class Info {
		String lang;
		String pos;
		String career;
		String food;
		int score;

		public Info(String lang, String pos, String career, String food, int score) {
			this.lang = lang;
			this.pos = pos;
			this.career = career;
			this.food = food;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Info [lang=" + lang + ", pos=" + pos + ", career=" + career + ", food=" + food + ", score=" + score
					+ "]";
		}
	}
}
