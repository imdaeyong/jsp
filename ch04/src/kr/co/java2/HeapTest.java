package kr.co.java2;
/*
 * ��¥ 2019 05 03
 * �̸� ����
 * ���� heap �޸� �ǽ�
 */
public class HeapTest {

	public static void main(String[] args) {
		
			Args arg = new Args();
			arg.x = 100;
			
			int[] arr = {1,2,3};
			
			arg.add(arg.x); //ù���� (int) �����ؼ� ���ÿ��� x�� 150������ �״�� ����.
			System.out.println("arg.x = " + arg.x);
			
			arg.add(arg); //����° , (Args�� �����ϴ� �ּҰ��� ������, heap�� �ִ� x�� +40
			System.out.println("arg.x = " +arg.x);
			
			//arg.addNew(arg); //���ǰͰ� ���������� ������ ����, heap�� ���ο� Args ����, x= 0, ���ÿ����� �����, ���ο� Args�� �����ϴ¾ְ� ��� �˾Ƽ� gc�� ����, ������ 140
			
			arg = arg.addNew(arg); // ���ǰͿ��� ���ϰ��� ������ �� 0����! 150¥���� �����ϴ¾ְ� �����! 
			System.out.println("arg.x = " + arg.x);
				
			
			arg.add(arr);// 1,2,3->2,2,3
			System.out.println("arr[0] = " + arr[0]);
			
			
	}
}
