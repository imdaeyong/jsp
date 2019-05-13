package kr.co.java3;
/*
 * 날짜 2019 05 03
 * 이름 김대용
 * 내용 String 실습
 * ppt : 0503스택 힙 메소드아레아ㅗ
 */
public class StringTest {
	
	public static void main(String[] args) {
		
			char c = 'H';
			char[] cArr = {'H','e','l','l','o'};
			
			//문자열(문자+배열)
			String str1 = "Hello"; // char이나 string이나 힙에 배열로 저장되는거 똑같아
			String str2 = new String("Hello");
			String str3 = new String("Hello");
			String str4 = "Hello";
			 
			if(str1 == str2 ) { //이건 참조값을 비교하는거기때문에 이렇게 비교.( 주소값 비교)ㄴ
				System.out.println("str1 과 str2의 주소값(참조값)이 같다");
			}else {
				System.out.println("str1 과 str2의 주소값(참조값)이 다르");
			}
			
			if(str1 == str4 ) { //이건 참조값을 비교하는거기때문에 이렇게 비교.( 주소값 비교)ㄴ
				System.out.println("str1 과 str4의 주소값(참조값)이 같다");
			}else {
				System.out.println("str1 과 str4의 주소값(참조값)이 다르");
			}
			
			if(str1.equals(str2)) {
				System.out.println("str1 과 str2의 문자열이 같다");
			}else {
				System.out.println("str1 과 str2의 문자열이 다르다");
				
			}
			
			
			
			
			//문자열 멤버 메서드
			System.out.println("str 문자열 길이 : " + str1.length());
			
			char c1 = str1.charAt(0); //문자 하나 추출
			char c2 = str1.charAt(2); //문자 하나 추출
			char c3 = str1.charAt(3); //문자 하나 추출
			
			System.out.println("c1 : " +c1);
			System.out.println("c2 : " +c2);
			System.out.println("c3 : " +c3);
					
			String v1 = "Hello Korea";
			String v2 = v1.substring(6);
			String v3 = v1.substring(6,9);
			System.out.println("v2 : " + v2);
			System.out.println("v3 : " + v3);
			
			int v4 = v1.indexOf("e");
			int v5 = v1.lastIndexOf("e");
			System.out.println("v4 : " + v4);
			System.out.println("v5 : " + v5);
			
			String v6 = v1.replace("Korea","Busan");
			System.out.println("v6 : " + v6);
			
			
	}
	
}
