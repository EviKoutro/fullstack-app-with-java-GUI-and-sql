package teachersMVC;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
//import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class StudModel {
		
	static class ConnWinAdapter extends WindowAdapter{
		@Override
		public void windowOpened(WindowEvent e) {
			String url = "jdbc:mysql://localhost:3306/students";
			String username = "testUser";
			String password = "6974856858";

			try {
				MainWindow.conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
			    throw new IllegalStateException("Cannot connect the database!", ex);
			}
			
		}
	};
	
	static ActionListener insertListener = (e) -> {
		try {
			int t_id = Integer.parseInt(FrmStudentsInsert.frm_id.getText());
			String t_sname = FrmStudentsInsert.frm_sname.getText();
			String t_fname = FrmStudensInsert.frm_fname.getText();
			
			PreparedStatement p = (PreparedStatement) 
					MainWindow.conn.prepareStatement("INSERT INTO STUDENTS VALUES (?, ?, ?)");
			p.setInt(1, t_id);
			p.setString(2, t_sname);
			p.setString(3, t_fname);
			p.executeUpdate();
			JOptionPane.showMessageDialog(null,"Record inserted.", "INSERT", JOptionPane.PLAIN_MESSAGE);
			p.close();
		} catch (SQLException e1) {
			//e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Inalid Key for STUDENT ID, Please try again", 
					"Error", JOptionPane.WARNING_MESSAGE);
			
		} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Δώστε στοιχεία Μαθητή", "Αποτυχία Εισαγωγής", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	
	static class UpdateDeleteWindowAdapter extends WindowAdapter{
		@Override
		public void windowActivated(WindowEvent e) {
			
			try{
			String sql = "SELECT STUDENT_ID, S_NAME, F_NAME FROM students WHERE S_NAME LIKE ?";
	
			FrmStudentsUpdate.pst =  MainWindow.conn.prepareStatement(sql);
			FrmStudentsUpdate.pst.setString(1, SearchForm.searchEpwnymoVar + '%');
	
			FrmStudentsUpdate.rs = FrmStudentsUpdate.pst.executeQuery();
		      if (FrmStudentsUpdate.rs.next())
		      {
		    	  FrmStudentsUpdate.udfrm_id.setText(Integer.toString(FrmStudentsUpdate.rs.getInt("STUDENT_ID")));
		    	  FrmStudentsUpdate.udfrm_sname.setText(FrmStudentsUpdate.rs.getString("S_NAME"));
		    	  FrmStudentsUpdate.udfrm_fname.setText(FrmStudentsUpdate.rs.getString("F_Name"));
		      }
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		      
		@Override
		public void windowDeactivated(WindowEvent e) {
			FrmStudentsUpdate.udfrm_id.setText("");
			FrmStudentsUpdate.udfrm_sname.setText("");
			FrmStudentsUpdate.udfrm_fname.setText("");
		}
	};
	
	
	
	static ActionListener updateListener = (e) -> {
		try {
			
			  String query = "UPDATE students set S_NAME = ?, F_Name = ? where STUDENT_ID = ?";
		      PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
		      preparedStmt.setString(1, FrmStudentsUpdate.udfrm_sname.getText());
		      preparedStmt.setString(2, FrmStudentsUpdate.udfrm_fname.getText());
		      preparedStmt.setInt(3, Integer.parseInt(FrmStudentsUpdate.udfrm_id.getText()));
		      
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      JOptionPane.showMessageDialog(null,"Update Done","UPDATE", JOptionPane.PLAIN_MESSAGE);
			  preparedStmt.close();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Not Successful Update", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	};

	static ActionListener deleteListener = (e) -> {
		try{
			String query = "DELETE from students where STUDENT_ID = ?";
		      PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
		      preparedStmt.setInt(1, Integer.parseInt(FrmStudentsUpdate.udfrm_id.getText()));

		      // execute the prepared statement
		      int dialogButton;
              dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?", 
            		  "Warning", JOptionPane.YES_NO_OPTION);

              if (dialogButton == JOptionPane.YES_OPTION) preparedStmt.execute();
              else {}
		}
		 catch (SQLException e6)
		{
			e6.printStackTrace();
			 
		}catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Not Successful Delete", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
	};
	
	
	static ActionListener firstRecordListener = (e) -> {
		try {
			if (FrmStudentsUpdate.rs.first()){
		        FrmStudentsUpdate.udfrm_id.setText(Integer.toString(FrmStudentsUpdate.rs.getInt("STUDENT_ID")));
		        FrmStudentsUpdate.udfrm_sname.setText(FrmStudentsUpdate.rs.getString("S_NAME"));
		        FrmStudentsUpdate.udfrm_fname.setText(FrmStudentsUpdate.rs.getString("F_Name"));
			} else{
				JOptionPane.showMessageDialog(null, 
					"Δεν υπάρχουν εγγραφές", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
			} 
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	};
	
	static ActionListener previousRecordListener = (e) -> {
		try {
			if (FrmStudentsUpdate.rs.previous()) { 
				FrmStudentsUpdate.udfrm_id.setText(Integer.toString(FrmStudentsUpdate.rs.getInt("STUDENT_ID")));
				FrmStudentsUpdate.udfrm_sname.setText(FrmStudentsUpdate.rs.getString("S_NAME"));
				FrmStudentsUpdate.udfrm_fname.setText(FrmStudentsUpdate.rs.getString("F_Name"));
			} else
			{
				FrmStudentsUpdate.rs.first();
			}
		} catch (SQLException e3) {
			e3.printStackTrace();
		}	
	};
	
	
	static ActionListener nextRecordListener = (e) -> {
		try {
			if (FrmStudentsUpdate.rs.next()){
				FrmStudentsUpdate.udfrm_id.setText(Integer.toString(FrmStudentsUpdate.rs.getInt("STUDENT_ID")));
				FrmStudentsUpdate.udfrm_sname.setText(FrmStudentsUpdate.rs.getString("S_NAME"));
				FrmStudentsUpdate.udfrm_fname.setText(FrmStudentsUpdate.rs.getString("F_Name"));
			}
			else 
				FrmStudentsUpdate.rs.last();
			
		} catch (SQLException e4) {
			e4.printStackTrace();
		}	
	};
	
	static ActionListener lastRecordListener = (e) -> {
		try {
			if (FrmStudentsUpdate.rs.last()) {
				FrmStudentsUpdate.udfrm_id.setText(Integer.toString(FrmStudentsUpdate.rs.getInt("STUDENT_ID")));
				FrmStudentsUpdate.udfrm_sname.setText(FrmStudentsUpdate.rs.getString("S_NAME"));
				FrmStudentsUpdate.udfrm_fname.setText(FrmStudentsUpdate.rs.getString("F_Name"));
			} else{
				JOptionPane.showMessageDialog(null, 
						"Δεν υπάρχουν εγγραφές", "Κενό αποτέλεσμα", 
						JOptionPane.WARNING_MESSAGE);
				} 
		} catch (SQLException e5) {
			e5.printStackTrace();
		}	
	};
}
