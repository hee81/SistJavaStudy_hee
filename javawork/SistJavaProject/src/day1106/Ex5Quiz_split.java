package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex5Quiz_split {

	static final String FILENAME="C:\\sist1017\\work\\file\\ex5test.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner sc=new Scanner(System.in);
	
	//Scanner
	public int getProcess() {
		int num=0;
		
		System.out.println("***[메뉴]   1.메뉴추가   2.상품재고현황   9.종료    ***");
		num=Integer.parseInt(sc.nextLine());
		
		return num;
	}
	
	
	//입력
	
	public void getinput() {
		
		System.out.println("상품명 입력");
		String name=sc.nextLine();
		System.out.println("입고된 수량");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("입고된 가격");
		int price=Integer.parseInt(sc.nextLine());
		
		try {
			fw=new FileWriter(FILENAME,true);
			
			fw.write(name+","+su+","+price+ "\n");

			
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
	public void getoutput() {
		try {
			System.out.println("번호\t상품명\t입고수량\t가격\t할인가격\t총가격");
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			int num=0;
			
			while(true)
			{
				String s=br.readLine();
				
				if(s==null)
					break;
				
				String [] test=s.split(",");
				num++;
				String sName=test[0];
				int su=Integer.parseInt(test[1]);
				int price=Integer.parseInt(test[2]);
				int discount=(int)getdiscount(su, price);
				int tot=price-discount;
				
				System.out.println(num+"\t"+sName+"\t"+su+"\t"+price+"\t"+discount+"\t"+tot);
			
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
	
	//할인
	public double getdiscount(int su,int price) {
		double dis=0;
		
		if(su>=10)
			dis=price*0.1;
		
		return dis;
	}
	 
	
	public static void main(String[] args) {
		Ex5Quiz_split e5t=new Ex5Quiz_split();
		
		while(true)
		{
			int num=e5t.getProcess();
			switch(num)
			{
			case 1:
				System.out.println("***상품정보를 입력합니다***");
				e5t.getinput();
				break;
			case 2:
				System.out.println("***상품정보를 출력합니다***");
				e5t.getoutput();
				break;
			case 9:
				System.out.println("***프로그램을 종료합니다***");
				System.exit(0);
				default:
					System.out.println("***다른 숫자를 입력해주세요***");
			}
		}
		
		

	}

}
