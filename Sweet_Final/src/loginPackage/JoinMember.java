package loginPackage;
//회원 가입. MemberJoin 텍스트 파일에 입력받은 값을 쓴다.
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class JoinMember extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtTelNum;
	private JPasswordField txtPw;
	private JTextArea txtAddress;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinMember frame = new JoinMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JoinMember() {
		setTitle("Sweet Delivery의 회원이 되어주세요~!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image bgimg = new ImageIcon(JoinMember.class.getResource("/image/joinbg4.png")).getImage();
		contentPane.setLayout(null);		

		JPanel p = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(bgimg, 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
			}
		};
		p.setBounds(0, 0, 896, 600);
		contentPane.add(p);
		p.setLayout(null);
		JLabel lbName = new JLabel("NAME");
		lbName.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		lbName.setBounds(47, 108, 56, 29);
		p.add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(143, 109, 176, 27);
		txtName.setColumns(10);
		p.add(txtName);
		
		JLabel lbTelNum = new JLabel("PHONE");
		lbTelNum.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		lbTelNum.setBounds(47, 273, 56, 18);
		p.add(lbTelNum);
		
		txtId = new JTextField();
		txtId.setBounds(143, 148, 176, 27);
		txtId.setColumns(10);
		p.add(txtId);
		
		JLabel lblNewLabel_2 = new JLabel("ADDRESS");
		lblNewLabel_2.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		lblNewLabel_2.setBounds(47, 311, 99, 18);
		p.add(lblNewLabel_2);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		lbId.setBounds(47, 149, 42, 18);
		p.add(lbId);
		
		txtTelNum = new JTextField();
		txtTelNum.setBounds(143, 267, 176, 30);
		txtTelNum.setColumns(10);
		p.add(txtTelNum);
		
		txtAddress = new JTextArea();
		txtAddress.setBounds(47, 341, 272, 142);
		p.add(txtAddress);
		
		JLabel lbPw = new JLabel("PASSWORD");
		lbPw.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		lbPw.setBounds(47, 226, 85, 18);
		p.add(lbPw);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(143, 226, 176, 27);
		txtPw.setColumns(10);
		p.add(txtPw);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.setBackground(new Color(230, 230, 250));
		btnJoin.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		
		//회원가입 버튼
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BufferedWriter bw = null;
				BufferedWriter bw1 = null;
				String name = txtName.getText().trim();
				String id = txtId.getText().trim();
				String pw = txtPw.getText().trim();
				String telNum = txtTelNum.getText().trim(); 
				String address = txtAddress.getText();
				
				
				
				if(name.length() == 0 || id.length() == 0 || pw.length() == 0 || telNum.length() == 0 ) {
					JOptionPane.showMessageDialog(null, "회원정보를 입력하세요");
				}else if(pw.length() < 7){
					JOptionPane.showMessageDialog(null, "비밀번호는 7자리 이상입력하세요");
				}else {
					//폴더생성
					File f = new File(".\\src\\resource\\MemberJoin");
					
					if(!f.exists()) {
						f.mkdir();
						System.out.println("MemberJoin폴더가 생성");
					}else {
						System.out.println("폴더가 이미 있습니다.");
					}				
					
					String path = ".\\src\\resource\\MemberJoin\\"+id+".txt";
					try {
						bw = new BufferedWriter(new FileWriter(path));
						bw.write(id);
						bw.write(",");
						bw.write(name);
						bw.write(",");
						bw.write(pw);
						bw.write(",");
						bw.write(telNum);
						bw.write(",");
						bw.write(address);
						
						JOptionPane.showMessageDialog(null, name+" 님 Sweet Delivery의 회원이 되신걸 환영합니다. 로그인 창으로 이동합니다.");
						dispose();
						setVisible(false);
						new LoginMember().setVisible(true);		
					} catch (IOException e1) {					
						e1.printStackTrace();
					} finally {
						try {
							if(bw != null) {bw.close();}
						} catch (IOException e1) {							
							e1.printStackTrace();
						}					
					}//try-catch
				}
					
					
			}//actionPerformed()
		});//회원가입 버튼
		
		btnJoin.setBounds(47, 495, 99, 27);
		p.add(btnJoin);
		btnJoin.setEnabled(false);
		
		//아이디 중복확인 버튼
		JButton btnConfirm = new JButton("\uC911\uBCF5\uD655\uC778");
		btnConfirm.setBackground(new Color(230, 230, 250));
		btnConfirm.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr = null;
				BufferedReader br = null;
				String id = txtId.getText().trim();
					
				if(id.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하셔야 합니다.");
				}else {
					try {//아이디가 없으면 예외 발생 --> 사용가능한 아이디
						fr = new FileReader(".\\src\\resource\\MemberJoin\\"+id+".txt");
						br = new BufferedReader(fr);
							
						String readId = br.readLine();
						String[] beaId = readId.split(",");
						//입력받은 아이디와 저장되어 있는 아이디 비교		
						if(id.equals(beaId[0])) {
							JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다.");
						}
					} catch (Exception e1) {
//						e1.printStackTrace();
						btnJoin.setEnabled(true);//저장된 아이디가 없기 떄문에 사용가능한 아이디 --> 회원가입 버튼 활성화
						JOptionPane.showMessageDialog(null, "사용이 가능한 아이디 입니다.");
								
					} finally {
							try {
								if(br != null) {
									br.close();
								}
								if(fr != null) {
									fr.close();
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
					}//try
				}//if			
			}//actionPerformed()
		});//아이디중복확인 버튼
		btnConfirm.setBounds(47, 187, 121, 27);
		p.add(btnConfirm);
		
		//취소 버튼
		JButton btnDelete = new JButton("\uCDE8\uC18C");
		btnDelete.setBackground(new Color(230, 230, 250));
		
		btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {				
			txtName.setText("");
			txtId.setText("");;
			txtTelNum.setText("");;
			txtPw.setText("");;
			txtAddress.setText("");;
			
			}
		});

		btnDelete.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		btnDelete.setBounds(229, 495, 90, 27);
		p.add(btnDelete);
		
		//로그인 페이지로 되돌아가기 버튼 
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			setVisible(false);
			new LoginMember().setVisible(true);			
		}
		});
		btnReturn.setIcon(new ImageIcon(JoinMember.class.getResource("/image/return.png")));
		btnReturn.setBackground(Color.WHITE);
		btnReturn.setBounds(270, 29, 49, 46);
		p.add(btnReturn);
		setLocationRelativeTo(null);		
	}	
}
