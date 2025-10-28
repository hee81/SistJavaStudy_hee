package day1028;

public class Array2ChaTotal_06 {

	public static void main(String[] args) {
		// 2차원 배열에서 합계구하기~(다중for문 잘 사용 안함~~)
		
		String [] stuName= {"조성진","이태준","김민지"};
		int [][] score= {
				{88,77,99,0},
				{98,56,100,0},
				{55,88,99,0}
		}; //총점 자리수는 만들어놓기
		
		//총점 구하기(중첩해서 구하기~~~)
		for(int i=0;i<score.length;i++)
		{
			for(int j=0;j<3;j++)
			{
				score[i][3]+=score[i][j];
			}
		}
		
		//출력
		System.out.println("이름\t자바점수\t오라클\t스프링\t총점");
		System.out.println("==========================================");
		for(int i=0;i<stuName.length;i++)
		{
			System.out.print(stuName[i]+"\t");
			
			//점수와 총점은 열갯수만큼 반복해서 출력
			for(int j=0;j<score[i].length;j++)
			{
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
