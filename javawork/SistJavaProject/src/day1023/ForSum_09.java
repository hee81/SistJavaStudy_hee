package day1023;

public class ForSum_09 {

	public static void main(String[] args) {
		// 1~10까지 합
		int sum=0;
		for (int i=1;i<=10;i++)
		{
			sum+=i; //sum=sum+=i
		}
		
		System.out.println("1부터 10까지의 합은 "+sum+"입니다");
		
		//1~10까지 합계_while
		int a=1; //초기값
		int tot=0;
		while(a<=10)
		{
			tot=tot+a; //합계 변수에 a변수를 누적시킨다 tot+=a
			a++;
								
		}
		System.out.println("while문 1~10까지의 합은: "+tot+"입니다");
		
		//1~10까지 2씩 증가하며 더해보자 1 3 5 7 9의 합 25
		int b=1;
		int tot2=0;
		while(b<=10)
		{
			tot2+=b;
			b+=2;
		}
		System.out.println("while_총합계는: "+tot2);
		
		int sum2=0;
		for (int i=1;i<=10;i+=2)
		{
			sum2+=i;
		}
		System.out.println("if_총합계는: "+sum2);
		
		//팩토리얼 1~10
		/*
		1!=1
		2!=2*1=2
		3!=3*2*1=6
		*/
		
		int result=1;
		for(int j=1;j<=10;j++)
		{
			result*=j; //result=result*j;
				System.out.println(j+"!="+result);
		}
		
		
		
		
		
		
		
		
		
		

	}

}
