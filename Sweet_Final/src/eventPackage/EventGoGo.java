package eventPackage;
//3x3 뽑기 화면 , 횟수의 제한이 없음.
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import payPackage.Rewards;

//import sweetdelivery.Event122;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class EventGoGo extends JFrame {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	int value;
	String temp;
	private JLabel lblCount;
	private JLabel panel_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventGoGo frame = new EventGoGo("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Play(String mococo){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(mococo));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }catch (Exception ex){}
    }//play()
	
	public EventGoGo() {}
	public EventGoGo(String id) { //생성자. 
		//메인 화면과 데이터를 주고 받기 위해서 생성자에 값을 넘기고 받을 것이다.
		int min = 1;
		int max = 9;
		Random random = new Random();
		
		value = random.nextInt(max)+min;
		System.out.println(value);
		
		String temp = "btnNo"+String.valueOf(value);
		System.out.println(temp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 750);
		setTitle("Event122");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경이미지
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();
		
		JPanel panelbg = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panelbg.setBounds(0, 0, 1190, 746);
		contentPane.add(panelbg);
		panelbg.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(380, 87, 201, 40);
		panelbg.add(panel);
		
		JLabel lblGoGo = new JLabel("Go Go!");
		lblGoGo.setFont(new Font("굴림", Font.BOLD, 25));
		panel.add(lblGoGo);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "아니야!");
			  }
			});			
		btn1.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("굴림", Font.PLAIN, 5));
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.setBounds(282, 160, 135, 135);
		panelbg.add(btn1);
		
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "아니지롱~~");
			}
		});
		btn2.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("굴림", Font.PLAIN, 5));
		btn2.setFocusPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.setBounds(431, 160, 135, 135);
		panelbg.add(btn2);
		
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "1000p 당첨!!");
				   Rewards rw = new Rewards(1000);
				   rw.WriteToFile(1000,id);
				   
			}
		});
		btn3.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("굴림", Font.PLAIN, 5));
		btn3.setFocusPainted(false);
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		btn3.setBounds(580, 160, 135, 135);
		panelbg.add(btn3);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {JOptionPane aa = new JOptionPane();
			   aa.showMessageDialog(null, "땡땡떙");
			}
		});
		btn6.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("굴림", Font.PLAIN, 5));
		btn6.setFocusPainted(false);
		btn6.setContentAreaFilled(false);
		btn6.setBorderPainted(false);
		btn6.setBounds(580, 307, 135, 135);
		panelbg.add(btn6);
		
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "꽝이지롱");
			}
			
		});
		btn4.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("굴림", Font.PLAIN, 5));
		btn4.setFocusPainted(false);
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		btn4.setBounds(282, 307, 135, 135);
		panelbg.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "10% 쿠폰 당첨!!");
				   Rewards rw = new Rewards(0.10, "이벤트 당첨");
				   rw.WriteToFile(0.10, "Event Reward",id);
			}
		});
		btn5.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("굴림", Font.PLAIN, 5));
		btn5.setFocusPainted(false);
		btn5.setContentAreaFilled(false);
		btn5.setBorderPainted(false);
		btn5.setBounds(431, 307, 135, 135);
		panelbg.add(btn5);
		
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "땡!");
			}
		});
		btn8.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("굴림", Font.PLAIN, 5));
		btn8.setFocusPainted(false);
		btn8.setContentAreaFilled(false);
		btn8.setBorderPainted(false);
		btn8.setBounds(431, 443, 135, 135);
		panelbg.add(btn8);
		
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "3000P 당첨!!!!");
				   Rewards rw = new Rewards(3000);
				   rw.WriteToFile(3000,id);
			}
		});
		btn7.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("굴림", Font.PLAIN, 5));
		btn7.setFocusPainted(false);
		btn7.setContentAreaFilled(false);
		btn7.setBorderPainted(false);
		btn7.setBounds(282, 443, 135, 135);
		panelbg.add(btn7);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane aa = new JOptionPane();
				   aa.showMessageDialog(null, "광광우럭따ㅠㅠ");
			}
		});
		btn9.setIcon(new ImageIcon(EventGoGo.class.getResource("/image2/\uBB34\uCF54\uCF541.jpg")));
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("굴림", Font.PLAIN, 5));
		btn9.setFocusPainted(false);
		btn9.setContentAreaFilled(false);
		btn9.setBorderPainted(false);
		btn9.setBounds(580, 443, 135, 135);
		panelbg.add(btn9);
		
		JButton btnNewButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new EventGoGoEnter(id).setVisible(true);
			}
		});
		btnNewButton.setBounds(49, 605, 165, 61);
		panelbg.add(btnNewButton);
		
		setLocationRelativeTo(null);
		
		
	}//생성자 
	int chance=3;
	
	
	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton)e.getSource();
		temp.setEnabled(false);
			
	}

		
		
}

