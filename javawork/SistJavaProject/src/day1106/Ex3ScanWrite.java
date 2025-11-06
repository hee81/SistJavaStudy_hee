package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3ScanWrite {
	
	//선언부-선언부에 작성하면 필요할때마다 가져가기 편함
	Scanner sc; //전역변수로 빼놓기.
	FileWriter fw;
	static final String FILENAME="C:\\sist1017\\work\\file\\member2.txt";
	FileReader fr;
	BufferedReader br;

	
	public Ex3ScanWrite() {
		sc=new Scanner(System.in); //생성자 안에 스캐너 넣으면 편한이유? 그때그떄 작성 안해도 됨
	}
	
	public void fileWrite() {
		try {
			fw=new FileWriter(FILENAME,true); //추가모드
			//키보드로 이름,주소,핸드폰 입력 후 파일에 저장
			System.out.println("이름입력");
			String name=sc.nextLine();
			System.out.println("주소입력");
			String addr=sc.nextLine();
			System.out.println("핸드폰입력");
			String hp=sc.nextLine();
			
			System.out.println("**파일저장 확인할 것!!!**");
			//파일저장
			fw.write(name+"\n");
			fw.write(addr+"\n");
			fw.write(hp+"\n");

			
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
	
	public void fileRead() {
		
		//제목
		System.out.println("**Member2정보**");
		System.out.println("이름\t주소\t핸드폰");
		System.out.println("==========================");
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			int num=0;
			while(true)
			{
				String name=br.readLine();
				
				if(name==null)
					break;
				
				String addr=br.readLine();
				String hp=br.readLine();
						
				System.out.println(++num+"\t"+name+"\t"+addr+"\t"+hp);
			}
			
			System.out.println("**출력 끝**");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

	public static void main(String[] args) {
		// 생성자로 만들면  //-->class내에서 선언부 작성했기 떄문에 class 매개변수 사용해서 그 안에 메서드 불러와야함
		Ex3ScanWrite ex=new Ex3ScanWrite();
		ex.fileWrite();
		ex.fileRead(); //ex.fileWrite()닫고 생성, 동시생성XX
		

	}

}
