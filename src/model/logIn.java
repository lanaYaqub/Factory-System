package model;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class logIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static logIn frame = new logIn();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public logIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("EnterData\r\ndc");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		textField = new JTextField();
		textField.setBounds(155, 84, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name ");
		lblNewLabel.setBounds(183, 59, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LogIn Page ");
		lblNewLabel_1.setBounds(183, 11, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("passwoerd");
		lblNewLabel_2.setBounds(183, 130, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 156, 96, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("logIn");
		btnNewButton.setBounds(337, 213, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			
				if(textField.getText().equals("Admin")&& passwordField.getText().equals("Admin")) {
					setVisible(false);
					 new Admin().setVisible(true);
					 return;
					 
					}else 
					{
						if(Main.libr.getAllUsers()!=null)
						{
						for (String s : Main.libr.getAllUsers().keySet())
						{
							if(s.equals(textField.getText()))
							{
								if(Main.libr.getAllUsers().get(s).equals(passwordField.getText()))
								{
										setVisible(false);
										new EmployeePage().setVisible(true);
										return;
								}
									
								
								
							}
						}
						JOptionPane.showMessageDialog(frame,"Password or User Name is Wrong!!" ,"Read File Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(frame,"Password or User Name is Wrong!!" ,"Read File Error", JOptionPane.ERROR_MESSAGE);
						}
						}
						
			}
						
								
				
			
		});
	}
}
