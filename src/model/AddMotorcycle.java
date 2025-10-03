package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;
import Exeption.IncorrectNumberOfSeats;
import Exeption.PoullutionLevelHybridVehiclesMustBeOne;
import Exeption.PoullutionLevelNotInRange;
import utils.Color;
import java.awt.Choice;

public class AddMotorcycle extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public AddMotorcycle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Add Motircycle");
		lblNewLabel.setBounds(163, 11, 81, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(32, 49, 89, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost Of Manufacture");
		lblNewLabel_2.setBounds(32, 80, 123, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pollution Level");
		lblNewLabel_2_1.setBounds(250, 49, 90, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Year Of Manufacture");
		lblNewLabel_2_2.setBounds(32, 109, 123, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Engine Capacity");
		lblNewLabel_2_3.setBounds(32, 141, 100, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("yes");
		rdbtnNewRadioButton.setBounds(122, 172, 68, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("no");
		rdbtnNewRadioButton_1.setBounds(215, 172, 81, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Is Off Road ");
		lblNewLabel_3.setBounds(32, 170, 89, 27);
		contentPane.add(lblNewLabel_3);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Color.values()));
		comboBox.setBounds(345, 111, 81, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(250, 109, 68, 27);
		contentPane.add(lblNewLabel_4);
		
		//Price
		textField = new JTextField();
		textField.setBounds(144, 49, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.') {//if its not a double
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		//cost of manufacturing
		textField_1 = new JTextField();
		textField_1.setBounds(143, 83, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.') { //if its not a double number
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		//Year Of Manufacture
		textField_2 = new JTextField();
		textField_2.setBounds(144, 116, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {//if there is a char
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		//Engine Capacity
		textField_3 = new JTextField();
		textField_3.setBounds(144, 147, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.') {//if its not double
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		//Pollution Level
		textField_4 = new JTextField();
		textField_4.setBounds(340, 52, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
		           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {//only numbers
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		
		JLabel lblNewLabel_5 = new JLabel("Is Hybrid:");
		lblNewLabel_5.setBounds(32, 216, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("yes");
		rdbtnNewRadioButton_2.setBounds(122, 212, 50, 23);
		contentPane.add(rdbtnNewRadioButton_2);
	
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("no");
		rdbtnNewRadioButton_3.setBounds(215, 198, 68, 44);
		contentPane.add(rdbtnNewRadioButton_3);

		  ButtonGroup G1 = new ButtonGroup();
		  G1.add(rdbtnNewRadioButton_2);
		  G1.add(rdbtnNewRadioButton_3);
		  
		  ButtonGroup G2 = new ButtonGroup();//if its hybrid or not
		  G2.add(rdbtnNewRadioButton);
		  G2.add(rdbtnNewRadioButton_1);
		  
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
				
				//if selected yes the is hybrid
				  boolean IsOffRoad = false;
				  if(rdbtnNewRadioButton.isSelected()) {
					  IsOffRoad=true;
				  }
				  if(rdbtnNewRadioButton_1.isSelected()) {
					  IsOffRoad=false;
				}
			if(rdbtnNewRadioButton_2.isSelected()) {
				try { //if its hybrid
					//try to make new object, if its not worked thats mean there is a empty filed 
					HybridMotorcycle hybridMotorcycle = new HybridMotorcycle(Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()), (Color) comboBox.getSelectedItem(), Integer.parseInt(textField_2.getText()), Double.parseDouble(textField_3.getText()), Integer.parseInt(textField_4.getText()), IsOffRoad);
					try {
						Main.libr.addHybridMotorcycle(hybridMotorcycle);
				} catch (PoullutionLevelHybridVehiclesMustBeOne e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
				}
				} catch (Exception e2) {
					EmptyTextfileds err = new EmptyTextfileds();
					JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
			}
			else if(rdbtnNewRadioButton_3.isSelected()) {
				try {//if its normal not hybrid
					//try to make new object, if its not worked thats mean there is a empty filed 
					Motorcycle motorcycle=new Motorcycle(Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()), (Color) comboBox.getSelectedItem(), Integer.parseInt(textField_2.getText()), Double.parseDouble(textField_3.getText()), Integer.parseInt(textField_4.getText()), IsOffRoad);
					try {
						Main.libr.addMotorcycle(motorcycle);
					} catch (PoullutionLevelNotInRange e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e2) {
					EmptyTextfileds err = new EmptyTextfileds();
					JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
				else {
					EmptyTextfileds err = new EmptyTextfileds();
					JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
				
			
			
			
			
		
		
			}
				
			}
		});
		  
	}
}