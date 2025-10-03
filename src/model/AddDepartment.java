package model;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import utils.Specialization;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class AddDepartment extends JInternalFrame   {

	
	private JPanel contentPane;
	private JTextField textField;
	

	@SuppressWarnings("unchecked")
	public AddDepartment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Department");
		lblNewLabel.setBounds(171, 11, 105, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department ID");
		lblNewLabel_1.setBounds(24, 38, 85, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialization");
		lblNewLabel_2.setBounds(24, 70, 105, 20);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Specialization.values()));
		comboBox.setBounds(146, 69, 75, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(146, 41, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))//char
		             {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		

		  JButton btnNewButton = new JButton("Exit");
		  btnNewButton.setBounds(10, 13, 68, 23);
		  contentPane.add(btnNewButton);
		  btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
		  
		  JButton btnNewButton_1 = new JButton("Submit");
		  btnNewButton_1.setBounds(345, 240, 89, 23);
		  contentPane.add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				Department department = new Department(Integer.parseInt(textField.getText()), (Specialization) comboBox.getSelectedItem());
				Main.libr.addDepartment(department);//add to the factory
				
			}	catch (Exception e3) {//empty field text
				EmptyTextfileds err = new EmptyTextfileds();
			JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
			return;
				
			}
			
			   
			}
		});
		
	}
}