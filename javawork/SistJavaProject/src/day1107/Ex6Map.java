package day1107;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex6Map {

	public static void main(String[] args) {
		// Map은 키(key)와 값(value)의 쌍으로 저장
		// key는 중복될 수 없다
		Map<String, String> map=new HashMap<String, String>(); //Spring에서 자주씀...!
		
		// put으로 값을 담고 get으로 가져온다
		map.put("name", "이효리");
		map.put("addr", "서울시 강남구");
		map.put("age", "24");
		
		//중복된 키_먼저 데이터는 없어진다
		map.put("name", "유재석"); //덮어쓰기 됨
		
		System.out.println("key값 size"+map.size()+"\n");
		
		System.out.println("key값을 정확하게 알면 value를 얻을 수 있다");
		System.out.println("이름: "+map.get("name"));
		System.out.println("주소: "+map.get("addr"));
		System.out.println("나이: "+map.get("age")+"\n");
		
		System.out.println("map에 없는 key값을 얻으려고하면 null이 나온다");
		System.out.println(map.get("city")+"\n");
		
		System.out.println("**키값을 먼저 한꺼번에 얻은 후 값을 얻는 방법**");
		//다른 인터페이스로 가져오면 됨
		Set<String> keyset=map.keySet();
		
		System.out.println("==출력1_Iterator==");
		Iterator<String> iter=keyset.iterator();
		while(iter.hasNext())
		{
			String key=iter.next();
			System.out.println(key+"==>"+map.get(key));
		}
		
		
		System.out.println("==출력2_For~each==");
		for(String key:keyset)
		{
			System.out.println(key+"==>"+map.get(key));
		}

	}

}
