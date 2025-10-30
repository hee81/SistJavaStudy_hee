package day1030;

class MyInfo{
	//변수명 임의로(private)
	String name;
	String mbit;
	int age;
	
	//명시적 생성자
	public MyInfo(String name, String mbit, int age) {
		this.name=name;
		this.mbit=mbit;
		this.age=age;
	}
	//제목 static
	public static void myTitle() {
		System.out.println("이름\tMBTI\t나이");
		System.out.println("======================");
	}
	//출력용메서드
	public void getMyInfo() {
		System.out.println(this.name+"\t"+this.mbit+"\t"+this.age+"세");
	}
}


public class Ex7ArrayOject {

	public static void main(String[] args) {
		/*
		 **for문 출력**
		 총 3명의 정보출력
		 이름		MBTI	나이
		 ====================
		 김민희	ENFJ	26세
		 김희애	ISTP	30세
		 이효리	ESTJ	35세
		 ====================
		  **for~each문 출력**
		 */
		//배열
		MyInfo [] mi=new MyInfo[3];
		mi[0]=new MyInfo("김민희", "ENFJ", 26);
		mi[1]=new MyInfo("김희애", "ISTP", 30);
		mi[2]=new MyInfo("이효리", "ESTJ", 35);
		
		//**for문 출력**
		System.out.println("**for문 출력**");
		MyInfo.myTitle();
		for(int i=0;i<mi.length;i++)
		{
			mi[i].getMyInfo();
		}
		
		//**for~each문 출력**
		System.out.println("**for~each문 출력**");
		MyInfo.myTitle();
		for(MyInfo m:mi)
		{
			m.getMyInfo();
		}
		
		

	}

}
