package model;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Exeption.PersonNotExistException;

public class RemoveCustomers extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public RemoveCustomers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Customers");
		lblNewLabel.setBounds(160, 11, 159, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(182, 56, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(24, 59, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(316, 212, 89, 23);
		contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Main.libr.getAllCustomers().containsKey(textField.getText())) 
				{
					Customer customer = Main.libr.getAllCustomers().get(textField.getText());
					
						if(customer instanceof VIPCustomer)
						{
							try {
								 Main.libr.removeVIPCustomer((VIPCustomer) customer);
							} catch (PersonNotExistException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
						  }
						else {
							try {
								 Main.libr.removeCustomer(customer);
							} catch (PersonNotExistException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
								return;
				
								
							}
						}
					}
				else {
					PersonNotExistException e2 = new PersonNotExistException();
			
					JOptionPane.showMessageDialog(null,e2.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				}
				
						
			}
		});
		
    	
		  JButton btnNewButton_1 = new JButton("Exit");
		  btnNewButton_1.setBounds(10, 13, 68, 23);
		  contentPane.add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
	}

}