package kr.co.java2;

/*
 * ��¥ 2019/05/03
 * �̸� ����
 * ���� �ݿ��� �ڹ�Ư��( Stack �޸� �ǽ��ϱ�)
 */

public class StackTest { //������. ���� �־��� ���� ����
	
	public static void main(String[] args) {
		
		int result = 0;
		int begin =1;
		int end = 10;
		
		//StackTest st = new StackTest();// �ƴϸ� �̷��� ��ü�����ϸ� ����
		//sum(begin, end); non static�� ȣ���Ҽ� ����. ((������))
		result = sum(begin, end);
		System.out.println("result ; " + result);
		//���� debug stacktest -> f6���پ� f5�Լ�������!! ����� �߿�١ڡ١ڡ١ڡ١ڡ١�		
	}
	
	public static int sum(int start, int end) {
		
		int sum = 0;
		
		for(int k = start; k<=end; k++) {
			sum +=k;
			
		}
		return sum;
				
	}
}
