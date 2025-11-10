package day1110;

import day1110.OuterObj.InnerObj;

//내부클래스: 클래스 안에 존재
//특정클래스 내에서만 사용하는 클래스가 필요한경우
class OuterObj{
	
	
	class InnerObj{
		
		public void write()
		{
			System.out.println("내부클래스의 메서드");
		}
	}
	
	public void show()
	{
		System.out.println("외부클래스의 메서드");
		System.out.println("외부에서 내부클래스의 메서드 호출가능");
		
		InnerObj inObj=new InnerObj();
		inObj.write();
	}
}


public class Ex1InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //외부클래스의 메서드 호출
		OuterObj outObj=new OuterObj();
		outObj.show();
		System.out.println("-------------------------------");
		
		//내부클래스의 메서드를 메인에서 호출하려면 외부를 통해서만 가능
		//InnerObj in=new InnerObj();  오류
		//OuterObj.InnerObj obj=new OuterObj().new InnerObj();
		OuterObj.InnerObj obj=outObj.new InnerObj();
		obj.write();
		
	}
	
	

}