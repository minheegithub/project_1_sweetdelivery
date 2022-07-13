package mainPackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//메인페이지 최신 공지사항 항목을 클릭시 나타나는 화면.
//텍스트 파일을 읽어서 textArea에 쓴다.
public class SystemMessage extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemMessage frame = new SystemMessage("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SystemMessage(String id) throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 520);
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
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setIcon(new ImageIcon(SystemMessage.class.getResource("/resource/back-button.png")));
		btnBack.setBounds(477, 358, 101, 73);
		panel.add(btnBack);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);	
		
		JLabel lblTitle = new JLabel("시스템 점검에 따른 안내문 ");
		lblTitle.setBounds(5, 5, 546, 17);
		lblTitle.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		panel.add(lblTitle);
		
		JLabel lblDate = new JLabel("2021.05.24");
		lblDate.setBounds(15, 29, 92, 34);
		lblDate.setFont(new Font("나눔스퀘어", Font.PLAIN, 15));
		panel.add(lblDate);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("나눔스퀘어 Light", Font.BOLD, 13));
		textArea.setBounds(25, 75, 553, 356);
		panel.add(textArea);
		
		try {
			Path path = Paths.get(".\\src\\resource\\systemMessage.txt");
			List<String> lines = Files.readAllLines(path);
			for(String line : lines) {
				textArea.append(line+"\n");
				System.out.println();
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		setLocationRelativeTo(null);
		
	}
}
