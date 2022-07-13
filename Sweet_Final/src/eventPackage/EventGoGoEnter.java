package eventPackage;
//이벤트 페이지
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class EventGoGoEnter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventGoGoEnter frame = new EventGoGoEnter("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EventGoGoEnter() {}
	public EventGoGoEnter(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
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
				
		
		JButton button = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Event1(id).setVisible(true);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				setVisible(false);
				new Event1(id).setVisible(true);
			}
		});
		button.setForeground(new Color(240, 255, 255));
		button.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 22));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(61, 38, 164, 43);
		panelbg.add(button);
		
		textField = new JTextField();
		textField.setText("당신의 운을 시험해보자!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 30));
		textField.setColumns(10);
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(295, 67, 676, 78);
		panelbg.add(textField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EventGoGoEnter.class.getResource("/image2/\uC5B4\uD50C\uBB38\uAD6C.png")));
		label.setBounds(17, 584, 229, 57);
		panelbg.add(label);
		
		JLabel label_1 = new JLabel("\uD68C\uC0AC : sweet deilvery");
		label_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_1.setBounds(263, 575, 196, 43);
		panelbg.add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-123-4567");
		label_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_2.setBounds(263, 610, 196, 43);
		panelbg.add(label_2);
		
		JLabel label_3 = new JLabel("\uC774\uBA54\uC77C : deliverysweet@naver.com");
		label_3.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_3.setBounds(263, 646, 306, 43);
		panelbg.add(label_3);
		
		JLabel label_4 = new JLabel("\uC8FC\uC18C : \u3147\u3147\u3147\u3147\u3147\u3147\u3147");
		label_4.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_4.setBounds(454, 610, 345, 43);
		panelbg.add(label_4);
		
		JLabel label_5 = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638 : 1234-15566-1245");
		label_5.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_5.setBounds(444, 575, 266, 43);
		panelbg.add(label_5);
		
		JButton btnNewButton = new JButton("\uBF51\uAE30\uD558\uB7EC\uAC00\uAE30~~!");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new EventGoGo(id).setVisible(true);					
			}
		});
		btnNewButton.setBounds(454, 476, 294, 70);
		panelbg.add(btnNewButton);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(EventGoGoEnter.class.getResource("/image2/24_sad_coconut.gif")));
		label_6.setBounds(468, 192, 255, 233);
		panelbg.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(EventGoGoEnter.class.getResource("/image2/23_멘탈터짐_coconut.gif")));
		label_7.setBounds(725, 192, 255, 233);
		panelbg.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(EventGoGoEnter.class.getResource("/image2/04_커여워_coconut.gif")));
		label_8.setBounds(211, 192, 266, 233);
		panelbg.add(label_8);
		setTitle("Event4");
		setSize(1200,745);
		setVisible(true);	
		
		setLocationRelativeTo(null);	
		

}
}
