import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;

public class Edit_Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtField;
	private JTextField txtDistrict;
	private JTextField txtName;
	private JTextField txtGender;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst;
	Connection con;
	ResultSet rs;
	private JTextField txtPhone;
	public void Connect() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/LVSS_HOSTEL","root","3903");
		}
		catch(SQLException ex) {
			
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Delete frame = new Edit_Delete();
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
	public Edit_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditOrDelete = new JLabel("Edit or Delete Record");
		lblEditOrDelete.setBounds(266, 56, 385, 44);
		lblEditOrDelete.setForeground(new Color(139, 0, 0));
		lblEditOrDelete.setFont(new Font("Tahoma", Font.BOLD, 36));
		contentPane.add(lblEditOrDelete);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(194, 216, 100, 32);
		lblNewLabel_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender");
		lblNewLabel_1_2.setBounds(194, 282, 100, 32);
		lblNewLabel_1_2.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Field");
		lblNewLabel_1_3.setBounds(194, 354, 100, 32);
		lblNewLabel_1_3.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("District");
		lblNewLabel_1_1_1.setBounds(194, 426, 100, 32);
		lblNewLabel_1_1_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1_1);
		
		txtField = new JTextField();
		txtField.setBounds(429, 364, 190, 20);
		txtField.setColumns(10);
		contentPane.add(txtField);
		
		txtDistrict = new JTextField();
		txtDistrict.setBounds(429, 438, 190, 20);
		txtDistrict.setColumns(10);
		contentPane.add(txtDistrict);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name,Gender,Field,District,Phone;
				Name=txtName.getText();
				Gender=txtGender.getText();
				Field=txtField.getText();
				District=txtDistrict.getText();
				Phone=txtPhone.getText();
				Connect();
				try {
					pst=con.prepareStatement("UPDATE ROOM SET Nam=?,Gender=?,Field=?,District=? WHERE Phone=?");
					pst.setString(1, Name);
					pst.setString(2, Gender);
					pst.setString(3, Field);
					pst.setString(4, District);
					pst.setString(5, Phone);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "UPDATE RECORD");
					//table_load();
					txtName.setText("");
					txtGender.setText("");
					txtField.setText("");
					txtDistrict.setText("");
				}
				catch(SQLException e1) {
					
				}
			}
		});
		btnNewButton.setBounds(225, 504, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(210, 105, 30));
		btnNewButton.setBackground(new Color(0, 0, 0));
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				number=txtPhone.getText();
				Connect();
				try {
					pst=con.prepareStatement("DELETE FROM ROOM WHERE Phone=?");
					pst.setString(1, number);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "DELETE RECORD");
					//table_load();
					txtName.setText("");
					txtGender.setText("");
					txtField.setText("");
					txtDistrict.setText("");
					txtPhone.requestFocus();
				}
				catch(SQLException e1) {
					
				}
			}
		});
		btnDelete.setBounds(409, 504, 89, 23);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setForeground(new Color(210, 105, 30));
		btnDelete.setBackground(Color.BLACK);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome_Page window = new Welcome_Page();
				window.frame.setVisible(true);
			    dispose();
			}
		});
		btnNewButton_1.setBounds(10, 538, 89, 23);
		btnNewButton_1.setForeground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.BLACK);
		contentPane.add(btnNewButton_1);
		
		txtName = new JTextField();
		txtName.setBounds(429, 226, 190, 20);
		txtName.setColumns(10);
		contentPane.add(txtName);
		
		txtGender = new JTextField();
		txtGender.setBounds(429, 292, 190, 20);
		txtGender.setColumns(10);
		contentPane.add(txtGender);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(116, 127, 700, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phone No");
		lblNewLabel.setBounds(200, 37, 100, 19);
		lblNewLabel.setForeground(new Color(147, 112, 219));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		txtPhone = new JTextField();
		txtPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				try {
					String Number=txtPhone.getText();
					pst=con.prepareStatement("SELECT Nam,Gender,Field,District FROM ROOM WHERE Phone=?");
					pst.setString(1, Number);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==true) {
						String name=rs.getString(1);
						String gender=rs.getString(2);
						String field=rs.getString(3);
						String district=rs.getString(4);
						txtName.setText(name);
						txtGender.setText(gender);
						txtField.setText(field);
						txtDistrict.setText(district);
					}
					else {
						JOptionPane.showMessageDialog(null, "Record Not Found!!!!");
					}
				}
				catch(SQLException ex){
					
				}
			}
		});
		txtPhone.setBounds(351, 39, 190, 20);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
	}
}
