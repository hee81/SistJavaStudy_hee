package day1031;

//super
class Shop{
	private String sangpum;
	private int su;
	
	//디폴트생성자
	public Shop() {
		//초기값 부여 가능
		sangpum="딸기";
		su=10;
	}
	//명시적생성자
	public Shop(String sp, int su) {
		this.sangpum=sp;
		this.su=su;
	}
	//메서드
	public void writeShop() {
		System.out.println("상품명: "+this.sangpum);
		System.out.println("수량: "+this.su);
	}
	
	
	//자식명시적생성자에서 맴버변수명을 그대로 사용하고 싶으면 setter,getter를 만들어야함
	//private->protected   super 그대로 사용하는 것이 가장 명확하고 객체지향적인 방법임!!!!!
//	public String getSangpum() {
//	return sangpum;
//}
//public void setSangpum(String sangpum) {
//	this.sangpum = sangpum;
//}
//public int getSu() {
//	return su;
//}
//public void setSu(int su) {
//	this.su = su;
//}
	
	
	
}
//sub_Shop을 상속받고, 디폴트생성자(초기값:1000), 명시적생성자(price추가)
class Mymall extends Shop{
	
	private int price;
	
	//디폴트생성자
	public Mymall() {
		super(); ///생략가능
		price=1000;
	}
	//명시적생성자
	public Mymall(String sp, int su,int price) {
		super(sp, su);    ///super가 두 종류임!! 초기화되기에 setget안쓰고 생성자에 바로 작성
		//맴버변수가 private이기 때문에 this.sangpum=sp; 가져올 수 없음
//		this.setSangpum(sp);
//		this.setSu(su);
		this.price=price;
	}
	
	public void mWirteWhop() {
		System.out.println("가격: "+price);
	}
	
	//writeShop 오버로딩 후 price 추가하기
	@Override
	public void writeShop() {
		// price 추가하기
//		System.out.println("가격: "+price); //생성자가 아니여서 부모 위에 가능!
		super.writeShop();
		System.out.println("가격: "+price);
	}
}


public class Ex4Inheri {

	public static void main(String[] args) {
		// 디폴트생성자로 추가후 메서드 출력(딸기, 10, 1000)
		Mymall m1=new Mymall();
		m1.writeShop();

		// 명시적생성작로 추가 후 메서드 출력(오렌지, 40, 2000)
		Mymall m2=new Mymall("오렌지", 40, 2000);
		m2.writeShop();

	}

}
