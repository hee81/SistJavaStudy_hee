package day1021;

import java.awt.Window.Type;

public class DataType_03 {

	public static void main(String[] args) {
		// 묵시적 형변환: 자동으로 결정되는 타입
		
		// String+int=String 변환필요없음 " " 만 넣어주면됨
		// double+int=double
		// long+short=long
		// char+int=int (char아스키포함한 정수형이기에)
		char a = 'A'; //65
		System.out.println(a);
		System.out.println(a+32); //97
		System.out.println(a+2); //67
		System.out.println((char)(a+32));
		System.out.println((char)(a+2));
		System.out.println("A"+5+6); //A56 String에서는 안됨.
		System.out.println('A'+3);
		System.out.println(2+'b');
		System.out.println('a'+'b'); //97+98+195

	}

}
