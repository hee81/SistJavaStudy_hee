package day1110;

import java.util.Scanner;

class SawonOuter{
	
	private String sawonName;
	private int gibonPay,familySu,timeSu;
	
	//내부클래스 생성
	InputInner input=new InputInner();
	SudangInner output=new SudangInner();
	
	//내부클래스 처리하는 메서드
	public void process()
	{
		//데이타 입력
		input.inputData();
		
		//데이타 출력
		output.getSawonPayWrite();
		
	}
	
	
	class InputInner{
		
		//사원데이타 입력
		public void inputData()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("사원명 입력");
			sawonName=sc.nextLine();
			System.out.println("기본급은");
			gibonPay=sc.nextInt();
			System.out.println("초과시간수는");
			timeSu=sc.nextInt();
			System.out.println("가족수는");
			familySu=sc.nextInt();
		}
		
	}
	
	
	class SudangInner{
		
		//시간외수당
		public int getTimeSudang()
		{
			return timeSu*20000;
		}
		
		//가족수당
		public int getFamilySudang()
		{
			if(familySu<=3)
				return 200000;
			else
				return 300000;
		}
		
		//실제급여
		public int getNetPay()
		{
			return gibonPay+getFamilySudang()+getTimeSudang();
		}
		
		//전체출력
		public void getSawonPayWrite()
		{
			System.out.println("사원명\t기본급\t초과시간수\t시간수당\t가족수\t가족수당\t실수령액");
			System.out.println("====================================================================================");
			System.out.println(sawonName+"\t"+gibonPay+"\t"+timeSu+"\t"+getTimeSudang()+"\t"+familySu+"\t"+getFamilySudang()+"\t"+getNetPay());
		}
		
	}
	
	
}

public class InnerSawon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.내부클래스를 외부에서 생성후 메서드로 만들어서 호출
		//SawonOuter sawon=new SawonOuter();
		//sawon.process();
		
		
		//2.외부클래스 통해서 내부클래스로 이동후 각각의 메서드를 호출
		SawonOuter sawon=new SawonOuter();
		
		SawonOuter.InputInner input=sawon.new InputInner();
		input.inputData();
		
		SawonOuter.SudangInner output=sawon.new SudangInner();
		output.getSawonPayWrite();
	}

}