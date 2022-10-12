package loginPackage;
//로그인 화면. 
//로그인 화면 실행 시 프로그램이 실행된다.
//시작.
import java.awt.EventQueue;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginMember extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPw;
	String loginId;
	String loginPw;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMember frame = new LoginMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginMember() {				
		setTitle("Sweet Delivery에 오신걸 환영합니다. 먼저 로그인을 하세요.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/loginbg4.png")).getImage();

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
		
		txtId = new JTextField();
		txtId.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		txtId.setBounds(33, 347, 222, 29);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JPasswordField();
		txtPw.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		txtPw.setBounds(33, 429, 222, 29);
		panel.add(txtPw);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(33, 306, 45, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 21));
		
		JLabel loginLabel = new JLabel("login");
		loginLabel.setBounds(143, 263, 121, 61);
		panel.add(loginLabel);
		loginLabel.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 34));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(33, 388, 138, 29);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 21));
		
		//로그인 버튼 
		JButton loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.setBackground(new Color(230, 230, 250));
		loginBtn.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 12));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginId = txtId.getText().trim();
				loginPw = txtPw.getText().trim();
				
				if(loginId.length() == 0 || loginPw.length() == 0 ) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력하셔야 합니다.");
				}else {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						String path = ".\\src\\resource\\MemberJoin\\"+loginId+".txt";
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						
						String readMember = br.readLine();
						String[] bea = readMember.split(",");
						if(loginPw.equals(bea[2])) {
							JOptionPane.showMessageDialog(null, bea[1]+"님 Sweet Delivery에 입장하신걸 환영합니다.");
					
							dispose();
							setVisible(false);
							new Branch(bea[0], bea[1], bea[2], bea[3], bea[4]).setVisible(true); //생성자로 값을 넘김.

						}else {
							JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "아이디를 확인해 주세요");
					} finally {
						try {
							if(br != null) {br.close();}
							if(fr != null) {fr.close();}
						} catch (IOException e1) {							
							e1.printStackTrace();
						}						
					}
				}			
			}
		});
		loginBtn.setBounds(284, 347, 75, 111);
		panel.add(loginBtn);
		
		//회원가입 창으로 가기
		JButton joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinBtn.setBackground(new Color(230, 230, 250));
		joinBtn.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		joinBtn.setBounds(33, 481, 105, 27);
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				setVisible(false);
				new JoinMember().setVisible(true);
			
			}
		});
		panel.add(joinBtn);
	
		//아이디 찾기
		JButton findBtn = new JButton("\uC544\uC774\uB514/\uBE44\uBC88\uCC3E\uAE30");
		findBtn.setBackground(new Color(230, 230, 250));
		findBtn.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 15));
		findBtn.setBounds(157, 481, 202, 27);
		
		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new FindMember().setVisible(true);
			
			}
		});
		panel.add(findBtn);
		setLocationRelativeTo(null);
	}
	
}
