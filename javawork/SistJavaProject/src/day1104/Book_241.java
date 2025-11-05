package day1104;

//super
abstract class Student{
	//맴버변수
	String name;
	int score;
	
	Student(String name,int score){
		this.name=name;
		this.score=score;
	}
	
	abstract void examTake(); //시험지 받는다
	abstract void examSolve(); //문제를 푼다
	abstract void examSubmit(); //시험지 제출한다
	
	//추상메서드
	final void doExam() {
		examTake();
		
		//5개의 문제를 푼다.
		for(int i=0;i<5;i++)
		{
			examSolve();
		}
		
		examSubmit();
		
	}
}

//sub
class HighStudent extends Student{

	HighStudent(String name, int score) {
		super(name, score);
	}

	@Override
	void examTake() {
		System.out.println(name+"가 강의장에서 시험지를 받는다.");
	}

	@Override
	void examSolve() {
		System.out.println(name+"가 강의장에서 문제를 푼다.");	
	}

	@Override
	void examSubmit() {
		System.out.println(name+"가 강의장에서 시험지를 제출한다.");	
	}
	

		
}


public class Book_241 {

	public static void main(String[] args) {
		Student stu1=new HighStudent("김둘리", 0);
		stu1.examTake();
		stu1.examSolve();
		stu1.examSubmit();

		System.out.println();
		
		Student stu2=new HighStudent("박또치", 0);
		stu2.examTake();
		stu2.examSolve();
		stu2.examSubmit();
		
		System.out.println();
		
		HighStudent stu3;
		stu3=new HighStudent("김둘리", 0);
		stu3.doExam();
 
		


	}

}
