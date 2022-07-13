package loginPackage;
//마이페이지, 유저 정보.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainPackage.MainPage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserInfo extends JFrame {
	
	private JPanel contentPane;

	String id, name, pw, phone, address, branch1, branch2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(0, 0, 893, 593);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(UserInfo.class.getResource("/image/logo1.png")));
		lbLogo.setBounds(32, 31, 229, 50);
		panel.add(lbLogo);
		
		CurrentUser cu = new CurrentUser();
		String bea[] = cu.bringUser();
		
		id = bea[0]; name = bea[1]; pw = bea[2]; phone = bea[3]; 
		address = bea[4]; branch1 =  bea[5]; branch2 =  bea[6];
		System.out.println("유저정보"+id+"+"+name+"+"+pw+"+"+phone+"+"+address+"branch");
		System.out.println(pw.length());
		String info=  "                                                 \n"+
					  
				      "             스위트 딜리버리 ("+branch1+branch2+")   \n"  +
					  " ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n"+
				      "  ID        | "+id+"\n"+
				      "  NAME      | "+ name+"\n"+
				      "  PASSWORD  | ";
				     
				      for (int i = 0; i < pw.length(); i++) {
						  info += "*";
				      }
				      info += "\n"+
				      "  PHONE     | "+phone+"\n"+
					  "  ADDRESS   | \n"
				      +  "  "+address+"\n"+
					  " ====================================================\n";
		
				
		System.out.println(info);
		
		JTextArea textArea = new JTextArea(info);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 17));
		textArea.setBounds(32, 99, 550, 255);
		panel.add(textArea);
		
		//다음 페이지로 넘어가는 버튼
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				setVisible(false);
				try {
					new MainPage(id).setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNext.setBackground(Color.WHITE);
		btnNext.setIcon(new ImageIcon(UserInfo.class.getResource("/image/return.png")));
		btnNext.setBounds(32, 370, 56, 50);
		panel.add(btnNext);
		
		setLocationRelativeTo(null);
	}
	

}
