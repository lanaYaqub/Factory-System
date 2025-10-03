package model;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Exeption.DepartmentNotInTheSystem;
import Exeption.ErrorInput;

public class RemoveDepartments extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	
	public RemoveDepartments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Deals");
		lblNewLabel.setBounds(160, 11, 159, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 98, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		 textField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	               ErrorInput errorInput=new ErrorInput();
	               e.consume();
	               JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);

	             }
	             
	         }
	      });

			


		JLabel lblNewLabel_1 = new JLabel("Department ID");
		lblNewLabel_1.setBounds(160, 73, 70, 14);
		contentPane.add(lblNewLabel_1);
		
	
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(316, 212, 89, 23);
		contentPane.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
		
			
			Department d=Main.libr.getRealDepartment(Integer.parseInt(textField.getText()));
	
					
						try {
							 Main.libr.removeDepartment(d);
						} catch (DepartmentNotInTheSystem e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
							return;
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
