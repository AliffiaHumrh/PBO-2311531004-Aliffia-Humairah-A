package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.OrderDetailRepo;
import DAO.ServiceRepo;
import model.OrderDetail;
import model.Service;
import table.TableOrderDetail;
import table.TableService;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetailFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JTextField txtOrderID;
	private JTextField txtTanggal;
	private JTextField txtTglPengambilan;

	/**
	 * Launch the application.
	 */
	ServiceRepo srvc = new ServiceRepo();
	List<Service> ls;
	String id;
	private JTable tableLayanan;
	
	public void loadTable() {
		ls = srvc.show();
		TableService tu = new TableService(ls);
		tableLayanan.setModel(tu);;
		tableLayanan.getTableHeader().setVisible(true);	
	}
	
	private double total(double harga, double qty) {
		return harga * qty;
	}
	private double hargabagi (double harga, double quantity) {
		return harga / quantity;
	}
	OrderDetailRepo odf = new OrderDetailRepo();
	List<OrderDetail> ls_1;
	
	public void loadDataOrderDetail() {
	    ls_1 = odf.show(""); // Ambil data dari repo
	    TableOrderDetail tu = new TableOrderDetail(ls_1); // Pastikan ini menggunakan data yang benar
	   	}
	public void reset () {
		txtHarga.setText("");
		txtJumlah.setText("");
		txtTotal.setText("");
	}
	
	LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = today.format(formatter);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailFrame frame = new OrderDetailFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderDetailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 198, 434);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Order ID");
		lblNewLabel_2.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 23, 78, 14);
		panel.add(lblNewLabel_2);
		
		txtOrderID = new JTextField();
		txtOrderID.setBounds(10, 37, 164, 20);
		panel.add(txtOrderID);
		txtOrderID.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pelanggan");
		lblNewLabel_2_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 68, 108, 14);
		panel.add(lblNewLabel_2_1);
		
		JComboBox cmbPelanggan = new JComboBox();
		cmbPelanggan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cmbPelanggan.setModel(new DefaultComboBoxModel(new String[] {"Pilih"}));
		cmbPelanggan.setBounds(10, 82, 164, 22);
		panel.add(cmbPelanggan);
		
		JLabel lblNewLabel_3 = new JLabel("Tanggal");
		lblNewLabel_3.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 115, 78, 14);
		panel.add(lblNewLabel_3);
		
		txtTanggal = new JTextField();
		txtTanggal.setColumns(10);
		txtTanggal.setBounds(10, 129, 164, 20);
		panel.add(txtTanggal);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tanggal Pengambilan");
		lblNewLabel_3_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(10, 160, 153, 14);
		panel.add(lblNewLabel_3_1);
		
		txtTglPengambilan = new JTextField();
		txtTglPengambilan.setColumns(10);
		txtTglPengambilan.setBounds(10, 175, 164, 20);
		panel.add(txtTglPengambilan);
		
		JLabel lblNewLabel_3_2 = new JLabel("Status");
		lblNewLabel_3_2.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(10, 206, 78, 14);
		panel.add(lblNewLabel_3_2);
		
		JComboBox cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"Proses", "Selesai"}));
		cmbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cmbStatus.setBounds(10, 220, 164, 22);
		panel.add(cmbStatus);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 252, 108, 14);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Rp 10.000");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_2.setBounds(10, 265, 108, 14);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Pembayaran");
		lblNewLabel_3_1_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(10, 290, 153, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JComboBox cmbPembayaran = new JComboBox();
		cmbPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Qris", "Transfer"}));
		cmbPembayaran.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cmbPembayaran.setBounds(10, 307, 164, 22);
		panel.add(cmbPembayaran);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Status Pembayaran ");
		lblNewLabel_3_1_1_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel_3_1_1_1.setBounds(10, 340, 153, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		JComboBox cmbPembayaran_1 = new JComboBox();
		cmbPembayaran_1.setModel(new DefaultComboBoxModel(new String[] {"Lunas", "Belum Lunas"}));
		cmbPembayaran_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cmbPembayaran_1.setBounds(10, 354, 164, 22);
		panel.add(cmbPembayaran_1);
		
		JButton btnSimpan_1 = new JButton("Simpan");
		btnSimpan_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnSimpan_1.setBounds(10, 400, 87, 23);
		panel.add(btnSimpan_1);
		
		JButton btnBatal_1 = new JButton("Batal");
		btnBatal_1.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnBatal_1.setBounds(107, 401, 81, 23);
		panel.add(btnBatal_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 123, 253, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(10, 28, 110, 20);
		panel_1.add(txtHarga);
		txtHarga.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Harga/Kg");
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 3, 86, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblJumlah.setBounds(10, 59, 86, 14);
		panel_1.add(lblJumlah);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("STZhongsong", Font.BOLD, 12));
		lblTotal.setBounds(10, 122, 86, 14);
		panel_1.add(lblTotal);
		
		txtJumlah = new JTextField();
		txtJumlah.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
		            if (txtJumlah.getText().isEmpty() || txtHarga.getText().isEmpty()) {
		                txtTotal.setText("");
		                txtJumlah.setText("");
		            } else {
		                double harga = Double.parseDouble(txtHarga.getText());
		                double quantity = Double.parseDouble(txtJumlah.getText());
		                txtTotal.setText("" + total(harga, quantity));
		                txtJumlah.setText("" + total(harga, quantity));
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers in the Harga and Jumlah fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(10, 84, 110, 20);
		panel_1.add(txtJumlah);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(10, 147, 110, 20);
		panel_1.add(txtTotal);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail orderdtl = new OrderDetail();
				orderdtl.setJumlah(txtJumlah.getText());
				orderdtl.setTotal(txtTotal.getText());
				reset();
				odf.save(orderdtl);
				loadTable();
				loadDataOrderDetail();
			}
		});
		btnSimpan.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnSimpan.setBounds(154, 11, 89, 23);
		panel_1.add(btnSimpan);
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail orderdtl = new OrderDetail();
				orderdtl.setJumlah(txtJumlah.getText());
				orderdtl.setTotal(txtTotal.getText());
				orderdtl.setId(id);
				odf.update(orderdtl);
				reset();
				loadTable();
				loadDataOrderDetail();
			}
		});
		btnUbah.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnUbah.setBounds(154, 55, 89, 23);
		panel_1.add(btnUbah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					odf.delete(id);
					reset();
					loadTable();
					loadDataOrderDetail();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnHapus.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnHapus.setBounds(154, 99, 89, 23);
		panel_1.add(btnHapus);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame main = new MainFrame();
				main.setVisible(true);
				dispose();
			}
		});
		btnBatal.setFont(new Font("STZhongsong", Font.BOLD, 12));
		btnBatal.setBounds(154, 145, 89, 23);
		panel_1.add(btnBatal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 312, 253, 133);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Layanan");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(218, 11, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 28, 252, 84);
		contentPane.add(scrollPane_1);
		
		tableLayanan = new JTable();
		scrollPane_1.setViewportView(tableLayanan);
		
		JButton btnKembali = new JButton("Kembali");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame login = new MainFrame ();
				login.setVisible(true);
				dispose();
			}
		});
		btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnKembali.setBounds(140, 456, 198, 23);
		contentPane.add(btnKembali);
		tableLayanan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHarga.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(),2).toString());
			}
			
		});
	}
}
