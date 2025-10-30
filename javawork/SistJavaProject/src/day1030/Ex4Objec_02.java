package day1030;

class Board2{
	private String writer;
	private String subject; //제목
	
	private static String comment="게시판 작성하는 날";

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public static String getComment() {
		return comment;
	}

	public static void setComment(String comment) {
		Board2.comment = comment;
	}
	
	public void getBoard()
	{
		System.out.println("**Board클래스 출력**2");
		System.out.println("작성자:"+this.writer);
		System.out.println("제목: "+this.subject);
	}
}
	
	
public class Ex4Objec_02 {

	public static void main(String[] args) {
		// 
		System.out.println("**Board클래스 comment 출력2");
		System.out.println(Board2.getComment());
		
		Board2 b1=new Board2();
		b1.setWriter("김구라");
		b1.setSubject("오늘은 목요일");
		
		Board2 b2=new Board2();
		b2.setWriter("유재석");
		b2.setSubject("안녕");
		
		b1.getBoard();
		b2.getBoard();

	}

}
