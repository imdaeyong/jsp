package kr.co.java1;

import java.util.ArrayList;
import java.util.List;


/*
 * ��¥: 2019 05 02
 * �̸�: ����
 * ����: Collection ArrayList �ǽ�
 */
public class ArrayListTest {

	public static void main(String[] args) {
	
		List<Integer> list1 = new ArrayList<Integer>(); //E -> Generic
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		//ù��° ���� 1 ����
		list1.remove(0);
		
		// ����Ʈ ���Ұ���
		System.out.println("list1 ��ü ������ :  " + list1.size());
		
		//����Ʈ ���� ����
		System.out.println("list1 1��° ���� :  " + list1.get(0));
		System.out.println("list1 2��° ���� :  " + list1.get(1));
		System.out.println("list1 3��° ���� :  " + list1.get(2));
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("����");
		list2.add("�λ�");
		list2.add("����");
		list2.add("�뱸");
		list2.add("����");
		
		for(String city : list2) {
			System.out.println("list2 ���� :  " + city);
		}
		List<Apple> list3 = new ArrayList<Apple>();
		list3.add(new Apple("�ѱ�",5000));
		list3.add(new Apple("�߱�",2000));
		list3.add(new Apple("�Ϻ�",4000));
		list3.add(new Apple("�̱�",3000));
		list3.add(1, new Apple("ȣ��", 3500));
		
		System.out.println("5��° ����� " + list3.get(4).getCountry()+ "�Դϴ�");
		
	
	}
	
}
