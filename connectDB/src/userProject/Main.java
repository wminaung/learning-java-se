package userProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qung\\Pictures\\icon\\school-bag.png"));
		setTitle("User Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("view user");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\qung\\Pictures\\icon\\user.png"));
		
		btnNewButton.setBounds(10, 71, 145, 33);
		contentPane.add(btnNewButton);
		
		JButton btnAddNewUser = new JButton("add user");
		
		btnAddNewUser.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddNewUser.setIcon(new ImageIcon("C:\\Users\\qung\\Pictures\\icon\\add-user.png"));
		btnAddNewUser.setBounds(10, 130, 145, 33);
		contentPane.add(btnAddNewUser);
		
		JButton btnEditUser = new JButton("edit");
		
		btnEditUser.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditUser.setIcon(new ImageIcon("C:\\Users\\qung\\Pictures\\icon\\edit-user.png"));
		btnEditUser.setBounds(10, 182, 145, 33);
		contentPane.add(btnEditUser);
		
		JButton btnRemove = new JButton("remove user");
		
		btnRemove.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemove.setIcon(new ImageIcon("C:\\Users\\qung\\Pictures\\icon\\remove-user.png"));
		btnRemove.setBounds(10, 240, 145, 33);
		contentPane.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 73, 275, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Phone"
			}
		));
		scrollPane.setViewportView(table);

		
		JLabel lblNewLabel = new JLabel("User Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(137, 11, 227, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection con = DatabaseConnection.initializeDatabase();
				String sql = "select * from user";
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs =	stmt.executeQuery();
				((DefaultTableModel)table.getModel()).setNumRows(0); // remove all rows 
				while(rs.next()) {
					String name = rs.getString("user_name");	
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					((DefaultTableModel)table.getModel()).addRow(new Object[] {name, address, phone});
				}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser user = new AddUser();
				user.setVisible(true);
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUser delete = new DeleteUser();
				delete.setVisible(true);
				
			}
		});
		
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update1 update = new Update1();
				update.setVisible(true);
			}
		});
		//end main
	}
}
