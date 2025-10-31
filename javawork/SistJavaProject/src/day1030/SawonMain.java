package day1030;

import java.util.Scanner;

public class SawonMain {

	public static void getSawonPay(SawonSub[] sawon)
	{
		//제목부터 호출
		SawonSub.sTitle();
		
		//입력한 사원수만큼 배열출력 //배열을 사용한이유->효율적으로 불러오기위해서!
		for(SawonSub sa:sawon) {
			System.out.println(sa.getSname()+"\t"+sa.getPay()+"\t"+sa.getFamilySu()+"\t"+sa.getTimeSu()+"\t"
					+sa.getFamilySudnag()+"\t"+sa.getTimeSudang()+"\t"+sa.getTotalPay());
		}
		
	}
	
	public static void main(String[] args) {
		//사원수를 입력하여 그 수만큼 사원명 급여 가족수 시간외근무시간을 입력해서
		//그입력한 값을 생성한다
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		SawonSub [] sawon; //옆class 사원Sub 불러옴 new는 할 수가 없음(입력된 값 사용하기 위해서)
		
		System.out.println("입력할 직원수는 몇명입니까?");
		inwon=Integer.parseInt(sc.nextLine());
		
		//배열할당
		sawon=new SawonSub[inwon];
		
		//인원수만큼 데이타 입력
		for(int i=0;i<inwon;i++)
		{
			//Sawon 생성
			sawon[i]=new SawonSub(); //디폴트생성
			System.out.println("사원명");
			String name=sc.nextLine();
			System.out.println("급여?");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("가족수?");
			int fs =Integer.parseInt(sc.nextLine());
			System.out.println("초과근무시간?");
			int ts=Integer.parseInt(sc.nextLine());
			
			//입력한 값이 setter매서드의 데이터로 초기화됨.
			sawon[i].setSname(name);
			sawon[i].setPay(pay);
			sawon[i].setFamilySu(fs);
			sawon[i].setTimeSu(ts);
			
		}
		
		getSawonPay(sawon);
		

	}

}
