package day1105;

import java.io.IOException;
import java.io.InputStream;

//문자스트림:	Reader,Writer _ 대부분 문자 단위로 처리한다
//바이트스트림: InputStream,OutputStream _ 대부분 바이트 단위로 처리한다 (원시언어?)
public class Ex6StringException {

	public static void main(String[] args) {
		
		InputStream is=System.in;
		int a=0;
		
		System.out.println("한글자 입력: ");
//		a=is.read();//예외처리 필수!
		// read()는 1바이트밖에 못 읽는다, 즉 한글 못 읽음
		try {
			a=is.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("오류: "+e.getMessage());
		}
		
		System.out.println("3초 뒤에 출력합니다");
		try {
			Thread.sleep(3000); //예외처리 필수
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("입력값: "+(char)a);

	}

}
