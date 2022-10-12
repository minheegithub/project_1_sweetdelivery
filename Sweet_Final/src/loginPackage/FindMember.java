
package loginPackage;
// 비밀번호 찾기.
import java.awt.EventQueue;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FindMember extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtId1;
	private JTextField txtName1;
	private JTextField txtPhone1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindMember frame = new FindMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FindMember() {
		setTitle("비밀번호 찾기 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 533);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		Image bgimg = new ImageIcon(FindMember.class.getResource("/image/findbg3.png")).getImage();
		JPanel p = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		p.setBounds(0, 0, 878, 495);
		p.setLayout(null);
		contentPane.add(p);
		
		txtId1 = new JTextField();
		txtId1.setBounds(177, 190, 140, 24);
		txtId1.setColumns(10);
		p.add(txtId1);
		
		txtName1 = new JTextField();
		txtName1.setBounds(177, 230, 140, 24);
		txtName1.setColumns(10);
		p.add(txtName1);
		
		txtPhone1 = new JTextField();
		txtPhone1.setBounds(177, 269, 140, 24);
		txtPhone1.setColumns(10);
		p.add(txtPhone1);
		
		JLabel lbId1 = new JLabel("ID");
		lbId1.setBounds(55, 197, 36, 14);
		lbId1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 14));
		p.add(lbId1);
		
		JLabel lbName1 = new JLabel("NAME");
		lbName1.setBounds(55, 236, 59, 14);
		lbName1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 14));
		p.add(lbName1);
		
		JLabel lblPhone1 = new JLabel("PHONE");
		lblPhone1.setBounds(55, 272, 68, 14);
		lblPhone1.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 12));
		p.add(lblPhone1);
		
		JButton pwFindBtn = new JButton("\uBE44\uBC00\uBC88\uD638 \uD78C\uD2B8");
		pwFindBtn.setBounds(170, 312, 150, 29);
		pwFindBtn.setBackground(new Color(230, 230, 250));
		pwFindBtn.setFont(new Font("나눔스퀘어OTF Light", Font.BOLD, 17));
		p.add(pwFindBtn);
		
		JButton btnReturn = new JButton("");
		//로그인창으로 되돌아가기
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new LoginMember().setVisible(true);	
			}
		});
		btnReturn.setBackground(Color.WHITE);
		btnReturn.setIcon(new ImageIcon(FindMember.class.getResource("/image/return.png")));
		btnReturn.setBounds(258, 31, 48, 41);
		p.add(btnReturn);
	
		//비밀번호 찾기
		pwFindBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId1.getText().trim();
				String name = txtName1.getText().trim();
				String phone = txtPhone1.getText().trim();
				FileReader fr = null;
				BufferedReader br = null;
				int count = 0;
				
				String path = ".\\src\\resource\\MemberJoin\\"+id+".txt";
				
				try {
					fr = new FileReader(path);
					br = new BufferedReader(fr);
					
					String read = br.readLine();
					String[] bea = read.split(",");
					if(bea[1].equals(name) && bea[3].equals(phone)) {
						String pw = bea[2];
						System.out.println(pw);
						
						String pwHint = pw.substring(0,2);
						for (int i = 0; i < pw.length()-2; i++) {
							pwHint += "*";
							count++;
						}
						 
						count = count + 2;
						
						JOptionPane.showMessageDialog(null, "비밀번호 힌트 : "+pwHint+"\n비밀번호 전체 자리수 : "+count);
					}else {
						JOptionPane.showMessageDialog(null, "회원의 이름과 전화번호가 일치하지 않습니다.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "등록된 아이디가 없습니다.");
				} finally {
					try {
						if(br != null) {br.close();}
						if(fr != null) {fr.close();}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});	
		
		setLocationRelativeTo(null);
	}//생성자
	

}
