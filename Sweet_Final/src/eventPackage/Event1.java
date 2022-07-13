package eventPackage; //이벤트 패키지는 메인화면 상단의 이벤트 버튼을 눌렀을 때 나오는 클래스들을 갖고 있다.
//이벤트 페이지 메인 .
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import loginPackage.UserInfo;
import mainPackage.MainPage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Event1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Event1 frame = new Event1("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Event1(String id) {
		System.out.println("event1 id"+id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1159, 746);
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(176, 224, 230));
		textField.setFont(new Font("굴림", Font.BOLD, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\uC774\uBCA4\uD2B8 \uD398\uC774\uC9C0");
		textField.setBounds(17, 15, 166, 49);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new EventFoundation(id).setVisible(true); //창립 기념 5000P획득 화면으로 전환.
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Event1.class.getResource("/image2/\uBB34\uC57C\uD638 \uC774\uBCA4\uD2B8.jpg")));
		btnNewButton.setBounds(192, 87, 300, 300);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Event1.class.getResource("/image2/\uC5B4\uD50C\uBB38\uAD6C.png")));
		lblNewLabel.setBounds(17, 591, 229, 57);
		panel.add(lblNewLabel);
		
		JButton btnbutton = new JButton("");
		btnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new EventGoGoEnter(id).setVisible(true);
			}
		});
		btnbutton.setForeground(Color.WHITE);
		btnbutton.setBackground(Color.WHITE);
		btnbutton.setIcon(new ImageIcon(Event1.class.getResource("/image2/\uB124\uC774\uC2A4\uD55C \uC774\uBCA4\uD2B83.jpg")));
		btnbutton.setBounds(684, 87, 300, 300);
		panel.add(btnbutton);
		
		JButton btnGoback = new JButton("\uD648\uD654\uBA74 \uC774\uB3D9");
		btnGoback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false); //지금창 안보이게
				try {
					new MainPage(id).setVisible(true); //메인페이지로 돌아간다.
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
				
			}
		});
		btnGoback.setBackground(new Color(135, 206, 250));
		btnGoback.setForeground(Color.WHITE);
		btnGoback.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 18));
		btnGoback.setBounds(931, 582, 173, 49);
		panel.add(btnGoback);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC0AC : sweet deilvery");
		lblNewLabel_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		lblNewLabel_1.setBounds(263, 582, 196, 43);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC8FC\uC18C : \u3147\u3147\u3147\u3147\u3147\u3147\u3147");
		label.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label.setBounds(464, 617, 345, 43);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638 : 1234-15566-1245");
		label_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_1.setBounds(461, 582, 266, 43);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-123-4567");
		label_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_2.setBounds(263, 617, 196, 43);
		panel.add(label_2);
		
		JLabel lblDeliverysweetnavercom = new JLabel("\uC774\uBA54\uC77C : deliverysweet@naver.com");
		lblDeliverysweetnavercom.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		lblDeliverysweetnavercom.setBounds(263, 653, 306, 43);
		panel.add(lblDeliverysweetnavercom);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new EventFoundation(id).setVisible(true);
			}
		});
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 14));
		textArea.setText("무야호~~ 창립 기념 포인트 쏜다! 들어와!\r\n\r\n이벤트 기간 : 21. 00. 00 ~ 21. 00. 00");
		textArea.setBounds(192, 387, 300, 66);
		panel.add(textArea);
		
		JTextArea txtrNice = new JTextArea();
		txtrNice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new EventGoGoEnter(id).setVisible(true);
			}
		});
		txtrNice.setText("NICE~~ \uD558\uB8E8\uC5D0 \uD55C\uBC88 \uC6B4\uC744 \uC2DC\uD5D8\uD574\uBD10~~~!\r\n\r\n\uC774\uBCA4\uD2B8 \uAE30\uAC04 : 21. 00. 00 ~ 21. 00. 00");
		txtrNice.setForeground(Color.WHITE);
		txtrNice.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 14));
		txtrNice.setBackground(Color.LIGHT_GRAY);
		txtrNice.setBounds(684, 387, 300, 66);
		panel.add(txtrNice);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setBounds(536, 498, 43, 29);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Event2(id).setVisible(true);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(596, 498, 43, 29);
		panel.add(button);
		
		JButton button_2 = new JButton("<");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa = new JOptionPane();
				aa.showMessageDialog(null, "첫 페이지 입니다.");
			}
		});
		button_2.setBounds(476, 498, 43, 29);
		panel.add(button_2);
		
		JButton button_3 = new JButton(">");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Event2(id).setVisible(true);
			}
		});
		button_3.setBounds(656, 498, 43, 29);
		panel.add(button_3);

		setTitle("Event1");
		setSize(1200,745);
		setVisible(true);
		
		
		setLocationRelativeTo(null);
		
	}
}
