package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import error.ValidationException;
import service.LoginService;
import ui.MainFrame;
import util.ValidationUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPassword;
	private JTextField txtUsername;

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
		setBounds(100, 100, 400, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 188, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Frame");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 378, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 129, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassword.setBounds(38, 152, 331, 27);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(38, 59, 81, 21);
		contentPane.add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		txtUsername.setBounds(38, 79, 331, 27);
		contentPane.add(txtUsername);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = txtUsername.getText();
				String passValue = txtPassword.getText();
				
				User user = new User(userValue, passValue);
				
				try {
					ValidationUtil.validate(user);
					LoginService loginService = new LoginService();
					if(loginService.authenticate(user)) {
						System.out.println("Login successfull!");
						new MainFrame().setVisible(true);
						dispose();
					}
					else {
						System.out.println("Invalid username or password.");
						JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");	
					}
				} catch (ValidationException | NullPointerException exception) {
					System.out.println("Data tidak valid : " + exception.getMessage());
					JOptionPane.showMessageDialog(null,  "Login Gagal: " + exception.getMessage());
				}finally {
					System.out.println("Selalu di eksekusi");
				}
			}
		});
		btnNewButton.setFont(new Font("STZhongsong", Font.BOLD, 14));
		btnNewButton.setBounds(164, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
}
