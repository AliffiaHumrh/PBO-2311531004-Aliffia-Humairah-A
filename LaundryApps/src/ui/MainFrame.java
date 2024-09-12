package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(130, 177, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_judul = new JLabel("Laundry Apps");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Harrington", Font.BOLD, 20));
		lbl_judul.setBounds(122, 28, 309, 36);
		contentPane.add(lbl_judul);
		
		JButton btn_pesanan = new JButton("PESANAN");
		btn_pesanan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_pesanan.setBackground(new Color(198, 219, 227));
		btn_pesanan.setBounds(46, 115, 140, 75);
		contentPane.add(btn_pesanan);
		
		JButton btn_layanan = new JButton("LAYANAN");
		btn_layanan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_layanan.setBackground(new Color(198, 219, 227));
		btn_layanan.setBounds(211, 115, 140, 75);
		contentPane.add(btn_layanan);
		
		JButton btn_pelanggan = new JButton("PELANGGAN");
		btn_pelanggan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_pelanggan.setBackground(new Color(198, 219, 227));
		btn_pelanggan.setBounds(375, 115, 140, 75);
		contentPane.add(btn_pelanggan);
		
		JButton btn_pengguna = new JButton("PENGGUNA");
		btn_pengguna.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_pengguna.setBackground(new Color(198, 219, 227));
		btn_pengguna.setBounds(46, 265, 140, 75);
		contentPane.add(btn_pengguna);
		
		JButton btn_laporan = new JButton("LAPORAN");
		btn_laporan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_laporan.setBackground(new Color(198, 219, 227));
		btn_laporan.setBounds(211, 265, 140, 75);
		contentPane.add(btn_laporan);
		
		JButton btn_profile = new JButton("PROFILE");
		btn_profile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_profile.setBackground(new Color(198, 219, 227));
		btn_profile.setBounds(375, 265, 140, 75);
		contentPane.add(btn_profile);
		
		JButton btn_keluar = new JButton("KELUAR");
		btn_keluar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_keluar.setBackground(new Color(198, 219, 227));
		btn_keluar.setBounds(178, 425, 206, 36);
		contentPane.add(btn_keluar);
		
		JLabel lbl_males = new JLabel("Males aja nyuci, biar kami yang nyuciin");
		lbl_males.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_males.setFont(new Font("STZhongsong", Font.BOLD, 13));
		lbl_males.setBounds(132, 62, 309, 27);
		contentPane.add(lbl_males);
	}

}