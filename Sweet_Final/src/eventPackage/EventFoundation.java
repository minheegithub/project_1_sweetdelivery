package eventPackage;
//창립 기념 포인트 적립.
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import payPackage.Rewards;

//import MainPackage.Rewards;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class EventFoundation extends JFrame {

	private JPanel contentPane;
	private JTextField txtp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventFoundation frame = new EventFoundation("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public EventFoundation() {}
	public EventFoundation(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1200, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Event3");
		setSize(1200,745);
		setLocationRelativeTo(null);	
		setVisible(true);
		
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EventFoundation.class.getResource("/image2/\uC5B4\uD50C\uBB38\uAD6C.png")));
		label.setBounds(17, 584, 229, 57);
		panelbg.add(label);
		
		JLabel label_1 = new JLabel("\uD68C\uC0AC : sweet deilvery");
		label_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_1.setBounds(263, 575, 196, 43);
		panelbg.add(label_1);
		
		JLabel label_2 = new JLabel("\uC8FC\uC18C : \u3147\u3147\u3147\u3147\u3147\u3147\u3147");
		label_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_2.setBounds(464, 610, 345, 43);
		panelbg.add(label_2);
		
		JLabel label_3 = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638 : 1234-15566-1245");
		label_3.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_3.setBounds(444, 575, 266, 43);
		panelbg.add(label_3);
		
		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-123-4567");
		label_4.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_4.setBounds(263, 610, 196, 43);
		panelbg.add(label_4);
		
		JLabel label_5 = new JLabel("\uC774\uBA54\uC77C : deliverysweet@naver.com");
		label_5.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_5.setBounds(263, 646, 306, 43);
		panelbg.add(label_5);
		
		JButton comeback = new JButton("\uB3CC\uC544\uAC00\uAE30");
		comeback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Event1(id).setVisible(true);
			}
		});

		
		comeback.setForeground(new Color(240, 255, 255));
		comeback.setBackground(new Color(135, 206, 250));
		comeback.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 22));
		comeback.setBounds(61, 38, 164, 43);
		panelbg.add(comeback);
		
		txtp = new JTextField();
		txtp.setForeground(new Color(0, 0, 0));
		txtp.setBackground(new Color(224, 255, 255));
		txtp.setHorizontalAlignment(SwingConstants.CENTER);
		txtp.setText("창립기념 5000P를 받아가세요!!");
		txtp.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 30));
		txtp.setBounds(299, 38, 676, 78);
		panelbg.add(txtp);
		txtp.setColumns(10);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(EventFoundation.class.getResource("/image2/5000\uC6D0 \uCFE0\uD3F033.jpg")));
		label_6.setBounds(444, 137, 350, 350);
		panelbg.add(label_6);
		
		JButton btnNewButton = new JButton("포인트 받기");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane aa = new JOptionPane();
				aa.showMessageDialog(null, "5000p가 지급되었습니다.");
				JOptionPane.showMessageDialog(null, "지급이 완료되었습니다.");
				
				//지급된 포인트를 기록.
				Rewards rw = new Rewards(5000);
				rw.WriteToFile(5000,id);
				
				String path = ".\\src\\resource\\event\\"+id+"Foundation.txt";
				
				File  f = new File(path);
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btnNewButton.setEnabled(false);
					
//			dispose();
//			setVisible(false);
//			new Event1(id).setVisible(true);
			}
		});
		btnNewButton.setBounds(464, 502, 313, 58);
		panelbg.add(btnNewButton);
		setTitle("Event3");
//		setSize(1200,745);
		setVisible(true);
		
		String path = ".\\src\\resource\\event\\"+id+"Foundation.txt";
		
		File  f1 = new File(path);
		
		if(f1.exists()) {
			btnNewButton.setEnabled(false);
			JOptionPane.showMessageDialog(null, "이미 참여하신 이벤트 입니다.");
		}
		
		
		
	}
}
