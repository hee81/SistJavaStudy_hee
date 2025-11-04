package day1104;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent extends JFrame implements ActionListener{
	
	Container cp;
	JButton btn1,btn2;

	public SwingEvent(String title) {
		super(title);
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //프레임닫기
		this.setBounds(200, 100, 500, 300);
//		this.getContentPane().setBackground(new Color(255,255,200)); //색바꾸려면 getContentPane()앞에 this가 없어야함
		cp.setBackground(new Color(255,255,200)); 
		
		//디자인호출
		initDesign();
		
		this.setVisible(true);
		
	}
	
	//디자인 작성
	public void initDesign() {
		//기본 다자인은 BorderLayout, FlowLayout은 레이아웃 변경 필요
		this.setLayout(new FlowLayout());
		
		//버튼생성
		btn1=new JButton("배경색을 연핑크로 변경");
		btn2=new JButton("배경색을 회색으로 변경");
		
		//프레임에 추가
		this.add(btn1);
		this.add(btn2);
		
		//btn1,btn2에 이벤트를 줄 예정
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingEvent("스윙이벤트 연습_#1");

	}

	//이벤트부여
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==btn1)
		{
			//배경색 연핑크로 변경
//			this.setBackground(Color.pink);
			cp.setBackground(Color.pink);
		}
		else if(ob==btn2)
		{
			cp.setBackground(Color.gray);
		}

		
	}

}
