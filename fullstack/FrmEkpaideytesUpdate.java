package TestDBPack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.*;

//import java.sql.Connection;
import java.sql.*;
//import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
//import javax.swing.border.LineBorder;
//import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class FrmEkpaideytesUpdate extends JFrame {
	JPanel contentPane;
	JTextField udfrm_sname;
	JTextField udfrm_fname;
	JTextField udfrm_id;
	PreparedStatement pst;
	ResultSet rs;
	
	public FrmEkpaideytesUpdate() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {	
				try{
					String sql = "SELECT TEACHER_ID, S_NAME, F_Name FROM TEACHERS WHERE S_NAME LIKE ?";
				    pst =  MainWindow.conn.prepareStatement(sql);
			        pst.setString(1, SearchForm.searchEpwnymoVar + '%');
			        rs = pst.executeQuery();
				      if (rs.next())
				      {
				        udfrm_id.setText(Integer.toString(rs.getInt("TEACHER_ID")));
				        udfrm_sname.setText(rs.getString("S_NAME"));
				        udfrm_fname.setText(rs.getString("F_Name"));
				      }
				      
					}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			      
			/*@Override
			public void windowDeactivated(WindowEvent e) {
				udfrm_id.setText("");
				udfrm_sname.setText("");
				udfrm_fname.setText("");
			}*/
		});
		
		setBackground(SystemColor.activeCaption);
		setTitle("\u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AD\u03C2");
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 296, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setForeground(new Color(153, 0, 0));
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ID.setBounds(9, 13, 56, 16);
		contentPane.add(lbl_ID);
		
		JLabel lbl_sname = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		lbl_sname.setForeground(new Color(153, 0, 0));
		lbl_sname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_sname.setBounds(9, 48, 56, 16);
		contentPane.add(lbl_sname);
		
		JLabel lbl_fname = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lbl_fname.setForeground(new Color(153, 0, 0));
		lbl_fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_fname.setBounds(9, 83, 56, 16);
		contentPane.add(lbl_fname);
		
		udfrm_id = new JTextField();
		udfrm_id.setEditable(false);
		udfrm_id.setBounds(78, 13, 56, 22);
		contentPane.add(udfrm_id);
		udfrm_id.setColumns(10);
		
		udfrm_sname = new JTextField();
		udfrm_sname.setBounds(78, 48, 189, 22);
		contentPane.add(udfrm_sname);
		udfrm_sname.setColumns(10);
		
		udfrm_fname = new JTextField();
		udfrm_fname.setBounds(78, 81, 189, 22);
		contentPane.add(udfrm_fname);
		udfrm_fname.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String query = "UPDATE teachers set S_NAME = ?, F_Name = ? where TEACHER_ID = ?";
				      PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
				      preparedStmt.setString(1, udfrm_sname.getText());
				      preparedStmt.setString(2, udfrm_fname.getText());
				      preparedStmt.setInt(3, Integer.parseInt(udfrm_id.getText()));
				      
				      int numberOfRowsAffected = preparedStmt.executeUpdate();
				      
				      JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
					  preparedStmt.close();	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				String query = "DELETE from teachers where TEACHER_ID = ?";
			      PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
			      preparedStmt.setInt(1, Integer.parseInt(udfrm_id.getText()));

			      // execute the prepared statement
			      int dialogButton;
	              dialogButton = JOptionPane.showConfirmDialog (null, "Είστε σίγουρος;", 
	            		  "Warning", JOptionPane.YES_NO_OPTION);

                  if (dialogButton == JOptionPane.YES_OPTION){
                	  int numberOfRowsAffected = preparedStmt.executeUpdate();
                	  JOptionPane.showMessageDialog (null, numberOfRowsAffected + " rows deleted successfully", 
    	            		  "DELETE", JOptionPane.INFORMATION_MESSAGE);
                	  
                  }
                  else {}
			}
			 catch (SQLException e6)
			{
				e6.printStackTrace();
			}
			}
		});
		
		btnDelete.setBounds(9, 165, 89, 25);
		contentPane.add(btnDelete);
		btnUpdate.setBounds(91, 165, 92, 25);
		contentPane.add(btnUpdate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setEnabled(true);
				TeachersApp.ekpaidUpdateFrame.setVisible(false);	
			}
		});
		btnClose.setBounds(180, 165, 95, 25);
		contentPane.add(btnClose);
		
		JButton btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon("C:\\THANASSIS\\AUEB\\MY_LECTURES\\JAVA\\Java-4-FullStackDev\\16x16\\First record.png"));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.first()){
				        udfrm_id.setText(Integer.toString(rs.getInt("TEACHER_ID")));
				        udfrm_sname.setText(rs.getString("S_NAME"));
				        udfrm_fname.setText(rs.getString("F_Name"));
					} else{
						JOptionPane.showMessageDialog(null, 
							"Δεν υπάρχουν εγγραφές", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
					} 
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnFirst.setBounds(9, 132, 39, 25);
		contentPane.add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.setIcon(new ImageIcon("C:\\THANASSIS\\AUEB\\MY_LECTURES\\JAVA\\Java-4-FullStackDev\\16x16\\Previous_record.png"));
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.previous()) { 
						udfrm_id.setText(Integer.toString(rs.getInt("TEACHER_ID")));
				        udfrm_sname.setText(rs.getString("S_NAME"));
				        udfrm_fname.setText(rs.getString("F_Name"));
					} else
					{
						rs.first();
					}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		btnPrev.setBounds(44, 132, 39, 25);
		contentPane.add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("C:\\THANASSIS\\AUEB\\MY_LECTURES\\JAVA\\Java-4-FullStackDev\\16x16\\Next_track.png"));
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.next()){
				        udfrm_id.setText(Integer.toString(rs.getInt("TEACHER_ID")));
				        udfrm_sname.setText(rs.getString("S_NAME"));
				        udfrm_fname.setText(rs.getString("F_Name"));
					}
					else 
						rs.last();
					
				} catch (SQLException e4) {
					e4.printStackTrace();
				}
			}
		});
		
		btnNext.setBounds(78, 132, 46, 25);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon("C:\\THANASSIS\\AUEB\\MY_LECTURES\\JAVA\\Java-4-FullStackDev\\16x16\\Last_Record.png"));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					if (rs.last()) {
				        udfrm_id.setText(Integer.toString(rs.getInt("TEACHER_ID")));
				        udfrm_sname.setText(rs.getString("S_NAME"));
				        udfrm_fname.setText(rs.getString("F_Name"));
					} else{
						JOptionPane.showMessageDialog(null, 
								"Δεν υπάρχουν εγγραφές", "Κενό αποτέλεσμα", 
								JOptionPane.WARNING_MESSAGE);
						} 
				} catch (SQLException e5) {
					e5.printStackTrace();
				}
			}
		});
		
		btnLast.setBounds(120, 132, 39, 25);
		contentPane.add(btnLast);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 115, 257, 2);
		contentPane.add(separator);
	

}
}
