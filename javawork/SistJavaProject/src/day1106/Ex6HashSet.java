package day1106;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//set: 순서유지 없다, 중복허용안함
//Set: 인터페이스, 생성안됨
//HashSet: set을 구현한 클래스 
//Set<제네릭타입> 참조변수명=new HashSet<제네릭타입>();
//HashSet<제네릭타입> 참조변수명=new HashSet<제네릭타입>();

public class Ex6HashSet {

	public static void main(String[] args) {
		// set안에 String이라는 자료형의 데이터만 담겠다
		Set<String> set1=new HashSet<String>();
		
		//추가(add),삭제(remove)가 가능한게 배열과의 차이점이다!(=가변적임)
//		set1.add(1); //오류~
		set1.add("사과");
		set1.add("배");
		set1.add("오렌지");
		set1.add("사과");
		set1.add("바나나");
		set1.add("사과");
		
		//데이터 갯수
		System.out.println("데이터갯수: "+set1.size());
		
		System.out.println("#출력1_For"); //for,for-each문을 자주 사용함
		for(String s:set1)
			System.out.println(s);
		System.out.println();
		
		System.out.println("#출력2_iterator");
		Iterator<String> iter=set1.iterator();
		while(iter.hasNext())
		{
			String s=iter.next();
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("#출력3_Object_toArray");
		Object [] ob=set1.toArray();
		for(int i=0;i<ob.length;i++)
			System.out.println(ob[i]);
		System.out.println();
		
		//모든 데이터 삭제
		set1.clear();
		
		//isEmpty()
		if(set1.isEmpty())
			System.out.println("Set타입 안에 데이터가 없다");
		else
			System.out.println("Set타입 안에 데이터가 있다");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
