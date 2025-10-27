package day1027;

public class ExString_01 {

	public static void main(String[] args) {
		// 문자열에 관한 함수_String객체의 메서드
		
		String str1="apple";
		String str2="Apple";
		String str3="Happly Monday!!";
		String str4="     Happy day     ";
		
		//길이
		System.out.println("st3의 길이: "+str3.length());
		System.out.println("str4의 길이: "+str4.length());
		//str4의 공백의 제거 후의 길이
		System.out.println("str4의 공백 제거 길이: "+str4.trim().length());
		
		//인덱스 알아보기
		System.out.println("str3에서 M의 인덱스: "+str3.indexOf("M"));
		System.out.println("str4에서의 d의 인덱스: "+str4.indexOf('d'));
		
		//str4의 day추출
		System.out.println("str4에서 day 추출: "+str4.substring(11, 14));
		
		//equals ..같으면 true ..다르면 false
		System.out.println("문자열비교: "+str1.equals(str2));
		System.out.println("대소문자: "+str1.equalsIgnoreCase(str2));
		
		//a.compareTo(b) : 오름차순, 내림차순...프로젝트X잘안씀, 정처기 배열에서 나옴.
		//a와 b가 같은 경우 0
		//a가 작을경우 -값
		//a가 클경우 +값
		System.out.println(str1.compareTo(str2)); //a(97)pple A(65)pple
		System.out.println(str1.compareTo(str1));
		System.out.println("kiwi".compareTo("orange"));
		System.out.println("김".compareTo("임"));
		
		//endsWith
		System.out.println(str3.endsWith("Happy"));
		System.out.println(str3.startsWith("H"));
		
		//문자열 분리: split
		//배열선언
		String str5="이태주:김민지:조성진:허현";
		System.out.println("str5를 컴마로 분리해서 출력: ");
//		String [] arr=str5.split(","); //주로 ,사용~
		String [] arr=str5.split(":");
		System.out.println("분리된 이름갯수: "+arr.length); //5 추가하면 6으로 변경되기에 
		//출력
		for(int i=0;i<arr.length;i++)
			System.out.println(i);
//			System.out.println(i+"="+arr);  //배열 출력 안됨 arr[i]

		

	}

}
