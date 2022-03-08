package TestDBPack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.*;


import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;


//import javax.swing.border.LineBorder;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FrmMathitesInsert extends JFrame {

	JPanel contentPane;
	JTextField frm_sname;
	JTextField frm_fname;
	JTextField frm_id;
	

	
	public FrmMathitesInsert() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				frm_id.setText("");
				frm_sname.setText("");
				frm_fname.setText("");	
			}
		});
		setBackground(SystemColor.activeCaption);
		setTitle("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 270);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ID = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2");
		lbl_ID.setForeground(new Color(153, 0, 0));
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ID.setBounds(58, 37, 56, 16);
		contentPane.add(lbl_ID);
		
		JLabel lbl_sname = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		lbl_sname.setForeground(new Color(153, 0, 0));
		lbl_sname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_sname.setBounds(58, 72, 56, 16);
		contentPane.add(lbl_sname);
		
		JLabel lbl_fname = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lbl_fname.setForeground(new Color(153, 0, 0));
		lbl_fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_fname.setBounds(58, 107, 56, 16);
		contentPane.add(lbl_fname);
		
		frm_id = new JTextField();
		frm_id.setBounds(117, 37, 120, 22);
		contentPane.add(frm_id);
		frm_id.setColumns(12);
		
		frm_sname = new JTextField();
		frm_sname.setBounds(117, 71, 189, 22);
		contentPane.add(frm_sname);
		frm_sname.setColumns(10);
		
		frm_fname = new JTextField();
		frm_fname.setBounds(117, 107, 189, 22);
		contentPane.add(frm_fname);
		frm_fname.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setForeground(new Color(0, 0, 153));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int id = Integer.parseInt(frm_id.getText());
					String sname = frm_sname.getText();
					String fname = frm_fname.getText();
					
					PreparedStatement p =  MainWindow.conn.prepareStatement("INSERT INTO STUDENTS VALUES (?, ?, ?)");
					
					p.setInt(1, id);
					p.setString(2, sname);
					p.setString(3, fname);
					
					int n = p.executeUpdate();
					
					JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", 
							JOptionPane.PLAIN_MESSAGE);
					
					p.close();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				
				  }
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 170, 341, 2);
		contentPane.add(separator);
		btnInsert.setBounds(168, 185, 82, 25);
		contentPane.add(btnInsert);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsApp.ekpaidSearchFrame.setEnabled(true);
				StudentsApp.ekpaidInsertFrame.setVisible(false);	
			}
		});
		btnClose.setBounds(250, 185, 95, 25);
		contentPane.add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(18, 13, 329, 144);
		contentPane.add(panel);
	}
}
