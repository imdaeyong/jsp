package kr.co.java1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * ��¥ : 2019 05 02
 * �̸� : ����
 * ���� : Collection HashSet �ǽ�
 */
public class HashSetTest {
	public static void main(String[] args) {
		Set<Integer> set= new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(3); //�ߺ� ��� x �����̶� �ߺ��� �ȵ� ,������ �ǹ̾��� 
		
		System.out.println("���� ���� ���� :  " + set.size());
		//�ؿ� 3�� �ſ� ���� ����Ű���
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println("set ���� : " + it.next());			
		}
		
	}
}
