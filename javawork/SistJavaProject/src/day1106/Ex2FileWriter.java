package day1106;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex2FileWriter {
	
	public static void fileWrite() {
		FileWriter fw=null;
		String fileName="C:\\sist1017\\work\\file\\test1.txt";
		
		try {
			fw=new FileWriter(fileName); //파일 새로 생성(같은 이름이 있더라도 새로생성)
			
			//파일에 내용추가
			
			fw.write("Have a Nice Day!!!\n");
			fw.write(new Date().toString()) ; //write=String, Date()=int--->Sring으로 변환해주기
			
			System.out.println("**파일 저장 성공**");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void fileWrite2() {
		
		FileWriter fw=null;
		String fileName="C:\\sist1017\\work\\file\\test2.txt";
		
		try {
			fw=new FileWriter(fileName, true); //true-추가모드
			fw.write("내 이름은 임소희입니다\n");
			fw.write("---------------------------\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileWrite();
		fileWrite2();

	}

}
