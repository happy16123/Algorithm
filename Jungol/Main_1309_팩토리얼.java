package jungol.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309_팩토리얼 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long data = Long.parseLong(br.readLine());
		System.out.println(fac(data));
	}
	
	public static long fac(long num) {
		if(num == 0 || num == 1) {
			System.out.println(num + "! = " + num);
			return 1;
		}
		System.out.println(num + "! = " + num + " * " + (num-1) + "!");
		return num * fac(num-1);
	}
}
