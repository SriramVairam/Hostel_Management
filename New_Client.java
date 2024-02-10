import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class New_Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtdistrict;
	private JTextField txtnumber;
	private JTextField txtgender;
	private JTextField txtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Client frame = new New_Client();
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
	public New_Client() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter The Detail");
		lblNewLabel.setBounds(295, 24, 302, 97);
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(180, 159, 100, 32);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(75, 0, 130));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setBounds(180, 237, 100, 32);
		lblNewLabel_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Field");
		lblNewLabel_1_2.setBounds(180, 312, 100, 32);
		lblNewLabel_1_2.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("District");
		lblNewLabel_1_3.setBounds(180, 386, 100, 32);
		lblNewLabel_1_3.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		txtname = new JTextField();
		txtname.setBounds(418, 169, 190, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtdistrict = new JTextField();
		txtdistrict.setBounds(418, 396, 190, 20);
		txtdistrict.setColumns(10);
		contentPane.add(txtdistrict);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome_Page window = new Welcome_Page();
				window.frame.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(10, 541, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone No");
		lblNewLabel_1_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(180, 462, 100, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtnumber = new JTextField();
		txtnumber.setColumns(10);
		txtnumber.setBounds(418, 472, 190, 20);
		contentPane.add(txtnumber);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clientname,clientgender,clientfield,clientdistrict,clientphone;
				clientname=txtname.getText();
				clientgender=txtgender.getText();
				clientfield=txtfield.getText();
				clientdistrict=txtdistrict.getText();
				clientphone=txtnumber.getText();
				Connect();
				try {
					pst=con.prepareStatement("insert into ROOM(Nam,Gender,Field,District,Phone)values(?,?,?,?,?)");
					pst.setString(1, clientname);
					pst.setString(2, clientgender);
					pst.setString(3, clientfield);
					pst.setString(4, clientdistrict);
					pst.setString(5, clientphone);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "RECORD ADD");
					//table_load();
					txtname.setText("");
					txtgender.setText("");
					txtfield.setText("");
					txtdistrict.setText("");
					txtnumber.setText("");
					txtname.requestFocus();
				}
				catch(SQLException e1) {
					
				}
			}
		});
		btnSave.setForeground(new Color(210, 105, 30));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBackground(Color.BLACK);
		btnSave.setBounds(333, 530, 89, 23);
		contentPane.add(btnSave);
		
		txtgender = new JTextField();
		txtgender.setColumns(10);
		txtgender.setBounds(418, 247, 190, 20);
		contentPane.add(txtgender);
		
		txtfield = new JTextField();
		txtfield.setColumns(10);
		txtfield.setBounds(418, 322, 190, 20);
		contentPane.add(txtfield);
	}
}
