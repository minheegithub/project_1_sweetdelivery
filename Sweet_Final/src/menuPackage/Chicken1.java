package menuPackage;
//후라이드 치킨 옵션 선택 화면 
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.JoinMember;
import loginPackage.LoginMember;
import payPackage.Payment;
import payPackage.Poket1;
import payPackage.Total;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Chicken1 extends JFrame {

	private JPanel contentPane;

	String product = "후라이드치킨";
	
	int op1;//양념
	int op2;//콜라
	int op3;//치즈볼
	
	int chickenPrice = 14000;
	int sourcePrice = 500;//양념가격
	int cokePrice = 1500;//콜라가격
	int cheesePrice = 4000;//
	//**************치킨가격,양념가격,콜라가격,치즈볼가격
	
	int count = 1;
	
	int totalPrice = 14000;
	String strTotal = "14000";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chicken1 frame = new Chicken1(0, "0","0","아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	public Chicken1(int defaultPrice, String option, String total,String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Chicken1");
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/food1.jpg")).getImage();

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Chicken1.class.getResource("/image3/1.png")));
		lblNewLabel.setBounds(165, 18, 221, 44);
		panel.add(lblNewLabel);
		
		//**********장바구니로 가는 버튼
		JButton button = new JButton();
		button.setBackground(new Color(230, 230, 250));
		button.setIcon(new ImageIcon(JoinMember.class.getResource("/image/cart1.png")));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Poket1(id).setVisible(true);
			}
		});
		button.setBounds(440, 70, 49, 49);
		panel.add(button);
		
		JLabel chicken1 = new JLabel("");
		chicken1.setIcon(new ImageIcon(Chicken1.class.getResource("/image3/Chicken1-1.jpg")));
		chicken1.setBounds(95, 111, 117, 111);
		panel.add(chicken1);
		
		JButton button_2 = new JButton("< 이전으로");
		button_2.setBackground(new Color(230, 230, 250));
		button_2.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new SweetDelivery(id).setVisible(true);
			}
		});
		
		button_2.setBounds(14, 312, 117, 29);
		panel.add(button_2);
		
		JLabel lblNewLabel_1 = new JLabel(product);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel_1.setBounds(233, 108, 98, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(strTotal);
		lblNewLabel_2.setBounds(343, 108, 53, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lbPrice = new JLabel();
		lbPrice.setText("총 주문금액");
		lbPrice.setBounds(250, 280, 117, 29);
		panel.add(lbPrice);
		
		//총 가격 표시
		JTextField txtTotal = new JTextField();
		txtTotal.setText(strTotal);
		txtTotal.setBounds(250,312,100,30);
		panel.add(txtTotal);
		
		//개수표시 
		JTextField countText = new JTextField("1");
		countText.setBounds(435, 270, 37, 24);
		countText.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		panel.add(countText);

		JButton btnMinus = new JButton("");
		btnMinus.setIcon(new ImageIcon(JoinMember.class.getResource("/image/minus.png")));
		btnMinus.setBackground(new Color(230, 230, 250));
		btnMinus.setFont(new Font("나눔바른고딕", Font.PLAIN, 10));
		btnMinus.setBounds(400, 270, 24, 24);
		panel.add(btnMinus);
		
		btnMinus.setEnabled(false);
		
		btnMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//by최민희 count가 0이상일때만 마이너스 버튼기능이 작동한다.
				if(count > 1) {
					count--;
					String strCount = String.valueOf(count);
					countText.setText(strCount);
					//by최민희 세가지 옵션을 선택하는 경우의 수를 분기해서 총액에 저장한다.
					totalPrice -= chickenPrice;
					if(op1 == 1 && op2 == 1 && op3 == 1) {
						totalPrice -= (sourcePrice + cokePrice + cheesePrice);
					}else if(op1 == 1 && op2 == 1) {
						totalPrice -= (sourcePrice + cokePrice);
					}else if(op2 == 1 && op3 == 1 ) {
						totalPrice -= (cokePrice + cheesePrice);				
					}else if(op1 == 1 && op3 == 1) {
						totalPrice -= (sourcePrice+ cheesePrice);
					}else if(op1 == 1) {
						totalPrice -= sourcePrice;
					}else if(op2 == 1) {
						totalPrice -= cokePrice;
					}else if(op3 == 1) {
						totalPrice -= cheesePrice;
					}
				
					System.out.println("총 가격 : "+totalPrice);
					strTotal = String.valueOf(totalPrice);
					
					txtTotal.setText(strTotal);
				}

				
			}
		});
		
		JButton btnPlus = new JButton();
		btnPlus.setIcon(new ImageIcon(JoinMember.class.getResource("/image/add.png")));
		btnPlus.setBackground(new Color(230, 230, 250));
		btnPlus.setFont(new Font("나눔바른고딕", Font.PLAIN, 10));
		btnPlus.setBounds(480, 270, 24, 24);
		panel.add(btnPlus);
		
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				String strCount = String.valueOf(count);
				countText.setText(strCount);
				//by최민희 +버튼으로 카운트가 증가하였을 경우에 마이너트 버튼이 활서화된다.
				if(count > 0) {
					btnMinus.setEnabled(true);
				}

				totalPrice += chickenPrice;
				//by최민희 세가지 옵션을 선택하는 경우의 수를 분기해서 총액에 저장한다.
				if(op1 == 1 && op2 == 1 && op3 == 1) {
					totalPrice += (sourcePrice + cokePrice + cheesePrice);
				}else if(op1 == 1 && op2 == 1) {
					totalPrice += (sourcePrice + cokePrice);
				}else if(op2 == 1 && op3 == 1 ) {
					totalPrice += (cokePrice + cheesePrice);				
				}else if(op1 == 1 && op3 == 1) {
					totalPrice += (sourcePrice+ cheesePrice);
				}else if(op1 == 1) {
					totalPrice += sourcePrice;
				}else if(op2 == 1) {
					totalPrice += cokePrice;
				}else if(op3 == 1) {
					totalPrice += cheesePrice;
				}
				
				System.out.println("총 가격 : "+totalPrice);
				strTotal = String.valueOf(totalPrice);
				
				txtTotal.setText(strTotal);
			}
		});
		
		File file = new File(".\\src\\resource\\Text\\"+id+"Cost.txt");
		File file2 = new File(".\\src\\resource\\Text\\"+id+"Product.txt");
		
		//****************장바구니에 추가***********************
		JButton btnNewButton_1 = new JButton("장바구니에 추가");
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			int totalChicken, sourceTotal, cokeTotal, cheeseTotal;
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
					if(btnNewButton_1.getText().equals("장바구니에 추가")) {
						BufferedWriter writer = null;
						BufferedWriter writer2 = null;
						try {//true면 덧붙이기 
							writer = new BufferedWriter(new FileWriter(file, true));//Cost.txt에 저장
							totalChicken = chickenPrice * count;
							String strChicken = String.valueOf(totalChicken);
							
							writer.write(strChicken+",");
							writer.close();
							System.out.println("후라이드 가격 : " + strChicken + "원 저장");
							
							writer2 = new BufferedWriter(new FileWriter(file2, true));//Product.txt
							product = product + "x"+ String.valueOf(count);
							
							writer2.write(product+",");
							writer2.close();
							System.out.println("후라이드 상품명 저장 : "+ product);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						Total tt = new Total();
						tt.WriteToFile(totalChicken,id);
						
						if(op1==1) {
							BufferedWriter bw1 = null;
							BufferedWriter bw2 = null;
							try {
								bw1 = new BufferedWriter(new FileWriter(file, true));
							
								sourceTotal = sourcePrice * count;
								String strSrcPrice = String.valueOf(sourceTotal);
								
								bw1.write(strSrcPrice+",");
								bw1.close();
								System.out.println("소스 가격"+strSrcPrice+"저장");
								bw2 = new BufferedWriter(new FileWriter(file2, true));
								
								bw2.write("+양념"+"x"+count+",");
								System.out.println("+양념"+"x"+count+"저장완료");
								bw2.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
				
							tt.WriteToFile(sourceTotal,id);
						}
						 if(op2==1) {
							BufferedWriter bw3 = null;
							BufferedWriter bw4 = null;
							try {
								bw3 = new BufferedWriter(new FileWriter(file, true));
								
								cokeTotal = cokePrice * count;
								String strCoke = String.valueOf(cokeTotal);
								
								bw3.write(strCoke+",");
								bw3.close();
								
								bw4 = new BufferedWriter(new FileWriter(file2, true));
								
								bw4.write("+콜라 1.25L"+"x"+count+",");
								bw4.close();
								System.out.println("+콜라 1.25L"+"x"+count+"저장완료");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
			
							tt.WriteToFile(cokeTotal,id);
						}
						 if(op3==1) {
							BufferedWriter bw5 = null;
							BufferedWriter bw6 = null;
							try {
								bw5 = new BufferedWriter(new FileWriter(file, true));
								
								cheeseTotal = cheesePrice * count;
								String strCheese = String.valueOf(cheeseTotal);

								bw5.write(strCheese+",");
								bw5.close();
								System.out.println("치즈볼가격 "+strCheese+"원 저장완료");
								bw6 = new BufferedWriter(new FileWriter(file2, true));
								
								bw6.write("+치즈볼"+"x"+count+",");
								bw6.close();
								System.out.println("+치즈볼"+"x"+count+"저장완료");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
	
							tt.WriteToFile(cheeseTotal,id);
						}
					}
				JOptionPane.showMessageDialog(lblNewLabel_1, "장바구니에 추가하였습니다.");
			}
		});
		btnNewButton_1.setBounds(370, 312, 140, 29);
		panel.add(btnNewButton_1);
		
		JCheckBox Box1 = new JCheckBox("양념+500");
		Box1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op1 = 1;
					totalPrice += sourcePrice * count;
					System.out.println(totalPrice);
					strTotal = String.valueOf(totalPrice);
					System.out.println("양념추가");
				}else {
					op1 = 0;
					totalPrice -= sourcePrice * count;
					strTotal = String.valueOf(totalPrice);
					System.out.println("양념추가취소");
				}
				txtTotal.setText(strTotal);
			}
		});
		Box1.setBounds(243, 149, 128, 23);
		panel.add(Box1);
		
		JCheckBox Box2 = new JCheckBox("콜라 1.25L +1500");
		Box2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op2 = 1;
					totalPrice += cokePrice * count;
					strTotal = String.valueOf(totalPrice);
					System.out.println("콜라선택");
				}else {
					op2 = 0;
					totalPrice -= cokePrice * count;
					strTotal = String.valueOf(totalPrice);
					System.out.println("콜라선택 취소");
				}
				txtTotal.setText(strTotal);
			}
		});
		Box2.setBounds(243, 173, 143, 23);
		panel.add(Box2);
		
		JCheckBox Box3 = new JCheckBox("치즈볼 +4000");
		Box3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op3 = 1;
					totalPrice += cheesePrice * count;
					strTotal = String.valueOf(totalPrice);
					System.out.println("치즈볼 추가");
				}else {
					op3 = 0;
					totalPrice -= cheesePrice * count;
					strTotal = String.valueOf(totalPrice);
					System.out.println("치즈볼 취소");
				}
				txtTotal.setText(strTotal);
			}
		});
		Box3.setBounds(243, 199, 128, 23);
		panel.add(Box3);
		
		setLocationRelativeTo(null);
		
	}
}
