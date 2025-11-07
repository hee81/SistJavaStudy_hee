package day1107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Ex2SetRandom {

	public static void main(String[] args) {
		// 1~45사이의 랜덤수 6개 구해서 출력하기
		Random rnd=new Random();
		Set<Integer> set=new HashSet<Integer>();
		
		while(true)
		{
			int n=rnd.nextInt(45)+1;
			set.add(n);
			
			if(set.size()==6)
				break;

		}
		
		System.out.println("출력#1_for~each");
		for(Integer r:set)
			System.out.printf("%5d",r);
		
		System.out.println("\n출력#2_Iterator");
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext())
			System.out.printf("%5d",iter.next());
				
		System.out.println("\n**정렬 후 출력**");
		
		Object [] ob=set.toArray();
		Arrays.sort(ob);
		for(int i=0;i<ob.length;i++)
			System.out.printf("%5d",ob[i]);

	}

}
