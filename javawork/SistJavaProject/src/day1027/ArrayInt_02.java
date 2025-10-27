package day1027;

public class ArrayInt_02 {

	public static void main(String[] args) {
		//배열선언
		//기본형 배열은 객제로 인식		 
		
		int []arr1,arr2; //배열선언
		arr1=new int[3]; //배열생성...매모리할당
		arr2=new int[4]; //할당만 해도 값음 0으로 초기화
		
		//할당만 하고 초기값 지정 없이 출력 가능
		arr2[0]=10;
		arr2[1]=20;
		arr2[3]=30;
		
		//arr1: 할당만 하고 초기값 지정 없이 출력가능
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(i); // 0 1 2 출력
//			System.out.println(arr1[i]); //초기값 없으므로 0 0 0 출력
		}
		System.out.println("=================");
		//arr2 출력-초기화 안한 인덱스만 0으로 출력
		for(int i=0;i<arr2.length;i++)
//			System.out.println(arr2[i]); // 10 20 0 30 출력
			System.out.println(i+":"+arr2[i]);
		
		//for~each문...i값 없이 모든 값을 일괄적으로 출력하고 싶다면 for~each도 자주 쓴다.
		for(int a1:arr1) //for(자료형 참조변수명:배열명)
			System.out.print(a1+" ");
		
		System.out.println();
		//arr2도 for~each문 가로형 출력
		for(int a2:arr2)
			System.out.print(a2+" ");
		System.out.println();
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+" ");
		
		//ex1
		System.out.println("정수형 배열변수를 선언과 동시에 저장한다.\n");
		int arrNum[]= {5,7,9,100,45,32,77};
		
		System.out.println("출력#1_0==>5");
		for(int i=1;i<arrNum.length;i++)
		{
			System.out.println(i+"==>"+arrNum[i]);
		}
		System.out.println("출력#2_arrNum의 모든 값을 가로로 출력");
		for(int an:arrNum)
			System.out.print(an+" ");
		
		
		
		
		
		

	}

}
