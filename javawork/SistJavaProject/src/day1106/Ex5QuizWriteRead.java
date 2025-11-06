package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex5QuizWriteRead {

	Scanner sc=new Scanner(System.in);
	static final String FILENAME="C:\\sist1017\\work\\file\\shop.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	
	//상품 선택하는 메서드
	public int getProcess() {
		int num;
		
		System.out.println("***[메뉴]   1.메뉴추가   2.상품재고현황   9.종료    ***");
		num=Integer.parseInt(sc.nextLine());
		
		return num;
	}
	
	//입력 후 파일에 저장 (ex. 아이폰12,5,1200000)
	public void sangpumAdd() {
		
		System.out.println("상품명 입력");
		String sang=sc.nextLine();
		System.out.println("입고된 수량");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("입고된 가격");
		int price=Integer.parseInt(sc.nextLine());
		
		//파일 입력 생성
		try {
			fw=new FileWriter(FILENAME,true);
			//내용 저장
			fw.write(sang+","+su+","+price+"\n");
			
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

	
	//출력
	//할인가격은 따로 메서드 만들어서 호출할 것!
	public void sangpumRead()
	{
		//수량이 10개 이상이면 10프로 할인
		//번호	상품명	입고수량	가격	할인가격	총가격
		
		//파일 오픈
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			int num=0;
			
			System.out.println("번호\t상품명\t입고수량\t가격\t할인가격\t총가격");
			
			while(true)
			{
				String s=br.readLine();
				
				if(s==null)
					break;
				
				num++;
				
				StringTokenizer stz=new StringTokenizer(s, ",");
				String sName=stz.nextToken();
				int su=Integer.parseInt(stz.nextToken());
				int price=Integer.parseInt(stz.nextToken());
				int dis=(int)(disCount(su,price));
				int tot=(int)(price-dis);
				
				System.out.println(num+"\t"+sName+"\t"+su+"\t"+price+"\t"+dis+"원\t"+tot+"원");

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	//할인가격
	public double disCount(int su,int price) {
		double disC = 0;
		
		if(su>=10)
			disC=price*1/10;

		return disC;
	}

	public static void main(String[] args) {
		//getProcess의 num으로 1.입력  2.출력  9.종료처럼 만들 것
		Ex5QuizWriteRead qwr=new Ex5QuizWriteRead();
		while(true)
		{
			int num=qwr.getProcess();
			switch (num) 
			{
			case 1:
				System.out.println("***입력***");
				qwr.sangpumAdd();
				break;
			case 2:
				System.out.println("***출력***");
				qwr.sangpumRead();
				break;
				default:
					System.out.println("***종료***");
					System.exit(0);
			}
		}

	}

}
