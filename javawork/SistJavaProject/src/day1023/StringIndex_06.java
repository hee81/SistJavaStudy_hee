package day1023;

public class StringIndex_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="나는 지금 쌍용교육센터에서 IT교육중입니다";
		
		char ch=str.charAt(6);
		String word1=str.substring(6); //6부터 끝까지
		String word2=str.substring(6, 12); //6부터 11까지
		int i=str.length();
		
		System.out.println(ch);
		System.out.println(word1);
		System.out.println(word2);
		System.out.println("str의 길이: "+i); //23:0~22까지의 index존재   
	}

}
