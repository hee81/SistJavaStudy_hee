package day1031;

import java.util.Scanner;

public class EmpMain {
	
	//main에서 해도되지만 member값에 접근하려면 생성해야함.
	public static void getEmpPay(Emp e) {
		System.out.println(e.getName()+"\t"+e.getPay()+"\t"+e.getSudang()+"\t"+e.getNetPay());
	}

	public static void main(String[] args) {
		// 회사명, 사원명, 급여, 수당, 입력 후
		// Emp테이블 생성 후 set메서드를 이용하여 초기값을 입력한다
		// 최종적으로 getEmpPay를 호출하여 급여명세서를 사원수만큼 출력한다
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		String empName;
		Emp[] emp; //
		
		System.out.println("회사이름입력");
		empName=sc.nextLine();
		
		//회사이름을 static맴버변수에 저장(초기화)
		Emp.setEmpName(empName);     
		
		//사원수
		System.out.println("총사원수입력");
		inwon=Integer.parseInt(sc.nextLine());
		
		//inwon수만큼 Emp배열할당
		emp=new Emp[inwon];
		
		for(int i=0;i<inwon;i++)
		{
			emp[i]=new Emp(); //객체 생성
			System.out.println("사원명 입력");
			String name=sc.nextLine();
			System.out.println("월 급여는");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("수당은?");
			int sudang=Integer.parseInt(sc.nextLine());
			
			//Emp 객체에 값 저장하기_초기화하기
			emp[i].setName(name);
			emp[i].setPay(pay);
			emp[i].setSudang(sudang);
			
		}

		//출력
		System.out.println("회사명: "+Emp.getEmpName());
		System.out.println("사원명\t급여\t수당\t총급여");
		System.out.println("================================");
		
		for(Emp e:emp)
			getEmpPay(e);
		
		

	}

}
