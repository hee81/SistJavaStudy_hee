package day1110;

interface Company{

	public void addSangpum();
	public void deleteSangpum();
	public void listSangpum();
}

public class Ex5Annony {


	//위의 Company인터페이스를 익명내부클래스 형식으로 선언하시오
	//각 메서드를 호출 완성해보세요
	Company comp=new Company() {

		@Override
		public void listSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품리스트를 출력합니다");
		}

		@Override
		public void deleteSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품을 삭제합니다");
		}

		@Override
		public void addSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품이 입고되었습니다");
		}
	};

	public static void main(String[] args) {
		// 익명내부클래스안의 메서드 호출해 볼것!!!
		Ex5Annony ex5=new Ex5Annony();
		ex5.comp.addSangpum();
		ex5.comp.deleteSangpum();
		ex5.comp.listSangpum();
	}

}