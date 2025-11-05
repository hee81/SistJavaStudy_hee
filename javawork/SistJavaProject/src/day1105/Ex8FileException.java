package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex8FileException {
	
	public static void read() {
		//경로는 / 혹은 \\
		String fileName="C:\\sist1017\\work\\file\\start.txt";
		BufferedReader br=null; //선언먼저하는이유? 생성 다 하면 접근이 안될 떄가 있음.
		FileReader fr=null; //문자단위
		
		//읽기 위해서 파일열기..=생성
		try {
			fr=new FileReader(fileName); //파일,DB생성시 try-catch처리 해야함...! 파일 없다고 종료될 수는 없기 때문에
			System.out.println("파일을 열었어요");
			
			br=new BufferedReader(fr); //bufferedreader 한 줄씩 읽어줌
			
			//여러줄 읽기 가능하기에 while(true)문으로 읽는다
			while(true)
			{
				//메모장에서 내용을 한 줄씩 읽는다
				String s=br.readLine();  //멀티캐치(try-catch안씀)
				
				//마지막줄일경우 null값을 읽는다, null일 경우 빠져나가기
				if(s==null)
					break;
				
				System.out.println(s);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { //멀티catch, 입출력발생
			// TODO: handle exception
		}finally {
			//익셉션이 발생하던 안하던 무조건 실행되는 영역
			//파일이나 DB자원을 반납
			//반드시 거꾸로 닫는다(오픈한 순서의 반대로!)
			//try-catch 사용
			try {
				br.close();
				fr.close();
				System.out.println("파일에 대한 자원을 모두 닫았어요!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public static void main(String[] args) {

		read();
		System.out.println("정상종료");

	}

}
