package day1030;

import java.util.Scanner;

/*
****쌍용 직원 급여현황***

가족수당:  가족당 5만원 (단 4인이상은 무조건 20만원)
시간수당:  초과근무시간당 3만원 (10시간이상은 무조건 30만으로 통일)
=============================================================================
사원명	급여       가족수     초과근무시간      가족수당    초과근무수당   총급여
=============================================================================
홍길동  1200000     5           12           200000    300000      1700000


===========================================
Sawon 클래스 (멤버클래스)

모든 멤버변수는 private
사원명: sname
급여:pay
가족수:familySu
초과근무시간: timeSu

전체: setter & getter

메서드3개
getFamilySudang()
getTimeSudang()
getTotalPay()


SawonMain 클래스

몇명의 사원인지 입력후 해당사원에대한 이름,급여,가족수,시간수를 입력받아서
출력할것!!!!

 */

class Sawon{
	
	private String sname;
	private int pay;
	private int familySu;
	private int timeSu;
	
	Scanner sc=new Scanner(System.in);
	
	//제목
	public static void sTitle() {
		System.out.println("****쌍용 직원 급여현황***");
		System.out.println();
		System.out.println("======================================================================");
		System.out.println("사원명\t급여\t가족수\t초과근무시간\t가족수당\t초과근무수당\t총급여");
		System.out.println("======================================================================");
	}
	
	//수정용_setter
	public void setSname(String sname) {
//		sname=sc.nextLine();
		this.sname = sname;
	}
	public void setPay(int pay) {
//		pay=sc.nextInt();
		this.pay = pay;
	}
	public void setFamilySu(int familySu) {
//		familySu=sc.nextInt();
		this.familySu = familySu;
	}
	public void setTimeSu(int timeSu) {
//		timeSu=sc.nextInt();
		this.timeSu = timeSu;
	}
	

	//출력용_getter
	public String getSname() {
		return sname;
	}
	public int getPay() {
		return pay;
	}
	public int getFamilySu() {
		return familySu;
	}
	public int getTimeSu() {
		return timeSu;
	}
	
	//가족수당
	public int getFamilySudnag() {
		
		int fs=0;
		
		if(familySu>=4)
			fs=200000;
		else
			fs=familySu*50000;
		
		return fs;
	}
	
	//시간외수당
	public int getTimeSudang()
	{
		int ts=0;
		
		if(timeSu>=10)
			ts=300000;
		else
			ts=timeSu*30000;
		
		return ts;
			
	}

	//총급여
	public int getTotalPay() {
		int tp=pay+getFamilySudnag()+getTimeSudang();
		return tp;
	}

}



public class SawonSub {
	public static void main(String[] args) {
		
//		Sawon sa=new Sawon();
//		System.out.print("사원명을 입력하시오: ");
//		sa.setSname(null);;
//		System.out.print("급여를 입력하시오: ");
//		sa.setPay(0);
//		System.out.print("가족수 입력하시오: ");
//		sa.setFamilySu(0);
//		System.out.print("초과근무시간 입력하시오: ");
//		sa.setTimeSu(0);
//		
//
//		Sawon.sTitle();
//		System.out.println(sa.getSname()+"\t"+sa.getPay()+"\t"+sa.getFamilySu()+"\t"+sa.getTimeSu()+"\t"
//		+sa.getFamilySudnag()+"\t"+sa.getTimeSudang()+"\t"+sa.getTotalPay());

		
	}

}
