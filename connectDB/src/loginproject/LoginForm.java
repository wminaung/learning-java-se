package loginproject;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
		lblNewLabel.setBounds(160, 24, 112, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 78, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(28, 138, 72, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txt = new JTextField();
		txt.setBounds(170, 76, 170, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(170, 136, 170, 20);
		contentPane.add(pwd);
		
		JLabel lbl = new JLabel("");
		lbl.setForeground(Color.RED);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl.setBounds(170, 178, 170, 14);
		contentPane.add(lbl);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt.getText();
				String password = String.valueOf(pwd.getPassword());
				lbl.setText("");
			
				try {
					Connection con = DatabaseConnection.initializeDatabase();
					String sql = "select * from user where user_name= ? and password=?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, name);
					stmt.setString(2, password);
					ResultSet rs = stmt.executeQuery();
					boolean flag = false;	
					while(rs.next()) {
						flag = true;
					}
					if(flag) {
						
						UserList ul = new UserList(); // call constructor 
						ul.setVisible(true);
						
						txt.setText("");
						pwd.setText("");
					}else {
						lbl.setText("Invalid User");
						txt.setText("");
						pwd.setText("");
					}
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(160, 203, 88, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
