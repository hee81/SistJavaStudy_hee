package day1105;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizFile {

	public static void ipgoRead() {
		
		//번호	상품명	수량	  가격   	총금액
		//split 또는 StringTokeneizer를 활용해서 출력해보세요
		
		String fileName="C:\\sist1017\\work\\file\\ipgo.txt";
		FileReader fr=null;
		BufferedReader br=null;
		int num = 0;
//		int tot;
		
		try {
			//파일 읽기
			fr=new FileReader(fileName);
			br=new BufferedReader(fr);
			
			System.out.println("번호\t상품명\t수량\t가격\t총금액");
			System.out.println("======================================");	

			while(true)
			{
				String s=br.readLine(); //mult-catch

				//break
				if(s==null)
					break;
				////split
				String [] s1=s.split(":");
				//번호, 총금액 계산
				num++;
//				tot=Integer.parseInt(s1[1])*Integer.parseInt(s1[2]);
				//출력
//				System.out.println(num+"\t"+s1[0]+"\t"+s1[1]+"\t"+s1[2]+"\t"+tot);
				
				////StringTokenizer
				StringTokenizer s2=new StringTokenizer(s, ":");
				String sangName=s2.nextToken();
				int su=Integer.parseInt(s2.nextToken());
				int price=Integer.parseInt(s2.nextToken());
				int tot=su*price;
				//출력   
				System.out.println(num+"\t"+sangName+"\t"+su+"\t"+price+"\t"+tot);

				
			}
			
			System.out.println("======================================");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				//자원닫기
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	public static void main(String[] args) {
		ipgoRead();

	}

}
