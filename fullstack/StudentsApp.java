package TestDBPack;
import java.awt.EventQueue;

public class StudentsApp {
	static MainWindow mainFrame;
	static FrmEkpaideytesInsert ekpaidInsertFrame;
	static FrmEkpaideytesUpdate ekpaidUpdateFrame;
	static SearchForm ekpaidSearchFrame;
	static Version version;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {							
					mainFrame = new MainWindow();
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);
					
					ekpaidInsertFrame = new FrmEkpaideytesInsert();
					ekpaidInsertFrame.setLocationRelativeTo(null);
					ekpaidInsertFrame.setVisible(false);
					
					ekpaidUpdateFrame = new FrmEkpaideytesUpdate();
					ekpaidUpdateFrame.setLocationRelativeTo(null);
					ekpaidUpdateFrame.setVisible(false);
					
					ekpaidSearchFrame = new SearchForm();
					ekpaidSearchFrame.setLocationRelativeTo(null);
					ekpaidSearchFrame.setVisible(false);
					
					version = new Version();
					version.setLocationRelativeTo(null);
					version.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}}
