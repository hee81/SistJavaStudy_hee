package day1027;

import java.util.Scanner;

public class ArrayQuiz_09 {

	public static void main(String[] args) {
		// 메뉴명을 입력하여 '해당 메뉴는 2번째에 있습니다' Q or q 입력시 프로그램 종료
		// 티본스테이크 처럼 없는 메뉴를 입력하면 '해당메뉴는 본 메뉴에 없습니다'
		
		Scanner sc=new Scanner(System.in);
		
		String [] menu = {"아보카도 샌드위치","에그샌드위치","콥샐러드","치아바타 샌드위치"
				,"스테이크 샐러드","까르보나라 파스타","토마토파스타"};
		String food;
		Boolean flag;
		
		while(true)
		{
			System.out.println("메뉴명을 입력하세요");
			food=sc.nextLine();
			
			if(food.equalsIgnoreCase("G"))
			{
				System.out.println("조회가 종료되었습니다");
				break;
			}
			
			flag=false;

			for(int i=0;i<menu.length;i++)
			{
				if(food.equals(menu[i]))
//				if(food.startsWith(menu[i]))
				{
					flag=true;
					System.out.println("해당 메뉴는 "+(i+1)+"번째에 있습니다.");
				}
			}
			
			if(!flag)
				System.out.println("해당 메뉴는 없습니다.");

		}
		
		
		

	}

}
