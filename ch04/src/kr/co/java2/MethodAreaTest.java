package kr.co.java2;
/*
 * ��¥ 2019 05 03
 * �̸� ����
 * ���� Method Area �޸� �ǽ�
 */
public class MethodAreaTest {
	
	public static void main(String[] args) {
		
		Increase ic1 = new Increase();
		Increase ic2 = new Increase();
		Increase ic3 = new Increase();
		
		ic1.num1 = 2;
			
		//Ŭ���� ����
		Increase.num2 = 2; //���������� ��ü �������ϰ� �̸�����.
		
		
		//Ŭ�����޼���
		Increase.add(); // ��ü�������ص��� , incraese�� ����ƽ�� �ٿ����⶧��
		sum();
				
}
	
	public static void sum() {
		
	}
}