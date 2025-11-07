package day1107;

import java.util.Iterator;
import java.util.Vector;

//List
//순차적으로 데이터가 들어간다(인덱스)
//중복데이터 허용
//처음 생성시 일정한 갯수로 생성, 그 이상의 데이터 넣으면 공간이 자동으로 늘어난다(=가변적이다)
//생성자(5,3)_할당크기가 5이고 혹시 넘치면 3씩 증가!
public class Ex3Vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> list=new Vector<String>();
		Vector<String> list=new Vector<String>(); //다형성
		
		//할당크기조회
		System.out.println("초기할당크기: "+list.capacity()); //초기할당크키:10
		System.out.println("초기데이터갯수: "+list.size());
		
		
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		list.add("키위");
		list.add("무화과");
		list.add("사과");
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		list.add("키위");
		list.add("무화과");

		System.out.println("할당크기: "+list.capacity());//넘치면 10씩 증가(=가변적이다)
		System.out.println("데이터갯수: "+list.size()); //중복허용
		
		System.out.println("출력#1_for");
		for(int i=0;i<list.size();i++)
		{
//			System.out.println(i); //숫자로 출력됨
			String s=list.get(i);
			System.out.println(s);   
		}
		
		System.out.println("\n출력#2_for~each");
		for(String s2:list)
			System.out.println(s2);
		
		System.out.println("\n출력#3_Iterator");
		Iterator<String> iter=list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		System.out.println("\n**출력#4_정렬 후 출력**");
		Object [] ob=list.toArray();
		for(int i=0;i<ob.length;i++)
		{
//			System.out.println(ob[i]);
			String s=(String)ob[i];
			System.out.println(s);
		}
		
		

	}

}
