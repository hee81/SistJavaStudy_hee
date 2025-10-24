package day1024;

public class guguFor_04 {

	public static void main(String[] args) {
		// 2~9단(세로)		
		for(int i=2;i<=9;i++) //단
		{
			for(int j=1;j<=9;j++)
			{
//				if (j==5) //각 단의 4단까지만 출력됨.
//					break;
				
				System.out.println(i+"X"+j+"="+(i*j));
			}
			System.out.println();
		}
		
		
		
		//자신이 속한 반복문 말고
		//최상단 반복문 빠져나가기 가능한지..?
		//이름(label)을 주어서 빠져나가기 가능!
		System.out.println("최상단 라벨을 주어 빠져나가는 경우");
		hee:for(int i=2;i<=9;i++) //단
		{
			for(int j=1;j<=9;j++)
			{
				if (j==5) //각 단의 4단까지만 출력됨.
					break hee;
				
				System.out.println(i+"X"+j+"="+(i*j));
			}
			System.out.println();
		}
		
		
		
		System.out.println("========================");
		
		for(int i=2;i<=9;i++)
		{
			System.out.print("["+i+"단]\t");
		}
		System.out.println();
		// 2~9단(가로)
		for(int j=1;j<=9;j++)
		{
			for(int i=2;i<=9;i++) //단
			{
				System.out.print(i+"X"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}

	}

}
