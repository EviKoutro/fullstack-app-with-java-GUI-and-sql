package teachersMVC;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelperUtil {
	static class InsWinAdapter extends WindowAdapter{
		@Override
		public void windowActivated(WindowEvent e) {
			FrmStudentsInsert.frm_id.setText("");
			FrmStudentsInsert.frm_sname.setText("");
			FrmStudentsInsert.frm_fname.setText("");			
		}
	}
	
	static ActionListener insertCloseListener = (e) -> {
		StudentsApp.studSearchFrame.setEnabled(true);
		StudentsApp.studInsertFrame.setVisible(false);	
	};
	
	static ActionListener updateDeleteCloseListener = (e) -> {
		StudentsApp.studSearchFrame.setEnabled(true);
		StudentsApp.studUpdateFrame.setVisible(false);	
	};
	
	static ActionListener newEkpaidMainWindowListener = (e) -> {
		StudentsApp.studSearchFrame.setVisible(true);
		StudentsApp.mainFrame.setEnabled(false);	
	};
	
	static ActionListener openVersionMainWindowListener = (e) -> {
		StudentsApp.mainFrame.setEnabled(false);
		StudentsApp.version.setVisible(true);
	};
	
	static ActionListener closeMainWindowListener = (e) -> {
		System.exit(0);
	};
	
}
