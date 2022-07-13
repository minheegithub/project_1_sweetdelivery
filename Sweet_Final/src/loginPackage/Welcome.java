package loginPackage;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//
public class Welcome extends JFrame {

	private JPanel contentPane;
	private Image background = new ImageIcon(Welcome.class.getResource("/image/welcomeClick.png")).getImage();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcome() {
		setTitle("Welcome~! Sweet Delivery!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("New button");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				new LoginMember().setVisible(true);
			}
		});
		btn.setIcon(new ImageIcon(Welcome.class.getResource("/image/logo1.png")));
		btn.setBounds(75, 375, 235, 65);
		contentPane.add(btn);		

		setLocationRelativeTo(null);		
	}//Welcome()생성자
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
