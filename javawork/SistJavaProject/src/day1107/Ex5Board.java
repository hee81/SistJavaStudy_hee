package day1107;

public class Ex5Board {
	
	private String writer;
	private String subject;
	private String content;
	
	//디폴트생성자
	public Ex5Board() {
		// TODO Auto-generated constructor stub
	}
	

	//명시적생성자_생성과 동시에 초기값까지 지정됨.
	public Ex5Board(String w, String s, String c) {
		this.writer=w;
		this.subject=s;
		this.content=c;
	}
	

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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	

}
