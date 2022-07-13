package eventPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import payPackage.Rewards;

import javax.swing.SwingConstants;

public class EventRSP extends JFrame {
	
	int count;
	
	JPanel contentPane;
	String id;
	ImageIcon [] img = {
			new ImageIcon(EventRSP.class.getResource("/img/kawi.jpg")),
			new ImageIcon(EventRSP.class.getResource("/img/bawi.jpg")),
			new ImageIcon(EventRSP.class.getResource("/img/bo.jpg")),
		
	};
	//세개의 버튼중에 하나를 선택하려면 Panel에 버튼을 넣어줘야 한다.
	SelectPanel select = new SelectPanel();
	ResultDisplay resultDisplay = new ResultDisplay();
	
	//by최민희입장하였을떄의 날짜
	Calendar c = Calendar.getInstance();
	String year = String.valueOf(c.get(Calendar.YEAR));
	String month = String.valueOf(c.get(Calendar.MONTH)+1); 
	String day = String.valueOf(c.get(Calendar.DATE));
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventRSP frame = new EventRSP("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EventRSP(String id) {
		this.id = id;

		System.out.println("id"+this.id);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bgimg, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(0, 0, 900, 746);
		contentPane.add(panel);
		
		//입장할때 저장되어 있는 카운트 숫자 가져온다.
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(".\\src\\resource\\event\\"+id+"RSP.txt");
			br = new BufferedReader(fr);
		
			String readMember = br.readLine();
			String[] bea = readMember.split("/");
			count = Integer.parseInt(bea[0]);
			System.out.println("읽어온 카운트 :"+count);
		
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
		//by최민희 결과 화면, 게임화면 배치
		panel.add(resultDisplay, "Center" );
		panel.add(select, "South");
		
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(EventRSP.class.getResource("/resource/back-button.png")));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new EventRSPEnter(id).setVisible(true);
			}
		});
		//contentPane.setLayout(null);
		btn1.setBounds(14,12,97,64);
		panel.add(btn1);
	
		
		setLocationRelativeTo(null);	
		
	}//생성자 
	
	class SelectPanel extends JPanel{
		JButton [] btn = new JButton[3];
		//JButton btn1 = new JButton("돌아가기");		
		
		public SelectPanel(){
			setBackground(Color.gray);
			for(int i=0; i<img.length; i++){
				btn[i] = new JButton(img[i]);
				this.add(btn[i]);
				
				btn[i].addActionListener(new EventHandler());
			}
		}		
	}
	class ResultDisplay extends JPanel{
		
		JLabel userlb = new JLabel("User");
		JLabel com = new JLabel("Sweet_Delivery");
		JLabel result = new JLabel("winner");
		
		public ResultDisplay() {
			
			setBackground(Color.WHITE);
			result.setText("          스위트 딜리버리와의 대결             ");
			result.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
			result.setForeground(Color.red);
			add(userlb);
			add(result);
			add(com);
		
		}
		
		public void output(Icon img, Icon comImage, String res){
			userlb.setIcon(img);
			userlb.setHorizontalTextPosition(JLabel.LEFT);
			com.setIcon(comImage);
			result.setText(res);
			result.setForeground(Color.red);
			result.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			
		
		}
	}//Class of ResultDisplay
	
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JButton btnSrc = (JButton)ae.getSource();
			int selCom = (int)(Math.random()*3); //by최민희 0: 가위 , 1: 바위, 2: 보
			
			String res = "";
			//by최민희 이벤트가 발생할때마다 카운트가 차감된다.
			count--;
			
			String strCount;
			//by최민희 가위바위보 이벤트 발생 횟수와 참여 날짜를 저장하기 위한 파일 저장소경로
			String path = ".\\src\\resource\\event\\"+id+"RSP.txt";
			BufferedWriter bw = null;
			
			//by최민희 카운트가 0 이상일때와 0일때 분기, 
			if(count > 0) {
			
				//by최민희 user 가 이기는 경우
				if(btnSrc.getIcon() == img[0] && selCom ==2 ||
				   btnSrc.getIcon() == img[1] && selCom ==0 ||
				   btnSrc.getIcon() == img[2] && selCom ==1 ) {
					//by최민희 이겼을 경우에만 쿠폰이 저장된다.
					res = id+" Win! 25% 할인 쿠폰당첨";
					Rewards rw = new Rewards(0.25,"이벤트 당첨");
					rw.WriteToFile(0.25,"Game-winner",id);
				}else if(btnSrc.getIcon() == img[0] && selCom == 0 ||
						btnSrc.getIcon() == img[1] && selCom == 1 ||
						btnSrc.getIcon() == img[2] && selCom == 2 
						) {
					res = id+"님 비겼습니다. ";
				}else { 
					res = "스위트 딜리버리 Win!";
				}
				
				res += " (남은 기회 " +count+"번)";
				
				resultDisplay.output(btnSrc.getIcon(), img[selCom], res);
				
				try {
					bw = new BufferedWriter(new FileWriter(path,false));
					//by최민희 남은 횟수와 이벤트 참여 날짜를 저장한다.
					strCount = String.valueOf(count);
					bw.write(strCount);
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
			}else if(count == 0) {
				//by최민희 user 가 이기는 경우
				if(btnSrc.getIcon() == img[0] && selCom ==2 ||
				   btnSrc.getIcon() == img[1] && selCom ==0 ||
				   btnSrc.getIcon() == img[2] && selCom ==1 ) {
					res = id+" Win! 25% 할인 쿠폰당첨";
					//by최민희 이겼을 경우에만 쿠폰이 저장된다.
					Rewards rw = new Rewards(0.25,"이벤트 당첨");
					rw.WriteToFile(0.25,"Game-winner",id);
				}else if(btnSrc.getIcon() == img[0] && selCom == 0 ||
						btnSrc.getIcon() == img[1] && selCom == 1 ||
						btnSrc.getIcon() == img[2] && selCom == 2 
						) {
					res = id+"님 비겼습니다.";
				}else { 
					res = "스위트 딜리버리 Win!";
				}
				
				res += " (남은 기회 " +count+"번)";
				
				resultDisplay.output(btnSrc.getIcon(), img[selCom], res);
				
				try {
					bw = new BufferedWriter(new FileWriter(path,false));
					//by최민희 남은 횟수와 이벤트 참여 날짜를 저장한다.
					strCount = String.valueOf(count);
					bw.write(strCount);
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
				
				JOptionPane.showMessageDialog(null,"기회를 다 소진 하였습니다. 다음날부터 도전하실수 있어요!");
				
				dispose();
				setVisible(false);
				new EventRSPEnter(id).setVisible(true);
			}
		}
	}

}