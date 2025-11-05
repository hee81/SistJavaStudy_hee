package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex9FileException {
	
	/*
	 score.txt일고 총 몇개인지 구하고
	 점수에 대한 총점 평균 구해서 출력하기
	 */
	public static void scoreRead() throws IOException,FileNotFoundException{
		String fileName="C:\\sist1017\\work\\file\\score.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int cnt=0;
		int tot=0;
		double avg=0;
		
		//파일읽기
		fr=new FileReader(fileName);
		System.out.println("파일이 정상적으로 오픈");
		br=new BufferedReader(fr);
		
		while(true)
		{
			String s=br.readLine();
			//더이상 값이 없으면 종료
			if(s==null)
				break;
			
			System.out.println(s);
			//점수에 대한 총점, 평균 구하기
			cnt++; //읽은갯수
			tot+=Integer.parseInt(s);
			
		}
		//평균구하기
		avg=(double)(tot/cnt);
		System.out.println("총갯수: "+cnt+"개");
		System.out.println("총점: "+tot+"점");
		System.out.printf("평균: %.2f\n",avg);


		//finally..자원닫기
		br.close();
		fr.close();
		System.out.println("자원닫기");
		
	}
	

	public static void main(String[] args) {
		//try-catch
		try {
			scoreRead();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//try-multicatch 도 가능
//		try {
//			scoreRead();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("정상종료");


	}

}
