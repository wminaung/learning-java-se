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
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Update1() {
		setTitle("User List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User List");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(152, 25, 122, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 110, 81, 24);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(158, 111, 151, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Edit");
	
		btnNewButton.setBounds(152, 198, 89, 23);
		contentPane.add(btnNewButton);
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String sql = "select * from user";
			PreparedStatement stmt = con.prepareStatement(sql);	
			ResultSet rs =	stmt.executeQuery();
			
			while(rs.next()) {
			String name = rs.getString("user_name");
			comboBox.addItem(name);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)comboBox.getSelectedItem();
				UpdateDetail detail = new UpdateDetail(name);
				detail.setVisible(true);
			}
		});
		// END CONSTRUCT
	}
}
