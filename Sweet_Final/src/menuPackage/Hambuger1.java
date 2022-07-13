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

public class Hambuger1 extends JFrame {

	private JPanel contentPane;

	String product = "수제버거";
	
	int op1;
	int op2;
	int op3;
	
	int hambugerPrice = 7000;
	int szupPrice = 500;
	int nuggetPrice = 1500;
	int wingPrice = 4000;
	
	int count = 1;
	
	int totalPrice = 7000;
	String strTotal = "7000";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hambuger1 frame = new Hambuger1(0, "0","0","아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	public Hambuger1(int defaultPrice, String option, String total,String id) {
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
		lblNewLabel.setIcon(new ImageIcon(Hambuger1.class.getResource("/image3/1.png")));
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
		
		JLabel chicken1 = new JLabel(product);
		chicken1.setIcon(new ImageIcon(Hambuger1.class.getResource("/image3/hambuger1.jpg")));
		chicken1.setBounds(61, 105, 150, 150);
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
			
				if(count > 1) {
					count--;
					String strCount = String.valueOf(count);
					countText.setText(strCount);
					
					totalPrice -= hambugerPrice;
					if(op1 == 1 && op2 == 1 && op3 == 1) {
						totalPrice -= (szupPrice + nuggetPrice + wingPrice);
					}else if(op1 == 1 && op2 == 1) {
						totalPrice -= (szupPrice + nuggetPrice);
					}else if(op2 == 1 && op3 == 1 ) {
						totalPrice -= (nuggetPrice + wingPrice);				
					}else if(op1 == 1 && op3 == 1) {
						totalPrice -= (szupPrice+ wingPrice);
					}else if(op1 == 1) {
						totalPrice -= szupPrice;
					}else if(op2 == 1) {
						totalPrice -= nuggetPrice;
					}else if(op3 == 1) {
						totalPrice -= wingPrice;
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
//			int totalChicken, sourceTotal, cokeTotal, cheeseTotal;
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				String strCount = String.valueOf(count);
				countText.setText(strCount);
				if(count > 0) {
					btnMinus.setEnabled(true);
				}

				totalPrice += hambugerPrice;
			
				if(op1 == 1 && op2 == 1 && op3 == 1) {
					totalPrice += (szupPrice + nuggetPrice + wingPrice);
				}else if(op1 == 1 && op2 == 1) {
					totalPrice += (szupPrice + nuggetPrice);
				}else if(op2 == 1 && op3 == 1 ) {
					totalPrice += (nuggetPrice + wingPrice);				
				}else if(op1 == 1 && op3 == 1) {
					totalPrice += (szupPrice+ wingPrice);
				}else if(op1 == 1) {
					totalPrice += szupPrice;
				}else if(op2 == 1) {
					totalPrice += nuggetPrice;
				}else if(op3 == 1) {
					totalPrice += wingPrice;
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
			int totalMain, sourceTotal, cokeTotal, cheeseTotal;
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
					if(btnNewButton_1.getText().equals("장바구니에 추가")) {
						BufferedWriter writer = null;
						BufferedWriter writer2 = null;
						try {//true면 덧붙이기 
							writer = new BufferedWriter(new FileWriter(file, true));//Cost.txt에 저장
							totalMain = hambugerPrice * count;
							String strChicken = String.valueOf(totalMain);
							
//							writer.write(strChicken+"\n");
							writer.write(strChicken+",");
							writer.close();
							
							writer2 = new BufferedWriter(new FileWriter(file2, true));//Product.txt
							product = product + "x"+ String.valueOf(count);
							
//							writer2.write(product+"\n");
							writer2.write(product+",");
							writer2.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
								
						Total tt = new Total();
						tt.WriteToFile(totalMain,id);
						
						if(op1==1) {
							BufferedWriter bw1 = null;
							BufferedWriter bw2 = null;
							try {
								bw1 = new BufferedWriter(new FileWriter(file, true));
							
								sourceTotal = szupPrice * count;
								String strSrcPrice = String.valueOf(sourceTotal);
//								bw1.write(strSrcPrice+"\n");
								bw1.write(strSrcPrice+",");
								bw1.close();
								bw2 = new BufferedWriter(new FileWriter(file2, true));
//								bw2.write("+사이즈업"+"x"+count+"\n");
								bw2.write("+사이즈업"+"x"+count+",");
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
								
								cokeTotal = nuggetPrice * count;
								String strCoke = String.valueOf(cokeTotal);
//								bw3.write(strCoke+"\n");
								bw3.write(strCoke+",");
								bw3.close();
								
								bw4 = new BufferedWriter(new FileWriter(file2, true));
								
//								bw4.write("+치킨너겟4조각"+"x"+count+"\n");
								bw4.write("+치킨너겟4조각"+"x"+count+",");
								bw4.close();
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
								
								cheeseTotal = wingPrice * count;
								String strCheese = String.valueOf(cheeseTotal);
//								bw5.write(strCheese+"\n");
								bw5.write(strCheese+",");
								bw5.close();
								bw6 = new BufferedWriter(new FileWriter(file2, true));
								
//								bw6.write("+치킨윙"+"x"+count+"\n");
								bw6.write("+치킨윙"+"x"+count+",");
								bw6.close();
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
		
		JCheckBox Box1 = new JCheckBox("사이즈업 +500");
		Box1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op1 = 1;
					totalPrice += szupPrice * count;
					System.out.println(totalPrice);
					strTotal = String.valueOf(totalPrice);
				}else {
					op1 = 0;
					totalPrice -= szupPrice * count;
					strTotal = String.valueOf(totalPrice);
				}
				txtTotal.setText(strTotal);
			}
		});
		Box1.setBounds(243, 149, 128, 23);
		panel.add(Box1);
		
		JCheckBox Box2 = new JCheckBox("치킨너겟4조각 +1500");
		Box2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op2 = 1;
					totalPrice += nuggetPrice * count;
					strTotal = String.valueOf(totalPrice);
				}else {
					op2 = 0;
					totalPrice -= nuggetPrice * count;
					strTotal = String.valueOf(totalPrice);
				}
				txtTotal.setText(strTotal);
			}
		});
		Box2.setBounds(243, 173, 175, 23);
		panel.add(Box2);
		
		JCheckBox Box3 = new JCheckBox("치킨윙 +4000");
		Box3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					op3 = 1;
					totalPrice += wingPrice * count;
					strTotal = String.valueOf(totalPrice);
				}else {
					op3 = 0;
					totalPrice -= wingPrice * count;
					strTotal = String.valueOf(totalPrice);
				}
				txtTotal.setText(strTotal);
			}
		});
		Box3.setBounds(243, 199, 128, 23);
		panel.add(Box3);
		
		setLocationRelativeTo(null);
		
	}
}
