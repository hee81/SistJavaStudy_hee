package day1031_2;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingBasic extends JFrame{
	
	//변수
	Container cp;
	//버튼변수
	JButton btn1;

	//생성
	public SwingBasic(String title) { 

		super(title);
		cp=this.getContentPane();  //this가 Jrame임
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //안전하게 닫기위해 사용
		//프레임위치
		this.setBounds(200, 100, 500, 300);
		cp.setBackground(new Color(255,255,0));
//		this.setBackground(new Color(255,255,0));//보이지 않는 팬이 존재함! this->cp
//		this.getContentPane().setBackground(new Color(150,100,200)); //Container 안 넣고 가능 //자주 사용할 떈XX
		
		//버튼생성
		btn1=new JButton("버튼1");
		
		//프레임에 버튼 추가(BorderLayout이 기본-동서남북, 2개이상-레이아웃생성필요)
		this.add("North", btn1); //첫글자 무조건 대문자!!!!!
		this.add("South", new JButton("아래쪽"));
		this.add("East", new JButton("오른쪽"));
		this.add("West", new JButton("왼쪽"));
		this.add("Center", new JButton("가운데"));
		
		//버튼1에 속성
		btn1.setBackground(Color.red);
		btn1.setForeground(Color.yellow);
		

		this.setVisible(true);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		SwingBasic sw=new SwingBasic();
		new SwingBasic("스윙연습_1"); //title 생성안하면 오류남
		

	}

}
