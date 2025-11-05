package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex10FileToken {

	public static void fileRead(){
		String filename="C:\\sist1017\\work\\file\\chuncheon.txt";
		BufferedReader br=null;
		FileReader fr=null;
		
		try {
			fr=new FileReader(filename);
			br=new BufferedReader(fr);
			
			System.out.println("**파일읽기 결과**");
			System.out.println("-----------------------------");
			System.out.println("메뉴명\t가격\t맛평가");
			System.out.println("-----------------------------");
			
			//배열
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				
				////(문자열분리)
//				//1.split으로 분리
//				String [] foodData=s.split(",");
//				//배열 갯수만큼 반복해서 출력
//				System.out.println(foodData[0]+"\t"+foodData[1]+"\t"+foodData[2]);

				//2.StringTokenizer
				StringTokenizer st=new StringTokenizer(s, ",");
				System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken());

			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
				System.out.println("자원종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
