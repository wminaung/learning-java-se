package testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option1 extends JFrame {

	private JPanel contentPane;
	private JButton threeBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option1 frame = new Option1();
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
	public Option1() {
		setTitle("Option1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton oneBtn = new JButton("one");
	
		oneBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		oneBtn.setBounds(128, 28, 89, 23);
		contentPane.add(oneBtn);
		
		JButton twoBtn = new JButton("two");
	
		twoBtn.setBounds(113, 83, 89, 23);
		contentPane.add(twoBtn);
		
		threeBtn = new JButton("three");
		
		threeBtn.setBounds(148, 148, 89, 23);
		contentPane.add(threeBtn);
		
		oneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Welcome", "Hello", JOptionPane.WARNING_MESSAGE);
			
			
			}
		});
		
		twoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String zz =	JOptionPane.showInputDialog(null, "Name", "your Name?", JOptionPane.QUESTION_MESSAGE);
			System.out.println(zz);
			}
		});
		
		threeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int a =	JOptionPane.showConfirmDialog(null, "Who are you?");
				
			if (a == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			
			}
		});
		
		// end
	}
}
