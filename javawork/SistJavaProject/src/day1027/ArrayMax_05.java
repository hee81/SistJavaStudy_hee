package day1027;

public class ArrayMax_05 {

	public static void main(String[] args) {
		// 배열 최대값 구하기
		int[] data= {45,32,4,12,65,100,76,7,2,87};
		
		System.out.println("갯수: "+data.length);
		
		//첫 데이터를 무조건 최대값에 저장한다
		int max=data[0];
		int min=data[0];
		
		//두번째 데이터부터 끝까지 max와 비교한다(index0X index1부터~)
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
				max=data[i];
			else if(min>data[i])
				min=data[i];
			
		}
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+min);
		
	}

}
