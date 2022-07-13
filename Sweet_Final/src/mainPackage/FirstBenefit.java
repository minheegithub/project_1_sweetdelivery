package mainPackage;
//첫 구매자 혜택.
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import loginPackage.LoginMember;
import payPackage.Rewards;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FirstBenefit extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstBenefit frame = new FirstBenefit("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FirstBenefit(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 524);
		setTitle("[Sweet Delivery] 신규 고객 | 스위트 딜리버리 ");
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
		
		JButton btnBackFirst = new JButton("");
		btnBackFirst.addActionListener(new ActionListener() {
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
		btnBackFirst.setIcon(new ImageIcon(FirstBenefit.class.getResource("/resource/back-button.png")));
		btnBackFirst.setBounds(38, 370, 105, 73);
		btnBackFirst.setBorderPainted(false);
		btnBackFirst.setContentAreaFilled(false);
		btnBackFirst.setFocusPainted(false);
		panel.add(btnBackFirst);	
		
		//쿠폰 발급 버튼
		JButton btnCouponFirst = new JButton(""); //프로젝트 폴더에 안들어가서 로컬에서 가져옴.
//		btnCouponFirst.setForeground(Color.BLUE);
		btnCouponFirst.setIcon(new ImageIcon(FirstBenefit.class.getResource("/resource/coupon.png")));
		btnCouponFirst.setBounds(136, 224, 117, 70);
		//btnCouponFirst.setBorderPainted(false);
		btnCouponFirst.setContentAreaFilled(false);
		btnCouponFirst.setFocusPainted(false);
		panel.add(btnCouponFirst);
		
		btnCouponFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"20% 할인 쿠폰이 발급되었습니다🎉😁");	
				Rewards rw = new Rewards(0.20,"첫 구매자 혜택");
				rw.WriteToFile(0.20, "1st visit",id);	
				
				btnCouponFirst.setEnabled(false);
				
				String path = ".\\src\\resource\\event\\"+id+"First.txt";
				
				File  f = new File(path);
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//포인트 발급 버튼
		JButton btnPointFirst = new JButton("");
		btnPointFirst.setForeground(Color.BLUE);
		btnPointFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"3000P가 발급되었습니다🎉😁");	
				Rewards rwp = new Rewards(3000);//?????생성자에 값을 넣을 필요가 없는것 같다.
				rwp.WriteToFile(3000,id);
				
				btnPointFirst.setEnabled(false);
				
				String path = ".\\src\\resource\\event\\"+id+"PtFirst.txt";
				
				File  f = new File(path);
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPointFirst.setIcon(new ImageIcon(FirstBenefit.class.getResource("/resource/basket.png")));
		btnPointFirst.setBounds(363, 224, 117, 70);		
		//btnPointFirst.setBorderPainted(false);
		btnPointFirst.setContentAreaFilled(false);
		btnPointFirst.setFocusPainted(false);
		panel.add(btnPointFirst);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		String text = "               스위트 배달이 처음이신가요?\r\n"
					+ "     \t        아래의 혜택을 누리세요\r\n"
					+ "    ---------------------------------------------------------\r\n\t\r\n"
					+ "\t20%할인 쿠폰\t   3000P 발급\r\n\r\n\r\n\r\n\r\n"
					+ "    ---------------------------------------------------------    \r\n\r\n";
		textPane.setText(text);
		textPane.setBounds(38, 49, 547, 394);
		panel.add(textPane);
		
		String path = ".\\src\\resource\\event\\"+id+"First.txt";
		String path2 = ".\\src\\resource\\event\\"+id+"PtFirst.txt";
		
		File  f1 = new File(path);
		File  f2 = new File(path2);
		
		if(f1.exists() && f2.exists()) {
			btnCouponFirst.setEnabled(false);
			btnPointFirst.setEnabled(false);
			JOptionPane.showMessageDialog(null, "이미 참여하신 이벤트 입니다.");
		}else if(f2.exists()) {
			btnPointFirst.setEnabled(false);
		}else if(f1.exists()){
			btnCouponFirst.setEnabled(false);
		}
		
		setLocationRelativeTo(null);
	}
}
