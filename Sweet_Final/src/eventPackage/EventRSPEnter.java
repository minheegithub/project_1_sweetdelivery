package eventPackage;
//가위바위보 이전 화면
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EventRSPEnter extends JFrame {

	private JPanel contentPane;
	
	//by최민희 입장하였을때의 날짜이다. 마지막으로 게임에 참여했던 날짜와 비교하기 위한것
	Calendar c = Calendar.getInstance();
	String year = String.valueOf(c.get(Calendar.YEAR));
	String month = String.valueOf(c.get(Calendar.MONTH)+1); 
	String day = String.valueOf(c.get(Calendar.DATE));

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventRSPEnter frame = new EventRSPEnter("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public EventRSPEnter(String id) {
		System.out.println("event8 id"+id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경이미지
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();
		
		JPanel panelbg = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panelbg.setBounds(0, 0, 1190, 746);
		contentPane.add(panelbg);
		panelbg.setLayout(null);
		
		JButton btnNewButton = new JButton("가위바위보 하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = ".\\src\\resource\\event\\"+id+"RSP.txt";
				
				File  f1 = new File(path);
				String readCount = "";
				String readYear = "";
				String readMonth = "";
				String readDay = "";
				//by최민희 게임에 한번이라도 참여하였다면 파일이 존재해 게임참여 정보를 바로 읽어올수 있다.
				if(f1.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					
					try {
						fr = new FileReader(".\\src\\resource\\event\\"+id+"RSP.txt");
						br = new BufferedReader(fr);
					
						String readMember = br.readLine();
						String[] bea = readMember.split("/");
						//by최민희 참여횟수
						readCount = bea[0];
						//by최민희 마지막참여날짜
						readYear = bea[1];
						readMonth = bea[2];
						readDay = bea[3];
					
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						if (br != null) {
							try {
								br.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
					System.out.println("참여날짜 : "+readYear+readMonth+readDay+"/"+readCount);
					System.out.println("지금 날짜 : "+year+month+day);
					//by최민희 마지막 참여날짜와 현재 날짜가 같고 카운트가 다 소진되었다면 게임에 참여할 수 없다.	
					//즉, 카운트가 3번이 소진되었다면 다음날 게임에 참여할수 있다.
					if((year.equals(readYear)) && (month.equals(readMonth)) && (day.equals(readDay) && ("0".equals(readCount)))  ) {
						System.out.println("날짜비교");
						JOptionPane.showMessageDialog(null, readYear+"년 "+readMonth+"월 "+ readDay+"일 "+"3번의 기회를 소진하였습니다. 다음날 참여하실수 있어요!");
					//by최민희 카운트가 남았을 경우 입장가능
					}else if(("2".equals(readCount)) || ("1".equals(readCount))){
						JOptionPane.showMessageDialog(null, "남은 기회는 "+readCount+"번!!");
						dispose();
						setVisible(false);
						new EventRSP(id).setVisible(true);
					//by최민희 3번의 기회를 소진하였지만 입장하는 날짜가 다른경우(count값 3과 현재 날짜를 저장한뒤 입장.)
					}else {
						String path1 = ".\\src\\resource\\event\\"+id+"RSP.txt";
						BufferedWriter bw = null;
						
						try {
							bw = new BufferedWriter(new FileWriter(path1,false));
							bw.write("3");
							bw.write("/");
							bw.write(year);
							bw.write("/");
							bw.write(month);
							bw.write("/");
							bw.write(day);
							
							
						} catch (IOException e1) {					
							e1.printStackTrace();
						} finally {
							try {
								if(bw != null) {bw.close();}
							} catch (IOException e1) {							
								e1.printStackTrace();
							}					
						}//try-catch
						
						JOptionPane.showMessageDialog(null, "기회는 3번까지 주어집니다.");
						dispose();
						setVisible(false);
						new EventRSP(id).setVisible(true);
						
					}
				}else {
					//by최민희 게임에 처음 참여하는 경우
					String path1 = ".\\src\\resource\\event\\"+id+"RSP.txt";
					BufferedWriter bw = null;
					
					try {
						bw = new BufferedWriter(new FileWriter(path1,false));
						bw.write("3");
						bw.write("/");
						bw.write(year);
						bw.write("/");
						bw.write(month);
						bw.write("/");
						bw.write(day);
						
						
					} catch (IOException e1) {					
						e1.printStackTrace();
					} finally {
						try {
							if(bw != null) {bw.close();}
						} catch (IOException e1) {							
							e1.printStackTrace();
						}					
					}//try-catch
					JOptionPane.showMessageDialog(null, "처음 참여 하시는군요!기회는 3번까지 주어집니다.");
					dispose();
					setVisible(false);
					new EventRSP(id).setVisible(true);
					
				}
				
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("가위바위보로 운을 시험해봐!!!");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(339, 90, 568, 48);
		panelbg.add(lblNewLabel);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 28));
		btnNewButton.setBounds(473, 453, 302, 70);
		panelbg.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EventRSPEnter.class.getResource("/image2/어플문구.png")));
		label_1.setBounds(17, 601, 229, 57);
		panelbg.add(label_1);
		
		JLabel label_2 = new JLabel("회사 : sweet deilvery");
		label_2.setFont(new Font("굴림", Font.BOLD, 13));
		label_2.setBounds(263, 580, 196, 43);
		panelbg.add(label_2);
		
		JLabel label_3 = new JLabel("전화번호 : 02-123-4567");
		label_3.setFont(new Font("굴림", Font.BOLD, 13));
		label_3.setBounds(263, 615, 196, 43);
		panelbg.add(label_3);
		
		JLabel label_4 = new JLabel("이메일 : deliverysweet@naver.com");
		label_4.setFont(new Font("굴림", Font.BOLD, 13));
		label_4.setBounds(263, 651, 306, 43);
		panelbg.add(label_4);
		
		JLabel label_5 = new JLabel("주소 : ㅇㅇㅇㅇㅇㅇㅇ");
		label_5.setFont(new Font("굴림", Font.BOLD, 13));
		label_5.setBounds(454, 615, 345, 43);
		panelbg.add(label_5);
		
		JLabel label_6 = new JLabel("사업자 번호 : 1234-15566-1245");
		label_6.setFont(new Font("굴림", Font.BOLD, 13));
		label_6.setBounds(444, 580, 266, 43);
		panelbg.add(label_6);
		
		JButton button = new JButton("돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();;
				setVisible(false);
				new Event2(id).setVisible(true);
			}
		});
		button.setForeground(new Color(240, 255, 255));
		button.setFont(new Font("굴림", Font.BOLD, 22));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(44, 43, 164, 43);
		panelbg.add(button);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(EventRSPEnter.class.getResource("/image2/딜리버리 이벤트.jpg")));
		label.setBounds(263, 55, 722, 112);
		panelbg.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EventRSPEnter.class.getResource("/image2/가위바위보.jpg")));
		lblNewLabel_1.setBounds(354, 187, 528, 236);
		panelbg.add(lblNewLabel_1);
		
		setLocationRelativeTo(null);	
	}
}
