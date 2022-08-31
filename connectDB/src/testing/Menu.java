package testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.SystemColor;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 156, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu1");
		mnNewMenu.setBackground(SystemColor.controlShadow);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu1.1");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Menu1.2");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Menu1.3");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Menu1.3.1");
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Menu1.3.2");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Menu2");
		mnNewMenu_1.setBackground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Menu2");
		menuBar.add(mnNewMenu_2);
	}

}
