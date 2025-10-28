package day1027;

import java.util.Scanner;

public class test_10_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
//		test8();
//		test9();
		

	}
	public static void test1() {
		//문자열에 관한 함수_String객체의 매세드
		String str1="apple";
		String str2="Apple";
		String str3="Happy Monday";
		String str4="     Happy day     ";
		
		//st3의 길이, str4의 길이, str4의 공백 제거 길이 
		
		//str3에서 M의 인덱스, str4에서의 d의 인덱스
		
		//str4에서 day 추출
		
		
		
		
		
		
		//split이 가장 중요?!
		String str5="A,B,C,D,E";
		String [] arr=str5.split(",");
		System.out.println(arr.length);
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
			
	}
	
	public static void test2() {
		//arrayInt_배열에는 반복문(for) 꼭 필요함
//		int []arr1;
//		arr1=new int[4];
//		
//		arr1[0]=10;
//		arr1[1]=20;
//		arr1[3]=30;
		
		int [] arr1 = {10,20,0,30};
		for(int a:arr1)
			System.out.println(a);
		
		System.out.println("arr1 길이 "+arr1.length);
		
		for(int i=0;i<arr1.length;i++)
			System.out.println(arr1[i]);
		System.out.println("----------");
		for(int a:arr1)
			System.out.println(a);	
		
	}
	
	public static void test3() {
		//String
		
		String [] str;
		str=new String[3];
		
		str[0]="A";
		str[1]="B";
		str[2]="C";
		
		String [] str2= {"가","나","다","라"}; //char 도 가능~~
		           
		System.out.println(str.length);
		System.out.println(str2.length);
		
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
		
		for(String s2:str2)
			System.out.println(s2);
		
		
	}
	
	public static void test4() {
		// 정수를 입력받아서 입력받은 그 수를 출력하고 합계도 구해보자
		// 입력도 출력도 모두 배열의 반복문 이용할 것
		
		Scanner sc=new Scanner(System.in);
		
		int[] arrNum;
		arrNum = new int[4];
		int sum=0;
		
		//입력
		for(int i=0;i<arrNum.length;i++)
		{
			System.out.print(i+" 인덱스 값: ");
			arrNum[i]=sc.nextInt();
		}
		
		//출력
		for(int i=0;i<arrNum.length;i++)
		{
			System.out.println((i+1)+"번째 값:"+arrNum[i]);
			sum+=arrNum[i];
		}
		System.out.println(sum);
		
		sc.close();
	}
	
	public static void test5() {
		//배열 최대값,최소값 구하기
		int[] data= {45,32,4,12,65,76,7,2,87};
		
//		int max=data[0];
//		
//		for(int i=1;i<data.length;i++)
//		{
//			if(max<data[i])
//				max=data[i];
//		}
//		System.out.println(max);

	}
	
	public static void test6() {
		// 인원수를 먼저 입력 후 그 인원수 만큼 이름과 점수를 입력 후 총점, 평균 구하기
		
		Scanner sc=new Scanner(System.in);
		
		int iw; //인원수
		String [] name;
		int [] score;
		int [] rank;
		
		int tot=0;
		double avg=0;
		
		System.out.println("몇 명의 학생들으 입력하실건가요");
		iw=Integer.parseInt(sc.nextLine());
		
		name=new String[iw];
		score=new int[iw];
		rank=new int[iw];
		
		for(int i=0;i<iw;i++)
		{
			System.out.println(i+"번지 학생명");
			name[i]=sc.nextLine();
			System.out.println(i+"번지 점수");
			score[i]=Integer.parseInt(sc.nextLine());
			
			tot+=score[i]; 
		}
		
		for(int i=0;i<iw;i++)
		{
			rank[i]=1;
			for(int j=0;j<iw;j++)
			{
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		
		
		avg=(double)tot/iw;
		
		for(int i=0;i<iw;i++)
		{
			System.out.println((i+1)+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}
		
		System.out.println("총점: "+tot);
		System.out.println("평균: "+avg);
		
		

		
		
	}
	
	public static void test7() {
		// 4명의 자바,오라클점수,합계,평균,등수를 구하시오
		// 4명의 자바,오라클점수,합계,평균,등수를 구하시오
		String [] stuName= {"김현능","나지예","임소희","이태주"};
		int [] java= {90,80,70,60};
		
	}
	
	public static void test8() {
		// 숫자배열을 생성과 동시에 초기화
		// 해당 숫자가 몇번째 있는지 출력, 숫자가 없으면 없다라고 출력
		// 찾는 숫자를 입력하여 해당 숫자의 유무,순번등을 출력.....
		// 반복문을 입력하여 0을 입력할 때까지 계속 할 수 있다
		
		int [] numData= {5,36,13,74,42,76,100,47,63,14};
		
		Scanner sc=new Scanner(System.in);
		
		int num;
		Boolean flag;
		
		while(true)
		{
			System.out.println("숫자를 입력하시오");
			num=sc.nextInt();
			
			if(num==0)
			{
				System.out.println("종료되었습니다");
				break;
			}
			
			flag=false;
			
			for(int i=0;i<numData.length;i++)
			{
				if(num==numData[i])
				{
					flag=true;
					System.out.println(i+"인덱스값은: "+numData[i]);
				}
			}
			
			if(!flag)
			{
				System.out.println(num+"는 없습니다.");
			}

		}
		
		
	}
	
	public static void test9() {
		// 메뉴명을 입력하여 '해당 메뉴는 2번째에 있습니다' Q or q 입력시 프로그램 종료
		// 티본스테이크 처럼 없는 메뉴를 입력하면 '해당메뉴는 본 메뉴에 없습니다'
		Scanner sc=new Scanner(System.in);
		
		String [] menu = {"아보카도 샌드위치","에그샌드위치","콥샐러드","치아바타 샌드위치"
				,"스테이크 샐러드","까르보나라 파스타","토마토파스타"};
		
	}

}
