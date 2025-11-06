package day1106;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex4FileWriteRead {
	
	static final String FILENAME="C:\\sist1017\\work\\file\\sungjuk.txt";
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner sc=new Scanner(System.in); //메인에서 scanner접근 못함.
	
	public int getMenu() {
		int num=0;
		
		System.out.println("1.추가   2.전체출력   9.종료");
		num=Integer.parseInt(sc.nextLine());
		return num;
	}
	
	//정보입력해서 저장
	public void sungjukInput() {
		//이름과 점수만 입력
		System.out.println("학생명을 입력하시오");
		String name=sc.nextLine();
		System.out.println("점수를 입력하시오");
		int score=Integer.parseInt(sc.nextLine()); //try-catch처리해도됨
//		int score=sc.nextLine();
		
		//입력한 값 파일에 저장
		try {
			fw=new FileWriter(FILENAME,true);
			
			fw.write(name+"\n");
			fw.write(score+"\n");
			
			System.out.println("**학생 정보가 저장됨***");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	//학생 정보 출력
	public void sungjunkOutput() {
		//제목
		System.out.println("***\t학생정보***");
		System.out.println("번호\t이름\t점수\t학점");
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			int num=1;
			
			while(true)
			{
				String name=br.readLine();
				if(name==null)
					break;
				int score=Integer.parseInt(br.readLine());
				char grade=getGrade(score);
				String pg=getEval(score);
				
				System.out.println(++num+"\t"+name+"\t"+score+"점\t"+grade+"\t"+pg);
			}
			
			System.out.println("**출력끝**");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//학점반환해주는 메서드
	public char getGrade(int score) {
		char grade=0;
		
		if(score>=90)
			grade='A';
		else if(score>=80)
			grade='B';
		else if(score>=70)
			grade='C';
		else if(score>=60)
			grade='D';
		else
			grade='F';
		
		return grade;
	}

	//평가
	//90점이상: 장학생, 80점이상: 통과, 80점미만: 재수강
	public String getEval(int score) {
		String eval;
		
		if(score>=90)
			eval="장학생";
		else if(score>=80)
			eval="통과";
		else
			eval="재수강";
		
		return eval;
	}
	
	
	public static void main(String[] args) {
		Ex4FileWriteRead fwr=new Ex4FileWriteRead();
//		int num=fwr.getMenu();
//		if(num==1)
//		{
//			System.out.println("학생정보입력");
//			fwr.sungjukInput();
//		}
		
		while(true)
		{
			int num=fwr.getMenu();
			switch(num)
			{
			case 1:
				System.out.println("학생정보입력");
				fwr.sungjukInput();
				break;
			case 2:
				System.out.println("전체출력");
				fwr.sungjunkOutput();
				break;
			case 9:
				System.out.println("**프로그램 종료**");
				System.exit(0);//강제종료
				default:
					System.out.println("다시 한번 숫자를 확인하세요");
			}
		}


	}

}
