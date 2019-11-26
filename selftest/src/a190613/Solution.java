package a190613;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] case1 = {3, 4, 5, 4};
		int[] case2 = {4, 5, 2, 3, 4};
		int[] case3 = {3, 5, 7, 3, 1};
		int[] case4 = {7, 6, 8, 9, 9};
		int[] case5 = {1,2,3,4,5,6,7,8};
		

		int rs1 = s.solution(case1);
		int rs2 = s.solution(case2);
		int rs3 = s.solution(case3);
		int rs4 = s.solution(case4);
		int rs5 = s.solution(case5);
		System.out.println("case2 : "+ s.solution2(case1));

		System.out.println("1. "+rs1);
		System.out.println("2. "+rs2);
		System.out.println("3. "+rs3);
		System.out.println("4. "+rs4);
		System.out.println("5. "+rs5);
		//System.out.println(rs1);
	}

	// Strategy
	// 새 리스트, 비교할 리스트

	public int solution(int[] A) {
		// 주어진 배열을 리스트로 변환
		List<Integer> fullList = new ArrayList<>();

		for(int i : A) {
			fullList.add(i);
		}

		int way = 0;

		for(int i=0 ; i<fullList.size() ; i++) {
			List<Integer> list = new ArrayList<>();
			list.addAll(fullList);
			list.remove(i);

			for(int current=0 ; current<list.size() ; current++) {				
				
				int next = current+1;
				int currentNum = list.get(current);
				int nextNum = list.get(next);
				int last = list.size()-1;				
				
				if(currentNum <= nextNum) {
					if(next==last) {  
						way++;
						break;
					}						
					continue;
				} else {					
					break;
				}				
			}
		}
		return way;
	}
	
	public int solution2(int[] A) {
		
		int[] fullList= A;
		for(int i =0; i<fullList.length; i++) {
			if(i==fullList.length-1) {
				fullList[i]=fullList[i-1];
			}else {
				fullList[i]=fullList[i+1];
			}
			System.out.print(fullList[i]);			
		}
		return 0;		
	}
}