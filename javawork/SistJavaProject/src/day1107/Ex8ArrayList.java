package day1107;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex8ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] stuName= {"조성진","허현","김성주","나지예","김현능"};
		
		//ArrayList: 객제들을 삽입,삭제 검색할 수 있는 컨테이너이다
//		List<String> nameList1=new ArrayList<String>();
		ArrayList<String> nameList=new ArrayList<String>();
		
		//데이터담기
		//stuName을 list에 삽입해본다
//		for(int i=0;i<stuName.length;i++)
//		{
//			nameList.add(stuName[i]);
//		}
		
//		nameList.add(stuName[0]);
//		nameList.add(stuName[1]);
//		nameList.add(stuName[2]);
//		nameList.add(stuName[3]);

		for(String s:stuName)
			nameList.add(s);

	
		
		//list를 출력해본다(출력방법은 2가지 이상)
		//for~each
		System.out.println("**출력1_for~each**");
		for(String s:nameList)
			System.out.println(s);
		
		//Iter
		System.out.println("**출력2_Iterator**");
		Iterator<String> iter=nameList.iterator();
		while(iter.hasNext())
		{
			String a=iter.next();
			System.out.println(a);
		}
		
		//for
		System.out.println("**출력3_for**");
		for(int i=0;i<nameList.size();i++)
		{
			String s=nameList.get(i);
			System.out.println((i+1)+": "+s);
		}
		
		
		
		
		
		
		

	}

}
