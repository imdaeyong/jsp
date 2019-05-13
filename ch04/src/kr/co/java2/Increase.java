package kr.co.java2;

public class Increase {

	int num1 =0 ; //=0 안붙여도 자동으로 0으로 초기화댄ㄷ[
	static int num2 = 0;

	public Increase() {
		
		num1++;
		num2++;
		
		System.out.println("num1 :" +num1);
		System.out.println("num2 :" +num2);
	}
	
	public static void add() {
		num2++;
	}
	
}
