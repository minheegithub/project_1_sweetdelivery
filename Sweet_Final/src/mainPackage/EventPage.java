package mainPackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import payPackage.Rewards;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingConstants;

//각 이미지 버튼 마다 1~9의 번호를 가지고 있음. 럭키박스.
//1에서 9중 랜덤으로 한 번호를 뽑는다. 뽑힌 번호와 일치하는 번호를 가진 버튼, 앞 뒤로 1차이의 버튼을 누를 경우 리워드를 지급 받는다.
public class EventPage extends JFrame implements ActionListener {

	String id;
	private JPanel contentPane;
	private JButton btnNo1;
	private JButton btnNo2;
	private JButton btnNo3;
	private JButton btnNo4;
	private JButton btnNo5;
	private JButton btnNo6;
	private JButton btnNo7;
	private JButton btnNo8;
	private JButton btnNo9;	
	int value;
	String temp;
	private JLabel lblCount;
	private JPanel panel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventPage frame = new EventPage("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EventPage(String id) {
		
		this.id = id;
		//랜점 번호 뽑기
		int min =1;
		int max = 9;
		Random random = new Random();		
		
		value = random.nextInt(max)+min; //1부터 9사이의 숫자.
		System.out.println(value);
		
		String temp = "btnNo"+String.valueOf(value);
		System.out.println(temp);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(0, 0, 1190, 746);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//setText로 번호당 1부터 9까지의 숫자를 각각 부여했다.
		btnNo1 = new JButton("");			
		btnNo1.setForeground(Color.WHITE);
		btnNo1.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo1.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/red.png")));
		btnNo1.setBorderPainted(false);
		btnNo1.setContentAreaFilled(false);
		btnNo1.setFocusPainted(false);		
		btnNo1.setBounds(161, 109, 135, 135);
		btnNo1.addActionListener(this); //버튼을 이벤트로 등록
		btnNo1.setText("1");
		panel.add(btnNo1);		
		
		btnNo2 = new JButton("");	
		btnNo2.setForeground(Color.WHITE);
		btnNo2.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo2.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/orange.png")));
		btnNo2.setBorderPainted(false);
		btnNo2.setContentAreaFilled(false);
		btnNo2.setFocusPainted(false);		
		btnNo2.setBounds(310, 109, 135, 135);
		btnNo2.addActionListener(this); 
		btnNo2.setText("2");
		panel.add(btnNo2);
		
		btnNo3 = new JButton("");
		btnNo3.setForeground(Color.WHITE);
		btnNo3.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo3.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/yellow.png")));		
		btnNo3.setBorderPainted(false);
		btnNo3.setContentAreaFilled(false);
		btnNo3.setFocusPainted(false);
		btnNo3.setBounds(459, 109, 135, 135);
		btnNo3.addActionListener(this); 
		getContentPane().add(btnNo3); 
		btnNo3.setText("3");
		panel.add(btnNo3);
		
		btnNo4 = new JButton("");
		btnNo4.setForeground(Color.WHITE);
		btnNo4.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo4.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/green.png")));		
		btnNo4.setBorderPainted(false);
		btnNo4.setContentAreaFilled(false);
		btnNo4.setFocusPainted(false);
		btnNo4.setBounds(161, 256, 135, 135);
		btnNo4.addActionListener(this); //버튼을 이벤트로 등록
		btnNo4.setText("4");
		panel.add(btnNo4);
		
		btnNo5 = new JButton("");
		btnNo5.setForeground(Color.WHITE);
		btnNo5.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo5.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/blue.png")));		
		btnNo5.setBorderPainted(false);
		btnNo5.setContentAreaFilled(false);
		btnNo5.setFocusPainted(false);
		btnNo5.setBounds(310, 256, 135, 135);
		btnNo5.addActionListener(this); //버튼을 이벤트로 등록
		btnNo5.setText("5");
		panel.add(btnNo5);
		
		btnNo6 = new JButton("");	
		btnNo6.setForeground(Color.WHITE);
		btnNo6.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo6.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/navy.png")));
		btnNo6.setBorderPainted(false);
		btnNo6.setContentAreaFilled(false);
		btnNo6.setFocusPainted(false);
		btnNo6.setBounds(459, 256, 135, 135);
		btnNo6.addActionListener(this); //버튼을 이벤트로 등록
		btnNo6.setText("6");
		panel.add(btnNo6);
		
		btnNo7 = new JButton("");
		btnNo7.setForeground(Color.WHITE);
		btnNo7.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo7.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/purple.png")));		
		btnNo7.setBorderPainted(false);
		btnNo7.setContentAreaFilled(false);
		btnNo7.setFocusPainted(false);
		btnNo7.setBounds(161, 392, 135, 135);
		btnNo7.addActionListener(this); //버튼을 이벤트로 등록
		btnNo7.setText("7");
		panel.add(btnNo7);
		
		btnNo8 = new JButton("");
		btnNo8.setForeground(Color.WHITE);
		btnNo8.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo8.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/neogreen.png")));		
		btnNo8.setBorderPainted(false);
		btnNo8.setContentAreaFilled(false);
		btnNo8.setFocusPainted(false);
		btnNo8.setBounds(310, 392, 135, 135);
		btnNo8.addActionListener(this); //버튼을 이벤트로 등록
		getContentPane().add(btnNo8); //창에 버튼을 add
		btnNo8.setText("8");
		panel.add(btnNo8);
		
		btnNo9 = new JButton("");	
		btnNo9.setForeground(Color.WHITE);
		btnNo9.setFont(new Font("굴림", Font.PLAIN, 5));
		btnNo9.setIcon(new ImageIcon(EventPage.class.getResource("/resource/EventIcons/pink.png")));
		btnNo9.setBorderPainted(false);
		btnNo9.setContentAreaFilled(false);
		btnNo9.setFocusPainted(false);
		btnNo9.setBounds(459, 392, 135, 135);
		btnNo9.addActionListener(this); //버튼을 이벤트로 등록
		btnNo9.setText("9");
		panel.add(btnNo9);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.ORANGE);
		panel1.setBounds(37, 43, 151, 37);
		panel.add(panel1);
		
		JLabel lblNewLabel = new JLabel("기회는 세번!");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 25));
		panel1.add(lblNewLabel);			
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(694, 245, 77, 75);
		
		lblCount = new JLabel("3");
		panel_1.add(lblCount);
		lblCount.setFont(new Font("배달의민족 주아", Font.PLAIN, 50));
		panel.add(panel_1);
		
		//메인 페이지로 가는 뒤로가기 버튼
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //지금창 해제, 프레임 닫는 것
				setVisible(false); //지금창 안보이게
				try {
					new MainPage(id).setVisible(true);
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
			}
		});
		
		btnBack.setIcon(new ImageIcon(EventPage.class.getResource("/resource/back-button.png")));
		btnBack.setBounds(31, 522, 103, 67);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);
		panel.add(btnBack);
		
		setLocationRelativeTo(null);
	}		
		
	int chance = 3;
	@Override
	public void actionPerformed(ActionEvent e) {
				
		JButton temp = (JButton)e.getSource();
		temp.setEnabled(false);
		
		if(chance == 0) temp.setEnabled(true); //기회가 끝났는데도 버튼이 눌림 처리된 것을 방지. 기회를 다 사용하면 더이상 작동하지 않는다.
		
		if(Integer.parseInt(temp.getText()) == value) {//value는 1부터 9까지의 숫자가 랜덤으로					
			
			if(chance==0) {	//기회가 끝난 경우
				JOptionPane.showMessageDialog(null,"더 이상 뽑을 수 없어요.✨😅");				
				return;
			}
			
			JOptionPane.showMessageDialog(null,"30% 할인 쿠폰 당첨🎉😁");		
			chance = chance-1;
			lblCount.setText(String.valueOf(chance)); //기회 횟수를 1줄인 것을 화면에 출력.
			
			Rewards rw = new Rewards(0.30,"오늘의 행운 테스트"); //
			rw.WriteToFile(0.30, "Today's Luck",id);
			
		}else if(Integer.parseInt(temp.getText())== value-1) {			//포인트				
			
			if(chance==0) {
				JOptionPane.showMessageDialog(null,"더 이상 뽑을 수 없어요.✨😅");				
				return;
			}
			
			JOptionPane.showMessageDialog(null,"500P 당첨🎉😁");	
			chance = chance-1;
			lblCount.setText(String.valueOf(chance));
			
			Rewards rw = new Rewards(500); //생성자 초기화 . Rewards 클래스는 포인트와 쿠폰의 값을 받고 쓴느 것을 관리한다. 리워드 설계 클래스.
			rw.WriteToFile(500,id); 				
		
		}else if(Integer.parseInt(temp.getText())== value+1) {		//할인쿠폰
			
			if(chance==0) {
				JOptionPane.showMessageDialog(null,"더 이상 뽑을 수 없어요.✨😅");				
				return;
			}
			
			JOptionPane.showMessageDialog(null,"10% 할인 쿠폰 당첨🎉😁");	
			chance = chance-1;
			lblCount.setText(String.valueOf(chance));
			
			Rewards rw = new Rewards(0.10,"오늘의 행운 테스트");
			rw.WriteToFile(0.10, "Today's Luck",id); //한글이 화면에 깨져서 영문 문자열로 받도록 했다.			
		}else {			  
		  
			if(chance==0) {
				JOptionPane.showMessageDialog(null,"더 이상 뽑을 수 없어요.✨😅");				
				return;
			}
		  JOptionPane.showMessageDialog(null,"다음기회에..✨😅");	
		  chance = chance-1;
		  lblCount.setText(String.valueOf(chance));
		}		
	}//actionPerformed()
	
	
}
