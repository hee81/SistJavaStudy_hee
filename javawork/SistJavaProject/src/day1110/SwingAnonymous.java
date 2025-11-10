package day1110;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAnonymous extends JFrame{

	Container cp;
	JButton btnAdd,btnSub;
	JLabel lblResult;


	public SwingAnonymous(String title) {
		super(title);
		cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //프레임닫기
		this.setBounds(500, 700, 500, 500);
		cp.setBackground(new Color(255,255,200));

		//디자인호출
		initDesign();

		this.setVisible(true);
	}


	public void initDesign()
	{
		//보더레이아웃이 기본...마음대로 레이아웃 null
		this.setLayout(null);


		JLabel lbl1=new JLabel("숫자1");
		JLabel lbl2=new JLabel("숫자2");
		JTextField tfsu1=new JTextField();
		JTextField tfsu2=new JTextField();
		btnAdd=new JButton("더하기");
		btnSub=new JButton("빼기");
		lblResult=new JLabel("결과 나오는곳");

		lbl1.setBounds(80, 50, 80, 30);
		lbl2.setBounds(80, 100, 80, 30);
		tfsu1.setBounds(250, 50, 100, 30);
		tfsu2.setBounds(250, 100, 100, 30);
		btnAdd.setBounds(150, 150, 200, 30);
		btnSub.setBounds(150, 190, 200, 30);
		lblResult.setBounds(100, 250, 250, 60);
		
		//글꼴변경
		lblResult.setFont(new Font("", Font.BOLD, 30));

		this.add(lbl1);
		this.add(lbl2);
		this.add(tfsu1);
		this.add(tfsu2);
		this.add(btnAdd);
		this.add(btnSub);
		this.add(lblResult);
		
		//버튼이벤트..익명내부클래스 형식으로 만들기
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int su1=Integer.parseInt(tfsu1.getText());
				int su2=Integer.parseInt(tfsu2.getText());
				int sum=su1+su2;
				
				//lblResult에 출력
				String result=su1+"+"+su2+"="+sum;
				//라벨에 결과출력
				lblResult.setText(result);
			}
		});
		
		
		//빼기 익명내부클래스 이벤트
		btnSub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int su1=Integer.parseInt(tfsu1.getText());
				int su2=Integer.parseInt(tfsu2.getText());
				int sub=su1-su2;
				
				//lblResult에 출력
				String result=su1+"+"+su2+"="+sub;
				//라벨에 결과출력
				lblResult.setText(result);
			}
		});
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SwingAnonymous("익명내부클래스 이용하여 이벤트");
	}

}