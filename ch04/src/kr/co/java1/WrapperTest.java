package kr.co.java1;

/*
 * 날짜 : 2019/05/02
 * 이름 : 김대용
 * 내용 : wrapper 클래스 실습하기
 */
public class WrapperTest {
	public static void main(String[] args) {
		
		//기본타입 변수
		boolean var1 = true;
		int 			 var2 = 10 ; //2147483647; //까지 저장
		long 		 var3 = 1000L;
		char	     var4 = 'A';
		double 	 var5 = 1.2345;

		//기본타입 ->String
		String s1 = String.valueOf(var1);
		String s2 = String.valueOf(var2);
		String s3 = String.valueOf(var3);
		String s4 = "" + var4;
		String s5 = "" + var5;
		
		System.out.println("s1 : " +s1);
		System.out.println("s2 : " +s2);
		System.out.println("s3 : " +s3);
		System.out.println("s4 : " +s4);
		System.out.println("s5 : " +s5);
		System.out.println();
		
			
		//Wrapper 클래스
		//기본데이터를 객체로 변환해서 저장! 나중에 자료구조에서 중요
		Boolean wp1 = new Boolean(var1);
		Integer  wp2 = new Integer(10);
		Long		wp3= new Long(1000);
	    Double   	wp4 = new Double(1.2345);
		
	    //Wrapper ->String
		String st1 = wp1.toString();
		String st2 = wp2.toString();
		String st3 = wp3.toString();
		String st4 = wp4.toString();
		
		System.out.println("st1 :" + st1);
		System.out.println("st2 :" + st2);
		System.out.println("st3 :" + st3);
		System.out.println("st4 :" + st4);
		System.out.println();
		
	    
	    
	    
	    //Wrapper 활용 I (String을 기본타입으로)
		String str1 = "false";
		String str2 = "100";
		String str3 = "1.234567";
		String str4 = new String("hello");// 이거 오토박싱이었음..
		
		boolean r1 = Boolean.parseBoolean(str1); //valueof로 받으면 Boolean이 되야함 맨앞
		int			 r2 = Integer.parseInt(str2);
		double 	 r3 = Double.parseDouble(str3);
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " +10);
		System.out.println("r3 : " +1.2);
		System.out.println();
		
		//Wrapper 활용 II (String을 Wrapper로)
		Boolean w1 = Boolean.valueOf(str1);
		Integer w2 = Integer.valueOf(str2);
		Double w3 = Double.valueOf(str3);
		
		System.out.println("w1 :" + w1);
		System.out.println("w2 :" + w2);
		System.out.println("w3 :" + w3);
		System.out.println();
		
		// auto-boxing
		Boolean box1 = true;
		Boolean box = new Boolean(true);//이걸 줄인게 박싱
		Integer  box2 = 100;
		Double   box3 = 1.123;
		
		System.out.println("box1 : " + box1);
		System.out.println("box2 : " + box2);
		System.out.println("box3 : " + box3);
		System.out.println();
		
		// auto-unboxing
		boolean ubx1 = box1;
		int			 ubx2 = box2;
		double 	 ubx3 = box3;
		
		System.out.println("ubx1 : " + ubx1);
		System.out.println("ubx2 : " + ubx2);
		System.out.println("ubx3 : " + ubx3);
		System.out.println();
		
		}	
}



// 스트링 -> 기본 wrapper.parse~
// 기본 -> 래퍼 오토박싱
// 래퍼 -> 기본 오토언박싱
// 스트링-> 래퍼 wrapper.valueof
// 기본 -> 스트링 String.valueof
// 래퍼-> 스트링 toString()