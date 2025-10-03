 package model;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;
import Exeption.IncorrectNumberOfSeats;
import Exeption.PoullutionLevelHybridVehiclesMustBeOne;
import Exeption.PoullutionLevelNotInRange;
import Exeption.YearOfBirthNotInRange;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import utils.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class AddCar extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	
	public AddCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Car");
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
		
		JLabel lblNewLabel_2_4 = new JLabel("Number Of Seats");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_4.setBounds(249, 80, 100, 27);
		contentPane.add(lblNewLabel_2_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("yes");
		rdbtnNewRadioButton.setBounds(122, 172, 68, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("no");
		rdbtnNewRadioButton_1.setBounds(215, 172, 81, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Is Convertible:  ");
		lblNewLabel_3.setBounds(32, 170, 140, 27);
		contentPane.add(lblNewLabel_3);
		
		  ButtonGroup G2 = new ButtonGroup();
		  G2.add(rdbtnNewRadioButton);
		  G2.add(rdbtnNewRadioButton_1);
		
		  
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Color.values()));
		comboBox.setBounds(345, 111, 81, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(250, 109, 68, 27);
		contentPane.add(lblNewLabel_4);
		//price
		textField = new JTextField();
		textField.setBounds(144, 49, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {//Price
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c!='.'))//if it char
		            	 {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		
		//Cost Of Manufacture
		textField_1 = new JTextField();
		textField_1.setBounds(143, 83, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c!='.'))//if it char
		            {
		             
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
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
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
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.') //if it char
		            {
		             
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
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		 
		//Number Of Seats
		textField_5 = new JTextField();
		textField_5.setBounds(340, 83, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
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
		rdbtnNewRadioButton_3.setBounds(215, 212, 50, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		  ButtonGroup G1 = new ButtonGroup();
		  G1.add(rdbtnNewRadioButton_2);
		  G1.add(rdbtnNewRadioButton_3);

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
				  boolean IsConvertible = false;
				  if(rdbtnNewRadioButton.isSelected()) {
					  IsConvertible=true;
				  }
				  if(rdbtnNewRadioButton_1.isSelected()) {
					  IsConvertible=false;
					 
				}
			if(rdbtnNewRadioButton_2.isSelected()) {//if its a hybrid car
				try {
					//try to to make new object, if its not worked , that mean there is a empty field text
					HybridCar hybridCar = new HybridCar(Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()),(Color)comboBox.getSelectedItem(), Integer.parseInt(textField_2.getText()), Double.parseDouble(textField_3.getText()), 
							Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_5.getText()), IsConvertible);
					try {
						 Main.libr.addHybridCar(hybridCar);
					} catch (PoullutionLevelHybridVehiclesMustBeOne e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					catch (IncorrectNumberOfSeats e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					//JOptionPane.showMessageDialog(contentPane,"The Car Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					// TODO: handle exception
					EmptyTextfileds err = new EmptyTextfileds();
					JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
		
			}
			else if(rdbtnNewRadioButton_3.isSelected()) {
				try {
					Car car=new Car(Double.parseDouble(textField.getText()), Double.parseDouble(textField_1.getText()), (Color)comboBox.getSelectedItem(), Integer.parseInt(textField_2.getText()),  Double.parseDouble(textField_3.getText()), Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), IsConvertible);
					
					try {
						 Main.libr.addCar(car); //add the car to factory
					
					} catch (PoullutionLevelNotInRange e1) { //if the level pollution not in range
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
						
						
					} catch (IncorrectNumberOfSeats e1) { //Incorrect Number Of Seats
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						
						
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