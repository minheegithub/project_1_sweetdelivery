package menuPackage;
//메뉴 선택 메인화면
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
import mainPackage.MainPage;
import payPackage.Poket1;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;

public class SweetDelivery extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SweetDelivery frame = new SweetDelivery("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SweetDelivery(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 701);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("SweetDelivery");
		
		//배경 이미지 
		Image bgimg = new ImageIcon(LoginMember.class.getResource("/image/menu1.jpg")).getImage();

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
		
		ImageIcon i = new ImageIcon("Chiken1");
		Image icon = i.getImage();
		Image cicon = icon.getScaledInstance(117, 111, Image.SCALE_SMOOTH);
		ImageIcon i1 = new ImageIcon(cicon);

		JLabel title1 = new JLabel("New label");
		title1.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/1.png")));
		title1.setBounds(14, 9, 224, 39);
		panel.add(title1);
		
		JButton poket1 = new JButton("장바구니");
		poket1.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		poket1.setBackground(new Color(230, 230, 250));
		poket1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new Poket1(id).setVisible(true);
			}
		});
		poket1.setBounds(461, 19, 103, 29);
		panel.add(poket1);
		
		JButton btn3 = new JButton("< 처음으로");
		btn3.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		btn3.setBackground(new Color(230, 230, 250));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				try {
					new MainPage(id).setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn3.setBounds(57, 592, 103, 29);
		panel.add(btn3);
		
		JButton btn4 = new JButton("다음 >");
		btn4.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		btn4.setBackground(new Color(230, 230, 250));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SweetDelivery2(id).setVisible(true);
			}
		});
		btn4.setBounds(461, 592, 103, 29);
		panel.add(btn4);
		
		JButton food1 = new JButton("");
		food1.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/Chicken1-1.jpg")));
		food1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Chicken1(14000, "0", "14000",id).setVisible(true);
			}
		});
		food1.setBounds(57, 181, 130, 111);
		panel.add(food1);
		
		JButton food2 = new JButton("");
		food2.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/chicken2-2.png")));
		food2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Chicken2(15000, "0", "0",id).setVisible(true);
			}
		});
		food2.setBounds(240, 181, 130, 111);
		panel.add(food2);
		
		JButton food3 = new JButton("");
		food3.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/pizza1.jpg")));
		food3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Pizza1(14000, "0","0",id).setVisible(true);
			}
		});
		food3.setBounds(421, 181, 130, 111);
		panel.add(food3);
		
		JButton food4 = new JButton("");
		food4.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/pizza2.jpg")));
		food4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Pizza3(14000, "0", "0",id).setVisible(true);
			}
		});
		food4.setBounds(57, 320, 130, 111);
		panel.add(food4);
		
		JButton food5 = new JButton("");
		food5.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/pizza3.jpg")));
		food5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Pizza2(15000, "0", "0",id).setVisible(true);
			}
		});
		food5.setBounds(240, 320, 130, 111);
		panel.add(food5);
		
		JButton food6 = new JButton("");
		food6.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/hambuger1.jpg")));
		food6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Hambuger1(7000, "0", "0",id).setVisible(true);
			}
		});
		food6.setBounds(421, 320, 130, 111);
		panel.add(food6);
		
		JToolBar toolBar = new JToolBar();  //카테고리 별 선택 가능한 툴바
		toolBar.setBackground(Color.WHITE);
		toolBar.setBounds(50, 75, 488, 78);
		panel.add(toolBar);
		
		JButton menu1 = new JButton("");
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Chicken(id).setVisible(true);
			}
		});
		menu1.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/Chicken.png")));
		toolBar.add(menu1);
		
		JButton menu2 = new JButton("");
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Pizza(id).setVisible(true);
			}
		});
		menu2.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/pizza.png")));
		toolBar.add(menu2);
		
		JButton menu3 = new JButton("");
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Hambuger(id).setVisible(true);
			}
		});
		menu3.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/hambuger.png")));
		toolBar.add(menu3);
		
		JButton menu4 = new JButton("");
		menu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SchoolFood(id).setVisible(true);
			}
		});
		menu4.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/schoolfood.png")));
		toolBar.add(menu4);
		
		JButton menu5 = new JButton("");
		menu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new ChineseFood(id).setVisible(true);
			}
		});
		menu5.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/chinesefood.png")));
		toolBar.add(menu5);
		
		JButton food7 = new JButton("");
		food7.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/hambuger2.jpg")));
		food7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Hambuger2(6000, "0", "0",id).setVisible(true);
			}
		});
		food7.setBounds(57, 467, 130, 101);
		panel.add(food7);
		
		JButton food8 = new JButton("");
		food8.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/hambuger3-2.png")));
		food8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new Hambuger3(5000, "0", "0",id).setVisible(true);
			}
		});
		food8.setBounds(240, 467, 130, 111);
		panel.add(food8);
		
		JButton food9 = new JButton("");
		food9.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/schoolfood1.jpg")));
		food9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SchoolFood1(14000, "0", "0",id).setVisible(true);
			}
		});
		food9.setBounds(421, 467, 130, 111);
		panel.add(food9);
		
		setLocationRelativeTo(null);
	}
}
