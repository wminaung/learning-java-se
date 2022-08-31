package loginproject;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Infromation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(133, 29, 136, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(82, 81, 251, 107);
		contentPane.add(jsp);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Phone No", "Name", "Address"
			}
		));
		
		Connection con;
		try {
			con = DatabaseConnection.initializeDatabase();
			String sql = "select * from user;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String name	 = rs.getString("user_name");
				String phone	 = rs.getString("phone");
				String address	 = rs.getString("address");
				((DefaultTableModel)table.getModel()).addRow(new Object[] {phone, name, address});	
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		jsp.setViewportView(table);
	}
}
