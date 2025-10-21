package day1021;

import java.util.Calendar;
import java.util.Date;

public class CalTest_04 {

	public static void main(String[] args) {
		// 
		
		Date date=new Date();
		System.out.println("지금은 "+(date.getYear()+1900)+"입니다."); //getYear 취소선=곧 사라짐.
		
		Calendar cal = Calendar.getInstance();
		System.out.println("지금은 "+cal.get(cal.YEAR)+"년도입니다.");
		System.out.println("지금은 "+(cal.get(cal.MONTH)+1)+"월입니다.");
		System.out.println("지금은 "+cal.get(cal.DAY_OF_MONTH)+"일 입니다."); //date보다 보편적으로 사용
		System.out.println("지금은 "+cal.get(cal.DATE)+"일 입니다.");
		System.out.println("시간: "+cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분");
	}

}
