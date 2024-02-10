import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class View_Room_Detail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Room_Detail frame = new View_Room_Detail();
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
	
	
	PreparedStatement pst;
	Connection con;
	ResultSet rs;
	public void Connect() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/LVSS_HOSTEL","root","3903");
		}
		catch(SQLException ex) {
			
		}
	}
	public void table_load(){
		Connect();
		try {
			pst=con.prepareStatement("SELECT * FROM ROOM");
			rs=pst.executeQuery();
			Table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public View_Room_Detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("View Client Detail");
		lblNewLabel_1.setBounds(250, 28, 348, 141);
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		contentPane.add(lblNewLabel_1);
		
		Table = new JTable();
		Table.setBackground(new Color(176, 224, 230));
		Table.setBounds(120, 150, 700, 399);
		contentPane.add(Table);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Welcome_Page window = new Welcome_Page();
				window.frame.setVisible(true);
			    dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(10, 530, 89, 23);
		contentPane.add(btnNewButton_1);
		table_load();
	}
}
