package loginproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EgMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EgMenu frame = new EgMenu();
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
	public EgMenu() {
		setTitle("eg menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Java Project");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Project");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Package");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open File");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Open Project");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Edit");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Undo Typing");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("Redo");
		mnNewMenu_2.add(mntmNewMenuItem_5_1);
		
		JMenuItem mntmNewMenuItem_5_2 = new JMenuItem("Cut");
		mnNewMenu_2.add(mntmNewMenuItem_5_2);
		
		JMenuItem mntmNewMenuItem_5_3 = new JMenuItem("Copy");
		mnNewMenu_2.add(mntmNewMenuItem_5_3);
		
		JMenu mnNewMenu_3 = new JMenu("Source");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Toggle Comment");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_6_1 = new JMenuItem("Add Block Comment");
		mnNewMenu_3.add(mntmNewMenuItem_6_1);
		
		JMenuItem mntmNewMenuItem_6_1_1 = new JMenuItem("Remove Block Comment");
		mnNewMenu_3.add(mntmNewMenuItem_6_1_1);
	}

}
