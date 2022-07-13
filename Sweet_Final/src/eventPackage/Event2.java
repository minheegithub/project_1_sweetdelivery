package eventPackage;
//이달의 음식점 할인을 확인하자. 가위바위보 이벤트
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Event2 extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Event2 frame = new Event2("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Event2() {}
	public Event2(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setBounds(0, 0, 1178, 689);
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
		
//		JPanel panel = new JPanel();
//		panel.setLayout(null);
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panel.setBounds(0, 0, 1178, 689);
//		panelbg.add(panel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("\uC774\uBCA4\uD2B8 \uD398\uC774\uC9C0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBackground(new Color(176, 224, 230));
		textField.setBounds(17, 15, 166, 49);
		panelbg.add(textField);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new EventDiscount(id).setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(Event2.class.getResource("/image2/\uB51C\uB9AC\uBC84\uB9AC \uC774\uBCA4\uD2B81.jpg")));
		button.setBackground(Color.WHITE);
		button.setBounds(192, 87, 300, 300);
		panelbg.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Event2.class.getResource("/image2/\uC5B4\uD50C\uBB38\uAD6C.png")));
		label.setBounds(17, 591, 229, 57);
		panelbg.add(label);
		
		JLabel label_1 = new JLabel("\uD68C\uC0AC : sweet deilvery");
		label_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_1.setBounds(263, 582, 196, 43);
		panelbg.add(label_1);
		
		JLabel label_2 = new JLabel("\uC8FC\uC18C : \u3147\u3147\u3147\u3147\u3147\u3147\u3147");
		label_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_2.setBounds(464, 617, 345, 43);
		panelbg.add(label_2);
		
		JLabel label_3 = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638 : 1234-15566-1245");
		label_3.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_3.setBounds(461, 582, 266, 43);
		panelbg.add(label_3);
		
		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-123-4567");
		label_4.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_4.setBounds(263, 617, 196, 43);
		panelbg.add(label_4);
		
		JLabel label_5 = new JLabel("\uC774\uBA54\uC77C : deliverysweet@naver.com");
		label_5.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_5.setBounds(263, 653, 306, 43);
		panelbg.add(label_5);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new EventDiscount(id).setVisible(true);
			}
		});
		textArea.setText("\uC774\uB2EC\uC758 \uC74C\uC2DD\uC810 \uD560\uC778 \uD655\uC778\uD558\uC790~~\r\n\r\n\uC774\uBCA4\uD2B8 \uAE30\uAC04 : 21. 00. 00 ~ 21. 00. 00");
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 16));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(192, 387, 300, 66);
		panelbg.add(textArea);
		
		JButton button_3 = new JButton("1");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Event1(id).setVisible(true);
			}
		});
		button_3.setBounds(536, 498, 43, 29);
		panelbg.add(button_3);
		
		JButton button_4 = new JButton("2");
		button_4.setBounds(596, 498, 43, 29);
		panelbg.add(button_4);
		
		JButton button_5 = new JButton("<");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Event1(id).setVisible(true); //Event1이 4가지의 생성자 값을 받아야 하는 이유는, mainPage로 돌아갈 때 4개의 값인 id, name,pw,phone,
				//address 값을 잃지 않기 위해서 이다.
				//mainPage는 branch 클래스로부터 회원가입 시 입력한 데이터(id,name,pw,phone)를를 전달받는다.
				
			}
		});
		button_5.setBounds(476, 498, 43, 29);
		panelbg.add(button_5);
		
		JButton button_6 = new JButton(">");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa = new JOptionPane();
				aa.showMessageDialog(null, "마지막 페이지입니다.");
				
			}
		});
		button_6.setBounds(656, 498, 43, 29);
		panelbg.add(button_6);
		
		JButton btnGGB = new JButton("");
		btnGGB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new EventRSPEnter(id).setVisible(true);				
			}
		});
			
		btnGGB.setIcon(new ImageIcon(Event2.class.getResource("/image2/페페페.png")));
		btnGGB.setBackground(Color.WHITE);
		btnGGB.setBounds(733, 87, 300, 300);
		panelbg.add(btnGGB);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("가위바위보!");
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Dialog", Font.BOLD, 22));
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setBounds(733, 387, 300, 66);
		panelbg.add(textArea_1);
		
		setTitle("Event2");
		setSize(1200,745);
		setVisible(true);
		
		setLocationRelativeTo(null);
	}
}
