package userProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AddUser() {
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registation Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(130, 25, 179, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 76, 102, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 158, 102, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone No:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 201, 102, 20);
		contentPane.add(lblNewLabel_1_2);
		
		txt1 = new JTextField();
		txt1.setBounds(223, 77, 159, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(223, 159, 159, 20);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(223, 202, 159, 20);
		contentPane.add(txt3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(10, 116, 102, 20);
		contentPane.add(lblNewLabel_1_3);
		
		pwd = new JPasswordField();
		pwd.setBounds(223, 117, 159, 20);
		contentPane.add(pwd);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txt1.getText();
					String address = txt2.getText();
					String phone = txt3.getText();
					String password = String.valueOf(pwd.getPassword());
					
					Connection con = DatabaseConnection.initializeDatabase();	
					String sql = "insert into user(user_name, address, phone, password) values(?,?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, name);
					stmt.setString(2, address);
					stmt.setString(3, phone);
					stmt.setString(4, password);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Registered");
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					pwd.setText("");
					
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(130, 254, 137, 23);
		contentPane.add(btnNewButton);
	}
}
