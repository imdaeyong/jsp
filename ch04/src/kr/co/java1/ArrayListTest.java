package kr.co.java1;

import java.util.ArrayList;
import java.util.List;


/*
 * 날짜: 2019 05 02
 * 이름: 김대용
 * 내용: Collection ArrayList 실습
 */
public class ArrayListTest {

	public static void main(String[] args) {
	
		List<Integer> list1 = new ArrayList<Integer>(); //E -> Generic
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		//첫번째 원소 1 제거
		list1.remove(0);
		
		// 리스트 원소갯수
		System.out.println("list1 전체 사이즈 :  " + list1.size());
		
		//리스트 원소 추출
		System.out.println("list1 1번째 원소 :  " + list1.get(0));
		System.out.println("list1 2번째 원소 :  " + list1.get(1));
		System.out.println("list1 3번째 원소 :  " + list1.get(2));
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("서울");
		list2.add("부산");
		list2.add("대전");
		list2.add("대구");
		list2.add("광주");
		
		for(String city : list2) {
			System.out.println("list2 원소 :  " + city);
		}
		List<Apple> list3 = new ArrayList<Apple>();
		list3.add(new Apple("한국",5000));
		list3.add(new Apple("중국",2000));
		list3.add(new Apple("일본",4000));
		list3.add(new Apple("미국",3000));
		list3.add(1, new Apple("호주", 3500));
		
		System.out.println("5번째 사과는 " + list3.get(4).getCountry()+ "입니다");
		
	
	}
	
}
