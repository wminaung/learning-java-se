package userProject;



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

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DeleteUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(172, 22, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(47, 82, 89, 21);
		contentPane.add(lblNewLabel_1);
		
		JComboBox <String>comboBox = new JComboBox<>();
		comboBox.setBounds(212, 82, 152, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete ");
	
		btnNewButton.setBounds(183, 198, 89, 23);
		contentPane.add(btnNewButton);
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String sql = "select * from user";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("user_name");	
				comboBox.addItem(name);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =  (String)comboBox.getSelectedItem();
				try {
					Connection con = DatabaseConnection.initializeDatabase();
					String sql = "delete from user where user_name=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, name);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted Successful");
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		// end construct
	}
}
