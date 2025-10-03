package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;
import Exeption.PersonAlreadyExistException;
import Exeption.YearOfBirthNotInRange;
import utils.Gender;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import utils.Area;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class AddCustomers extends JInternalFrame {

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
//	private JTextField textField_5;
	private JTextField textField_6;
	

	

	public AddCustomers()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(20, 45, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("First Name");
		lblNewLabel_4.setBounds(21, 66, 74, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Last Name");
		lblNewLabel_5.setBounds(21, 91, 93, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Phone Number");
		lblNewLabel.setBounds(21, 128, 85, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Gender.values()));
		comboBox.setBounds(319, 41, 49, 22);
		contentPane.add(comboBox);
		Gender gender= (Gender) comboBox.getSelectedItem();
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setBounds(247, 39, 66, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Date of Joining");
		lblNewLabel_1.setBounds(247, 153, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Area.values()));
		comboBox_1.setBounds(317, 75, 97, 22);
		contentPane.add(comboBox_1);
		Area area= (Area) comboBox_1.getSelectedItem();
		
		JLabel lblNewLabel_2 = new JLabel("Area");
		lblNewLabel_2.setBounds(247, 79, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Add Customer");
		lblNewLabel_7.setBounds(174, 3, 110, 25);
		contentPane.add(lblNewLabel_7);
		 JLabel lblNewLabel_10 = new JLabel("Discount percentage");
			lblNewLabel_10.setBounds(247, 128, 110, 14);
			contentPane.add(lblNewLabel_10);
			
			textField_6 = new JTextField();//discount percentage
			textField_6.setBounds(374, 125, 96, 20);
			contentPane.add(textField_6);
			textField_6.setColumns(10);
			lblNewLabel_10.setVisible(false);
			textField_6.setVisible(false);
			textField_6.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           
		        	    char c = e.getKeyChar();
			             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.') {
			            	 //if its not a double number
			            
			                ErrorInput errorInput=new ErrorInput();
			            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
			            	    e.consume();
			       
			             }
		         }
			      });
		
		JLabel lblNewLabel_8 = new JLabel("Type");
		lblNewLabel_8.setBounds(247, 104, 49, 20);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("VipCustomer");
		rdbtnNewRadioButton_2.setBounds(282, 103, 101, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Customer");
		rdbtnNewRadioButton_3.setBounds(385, 103, 85, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		  ButtonGroup G1 = new ButtonGroup();
		  G1.add(rdbtnNewRadioButton_2);
		  G1.add(rdbtnNewRadioButton_3);
		  rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			//if its a VipCustomer,show the text field of the discount percentage
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblNewLabel_10.setVisible(true);
				textField_6.setVisible(true);
				
			}
		});
		  rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			//if its a normal Customer, no discount percentage 
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lblNewLabel_10.setVisible(false);
					textField_6.setVisible(false);
					
				}
			});
		 
	
		
		
		JLabel lblNewLabel_9 = new JLabel("Year Of Birth");
		lblNewLabel_9.setBounds(21, 153, 93, 19);
		contentPane.add(lblNewLabel_9);
		

		  JButton btnNewButton_1 = new JButton("Exit");
		  btnNewButton_1.setBounds(10, 13, 68, 23);
		  contentPane.add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
		  
		textField = new JTextField();//id
		textField.setBounds(110, 39, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))//only numbers
		            	 {
		             
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		
		//first name
		textField_1 = new JTextField();
		textField_1.setBounds(110, 69, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( (c > '0' && c <'9')) //if there is numbers
		             {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//last name
		textField_2 = new JTextField();
		textField_2.setBounds(110, 94, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( (c > '0' && c <'9'))//if there is numbers
		            {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//phone number
		textField_3 = new JTextField();
		textField_3.setBounds(110, 125, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//year of birth
		textField_4 = new JTextField();
		textField_4.setBounds(110, 153, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();//only numbers
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		
		//date of joining
		DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField textField_5 = new JFormattedTextField(format1);
		textField_5.setBounds(374, 150, 96, 20);
		contentPane.add(textField_5);
		textField_5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c !='/'))//if there is  char
		             {
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(308, 216, 89, 23);		
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Date date1 = new Date();
				try {
					 date1 = new SimpleDateFormat("dd/MM/yyyy").parse(textField_5.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e2.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
					if(rdbtnNewRadioButton_2.isSelected())
					{		//if the customer is VIP
						
					try {
						//try to make new object, if its not worked thats mean there is a empty filed 
						double d= Double.parseDouble(textField_6.getText());
						VIPCustomer vc= new VIPCustomer(textField.getText(), textField_1.getText() 
								, textField_2.getText(), textField_3.getText() ,gender ,Integer.parseInt(textField_4.getText()), area, date1,d);
						try {
							 Main.libr.addVIPCustomer(vc); //add to the factory
						} catch (PersonAlreadyExistException e1) {
							// TODO Auto-generated catch block
							 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE); //if the person already exist
							
						} catch (YearOfBirthNotInRange e1) { //if the year is not in range
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {//empty field text
						// TODO: handle exception
						EmptyTextfileds err = new EmptyTextfileds();
						JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
					}	
						 
					}
					if(rdbtnNewRadioButton_3.isSelected()) {
						try {//if its normal customer
							//try to make new object, if its not worked thats mean there is a empty filed 
							Customer c= new Customer(textField.getText(), textField_1.getText() , textField_2.getText(), 
									textField_3.getText() ,gender ,Integer.parseInt(textField_4.getText()), area, date1);
							try {
								 Main.libr.addCustomer(c); //add to the factory
							} catch (PersonAlreadyExistException e1) {
								// TODO Auto-generated catch block
								 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE); //if the person already exist
								
							} catch (YearOfBirthNotInRange e1) { //if the year is not in range
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
							}
							
						} 
						catch (Exception e3) {//empty field text
							EmptyTextfileds err = new EmptyTextfileds();
						JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						return;
				}
				
			}
			}
			
		});
		
	}
}