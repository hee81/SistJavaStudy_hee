package day1107;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class QuizShopMain2 {
	
	//제네릭타입은 QuizShop으로!!
	List<QuizShop> list=new Vector<QuizShop>();	
	
	//입력하기
	public void ipgoSangpum() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("**상품명을 입력하시오**");
		String name=sc.nextLine();
		System.out.println("**색상을 입력하시오**");
		String color=sc.nextLine();
		System.out.println("**제조사을 입력하시오**");
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
		
		System.out.println("현재 데이터 갯수: "+list.size());

	}
	
	//출력하기
	public void jegoSangpum() {
		
		int tot;
		System.out.println("상품명\t색상\t제조사\t입고수량\t입고가격\t총금액");
		
		System.out.println("********************************");
		
		for(int i=0;i<list.size();i++)
		{
			QuizShop gs=list.get(i);
			tot=gs.getSu()*gs.getPrice();
			System.out.println(gs.getSangpumName()+"\t"+gs.getColor()+"\t"+gs.getMadeCompany()+"\t"+
					gs.getSu()+"개\t"+gs.getPrice()+"원\t"+tot+"원");
			
//			System.out.println(list.get(i));  //day1107.QuizShop@27bc2616로 출력되기에 데이터타입을 붙여줘야함.
			

		}
		
		
		
	}

	public static void main(String[] args) {
		
		QuizShopMain2 qsm=new QuizShopMain2();
		Scanner sc=new Scanner(System.in);
		int num;
		
		while(true)
		{
			System.out.println("1.상품입고\t2.상품재고\t9.종료");
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
			else
				System.out.println("다시 번호를 입력하세요");
				
		}



	}

}




