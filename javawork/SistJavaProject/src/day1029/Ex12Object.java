package day1029;

class Member{
	//모든 맴버 변수 private
	private String memName;
	private int memAge;
	private String job;
	
	static final String ADDR="세종시";
	
	//setter_
	public void setMemName(String name)
	{
		memName=name;
	}
	public void setMemAge(int age)
	{
		memAge=age;
	}
	public void setJob(String job)
	{
		this.job=job;
	}
	
	//getter_
	public String getMemName()
	{
		return memName;
	}
	public int getMemAge()
	{
		return memAge;
	}
	public String getJob()
	{
		return job;
	}
	
	//출력메서드
	public void writeMember()
	{
		System.out.println("회원명: "+memName);
		System.out.println("회원나이: "+memAge);
		System.out.println("회원직업: "+job);
	}
}

public class Ex12Object {

	public static void main(String[] args) {
		//디폴트생성자로 생성 후 setter이용해서 수정하고
		//getter이용해서 출력
		Member mem=new Member();
		

		//매서드 이용해서 출력가능
		mem.writeMember();
		
		//수정
		mem.setMemName("김구라");
		mem.setMemAge(33);
		mem.setJob("연예인");
		
		//매서드 다시 호출
		mem.writeMember();
		
		//수정2
		mem.setMemName("유재석");
		mem.setMemAge(22);
		mem.setJob("아나운서");
		
		//조회 메서드로 출력
		System.out.println(Member.ADDR);
		System.out.println("회원명: "+mem.getMemName());
		System.out.println("회원나이: "+mem.getMemAge());
		System.out.println("회원직업: "+mem.getJob());
		

	}

}
