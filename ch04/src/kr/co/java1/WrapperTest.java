package kr.co.java1;

/*
 * ��¥ : 2019/05/02
 * �̸� : ����
 * ���� : wrapper Ŭ���� �ǽ��ϱ�
 */
public class WrapperTest {
	public static void main(String[] args) {
		
		//�⺻Ÿ�� ����
		boolean var1 = true;
		int 			 var2 = 10 ; //2147483647; //���� ����
		long 		 var3 = 1000L;
		char	     var4 = 'A';
		double 	 var5 = 1.2345;

		//�⺻Ÿ�� ->String
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
		
			
		//Wrapper Ŭ����
		//�⺻�����͸� ��ü�� ��ȯ�ؼ� ����! ���߿� �ڷᱸ������ �߿�
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
		
	    
	    
	    
	    //Wrapper Ȱ�� I (String�� �⺻Ÿ������)
		String str1 = "false";
		String str2 = "100";
		String str3 = "1.234567";
		String str4 = new String("hello");// �̰� ����ڽ��̾���..
		
		boolean r1 = Boolean.parseBoolean(str1); //valueof�� ������ Boolean�� �Ǿ��� �Ǿ�
		int			 r2 = Integer.parseInt(str2);
		double 	 r3 = Double.parseDouble(str3);
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " +10);
		System.out.println("r3 : " +1.2);
		System.out.println();
		
		//Wrapper Ȱ�� II (String�� Wrapper��)
		Boolean w1 = Boolean.valueOf(str1);
		Integer w2 = Integer.valueOf(str2);
		Double w3 = Double.valueOf(str3);
		
		System.out.println("w1 :" + w1);
		System.out.println("w2 :" + w2);
		System.out.println("w3 :" + w3);
		System.out.println();
		
		// auto-boxing
		Boolean box1 = true;
		Boolean box = new Boolean(true);//�̰� ���ΰ� �ڽ�
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



// ��Ʈ�� -> �⺻ wrapper.parse~
// �⺻ -> ���� ����ڽ�
// ���� -> �⺻ �����ڽ�
// ��Ʈ��-> ���� wrapper.valueof
// �⺻ -> ��Ʈ�� String.valueof
// ����-> ��Ʈ�� toString()