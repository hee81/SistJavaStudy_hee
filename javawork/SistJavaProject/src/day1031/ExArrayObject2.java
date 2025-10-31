package day1031;

/*
 No.	음식명	가격		맛평가
 ==============================
 1		춘천막국수	11000	추천메뉴
 2		감자전	9000	인기메뉴
 3		메밀전병	8000	1위메뉴
 4		닭갈비	15000	흑백요리사 
 */

class Menu{
	private String foodName;
	private int price;
	private String tasty;
	private static int no; //메뉴번호
	
	//명시적생성자
	public Menu(String foodName, int price, String t) {
		this.foodName=foodName;
		this.price=price;
		tasty=t;
	}
	
	//제목메서드
	public static void showTitle() {
		System.out.println("No.\t음식명\t가격\t맛평가");
		System.out.println("=================================");
	}
	
	//출력메서드
	public void getMenu() {
		no++;
		System.out.println(no+"\t"+foodName+"\t"+price+"\t"+tasty);
	}
	
}


public class ExArrayObject2 {

	public static void main(String[] args) {
		//생성과 동시에 초기화
		
		Menu[] menu= {
				new Menu("춘천막국수", 11000, "추천메뉴"),
				new Menu("감자전", 9000, "인기메뉴"),
				new Menu("메밀전병", 8000, "1위메뉴"),
				new Menu("닭갈비", 15000, "흑백요리사")
		};
		
		//제목출력
		Menu.showTitle();
		//배열출력_for
		for(int i=0;i<menu.length;i++)
		{
			menu[i].getMenu();
		}
		System.out.println("---------------------------------");
		//제목출력
		Menu.showTitle();
		//배열출력_for~each
		for(Menu m:menu)
		{
			m.getMenu();
		}
		

	}

}
