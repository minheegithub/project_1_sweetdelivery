package payPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.CurrentUser;
import loginPackage.LoginMember;
import menuPackage.SweetDelivery;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
//결제 페이지. coupons, points, pocket1(장바구니) 클래스와 연동 된다.
public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextArea txtOption2;
	private JTextField txtFirstValue2;
	private JTextField txtCoupon;
	private JTextField txtPoint;
	private JTextField txtTotalPayment;
	
	private JLabel lblBaedal;
	private JTextField txtBaedal;	
	
	CurrentUser cu = new CurrentUser();
	
	String id, name, pw, phone, address, branch1, branch2;
	
	String userName; //유저 이름도 표시되어야 한다.	
	private JTextField txtPhone;
	private JTextField txtName;
	JTextArea txt_address;

	JPanel panel_pay; //현금, 카드 결제의 라디오 그룹이 들어가는 패널.
	
	String defPrice;
	int defaultPrice;
	
//	public static int realTotal;
	int realTotal;
	
	int cnt1;
	int cnt2;
	
	JButton btnPoint1 = new JButton("적용");
	JButton btnCoupon1 = new JButton("적용");
	
	String usePnt1;
	String resetCoupon1;
	String selectCoupon1;
	
	int find;
	String[] arrCoupon;
	
	private int minusPoint;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment("","",0,0,0,0,"","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Payment() {}
	public Payment(String usePnt, String savePoint, int cnt_1, int cnt_2,int total,int dcPrice, String selectCoupon, String resetCoupon) throws NullPointerException { //총 결제 금액이 넘어온 것.defaultPrice	
		this.cnt1 = cnt_1;
		this.cnt2 = cnt_2;
		this.usePnt1 = usePnt;
		resetCoupon1 = resetCoupon;
		selectCoupon1 = selectCoupon;
		System.out.println("리셋쿠폰"+resetCoupon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 590);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
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
		
		//배송 정보------------------------------------------------------//
		String bea[] = cu.bringUser();
		id = bea[0]; name = bea[1]; pw = bea[2]; phone = bea[3]; 
		address = bea[4]; branch1 =  bea[5]; branch2 =  bea[6];
		System.out.println("결제유저정보"+id+"+"+name+"+"+pw+"+"+phone+"+"+address+""+branch1+branch2);
		
		//기본 가격
		JLabel lbl_firstValue2 = new JLabel("기본가격");
		lbl_firstValue2.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lbl_firstValue2.setBounds(62, 62, 62, 18);
		panel.add(lbl_firstValue2);		
		
		txtFirstValue2 = new JTextField();
		txtFirstValue2.setEditable(false);
		txtFirstValue2.setBounds(142, 62, 116, 24);
		panel.add(txtFirstValue2);
		
		//장바구니에 저장된 전체금액 가져오기
		defPrice = cu.bringTotal(id);
		
		txtFirstValue2.setText(defPrice);
		defaultPrice = Integer.parseInt(defPrice);
		txtFirstValue2.setColumns(10);
		
		//전체 메뉴
		JLabel lblOption2 = new JLabel("전체 메뉴");
		lblOption2.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblOption2.setBounds(62, 106, 62, 18);
		panel.add(lblOption2);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 105, 170, 50);
		panel.add(scrollPane);
		
		txtOption2 = new JTextArea();
		scrollPane.setViewportView(txtOption2);
		
		//장바구니 상품정보 가져오기
		String[] arrProduct = cu.bringProduct(id);
		
		for (int i = 0; i < arrProduct.length; i++) {
			txtOption2.append(arrProduct[i]+"\n");
		}
		
		//할인 쿠폰----------------------------------------//
		JLabel lblCoupon = new JLabel("할인 쿠폰");
		lblCoupon.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblCoupon.setBounds(62, 294, 62, 24);
		panel.add(lblCoupon);	
		
		txtCoupon = new JTextField();
		txtCoupon.setEditable(false);
		txtCoupon.setBounds(127, 294, 160, 24);
		panel.add(txtCoupon);
		txtCoupon.setColumns(10);
		txtCoupon.setText(selectCoupon1); //초기상태.----------------> 어떤 쿠폰을 적용했는지.	
		
		
		//쿠폰 조회 버튼
		JButton btnCoupon = new JButton("조회");
		btnCoupon.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		btnCoupon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Coupons(defaultPrice, id, usePnt1, savePoint, cnt1, cnt2, realTotal).setVisible(true);
				
				dispose();
				setVisible(false);
			}
		});
		btnCoupon.setBounds(297, 296, 62, 20);
		btnCoupon.setBackground(new Color(230, 230, 250));
		panel.add(btnCoupon);	
		
		//포인트 	--------------------------------------------//	
		JLabel lblPoint = new JLabel("포인트");
		lblPoint.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblPoint.setBounds(62, 258, 55, 24);
		panel.add(lblPoint);		
						
		//포인트 조회 및 사용-> 새 창이 뜬다.
		//포인트 사용액이 주문액을 넘지 않기 위해 
		JButton btnPoint= new JButton("조회");
		btnPoint.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		btnPoint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//배송비를 포함한 총금액 계산
				txtBaedal.setText("1500원");

				System.out.println("넘겨준 총액은:"+realTotal);
				new Points(realTotal,defaultPrice,id,cnt1,cnt2, dcPrice, selectCoupon1,resetCoupon1).setVisible(true);	
				dispose();
				setVisible(false);
			}			
		});
		btnPoint.setBounds(297,260,62,20);
		btnPoint.setBackground(new Color(230, 230, 250));
		panel.add(btnPoint);
		
		txtPoint = new JTextField(); //값이 들어가는 영역
		txtPoint.setEditable(false);
		txtPoint.setBounds(127, 258, 91, 24);
		panel.add(txtPoint);
		txtPoint.setColumns(10);
		txtPoint.setText(usePnt1); //초기값을 0으로 해두었다.
		
		//배송비-----------------------------------------------------// --> 메뉴 선택에서 받아온 총금액에서 배달비를 더해야 한다.
		lblBaedal = new JLabel("배달비");
		lblBaedal.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblBaedal.setBounds(62, 167, 55, 24);
		panel.add(lblBaedal);
		
		txtBaedal = new JTextField();
		txtBaedal.setEditable(false);
		txtBaedal.setBounds(142, 167, 116, 24);
		txtBaedal.setText("1500원"); //보유한 쿠폰에 따라 배달비가 제외될 수 있다.
		panel.add(txtBaedal);
		txtBaedal.setColumns(10);
		
		//배송비를 포함한 총금액 계산
		String temp = txtBaedal.getText();
		String onlyValue = temp.substring(0,4); // "1500원" -> "1500"
		int baedal = Integer.parseInt(onlyValue); //1500
		System.out.println("배달비는"+baedal);
				
		int totalValue = defaultPrice;
		realTotal += totalValue+ baedal; //총액 잘못받은 것 수정.			
		System.out.println("총액은:"+realTotal);
				
		//총액 
		JLabel lblTotal = new JLabel("총 결제 금액");
		lblTotal.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		lblTotal.setBounds(268, 381, 116, 24);
		panel.add(lblTotal);		

		txtTotalPayment = new JTextField();
		txtTotalPayment.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtTotalPayment.setEditable(false);
		txtTotalPayment.setBounds(389, 382, 116, 24);

		panel.add(txtTotalPayment);
		txtTotalPayment.setColumns(10);

		if(cnt1 == 1){
		/*	by최민희 포인트가 이미 적용이 되었다면 쿠폰창에 갔다가 다시 돌아와도 
			포인트 부분의조회버튼과 적용버튼이 그대로 비활성화가 되어 있다. */
			System.out.println("total : "+total);
			txtTotalPayment.setText(String.valueOf(total));//포인트가 적용된 total
			this.realTotal = total;
			System.out.println("포인트가 적용된 realTotal을 보자"+realTotal);
			btnPoint1.setEnabled(false);
			btnPoint.setEnabled(false);
		}else if(cnt2 == 1) {
		/*  by최민희	쿠폰이 이미 적용이 되었다면 포인트창에 갔다가 다시 돌아와도 
			쿠폰 부분의 조회버튼과 적용버튼이 그대로 비활성화가 되어 있다. */
			System.out.println("total : "+total);
			txtTotalPayment.setText(String.valueOf(total));//쿠폰이 적용된 total
			this.realTotal = total;
			System.out.println("쿠폰이 적용된 realTotal을 보자"+realTotal);
			btnCoupon1.setEnabled(false);
			btnCoupon.setEnabled(false);
		}else {
			//포인트와 쿠폰 적용이 안된 값.
			txtTotalPayment.setText(String.valueOf(realTotal));
		}
		
		JButton btnBackPay = new JButton("");
		btnBackPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realTotal = 0;
				
				dispose(); //지금창 해제, 프레임 닫는 것
				setVisible(false); //지금창 안보이게
				new SweetDelivery(id).setVisible(true);//메뉴 선택 페이지로 되돌아간다. 
			}
		});
		btnBackPay.setIcon(new ImageIcon(Payment.class.getResource("/resource/back-button.png")));
		btnBackPay.setBounds(12, 391, 98, 74);
		btnBackPay.setBorderPainted(false);
		btnBackPay.setContentAreaFilled(false);
		btnBackPay.setFocusPainted(false);
		panel.add(btnBackPay);
		
		//라디오 버튼 체크 여부에 따라 최종 구매목록에 나타날 예정.
		//결제수단-----------------------------------------------------------------------------------//
		JLabel lblHowtoPay = new JLabel("결제 수단(현장)");
		lblHowtoPay.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblHowtoPay.setBounds(268, 417, 115, 18);
		panel.add(lblHowtoPay);			
		
		JRadioButton rb1 = new JRadioButton("현금"); 
		JRadioButton rb2 = new JRadioButton("카드");
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		
		panel_pay = new JPanel();
		panel_pay.setBounds(389, 425, 160, 60);
		panel.add(panel_pay);			
		
		panel_pay.add(rb1);
		panel_pay.add(rb2);		
		
		btnPoint1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		btnPoint1.setBackground(new Color(230, 230, 250));
		
		
		//포인트 적용 버튼
		btnPoint1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int pt = Integer.parseInt(txtPoint.getText());
				if(pt == 0) {
					JOptionPane.showMessageDialog(null, "포인트 조회를 하셔야 합니다.");
				}else {
					minusPoint = Integer.parseInt(usePnt1);
					//by최민희 총액에서 적용값 빼주기
					realTotal = realTotal - minusPoint;
					txtTotalPayment.setText(String.valueOf(realTotal));
					System.out.println("포인트 적용 후 총 금액"+realTotal);
					cnt1 = 1;//by최민희 다시 조회 했을때 이미 포인트 적용한 것을 기억하기 위해 
//					System.out.println("적용후 cnt1 : "+cnt1);
					//by최민희 성공적으로 적용이 되었을대 조회, 적용 버튼을 죽인다.
					btnPoint1.setEnabled(false);
					btnPoint.setEnabled(false);
					
					//by최민희 포인트를 적용하였기 때문에 다시 0값을 세팅한다.
					usePnt1 = "0";
					txtPoint.setText(usePnt1);
				}
			}
		});
		
	
		btnPoint1.setBounds(371, 258, 62, 25);
		panel.add(btnPoint1);
		
		//쿠폰적용버튼
		btnCoupon1.setFont(new Font("나눔바른고딕", Font.PLAIN, 13));
		btnCoupon1.setBackground(new Color(230, 230, 250));
		btnCoupon1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//by최민희 쿠폰 기본값으로 "적용하지 않음"이란 문자열을 생성자에서 미리 넘겨
				if(txtCoupon.getText().equals("적용하지 않음")) {
					JOptionPane.showMessageDialog(null, "쿠폰 조회를 하셔야 합니다.");

				}else {
					
					realTotal = total; 
					realTotal -= dcPrice;
					txtTotalPayment.setText(String.valueOf(realTotal));
					System.out.println("쿠폰적용후 총금액"+realTotal);
					cnt2 = 1;//다시 조회 했을때 이미 쿠폰 적용한 것을 기억하기 위해 
//					System.out.println("적용후 cnt2 : "+cnt2);
					//by최민희 성공적으로 적용이 되었을대 조회, 적용 버튼을 죽인다.
					btnCoupon1.setEnabled(false);
					btnCoupon.setEnabled(false);
				}
				
			}
		});
		btnCoupon1.setBounds(371, 295, 62, 25);
		panel.add(btnCoupon1);
		
		
		JButton btnComplete = new JButton("주문하기");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path0 =".\\src\\resource\\rewards\\"+id+"Point.txt";
				
				FileReader fr = null;
				BufferedReader br = null;
				int savePnt = 0;
				try {
					fr = new FileReader(new File(path0));
					br = new BufferedReader(fr);	
					
					String readPoint = br.readLine();
					
					//by최민희 파일에 포인트가 없을 경우
					if(readPoint == null)
						readPoint = "0";
						
					savePnt = Integer.parseInt(readPoint) - minusPoint;
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					if(br != null) {
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				
				//by최민희 포인트 사용한거 새로 작성
				FileWriter writer = null;
				String message = String.valueOf(savePnt); //잔여액을 파일에 쓰기 위해 문자열로 바꾸었다.
				try {
					//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
					writer = new FileWriter(path0,false); 
					writer.write(message);					
					writer.flush();					
					System.out.println("포인트 사용 후 잔여액으로 다시 저장:"+message+"원");
				}catch(IOException e1) {
					e1.printStackTrace();
				}finally {
					try {
						if(writer !=null) writer.close();
					}catch(IOException e2) {
						e2.printStackTrace();
					}
				}
				
				//사용한 쿠폰 파일에서 지우기 
				String path = ".\\src\\resource\\rewards\\"+id+"Coupon.txt";
				
				FileReader fr1 = null;
				BufferedReader br1 = null;
				
				try {
					
					//by최민희 쿠폰을 사용하였을경우에만 기존쿠폰값을 읽어오자
					//by최민희 쿠폰값이 초기값으로 두었던 ""이 아니라면 저장된 쿠폰을 재 새팅해야 한다.	
					if(resetCoupon1 != "") {
							fr1 = new FileReader(new File(path));
							br1 = new BufferedReader(fr1);	
							
							arrCoupon = br1.readLine().split("/");
							for (int i = 0; i < arrCoupon.length; i++) {
								//by최민희 사용한 쿠폰과 저장된 쿠폰이 일치한 배열의 인덱스 번호를 find에 저장한다.
								if(arrCoupon[i].equals(resetCoupon1)) {
									find = i;
									System.out.println("사용한 쿠폰 찾았니?"+arrCoupon[i]);
									break;
								}
							}
						}
						
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					if(br1 != null) {
						try {
							br1.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}
				
				FileWriter writer1 = null;
				try {
					//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
						if(resetCoupon1 != "") {
							
							writer1 = new FileWriter(path,false); 
							for (int i = 0; i < arrCoupon.length; i++) {
							//by최민희 앞서 사용한 쿠폰의 인덱스 번호를 저장한 find변수를 이용해 사용한 쿠폰만 빼고 나머지 쿠폰들을 재저장하는 로직이다.	
								if(i == find) {
									continue;
								}
								writer1.write(arrCoupon[i]+"/");					
							}
							writer1.flush();					
							System.out.println("쓰기 성공하였습니다.");
						}
					
				}catch(IOException e1) {
					e1.printStackTrace();
				}finally {
					try {
						if(writer1 !=null) writer1.close();
					}catch(IOException e2) {
						e2.printStackTrace();
					}
				}
				
				//수단
				Enumeration<AbstractButton> enums = group.getElements();
				String gibonSelect=null;
				while(enums.hasMoreElements()) {                 // hasMoreElements() Enum에 더 꺼낼 개체가 있는지 체크.
				    AbstractButton ab = enums.nextElement();    
				    JRadioButton jb = (JRadioButton)ab;         // 형변환. 물론 윗줄과 이줄을 합쳐서 바로 형변환 해서 받아도 된다.
				 
				    if(jb.isSelected())                         // 받아낸 라디오버튼의 체크 상태를 확인한다. 체크되었을경우 true 반환.
				    	gibonSelect = jb.getText().trim(); //getText() 메소드로 문자열 받아낸다. 카드를 선택했으면 "카드" 문자열 값을 가지고 있다.		    
				}	
							
				
				dispose();
				setVisible(false);
				new Order_History(gibonSelect, realTotal).setVisible(true);
			}
		});
		btnComplete.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		btnComplete.setBackground(new Color(230, 230, 250));
		btnComplete.setBounds(610, 460, 116, 28);
		panel.add(btnComplete);
		
		JLabel lbBranch2 = new JLabel("스위트 딜리버리");
		lbBranch2.setBounds(110,420 ,150 ,40 );
		lbBranch2.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		panel.add(lbBranch2);
		
		JLabel lbBranch3 = new JLabel(branch1+branch2);
		lbBranch3.setBounds(110, 450, 170, 40);
		lbBranch3.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		panel.add(lbBranch3);
		
		JLabel lblAddress = new JLabel("배송 주소");
		lblAddress.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblAddress.setBounds(504, 106, 55, 18);
		panel.add(lblAddress);
		
		txt_address = new JTextArea();
		txt_address.setBounds(550, 124, 210, 43);
		panel.add(txt_address);
		//
		txt_address.setText(address);
		
		JLabel lblPhone = new JLabel("휴대폰");
		lblPhone.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblPhone.setBounds(504, 188, 55, 18);
		panel.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(550, 187, 136, 24);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		//
		txtPhone.setText(phone);
		
		JLabel lbBranch = new JLabel("지점");
		lbBranch.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lbBranch.setBounds(504, 240, 55, 18);
		panel.add(lbBranch);
		
		JTextField txtBranch = new JTextField();
		txtBranch.setText(branch1+branch2);
		txtBranch.setColumns(10);
		txtBranch.setBounds(548, 240, 114, 24);
		panel.add(txtBranch);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(504, 62, 55, 18);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(548, 60, 114, 24);
		panel.add(txtName);
		txtName.setColumns(10);
		//
		txtName.setText(name);
		//------------------------------------------------------------//
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setBounds(450, 57, 1, 290);
		panel.add(panel1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(30, 349, 792, 1);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("상품 정보");
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		lblNewLabel_1.setBounds(30, 31, 91, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("배송 정보");
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		lblNewLabel_2.setBounds(465, 31, 84, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("혜택 적용");
		lblNewLabel_3.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		lblNewLabel_3.setBounds(30, 228, 70, 18);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 206, 421, 1);
		panel.add(panel_2);
		
		setLocationRelativeTo(null);
	}
	
	
}
