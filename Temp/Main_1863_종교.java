package jungol.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<M; i++) {
			data.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			data.get(v1).add(v2);
			data.get(v2).add(v1);
		}
		
		for(int i=0;i<N;i++) {
            Iterator<Integer> iter = data.get(i).iterator();
            System.out.print(i);
            if(iter.hasNext()) System.out.print("-");
            while(iter.hasNext()) System.out.print(iter.next() + " ");
            System.out.println("");
        }

	}
}
