package day1031;

public class Ex2Main {

	public static void main(String[] args) {
		// 이효리,260000,개발팀
		
		//객체생성은 자동으로 부모->자식순
		//그래야 자식이 부모의 맴버를 사용할 수 있음
		//디폴트 생성자는 자동호출된다
		
		Ex2Manager ex2=new Ex2Manager("이효리", 260000, "개발팀");
		System.out.println(ex2.getEmp());
		
	}

}
