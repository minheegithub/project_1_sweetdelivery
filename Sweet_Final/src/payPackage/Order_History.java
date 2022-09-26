package payPackage;
//주문 내역
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.CurrentUser;
import loginPackage.LoginMember;
import mainPackage.MainPage;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Order_History extends JFrame {

	private JPanel contentPane;
	
	String currentId, name, pw, phone, address, branch1, branch2;
	
	File file4 = new File(".\\src\\resource\\Text\\receipt.txt");  //장바구니에 담긴 총금액이 저장된다.
	String order_time;
	
	CurrentUser cu = new CurrentUser();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_History frame = new Order_History("현금/카드");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Order_History(String howToPay) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/menu1.jpg")).getImage();

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
		
		//시간---------------------------------------------------------
		JLabel lblNewLabel_5 = new JLabel("주문 완료 시간");
		lblNewLabel_5.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(63, 331, 113, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblTime = new JLabel("주문 완료 시간 텍스트");
		lblTime.setForeground(new Color(0, 128, 128));
		lblTime.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		lblTime.setBounds(63, 349, 260, 24);
		panel.add(lblTime);
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		order_time = format.format (System.currentTimeMillis());
		lblTime.setText(order_time);
		
		String bea[] = cu.bringUser();
		
		currentId = bea[0]; name = bea[1]; pw = bea[2]; phone = bea[3]; 
		address = bea[4]; branch1 =  bea[5]; branch2 =  bea[6];
		System.out.println("마지막 유저정보"+currentId+"+"+name+"+"+pw+"+"+phone+"+"+address+"+"+branch1+branch2);
		
		//by최민희 영수증 작성
		String arrProduct[] = cu.bringProduct(currentId);
		String arrCost[] = cu.bringCost(currentId);
		String total = cu.bringTotal(currentId);
		String receipt = "============================\n"
				+"스위트 딜리버리("+branch1+branch2+")\n"
				+ order_time+"("+currentId+"님)\n"
				+ "-------------------------------------\n"
				+ "[배송지 정보] \n"+address+"\n"
				+ "-------------------------------------\n";
		
		for (int i = 0; i < arrProduct.length; i++) {
			receipt += arrProduct[i]+"("+arrCost[i]+")\n";
		}
		
		receipt += "배달비 (1500원)\n"
				+ "--------------------------------------\n"
				+ "합계(쿠폰/포인트 적용)   "+total+"원\n"
				+ "============================\n\n";
		BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(".\\src\\resource\\Text\\receipt.txt",true));
				bw.write(receipt);
				
			} catch (IOException e1) {					
				e1.printStackTrace();
			} finally {
				try {
					if(bw != null) {bw.close();}
				} catch (IOException e1) {							
					e1.printStackTrace();
				}					
		}//try-catch
		File file = new File(".\\src\\resource\\Text\\"+currentId+"Cost.txt"); 
		File file2 = new File(".\\src\\resource\\Text\\"+currentId+"Product.txt");
		File file3 = new File(".\\src\\resource\\Text\\"+currentId+"Total.txt"); 
		//장바구니 내용 지우기
		FileWriter writer = null;
		FileWriter writer2 = null;
		FileWriter writer3 = null;
		try {
			//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
			writer = new FileWriter(file,false); 
			writer.write("");					
			writer.flush();					
			writer2 = new FileWriter(file2,false); 
			writer2.write("");					
			writer2.flush();					
			writer3 = new FileWriter(file3,false); 
			writer3.write("0");					
			writer3.flush();					
		}catch(IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(writer !=null) writer.close();
			}catch(IOException e2) {
				e2.printStackTrace();
			}
		}
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Order_History.class.getResource("/resource/delivery-man.png")));
		lblNewLabel_3.setBounds(261, 303, 88, 90);
		panel.add(lblNewLabel_3);

		//-----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Order_History.class.getResource("/projectimage/어플문구.png")));
		lblNewLabel.setBounds(37, 12, 232, 67);
		panel.add(lblNewLabel);
		
		JLabel lbTotal1 = new JLabel("총");
		lbTotal1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbTotal1.setBounds(63, 80, 300, 18);
		panel.add(lbTotal1);
		
		JLabel lbTotalP = new JLabel(total);
		lbTotalP.setFont(new Font("나눔바른고딕", Font.PLAIN, 17));
		lbTotalP.setForeground(new Color(0, 128, 128));
		lbTotalP.setBounds(80, 78, 300, 18);
		panel.add(lbTotalP);
		
		JLabel lbTotal = new JLabel("원 결제 도와드렸습니다.");
		lbTotal.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 13));
		lbTotal.setBounds(159, 80, 300, 18);
		panel.add(lbTotal);
		
		JLabel lblUserName = new JLabel("유저 이름");
		lblUserName.setForeground(new Color(0, 128, 128));
		lblUserName.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 16));
		lblUserName.setBounds(63, 105, 88, 20);
		panel.add(lblUserName);
		lblUserName.setText(currentId);
		
		JLabel lblNewLabel_1 = new JLabel("님");
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(159, 106, 62, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lbAddress1 = new JLabel("지정하신 주소인");
		lbAddress1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbAddress1.setBounds(63, 130, 146, 18);
		panel.add(lbAddress1);
		
		JLabel lbAddress2 = new JLabel(address);
		lbAddress2.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbAddress2.setForeground(new Color(0, 128, 128));
		lbAddress2.setBounds(63, 150, 300, 18);
		panel.add(lbAddress2);
		
		JLabel lbAddress3 = new JLabel("으로 곧 따뜻한 음식이 도착합니다.");
		lbAddress3.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbAddress3.setBounds(63, 170, 300, 18);
		panel.add(lbAddress3);
		
		JLabel lblNewLabel_2 = new JLabel("택하신 현장 결제 방식인");
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(63, 210, 169, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblHowtoPay = new JLabel("현금/카드");
		lblHowtoPay.setForeground(new Color(0, 128, 128));
		lblHowtoPay.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 15));
		lblHowtoPay.setBounds(206, 210, 81, 18);
		panel.add(lblHowtoPay);
		lblHowtoPay.setText(howToPay);  //결제 페이지에서 선택한 현금 또는 카드 결제 방식 값이 들어온다.
	
		JLabel lblNewLabel_4 = new JLabel("미리 준비해주세요.");
		lblNewLabel_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(63, 230, 146, 18);
		panel.add(lblNewLabel_4);
		
		JLabel lbBranch = new JLabel("스위트 딜리버리 ");
		lbBranch.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbBranch.setBounds(63, 270, 300, 18);
		panel.add(lbBranch);
		
		JLabel lbBranch1 = new JLabel(branch1+branch2);
		lbBranch1.setForeground(new Color(0, 128, 128));
		lbBranch1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		lbBranch1.setBounds(63, 290, 300, 18);
		panel.add(lbBranch1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(37, 63, 352, 330);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("메인 홈으로 가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				try {
					new MainPage(currentId).setVisible(true);
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.setBounds(141, 418, 169, 27);
		panel.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}
}
