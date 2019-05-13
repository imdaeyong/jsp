package kr.co.java2;
/*
 * 날짜 2019 05 03
 * 이름 김대용
 * 내용 heap 메모리 실습
 */
public class HeapTest {

	public static void main(String[] args) {
		
			Args arg = new Args();
			arg.x = 100;
			
			int[] arr = {1,2,3};
			
			arg.add(arg.x); //첫번쨰 (int) 대입해서 스택에서 x가 150되지만 그대로 끝남.
			System.out.println("arg.x = " + arg.x);
			
			arg.add(arg); //세번째 , (Args를 참조하는 주소값을 참조함, heap에 있는 x에 +40
			System.out.println("arg.x = " +arg.x);
			
			//arg.addNew(arg); //위의것과 마찬가지로 같은걸 참조, heap에 새로운 Args 생성, x= 0, 스택에서는 사라짐, 새로운 Args를 참조하는애가 없어서 알아서 gc가 없앰, 같은값 140
			
			arg = arg.addNew(arg); // 위의것에서 리턴값을 받으면 값 0가능! 150짜리가 참조하는애가 사라짐! 
			System.out.println("arg.x = " + arg.x);
				
			
			arg.add(arr);// 1,2,3->2,2,3
			System.out.println("arr[0] = " + arr[0]);
			
			
	}
}
