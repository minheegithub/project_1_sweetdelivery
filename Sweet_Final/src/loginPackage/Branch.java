package loginPackage;
//지점 선택


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainPackage.*;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

public class Branch extends JFrame {

	private JPanel cp;
	private JTextField textName;
	JLabel branchLb;
	JComboBox cbSeoul;
	JComboBox cbKyungki;
	JComboBox cbPusan;

	String localchoice;
	String localchoice1;
//	JTextField txtChoice;
	JLabel txtChoice;

	String[] local = {"원하시는 지점을 선택하세요", "서울", "경기", "부산"};
	
	ImageIcon img[] = new ImageIcon[4];
	int imgId;
	private JLabel lbAd;
	private JLabel lblAd;
//	private JTextField txtlocal;
	private JLabel txtlocal;
	
	JLabel lbad2;
	
	ImageIcon[] adimg = {
			new ImageIcon(Branch.class.getResource("/image/kimbab.png")),
			new ImageIcon(Branch.class.getResource("/image/dish.png")),
			new ImageIcon(Branch.class.getResource("/image/cookie.png")),
	};
	
	JButton btnNext;
	
	private JComboBox branchCb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Branch frame = new Branch("","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Branch() {}
	
	public Branch(String id, String name, String pw, String phone, String address) {
		
		setTitle("지점선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 609);
		cp = new JPanel();
		cp.setBorder(new EmptyBorder(5, 5, 5, 5));
		cp.setLayout(null);
		setContentPane(cp);
		cp.setLayout(null);
		
		//by최민희 배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(0, 0, 893, 593);
		cp.add(panel);
		panel.setLayout(null);
		
		JLabel logoLB = new JLabel("");
		logoLB.setIcon(new ImageIcon(Branch.class.getResource("/image/logo1.png")));
		logoLB.setBounds(52, 21, 234, 57);
		panel.add(logoLB);
		
		//by최민희 지역 이미지 
		ImageIcon[] img1 = {
				new ImageIcon(Branch.class.getResource("/image/choice.png")),
				new ImageIcon(Branch.class.getResource("/image/seoul.png")),
				new ImageIcon(Branch.class.getResource("/image/kyungki.png")),
				new ImageIcon(Branch.class.getResource("/image/pusan.png")),
		};
		
		branchLb = new JLabel(img1[0]);
		branchLb.setBounds(382, 154, 156, 131);
		panel.add(branchLb);
		
//		txtChoice = new JTextField();
		txtChoice = new JLabel();
		txtChoice.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		txtChoice.setBounds(377, 312, 65, 33);
		panel.add(txtChoice);
//		txtChoice.setColumns(10);
		
//		txtlocal = new JTextField();
		txtlocal = new JLabel();
		txtlocal.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		txtlocal.setBounds(443, 312, 121, 33);
		panel.add(txtlocal);
//		txtlocal.setColumns(10);
		
		//by최민희 서울, 경기, 부산 지역 고르기	
		branchCb = new JComboBox();
		branchCb.setFont(new Font("굴림", Font.BOLD, 17));
		branchCb.setModel(new DefaultComboBoxModel(new String[] {"원하시는 지점을 선택하세요", "서울", "경기", "부산"}));
		branchCb.setBounds(380, 98, 340, 33);
		panel.add(branchCb);
		branchCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox obj = (JComboBox)arg0.getSource();
				int idx = obj.getSelectedIndex();
				branchLb.setIcon(img1[idx]);
				
				String str = (String)obj.getSelectedItem();
				
				if(str.equals(local[1])) {
					txtChoice.setVisible(false);
					txtlocal.setVisible(false);
					cbSeoul.setVisible(true);//by최민희 서울지역 콤보막스만 보인다.
					cbKyungki.setVisible(false);
					cbPusan.setVisible(false);
					
					localchoice = "서울 / ";
					
					btnNext.setEnabled(false);
				}else if(str.equals(local[2])) {
					txtChoice.setVisible(false);
					txtlocal.setVisible(false);
					cbKyungki.setVisible(true);//by최민희 경기지역 콤보박스만 보인다.
					cbSeoul.setVisible(false);
					cbPusan.setVisible(false);
					localchoice = "경기 / ";
					
					btnNext.setEnabled(false);
				}else if(str.equals(local[3])) {
					txtChoice.setVisible(false);
					txtlocal.setVisible(false);
					cbPusan.setVisible(true);//by최민희 부산지역 콤보박스만 보인다.
					cbKyungki.setVisible(false);
					cbSeoul.setVisible(false);
					localchoice = "부산 / ";
					
					btnNext.setEnabled(false);
				}
			}
		});
		
		cbSeoul = new JComboBox();
		cbSeoul.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		//cbSeoul.setModel(new DefaultComboBoxModel(new String[] {"\uC885\uB85C3\uAC00\uC810", "\uAC15\uB0A8\uC810", "\uB178\uB7C9\uC9C4\uC810"}));
		cbSeoul.setModel(new DefaultComboBoxModel(new String[] {"종로 3가점", "강남점", "노량진점"}));
		
		
		///by최민희 하단 콤보박스 서울 
		cbSeoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				String str = (String)cb.getSelectedItem();
				
				txtChoice.setText(localchoice);
				txtlocal.setText(str); 
				txtlocal.setVisible(true);
				txtChoice.setVisible(true);
				
				localchoice1 = (String)cbSeoul.getSelectedItem();
				
				btnNext.setEnabled(true);
				
			}
		});
		cbSeoul.setBounds(552, 154, 168, 34);
		panel.add(cbSeoul);
		cbSeoul.setVisible(false);
		cbKyungki = new JComboBox();
		cbKyungki.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		cbKyungki.setModel(new DefaultComboBoxModel(new String[] {"부천점", "광명점"}));
		
		//by최민희 하단 콤보박스 경기 
		cbKyungki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String str = (String)cb.getSelectedItem();
				
				txtlocal.setText(str); 
				txtlocal.setVisible(true);
				txtChoice.setText(localchoice);
				txtChoice.setVisible(true);
				
				localchoice1 = (String)cbKyungki.getSelectedItem();
				btnNext.setEnabled(true);
			}
		});
		cbKyungki.setBounds(552, 200, 168, 34);
		panel.add(cbKyungki);
		cbKyungki.setVisible(false);
		
		cbPusan = new JComboBox();
		cbPusan.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));		
		cbPusan.setModel(new DefaultComboBoxModel(new String[] {"중구점", "서구점"}));
		
		//by최민희 하단 콤보박스 부산
		cbPusan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String str = (String)cb.getSelectedItem();
				txtlocal.setText(str); 
				txtlocal.setVisible(true);
				
				txtChoice.setText(localchoice);
				txtChoice.setVisible(true);
				
				localchoice1 = (String)cbPusan.getSelectedItem();
				btnNext.setEnabled(true);
			}
		});
		cbPusan.setBounds(552, 246, 168, 33);
		cbPusan.setVisible(false);
		panel.add(cbPusan);
		
		//by최민희 로그아웃
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(new Color(230, 230, 250));
		btnLogout.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				setVisible(false);
				new LoginMember().setVisible(true);
			}
		});
		btnLogout.setBounds(603, 21, 105, 27);
		panel.add(btnLogout);
		
		//by최민희 상위 광고 이미지 
		for(int i=0; i<img.length; i++){
			img[i] = new ImageIcon(Branch.class.getResource("/image/ad_"+(i+1)+".png"));
		}
		lbAd = new JLabel("");
		lbAd.setIcon(img[0]);
		
		lbAd.setBounds(52, 139, 245, 170);
		panel.add(lbAd);
		
		lblAd = new JLabel("\uAD11\uACE0");
		lblAd.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAd.setBounds(52, 100, 72, 27);
		panel.add(lblAd);
		
		txtChoice.setVisible(false);
		txtlocal.setVisible(false);
		
		JLabel lblogin = new JLabel("");
		lblogin.setIcon(new ImageIcon(Branch.class.getResource("/image/login1.png")));
		lblogin.setBounds(550, 22, 44, 47);
		panel.add(lblogin);
		
		JLabel showId = new JLabel("");
		showId.setText(name+"님 환영합니다.");
		showId.setBounds(400, 22, 200, 47);
		panel.add(showId);
		
		//by최민희 상위 광고 왼쪽 버튼 
		JButton btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgId--; //이전 이미지
				imgId += img.length;// 0인 경우를 대비
				imgId %= img.length;
				lbAd.setIcon(img[imgId]);//0,1,2,3
			
			}
		});
		btnLeft.setBackground(Color.WHITE);
		btnLeft.setIcon(new ImageIcon(Branch.class.getResource("/image/left.png")));
		btnLeft.setBounds(10, 200, 40, 66);
	
		panel.add(btnLeft);
		
		//by최민희 상위 광고 오른쪽 버튼
		JButton btnright = new JButton("");
		btnright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgId++;//다음 이미지 아이디	
				imgId %= img.length;//4
				lbAd.setIcon(img[imgId]);//0,1,2,3
			}
		});
		btnright.setIcon(new ImageIcon(Branch.class.getResource("/image/right.png")));
		btnright.setForeground(Color.WHITE);
		btnright.setBackground(Color.WHITE);
		btnright.setBounds(300, 200, 40, 66);
		panel.add(btnright);
		
		lbad2 = new JLabel("");
		lbad2.setBounds(51, 406, 683, 97);
		panel.add(lbad2);
		
		btnNext = new JButton("메인페이지>");
		btnNext.setBackground(new Color(135, 206, 250));
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 18));
		btnNext.setBounds(570, 298, 144, 49);		
		panel.add(btnNext);
		btnNext.setEnabled(false);	
		
		//by최민희 메인페이지로 넘어가기전, 현재 유저 정보를 currentUser텍스트 파일에 저장한다.
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String currentUser = ".\\src\\resource\\MemberJoin\\currentUser.txt";
					FileWriter writer = null;
					String message = id+","+name+","+pw+","+phone+","+address+","+localchoice+","+localchoice1;
					
					try {
						//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
						writer = new FileWriter(currentUser,false); 
						writer.append(message);
						writer.flush();
						
						System.out.println("현재 접속한 유저정보및 선택지점 저장완료");
					}catch(IOException e1) {
						e1.printStackTrace();
					}finally {
						try {
							if(writer !=null) writer.close();
						}catch(IOException e2) {
							e2.printStackTrace();
						}
					}
					new MainPage(id).setVisible(true);
					dispose(); //지금창 해제, 프레임 닫는 것
					setVisible(false); //지금창 안보이게
					
				} catch (IOException e2) {					
					e2.printStackTrace();
				}
				
			}
		});		
			
		//by최민희 하단 광고 배너 바뀌는 쓰레드
		MyThread mt = new MyThread();
		mt.start();		

		setLocationRelativeTo(null);
	}
	
	class MyThread extends Thread{
		
		public void run() {
			while(true) {
				int rn = (int)(Math.random()*adimg.length);
				
				lbad2.setIcon(adimg[rn]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				
			}
		}
	}
}
