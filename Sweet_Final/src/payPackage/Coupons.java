package payPackage; //MainPackage는 mainpage 메인 화면에 관련된 클래스들을 갖고 있다.
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class Coupons extends JFrame {

	private JPanel contentPane;	
	private JTextField txtOnlyProduct;
	private JTextField txtDiscountPrice;
	JComboBox <CouponSetting> cmbCouponlist;
	JButton btnUseCoupon;
	JButton btnReturn;
	
	String[] arrCoupon;
	String arrC[];
	
	String selectCoupon1 = "적용하지 않음";
	int dcPrice1;
	String resetCoupon1 = "";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coupons frame = new Coupons(1000,"","","",0,0,0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Coupons(){}
	public Coupons(int defaultPrice,String id,String usePnt, String savePoint,int cnt,int cnt2,int total) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("쿠폰 조회");
		setBounds(100, 100, 544, 380);
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
		
	
		//상품 가격
		JLabel lblOnlyProduct = new JLabel("상품 가격");
		lblOnlyProduct.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblOnlyProduct.setBounds(24, 40, 62, 18);
		panel.add(lblOnlyProduct);
		
		txtOnlyProduct = new JTextField();
		txtOnlyProduct.setEditable(false);
		txtOnlyProduct.setBounds(86, 36, 116, 24);
		panel.add(txtOnlyProduct);
		txtOnlyProduct.setColumns(10);
		txtOnlyProduct.setText(String.valueOf(defaultPrice));	
		
		//쿠폰 조회
		JLabel lblCouponlist = new JLabel("적용 쿠폰");
		lblCouponlist.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblCouponlist.setBounds(24, 100, 62, 18);
		panel.add(lblCouponlist);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 166, 119, -77);
		panel.add(scrollPane);
		
		JComboBox <CouponSetting> cmbCouponlist = new JComboBox();
		cmbCouponlist.setBackground(new Color(230, 230, 250));
		cmbCouponlist.setBounds(86, 96, 228, 24);
		panel.add(cmbCouponlist);
		
	
		String path = ".\\src\\resource\\rewards\\"+id+"Coupon.txt";
		ArrayList<CouponSetting> cs = new ArrayList<CouponSetting>();			
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(new File(path));
			br = new BufferedReader(fr);	
			String readCoupon = br.readLine();
			if(readCoupon != null) {
				
				arrCoupon = readCoupon.split("/");								
				
				for (int i = 0; i < arrCoupon.length; i++) {
					arrC = arrCoupon[i].split(",");
					cs.add(new CouponSetting(Double.parseDouble(arrC[0]),arrC[1])); 			
				}
			}else {
				JOptionPane.showMessageDialog(null, "보유하신 쿠폰이 없습니다.");
			}
				

			System.out.println("cs사이즈" +cs.size());
			
			
		}catch(Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "보유하신 쿠폰이 없습니다. 이벤트에 참여해 주세요");
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
	
		
		for(int i=0;i<cs.size();i++) {
			System.out.println(cs.get(i).getCouponName()+":"+cs.get(i).getDiscount_percent());
		}
		//콤보박스에 넣기 
		for(int i=0;i<cs.size();i++) {
			cmbCouponlist.addItem(new CouponSetting(cs.get(i).getDiscount_percent(),cs.get(i).getCouponName()));
		}
		
			
		cmbCouponlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== cmbCouponlist) {
					//할인 금액 계산
					//선택된 값 그대로 뽑는 방법.
					//txtDiscountPrice.setText(cmbCouponlist.getSelectedItem().toString());
					//System.out.println(cmbCouponlist.getSelectedItem());					
					int productPrice = Integer.parseInt(txtOnlyProduct.getText()); //상품 가격
					
					String[] setting = cmbCouponlist.getSelectedItem().toString().split(":");
					System.out.println("선택값 : "+cmbCouponlist.getSelectedItem());
					
					String percent_s = setting[1].substring(0,2); // 20%할인 -> 20을 추출.
				    double percent  = Integer.parseInt(percent_s)/100.00;
					
					int discountPrice = (int)(productPrice * percent);
					txtDiscountPrice.setText(String.valueOf(discountPrice)); //할인되는 가격. 원가 * 할인 퍼센트.					
				}				
			}			
		});		
		
		//할인 가격 계산
		JLabel lblDiscountPrice = new JLabel("원    할인 적용");
		lblDiscountPrice.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblDiscountPrice.setBounds(180, 145, 92, 18);
		panel.add(lblDiscountPrice);
		
		txtDiscountPrice = new JTextField();
		txtDiscountPrice.setEditable(false);
		txtDiscountPrice.setBounds(86, 141, 87, 24);
		panel.add(txtDiscountPrice);
		txtDiscountPrice.setColumns(10);
		
		btnUseCoupon = new JButton("사용하기");
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("쿠폰으로 차감할 구매비용은:"+txtDiscountPrice.getText());
				System.out.println("선택된 쿠폰은:"+cmbCouponlist.getSelectedItem().toString());
				
				int dcPrice = Integer.parseInt(txtDiscountPrice.getText());
				dcPrice1 = dcPrice;
				String selectCoupon = cmbCouponlist.getSelectedItem().toString();
				selectCoupon1 = selectCoupon;
				//쿠폰 저장된 이름으로 다시 세팅
				CouponResetting cr = new CouponResetting(selectCoupon);
				System.out.println("사용값 : "+cr.reName());
				String resetCoupon = cr.reName();
				resetCoupon1 = resetCoupon;
				new Payment(usePnt, savePoint, cnt, cnt2, total, dcPrice1, selectCoupon1, resetCoupon1).setVisible(true);
				dispose();
				setVisible(false);			
								
			}
		});
		btnUseCoupon.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnUseCoupon.setBackground(new Color(230, 230, 250));
		btnUseCoupon.setBounds(210, 191, 100, 25);
		panel.add(btnUseCoupon);
		
		//파일에 저장된 쿠폰이 없으면 사용하기 버튼 비활성화
		if(cs.size() == 0) {
			btnUseCoupon.setEnabled(false);
		}
		
		btnReturn = new JButton("되돌아가기");
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Payment(usePnt, savePoint, cnt, cnt2, total, dcPrice1, selectCoupon1, resetCoupon1).setVisible(true);
				dispose();
				setVisible(false);	
			}
		});
		btnReturn.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnReturn.setBackground(new Color(230, 230, 250));
		btnReturn.setBounds(84, 191, 100, 25);
		panel.add(btnReturn);
		setLocationRelativeTo(null);
		
		
	}
}
