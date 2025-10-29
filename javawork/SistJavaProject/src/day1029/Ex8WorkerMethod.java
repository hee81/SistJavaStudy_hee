package day1029;

class MyJeongbo{
	
	private String name; //null
	private int age; //0
	private String city; //null	
	
	//변수 앞에 private을 붙히면 다른 클래스에서 생성을 하더라도 변수명에 접근할 수 없다
	//반드시 메서드를 만들어서 그 메서드를 호출하여 사용한다
	//setter메서드:수정용   getter메서드:조회용    이 2개를 합쳐서 worker method라 부른다
	//캡슐화라고도 한다
	
	//수정용메서드_set
	//반환타입없다,인자값 있음,리턴값 없음
	public void setName(String name) //인자값에 수정하려는 변수에 꼭넣기
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public void setCity(String city) 
	{
		this.city=city;
	}

	//조회용메서드_get
	//무조건 반환타입존재함,인자값 없음
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return age;
	}
	public String getCity()
	{
		return city;
	}
	
	
	
	
}


public class Ex8WorkerMethod {

	public static void main(String[] args) {
		
		MyJeongbo jb1=new MyJeongbo();
//		jb1.name="홍길동"; // 변수명에 접근안됨(캡슐화로 인해 불어올 수 없음)
		
		jb1.setName("임소희"); //수정용
		String name=jb1.getName();
		System.out.println("이름:"+name);
		
		jb1.setAge(26);
		System.out.println(jb1.getAge());
		int age=jb1.getAge();
		System.out.println("나이:"+age+"세");
		
		jb1.setCity("경기도");
		String city=jb1.getCity();
		System.out.println("지역:"+city );

	}

}
