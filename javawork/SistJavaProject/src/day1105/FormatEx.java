package day1105;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatEx {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		
		//날짜, 시간 원하는 양식으로 출력
		//HH:24시간 MM:월 mm:분
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(sdf1.format(date));
		
		//a:오전/오후 hh:12시간표시
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		System.out.println(sdf2.format(date));
		
		//EEE:월 EEEE:월요일
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm EEE");
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		
		SimpleDateFormat sdf5=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 EEE요일");
		System.out.println(sdf5.format(date));
		
		//숫자를 문자열로 변환하여 출력(컴마(,)나 소수점 지정가능)
		int money=9854600;
		double num=84541.121300;
		
		NumberFormat nf1=NumberFormat.getCurrencyInstance(); //화폐단위랑 컴마를 제공해줌
		System.out.println(nf1.format(money));
		
		NumberFormat nf2=NumberFormat.getInstance(); //컴마 제공
		System.out.println(nf2.format(money));
		System.out.println(nf2.format(num)); //자동올림은 함수사용해야함!


	}

}
