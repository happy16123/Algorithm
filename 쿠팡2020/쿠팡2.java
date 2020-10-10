package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 쿠팡2 {
	
	public static void main(String[] args) {
		String[] s = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
		String[] s1 = {"02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"};
//		solution(3, s);
		System.out.println(solution(2, s1));
	}

	public static int solution(int n, String[] customers) {
		int answer = 0;
		Kiosk[] list = new Kiosk[n];
		for (int i = 0; i < n; i++) {
			list[i] = new Kiosk();
		}

		SimpleDateFormat fmt = new SimpleDateFormat("MM/DD HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		int size = customers.length;
		for (int i = 0; i < size; i++) {
			String cur = customers[i];
			String[] cut = cur.split(" ");
			try {
				boolean use = false;
				Date now = fmt.parse(cut[0] + " " + cut[1]);
				Date min = list[0].endDate;
				int idx = 0;
				for (int j = 1; j < n; j++) {
					if (list[j].endDate.compareTo(min) < 0) {
						min = list[j].endDate;
						idx = j;
					}
				}
				for (int j = 0; j < n; j++) {
					if (list[j].endDate.compareTo(now) <= 0) {
						if(j != idx) {
							break;
						}
						list[j].startDate = now;
						cal.setTime(now);
						cal.add(Calendar.MINUTE, Integer.parseInt(cut[2]));
						list[j].endDate = cal.getTime();
						list[j].count += 1;
						use = true;
						break;
					}
				}
				if(!use) {
					list[idx].startDate = now;
					cal.setTime(now);
					cal.add(Calendar.MINUTE, Integer.parseInt(cut[2]));
					list[idx].endDate = cal.getTime();
					list[idx].count += 1;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<n; i++) {
			answer = Math.max(list[i].count, answer);
		}

		return answer;
	}

	static class Kiosk {
		Date startDate;
		Date endDate;
		int minute;
		int count;

		public Kiosk() {
			try {
				startDate = new SimpleDateFormat("MM/DD HH:mm:ss").parse("01/01 00:00:00");
				endDate = new SimpleDateFormat("MM/DD HH:mm:ss").parse("01/01 00:00:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

}
