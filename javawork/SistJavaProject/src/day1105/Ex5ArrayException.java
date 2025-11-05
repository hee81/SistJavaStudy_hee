package day1105;

public class Ex5ArrayException {

	public static void main(String[] args) {
		// 배열범위에 관한 익셉션
		
		String [] str= {"Apple","Pear","Banana","Orange","Kiwi"};
		
		System.out.println("차례대로 출력");
		
		try {
		for(int i=0;i<=str.length;i++)
		{
			System.out.println(str[i]);
		}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열요구: "+e.getMessage());
		}
		
		System.out.println();
		
		System.out.println("거꾸로 출력");
		try {
		for(int i=4;i<=str.length;i--)
		{
			System.out.println(str[i]);
		}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열요구: "+e.getMessage());
		}
		
		System.out.println("프로그램 종료!!");

	}

}
