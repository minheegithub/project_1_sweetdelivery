package payPackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
//포인트 조회 버튼을 누르면 나오는 화면. 보유 포인트, 사용하는 포인트-> 입력받는다, 사용 후 잔여 포인트를 계산.
//
public class Points extends JFrame {

	private JPanel contentPane;

	private JTextField txtNow;
	private JTextField txtUse;
	private JTextArea textArea;
	private JButton btnTouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Points frame = new Points(10000,0,"",0,0,0,"",""); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Points(int total, int defaultPrice, String id, int cnt1, int cnt2, int dcPrice, String selectCoupon, String resetCoupon) {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("포인트 조회");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food2.jpg")).getImage();

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(0, 0, 693, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPoint = new JLabel("보유 포인트");
		lblPoint.setBounds(38, 53, 97, 18);
		panel.add(lblPoint);
		
		//보유 포인트 - 텍스트 파일에서 읽어오기
		String path =".\\src\\resource\\rewards\\"+id+"Point.txt";
		int existingValue=0; //=0을 지움
		DataInputStream dis = null;
		try {
		 	dis = new DataInputStream(new FileInputStream(path));
		 			String text;
					text = dis.readLine();
					
			 		existingValue = Integer.parseInt(text);				 		
			 		System.out.println("현존 포인트:"+existingValue);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "보유하신 포인트가 없습니다. 이벤트에 참여해 주세요");
		}
		System.out.println("현재 보유한 포인트:"+existingValue); //정수값
		String nowValue = String.valueOf(existingValue); //문자열값
		System.out.println("현재 보유한 포인트를 문자열로 바꾼 값:"+nowValue);
		 
		txtNow = new JTextField();
		txtNow.setEditable(false);
		txtNow.setBounds(180, 50, 116, 24);
		panel.add(txtNow);
		txtNow.setColumns(10);
		txtNow.setText(nowValue);
		System.out.println("화면에 나타난 포인트 값은"+txtNow.getText()); //화면에 나타난 포인트 값 
		//-------------------------------------------------
		btnTouse = new JButton("사용하기");
		btnTouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
														
				int use = Integer.parseInt(txtUse.getText());
				int now = Integer.parseInt(txtNow.getText());
				System.out.println("넘겨받은 총액은"+total);
				if(use<0 || use>now ) {
					JOptionPane.showMessageDialog(null,"올바른 값을 넣어주세요");	
					txtUse.setText("0");
					textArea.setText(txtNow.getText());
				}else if(use>total) {
					JOptionPane.showMessageDialog(null,"총 금액보다 작은 값을 넣어주세요");	 //물품 가격보다 많은 포인트를 입력했을 경우 메시지창이 뜬다.
					txtUse.setText("0");
					textArea.setText(txtNow.getText()); //잔여 포인트도 제대로 되돌려준다.
				}else if(use>=0 && use<=now && use<=total) {
					textArea.setText(String.valueOf(now-use)); //올바르게 입력된 경우, 포인트 잔액이 표시된다.
				}else {
					JOptionPane.showMessageDialog(null,"올바른 값을 넣어주세요");	
					txtUse.setText("0");
					textArea.setText(txtNow.getText());
					
				}

			}
		});
		btnTouse.setFont(new Font("굴림", Font.PLAIN, 13));
		btnTouse.setBounds(26, 97, 97, 36);
		panel.add(btnTouse);		
		
		txtUse = new JTextField();   //쓰고 싶은 만큼 입력할 수 있음.사용액이 표시되는 부분.		
		txtUse.setBounds(180, 103, 116, 24);
		panel.add(txtUse);
		txtUse.setColumns(10);	
		txtUse.setText("0");
		
		//잔여포인트-----------------------------------------//
		JLabel lblNewLabel_1 = new JLabel("잔여 포인트");
		lblNewLabel_1.setBounds(38, 171, 97, 18);
		panel.add(lblNewLabel_1);	
				
		textArea = new JTextArea(); //잔여 포인트
		textArea.setEditable(false);
		textArea.setText(txtNow.getText());
		textArea.setBounds(180, 169, 116, 24);
		panel.add(textArea);		
		
		JButton btnBacktoPay = new JButton("확인");
		btnBacktoPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("사용할 포인트는:"+txtUse.getText());				
				//확인 버튼을 눌렀으면 포인트 잔여 포인트가 다시 텍스트 파일에 기록되어야 한다.
			
				Payment pay = new Payment(txtUse.getText(),textArea.getText(),cnt1,cnt2,total, dcPrice, selectCoupon,resetCoupon);
				pay.setVisible(true);
				//그리고 창을 닫는다.
				dispose();
				setVisible(false); //지금창 안보이게						
			}
		});
		btnBacktoPay.setBounds(332, 214, 61, 27);
		panel.add(btnBacktoPay);
		setLocationRelativeTo(null);
	}

}
