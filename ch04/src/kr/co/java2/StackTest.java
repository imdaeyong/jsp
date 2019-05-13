package kr.co.java2;

/*
 * 날짜 2019/05/03
 * 이름 김대용
 * 내용 금요일 자바특강( Stack 메모리 실습하기)
 */

public class StackTest { //스택임. 변수 넣었다 뺴면 보임
	
	public static void main(String[] args) {
		
		int result = 0;
		int begin =1;
		int end = 10;
		
		//StackTest st = new StackTest();// 아니면 이렇게 객체생성하면 가능
		//sum(begin, end); non static을 호출할수 없다. ((오류뜸))
		result = sum(begin, end);
		System.out.println("result ; " + result);
		//위에 debug stacktest -> f6한줄씩 f5함수안으로!! 디버깅 중요☆★☆★☆★☆★☆★		
	}
	
	public static int sum(int start, int end) {
		
		int sum = 0;
		
		for(int k = start; k<=end; k++) {
			sum +=k;
			
		}
		return sum;
				
	}
}
