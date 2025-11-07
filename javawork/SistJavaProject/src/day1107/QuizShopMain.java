package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class QuizShopMain {
	
	//리스트의 제네릭유형은 QuizShop이라는 클래스이다
	List<QuizShop> list=new Vector<QuizShop>();
	
	//입력
	//상품,색상,제조사,수량,가격에 대해서 값을 입력 받는다
	//입력한 상품의 갯수를 출력해본다
	public void ipgoSangpum() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("**상품명을 입력하시오**");
		String name=sc.nextLine();
		System.out.println("**색상을 입력하시오**");
		String color=sc.nextLine();
		System.out.println("**제조사를 입력하시오**");
		String madeCp=sc.nextLine();
		System.out.println("**수량을 입력하시오**");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("**가격을 입력하시오**");
		int price=Integer.parseInt(sc.nextLine());
		
		QuizShop qs=new QuizShop();
		qs.setSagnpumName(name);
		qs.setColor(color);
		qs.setMadeCompany(madeCp);
		qs.setSu(su);
		qs.setPrice(price);
		
		list.add(qs);
		
		System.out.println("현재 데이터 갯수:" +list.size());

	}
	
	//출력
	public void jegoSangpum() {
		
		int tot;
		
		System.out.println("상품명\t색상\t제조사\t입고수량\t입고가격\t총금액");
		System.out.println("============================================");
		for(int i=0;i<list.size();i++)
		{
			QuizShop gs=list.get(i);
			tot=gs.getSu()*gs.getPrice();
			System.out.println(gs.getSangpumName()+"\t"+gs.getColor()+"\t"+gs.getMadeCompany()+"\t"+
					gs.getSu()+"개\t"+gs.getPrice()+"원\t"+tot+"원");
		}

			
	}
	
	

	public static void main(String[] args) {
		// 1.상품입고    2.상품재고		9.종료
		QuizShopMain qsm=new QuizShopMain();
		
		Scanner sc=new Scanner(System.in);
		int num;
		
		while(true)
		{
			System.out.println("1.상품입고    2.상품재고		9.종료");
			num=Integer.parseInt(sc.nextLine());
			
			if(num==1)
				qsm.ipgoSangpum();
			else if(num==2)
				qsm.jegoSangpum();
			else if(num==9)
			{
				System.out.println("=====프로그램 종료======");
				break;
			}
			
	
			
		}

	}

}
