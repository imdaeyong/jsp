package kr.co.java1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 날짜 : 2019 05 02
 * 이름 : 김대용
 * 내용 : Collection HashSet 실습
 */
public class HashSetTest {
	public static void main(String[] args) {
		Set<Integer> set= new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(3); //중복 허용 x 집합이라 중복이 안됨 ,순서도 의미없음 
		
		System.out.println("집합 원소 개수 :  " + set.size());
		//밑에 3줄 매우 많이 썼던거같음
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println("set 원소 : " + it.next());			
		}
		
	}
}
