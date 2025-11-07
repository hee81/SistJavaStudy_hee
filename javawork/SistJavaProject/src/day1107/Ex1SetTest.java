package day1107;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set<Integer> set1=new HashSet<Integer>();
		HashSet<Integer> set1=new HashSet<Integer>(); //다형성
		
		set1.add(10); //가변적임
//		set1.add("11"); //문자열 불가능
		set1.add(12);
		set1.add(10);
		set1.add(15);
		set1.add(16);
		
		System.out.println("갯수: "+set1.size()); //length아님!!, 중복안됨
		
		System.out.println("출력#1_for~each");
		for(Integer i:set1)
			System.out.printf("%5d",i);
		
		System.out.println();
		
		System.out.println("출력#2_Iterator");
		Iterator<Integer> iter=set1.iterator();
		while(iter.hasNext())
			System.out.printf("%5d",iter.next());
		
		System.out.println();
		
		System.out.println("출력#3_toArray()");
		Object [] ob=set1.toArray();
		for(int i=0;i<ob.length;i++)
		{
			System.out.printf("%5d",ob[i]);
		}
		

	}

}
