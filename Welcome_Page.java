import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Welcome_Page {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_Page window = new Welcome_Page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome_Page() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(233, 150, 122));
		frame.setBounds(100, 100, 914, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO LVSS HOSTEL");
		lblNewLabel.setBounds(206, 11, 517, 158);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBackground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Client Detail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View_Room_Detail one=new View_Room_Detail();
				one.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(329, 180, 250, 50);
		btnNewButton.setForeground(new Color(210, 105, 30));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddNew = new JButton("Add New Client");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New_Client second=new New_Client();
				second.setVisible(true);
				frame.dispose();
				
			}
		});
		btnAddNew.setBounds(329, 296, 250, 50);
		btnAddNew.setForeground(new Color(210, 105, 30));
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddNew.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(btnAddNew);
		
		JButton btnEdit = new JButton("Edit Client Detail");
		btnEdit.setBounds(329, 415, 250, 50);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Edit_Delete three=new Edit_Delete();
				three.setVisible(true);
				frame.dispose();
				
			}
		});
		btnEdit.setForeground(new Color(210, 105, 30));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(btnEdit);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(210, 105, 30));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(10, 529, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
