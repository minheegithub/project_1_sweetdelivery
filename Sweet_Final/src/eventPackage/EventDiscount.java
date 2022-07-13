package eventPackage;
//5월 이벤트 중인 메뉴들 + 바로 주문하러 가기
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import menuPackage.SweetDelivery;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventDiscount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventDiscount frame = new EventDiscount("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EventDiscount(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 471);
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
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Event2(id).setVisible(true);
			}
		});
		button_1.setForeground(new Color(240, 255, 255));
		button_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 22));
		button_1.setBackground(new Color(135, 206, 250));
		button_1.setBounds(61, 38, 164, 43);
		panelbg.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EventDiscount.class.getResource("/image2/\uC5B4\uD50C\uBB38\uAD6C.png")));
		label.setBounds(0, 579, 243, 57);
		panelbg.add(label);
		
		JLabel label_1 = new JLabel("\uC774\uBA54\uC77C : deliverysweet@naver.com");
		label_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_1.setBounds(263, 646, 306, 43);
		panelbg.add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638 : 02-123-4567");
		label_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_2.setBounds(263, 610, 196, 43);
		panelbg.add(label_2);
		
		JLabel label_3 = new JLabel("\uD68C\uC0AC : sweet deilvery");
		label_3.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_3.setBounds(263, 575, 196, 43);
		panelbg.add(label_3);
		
		JLabel label_4 = new JLabel("\uC8FC\uC18C : \u3147\u3147\u3147\u3147\u3147\u3147\u3147");
		label_4.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_4.setBounds(464, 610, 345, 43);
		panelbg.add(label_4);
		
		JLabel label_5 = new JLabel("\uC0AC\uC5C5\uC790 \uBC88\uD638 : 1234-15566-1245");
		label_5.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 13));
		label_5.setBounds(444, 575, 266, 43);
		panelbg.add(label_5);
		
		textField = new JTextField();
		textField.setText("5월의 할인 이벤트 ~~~!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("나눔스퀘어", Font.BOLD, 30));
		textField.setColumns(10);
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(407, 29, 391, 57);
		panelbg.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(175, 238, 238));
		textField_1.setFont(new Font("배달의민족 연성", Font.BOLD, 23));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("\uCE58\uD0A8");
		textField_1.setBounds(329, 132, 83, 57);
		panelbg.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("\uD53C\uC790");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("배달의민족 연성", Font.BOLD, 23));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(175, 238, 238));
		textField_2.setBounds(329, 204, 83, 57);
		panelbg.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("\uD55C\uC2DD");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("배달의민족 연성", Font.BOLD, 23));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(175, 238, 238));
		textField_3.setBounds(329, 276, 83, 57);
		panelbg.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("\uC9DC\uC7A5\uBA74");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("배달의민족 연성", Font.BOLD, 23));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(175, 238, 238));
		textField_4.setBounds(329, 348, 83, 57);
		panelbg.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("\uC591\uC2DD");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("배달의민족 연성", Font.BOLD, 23));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(175, 238, 238));
		textField_5.setBounds(329, 420, 83, 57);
		panelbg.add(textField_5);
		
		JButton btnNewButton = new JButton("바로 주문하기!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SweetDelivery(id).setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(240, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 23));
		btnNewButton.setBounds(573, 478, 186, 57);
		panelbg.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u3141\u3141\uCE58\uD0A8 / bab\uCE58\uD0A8 / \u3147\u3147\uCE58\uD0A8");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setLabelFor(textField_1);
		lblNewLabel.setFont(new Font("타이포_크레파스 M", Font.BOLD, 23));
		lblNewLabel.setBounds(444, 132, 444, 57);
		panelbg.add(lblNewLabel);
		
		JLabel lblMaster = new JLabel("\uC62C\uB9BC \uD53C\uC790 / master\uD53C\uC790  / 39\uD53C\uC790");
		lblMaster.setForeground(Color.BLACK);
		lblMaster.setFont(new Font("타이포_크레파스 M", Font.BOLD, 23));
		lblMaster.setBackground(Color.LIGHT_GRAY);
		lblMaster.setBounds(444, 204, 444, 57);
		panelbg.add(lblMaster);
		
		JLabel label_7 = new JLabel("\uAC00\uC815\uC9D1 \uBC31\uBC18 /  \uD765\uBD80 \uBD80\uB300\uCC0C\uAC1C");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("타이포_크레파스 M", Font.BOLD, 23));
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setBounds(444, 276, 444, 57);
		panelbg.add(label_7);
		
		JLabel label_8 = new JLabel("\uBC88\uAC1C\uBC18\uC810 / \uD64D\uCF69\uBC18\uC810");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("타이포_크레파스 M", Font.BOLD, 23));
		label_8.setBackground(Color.LIGHT_GRAY);
		label_8.setBounds(444, 348, 444, 57);
		panelbg.add(label_8);
		
		JLabel label_9 = new JLabel("\uB3C8\uAE4C\uC2A4\uD138\uAE30 / \uC218\uC81C \uBC84\uAC70 / \uC2A4\uD14C\uC774\uD06C\uC9D1");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("타이포_크레파스 M", Font.BOLD, 23));
		label_9.setBackground(Color.LIGHT_GRAY);
		label_9.setBounds(444, 420, 444, 57);
		panelbg.add(label_9);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(EventDiscount.class.getResource("/image2/06_냥바타콘_100x100_09_침.png")));
		label_6.setBounds(666, 312, 117, 128);
		panelbg.add(label_6);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(EventDiscount.class.getResource("/image2/04_모코코콘2_ㄹㅇ.gif")));
		label_10.setBounds(850, 38, 117, 91);
		panelbg.add(label_10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EventDiscount.class.getResource("/image2/restaurant.png")));
		lblNewLabel_1.setBounds(44, 439, 166, 128);
		panelbg.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 559, 1182, 24);
		panelbg.add(textArea);
		
		
		setTitle("Event5");
		setSize(1200,745);
		setVisible(true);
		setLocationRelativeTo(null);	
	}
}
