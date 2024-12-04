package tugas;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.Font;
import java.util.ArrayList;

public class Array extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inputField;
    private JTextField checkField;
    private JTextArea dataArea;
    private ArrayList<Integer> dataList;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Array frame = new Array();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Array() {
        dataList = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 605, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblData = new JLabel("Masukkan Data");
        lblData.setFont(new Font("STZhongsong", Font.PLAIN, 14));
        lblData.setBounds(10, 64, 137, 14);
        contentPane.add(lblData);

        inputField = new JTextField();
        inputField.setFont(new Font("STZhongsong", Font.PLAIN, 12));
        inputField.setBounds(10, 84, 391, 38);
        contentPane.add(inputField);
        inputField.setColumns(10);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputText = inputField.getText();
                    String[] numbers = inputText.split(",");
                    dataList.clear();
                    for (String num : numbers) {
                        dataList.add(Integer.parseInt(num.trim()));
                    }
                    updateDataArea();
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka yang dipisahkan dengan koma.");
                }
            }
        });
        btnSimpan.setBounds(411, 84, 167, 38);
        contentPane.add(btnSimpan);

        JLabel lblData_2 = new JLabel("Data :");
        lblData_2.setFont(new Font("STZhongsong", Font.PLAIN, 14));
        lblData_2.setBounds(10, 154, 137, 14);
        contentPane.add(lblData_2);

        dataArea = new JTextArea();
        dataArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        dataArea.setBounds(60, 150, 518, 20);
        dataArea.setEditable(false);
        contentPane.add(dataArea);

        JLabel lbkCheckArray = new JLabel("Check Array Ke-");
        lbkCheckArray.setFont(new Font("STZhongsong", Font.PLAIN, 14));
        lbkCheckArray.setBounds(10, 191, 137, 26);
        contentPane.add(lbkCheckArray);

        checkField = new JTextField();
        checkField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        checkField.setBounds(138, 179, 263, 38);
        contentPane.add(checkField);
        checkField.setColumns(10);

        JButton btnCheck = new JButton("Check");
        btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(checkField.getText()) - 1; // Konversi dari 1-based ke 0-based
                    if (index >= 0 && index < dataList.size()) {
                        int value = dataList.get(index);
                        textField.setText("Index ke-" + (index + 1) + " adalah " + value);
                    } else {
                        textField.setText("Index di luar batas array.");
                    }
                } catch (NumberFormatException ex) {
                    textField.setText("Input harus berupa angka.");
                }
            }
        });

        btnCheck.setBounds(411, 179, 167, 38);
        contentPane.add(btnCheck);

        JLabel lblJudul = new JLabel("CHECK ARRAY");
        lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
        lblJudul.setFont(new Font("STZhongsong", Font.BOLD, 20));
        lblJudul.setBounds(165, 0, 236, 48);
        contentPane.add(lblJudul);
        
        JLabel lblHasil = new JLabel("Hasil : ");
        lblHasil.setFont(new Font("STZhongsong", Font.PLAIN, 18));
        lblHasil.setBounds(10, 249, 66, 37);
        contentPane.add(lblHasil);
        
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textField.setColumns(10);
        textField.setBounds(73, 251, 328, 38);
        contentPane.add(textField);
    }

    private void updateDataArea() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++) {
            sb.append(dataList.get(i));
            if (i < dataList.size() - 1) {
                sb.append(", ");
            }
        }
        dataArea.setText(sb.toString());
        
    }
}