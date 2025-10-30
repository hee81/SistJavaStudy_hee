package day1030;

class Student{
	
	private String name;
	private String hp;
	private int score;
	
	//명시적생성자_3개 변수 생성과 동시에 초기화
	public Student(String name,String hp,int score) {
		this.name=name;
		this.hp=hp;
		this.score=score;
	}
	
	//출력메서드
	public void getStuScore() {
		System.out.println("이름: "+name);
		System.out.println("핸드폰: "+hp);
		System.out.println("점수: "+score);
	}
	
}

public class Ex5ArrayObject {

	public static void main(String[] args) {
		///배열없이 출력
		Student stu1=new Student("홍길동", "010-1111-2222", 88);
		stu1.getStuScore();
		Student stu2=new Student("이미영", "010-2222-3333", 99);
		stu2.getStuScore();
		Student stu3=new Student("김구라", "010-3333-5555", 97);
		stu3.getStuScore();
		
		///배열로 생성해서 출력!!
		//배열//
		//1.먼저 갯수를 할당받고 그 갯수만큼 초기화
//		Student[] stu=new Student[3];
//		stu[0]=new Student("홍길동", "010-1111-2222", 88);
//		stu[1]=new Student("이미영", "010-2222-3333", 99);
//		stu[2]=new Student("김구라", "010-3333-5555", 97);
		
		//2.배열 선언과 동시에 초기화
		Student[] stu= {
				new Student("홍길동", "010-1111-2222", 88),
				new Student("이미영", "010-2222-3333", 99),
				new Student("김구라", "010-3333-5555", 97)
		};
		
		//1.반복문으로 출력_for//
		System.out.println("**배열 반복문으로 출력메서드 호출_for**");
		for(int i=0;i<stu.length;i++)
		{
			stu[i].getStuScore();
		}
		//2.반복문으로 출력_for~each//
		System.out.println("**배열 반복문으로 출력메서드 호출_for~each**");
		for(Student s:stu)
		{
			s.getStuScore();
		}
		

	}

}
