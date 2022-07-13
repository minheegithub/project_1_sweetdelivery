package menuPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPackage.LoginMember;
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
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.SystemColor;

public class SweetDelivery2 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SweetDelivery2 frame = new SweetDelivery2("아이디");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SweetDelivery2(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 701);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

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
		
		JLabel title1 = new JLabel("New label");
		title1.setIcon(new ImageIcon(SweetDelivery.class.getResource("/image3/1.png")));
		title1.setBounds(14, 9, 224, 39);
		panel.add(title1);
		
		JButton poket1 = new JButton("장바구니");
		poket1.setBackground(new Color(230, 230, 250));
		poket1.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		poket1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JButton btn3 = new JButton("< 이전");
		btn3.setBackground(new Color(230, 230, 250));
		btn3.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SweetDelivery(id).setVisible(true);
			}
		});
		btn3.setBounds(57, 592, 103, 29);
		panel.add(btn3);
		
		JButton food1 = new JButton("");
		food1.setIcon(new ImageIcon(SweetDelivery2.class.getResource("/image3/schoolfood2.jpg")));
		food1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new SchoolFood2(15000, "0", "0",id).setVisible(true);
			}
		});
		food1.setBounds(57, 181, 130, 111);
		panel.add(food1);
		
		JButton food2 = new JButton("");
		food2.setIcon(new ImageIcon(SweetDelivery2.class.getResource("/image3/chinese1.jpg")));
		food2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new ChineseFood1(4000, "0", "0",id).setVisible(true);
			}
		});
		food2.setBounds(240, 181, 130, 111);
		panel.add(food2);
		
		JButton food3 = new JButton("");
		food3.setIcon(new ImageIcon(SweetDelivery2.class.getResource("/image3/chinese2.jpg")));
		food3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new ChineseFood2(5000, "0", "0",id).setVisible(true);
			}
		});
		food3.setBounds(421, 181, 130, 111);
		panel.add(food3);
		
		JButton food4 = new JButton("");
		food4.setIcon(new ImageIcon(SweetDelivery2.class.getResource("/image3/chinese3.jpg")));
		food4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new ChineseFood3(14000, "0", "0",id).setVisible(true);
			}
		});
		food4.setBounds(57, 322, 130, 111);
		panel.add(food4);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(UIManager.getColor("Button.darkShadow"));
		button_3.setBounds(240, 322, 130, 111);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBackground(UIManager.getColor("Button.darkShadow"));
		button_4.setBounds(420, 322, 130, 111);
		panel.add(button_4);
		
		JToolBar toolBar = new JToolBar();
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
	
		
		JButton button_9 = new JButton("");
		button_9.setBackground(UIManager.getColor("Button.darkShadow"));
		button_9.setBounds(57, 455, 130, 111);
		panel.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBackground(UIManager.getColor("Button.darkShadow"));
		button_10.setBounds(240, 455, 130, 111);
		panel.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setBackground(UIManager.getColor("Button.darkShadow"));
		button_11.setBounds(420, 455, 130, 111);
		panel.add(button_11);
		
		setLocationRelativeTo(null);
	}
}
