package spring.ex1.di;

public class Message2 implements MessageInter {

	@Override
	public void sayHello(String name) {
		System.out.println("반가워~ 나는"+name+"이야~");

	}

}
