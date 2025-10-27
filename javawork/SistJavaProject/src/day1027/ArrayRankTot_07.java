package day1027;

public class ArrayRankTot_07 {

	public static void main(String[] args) {
		// 4명의 자바,오라클점수,합계,평균,등수를 구하시오
		String [] stuName= {"김현능","나지예","임소희","이태주"};
		int[] java= {88,77,100,98};
		int[] oracle= {78,96,55,99};
		int [] tot=new int[4];
		double [] avg=new double[4];
		int [] rank=new int[4];
		
		//각 학생들 점수에 대한 총점, 평균, 등수 출력
		//번호  학생명  자바  오라클  총점  평균  등수
		//1    김현능  88   78    166  83  3
		
		for(int i=0;i<stuName.length;i++)
		{
			tot[i]=java[i]+oracle[i];
			avg[i]=(double)(tot[i]/2.0);
		}

		for(int i=0;i<stuName.length;i++)
		{
			rank[i]=1; //등수배열을 1등으로 초기화
			
			for(int j=0;j<stuName.length;j++)
			{
				//반복하면서 나보다 큰 점수가 나오면 나의 등수를 1증가시킨다
				if(tot[i]<tot[j])
					rank[i]++;
			}
		}
		
		System.out.println("번호\t학생명\t자바\t오라클\t총점\t평균\t등수");
		for(int i=0;i<stuName.length;i++)
		{
			System.out.println((i+1)+"\t"+stuName[i]+"\t"+java[i]+"\t"
		+oracle[i]+"\t"+tot[i]+"\t"+avg[i]+"\t"+rank[i]);
		}
	
	}

}
