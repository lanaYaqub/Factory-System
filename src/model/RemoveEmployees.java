package model;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import Exeption.PersonNotExistException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
	import javax.swing.JButton;

	public class RemoveEmployees extends JInternalFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
	
		
		public RemoveEmployees() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Remove Employees Or Department Manger");
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
					if(Main.libr.getAllEmployees().containsKey(textField.getText())) {
						Employee employee=Main.libr.getAllEmployees().get(textField.getText())  ; 
							if(employee instanceof DepartmentManager) {
								try {
									Main.libr.removeDepartmentManager((DepartmentManager) employee);
								} catch (PersonNotExistException e1) {
									// TODO Auto-generated catch block
                                   JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
                                   return;
								}
							  
							}else {
								try {
									 Main.libr.removeEmployee(employee);
								} catch (PersonNotExistException e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						
					}
					else {
					PersonNotExistException e3 = new PersonNotExistException();
					JOptionPane.showMessageDialog(null,e3.getMessage() ,"Read File Error", JOptionPane.ERROR_MESSAGE);
					}	
							
				}
					
				
					
				
			});
			
		
			JButton btnNewButton_1 = new JButton("<----");
			btnNewButton_1.setBounds(56, 212, 89, 23);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
							setVisible(false);
						
					
				}
			});
		
		}
	}

