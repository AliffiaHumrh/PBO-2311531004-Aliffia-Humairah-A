package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(120, 168, 188));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_username = new JTextField();
		txt_username.setBounds(71, 165, 309, 36);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lbl_username = new JLabel("USERNAME");
		lbl_username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_username.setBounds(183, 135, 115, 20);
		contentPane.add(lbl_username);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_password.setBounds(183, 225, 115, 20);
		contentPane.add(lbl_password);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(71, 255, 309, 36);
		contentPane.add(txt_password);
		
		JButton btn_login = new JButton("Login");
		btn_login.setBackground(new Color(198, 219, 227));
		btn_login.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.login(txt_username.getText(), txt_password.getText())) {
					JOptionPane.showMessageDialog(null, "Yeyy berhasil login");
					//untuk pindah dari login ke mainFrame
					new MainFrame().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Login gagal");
				} 
			}
		});
		btn_login.setBounds(120, 309, 214, 36);
		contentPane.add(btn_login);
		
		JLabel lbl_judul = new JLabel("Laundry Apps");
		lbl_judul.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_judul.setBounds(71, 38, 309, 36);
		contentPane.add(lbl_judul);
		
		JLabel lbl_males = new JLabel("Males aja nyuci, biar kami yang nyuciin");
		lbl_males.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbl_males.setBounds(71, 62, 309, 27);
		contentPane.add(lbl_males);
	}
}