package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {

	public static int N;
	public static int M;
	public static int C;
	public static int[][] map;
	public static ArrayList<Pos> pos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			pos = new ArrayList<Pos>();
			int temp = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();
			
			
			Collections.sort(pos, new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return o2.sum - o1.sum;
				}
			});

			for (int i = 1; i < pos.size(); i++) {
//				System.out.println(pos.get(i));
				// 이미 내림차순으로 정렬되어 있으므로 첫번째 값이 제일 큼
				// 제일 큰 값이 있는 위치에 없는 인덱스를 체크하여 두번째 값을 구해줌
				if(pos.get(0).r == pos.get(i).r && pos.get(0).c + M > pos.get(i).c) {
					continue;
				} else {
					temp = pos.get(i).sum;
					break;
				}
			}

			System.out.println("#" + t + " " + (pos.get(0).sum + temp));
		}
	}

	public static void solve() {
		int[] temp = new int[M];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				for (int k = 0; k < M; k++) {
					temp[k] = map[i][j + k];  // temp 배열에 선택된 곳부터 통 범위 까지 값을 넣음
				}
				temp = check(temp);  
//				System.out.println(Arrays.toString(temp));
				for (int k = 0; k < M; k++) {
					sum += temp[k] * temp[k];  // 배열에 들어있는 값들을 제곱하여 더해줌
				}
				if (!pos.contains(sum)) {  // 최대값이 중복되는 경우 무시
					pos.add(new Pos(i, j, sum));
				}
				sum = 0;
			}
		}
	}

	public static int[] check(int[] data) {
		int sum = 0;
		int[] select;
		for (int i = 0; i < M; i++) {
			sum += data[i];  // 꿀통에 담긴 양을 확인
		}
		if (sum > C) {
			select = subset(data);  // 최대 용량보다 많으면 그 안에서의 최대를 뽑아냄
		} else {
			select = data;
		}
		return select;  // 선택된 통 배열을 리턴
	}

	public static int[] subset(int[] data) {
		int size = 1 << M;
		int[] select = new int[M];
		int[][] subset = new int[size][M];
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int temp = 0;
		int index = 0;
		int[] res = new int[M];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < M; j++) {
				if ((i & 1 << j) != 0) {
					select[j] = 1;
				}
			}
			subset[i] = Arrays.copyOf(select, M);  // 계산을 위해 부분집합을 구함
			Arrays.fill(select, 0);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < M; j++) {
				if (subset[i][j] == 1) {  // 1일 때 선택되었다고 판단하고 선택 된 값들을 더함
					sum += data[j] * data[j];  // temp의 값이 같더라도 각 원소의 제곱의 합은 다를 수 있어 구해줌 
					temp += data[j];  // 최대 용량을 위해 구함
				}
			}
//			System.out.println(sum + " " + max);
			if (sum > max && temp <= C) {  // 최대 용량보다 작거나 같아야 하며 최대 값을 찾았을 때
				index = i;  // 그 때의 부분집합의 위치를 구함
				max = sum;  // 제곱의 최대값
			}
			sum = 0;
			temp = 0;
		}
		for (int i = 0; i < M; i++) {
			if (subset[index][i] == 1) { 
				res[i] = data[i];  // 최대 값을 찾은 부분집합의 위치를 활용해 데이터를 담음
			}
		}
		return res;
	}
}

class Pos{
	int r;
	int c;
	int sum;
	Pos(int r, int c, int sum){
		this.r = r;
		this.c = c;
		this.sum = sum;
	}
}
