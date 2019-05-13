package kr.co.java2;
/*
 * 날짜 2019 05 03
 * 이름 김대용
 * 내용 Method Area 메모리 실습
 */
public class MethodAreaTest {
	
	public static void main(String[] args) {
		
		Increase ic1 = new Increase();
		Increase ic2 = new Increase();
		Increase ic3 = new Increase();
		
		ic1.num1 = 2;
			
		//클래스 변수
		Increase.num2 = 2; //마찬가지로 객체 생성안하고 이름으로.
		
		
		//클래스메서드
		Increase.add(); // 객체생성안해도됨 , incraese에 스태틱을 붙여놨기때문
		sum();
				
}
	
	public static void sum() {
		
	}
}
