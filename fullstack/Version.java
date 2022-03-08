package TestDBPack;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Version extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Version() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\THANASSIS\\AUEB\\MY_LECTURES\\JAVA\\Java-4-FullStackDev\\16x16\\Lightning.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 0.1");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsApp.mainFrame.setEnabled(true);
				StudentsApp.version.setVisible(false);
				
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnClose, BorderLayout.SOUTH);
		setTitle("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7");
	}

}
