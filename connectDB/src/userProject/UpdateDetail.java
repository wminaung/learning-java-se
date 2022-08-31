package userProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDetail extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public Connection con = null ;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	/**
	 * Create the frame.
	 */
	public UpdateDetail(String name) {
		setTitle("Detail Infromation");
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(117, 11, 195, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 65, 106, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(23, 104, 106, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(23, 146, 106, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JButton updateBtn = new JButton("Update");
	
		updateBtn.setBounds(148, 212, 89, 23);
		contentPane.add(updateBtn);
		
		txt1 = new JTextField();
		txt1.setBounds(176, 66, 178, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(176, 105, 178, 20);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(176, 147, 178, 20);
		contentPane.add(txt3);
		

		try {
			con = DatabaseConnection.initializeDatabase();
			String sql = "Select * from user where user_name=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();		
			if(rs.next()) {
				String name1 = rs.getString("user_name");
				String  address = rs.getString("address");
				String phone = rs.getString("phone");
				this.setText(name1, address, phone);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sql = "Update user set user_name=?, address=?, phone=? where user_name=?";
				try {
					PreparedStatement stmt = con.prepareStatement(sql);
			
					stmt.setString(1, txt1.getText());
					stmt.setString(2, txt2.getText());
					stmt.setString(3, txt3.getText());
					stmt.setString(4, name);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					con.close();
					setText("", "", "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		// end construct
	}
	public void setText(String name, String address, String phone) {
		txt1.setText(name);
		txt2.setText(address);
		txt3.setText(phone);
	}
	
}
