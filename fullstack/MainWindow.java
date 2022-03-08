package TestDBPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	JPanel contentPane;
	static Connection conn;
			
	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AUEB Coding Factory");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String url = "jdbc:mysql://localhost:3306/students";
				String username = "testUser";
				String password = "6974856858";

				try {
					conn = DriverManager.getConnection(url, username, password);
				} catch (SQLException ex) {
				    throw new IllegalStateException("Cannot connect to database!", ex);
				}
			}
		});
		setBounds(100, 100, 421, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu appMenuInFileMenu = new JMenu("App");
		fileMenu.add(appMenuInFileMenu);
		
		JMenuItem itemCloseInAppMenu = new JMenuItem("Close");
		itemCloseInAppMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		appMenuInFileMenu.add(itemCloseInAppMenu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton buttonEkpaid = new JButton("");
		buttonEkpaid.setBounds(25, 110, 33, 27);
		buttonEkpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setVisible(true);
				TeachersApp.mainFrame.setEnabled(false);
			}
		});
		
		JLabel lbl_ekpaid = new JLabel("\u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AD\u03C2");
		lbl_ekpaid.setBounds(70, 110, 95, 27);
		lbl_ekpaid.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ekpaid.setForeground(new Color(153, 0, 0));
		lbl_ekpaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		
		//contentPane.paintComponent(g);
		//g.setColor( Color.RED );
		//g.drawLine( 0, 200, 500, 200 );
			
		JLabel lbl_qualityGreen = new JLabel("\u03A0\u03BF\u03B9\u03CC\u03C4\u03B7\u03C4\u03B1 \u03C3\u03C4\u03B7\u03BD \u0395\u03BA\u03C0\u03B1\u03AF\u03B4\u03B5\u03C5\u03C3\u03B7");
		lbl_qualityGreen.setBounds(5, 34, 387, 47);
		lbl_qualityGreen.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_qualityGreen.setForeground(new Color(0, 100, 0));
		lbl_qualityGreen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_qualityGreen);
		
		JLabel lbl_qualityGray = new JLabel("\u03A0\u03BF\u03B9\u03CC\u03C4\u03B7\u03C4\u03B1 \u03C3\u03C4\u03B7\u03BD \u0395\u03BA\u03C0\u03B1\u03AF\u03B4\u03B5\u03C5\u03C3\u03B7");
		lbl_qualityGray.setBounds(6, 36, 387, 47);
		lbl_qualityGray.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_qualityGray.setForeground(Color.GRAY);
		lbl_qualityGray.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lbl_qualityGray);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 84, 373, 1);
		contentPane.add(separator);
		contentPane.add(buttonEkpaid);
		
		JButton btnEkpaid = new JButton("");
		btnEkpaid.setBounds(25, 150, 33, 27);
		btnEkpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.mainFrame.setEnabled(false);
				TeachersApp.version.setVisible(true);
				
			}
		});
		contentPane.add(btnEkpaid);
		contentPane.add(lbl_ekpaid);
		
		JLabel lbl_version = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7");
		lbl_version.setBounds(70, 150, 62, 27);
		lbl_version.setForeground(new Color(153, 0, 0));
		lbl_version.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbl_version);
		
	}
}
