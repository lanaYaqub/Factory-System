package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;
import Exeption.PersonAlreadyExistException;
import Exeption.YearOfBirthNotInRange;
import utils.Gender;
import javax.swing.JFormattedTextField;

public class AddDepartmentManger extends JInternalFrame implements Serializable{

	private JPanel contentPane;
	
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private static 	Integer depId;
	
	public AddDepartmentManger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(251, 226, 66, 26);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(333, 229, 120, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(251, 266, 73, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(333, 266, 120, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Add Department Manger");
		lblNewLabel_2.setBounds(164, 0, 134, 29);
		contentPane.add(lblNewLabel_2);
		
		
		  JButton btnNewButton_1 = new JButton("Exit");
		  btnNewButton_1.setBounds(10, 13, 68, 23);
		  contentPane.add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
	
		
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(29, 45, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("First Name");
		lblNewLabel_4.setBounds(29, 66, 66, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Last Name");
		lblNewLabel_5.setBounds(29, 91, 85, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Phone Number");
		lblNewLabel_7.setBounds(29, 119, 96, 26);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Starting Date");
		lblNewLabel_8.setBounds(234, 92, 83, 24);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(333, 58, 96, 22);
		comboBox.setModel(new DefaultComboBoxModel(Gender.values()));
		contentPane.add(comboBox);
		Gender gender= (Gender) comboBox.getSelectedItem();
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setBounds(234, 66, 66, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("Year Of Birth");
		lblNewLabel_9.setBounds(29, 156, 85, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Salary");
		lblNewLabel_10.setBounds(232, 119, 66, 26);
		contentPane.add(lblNewLabel_10);
		
		//phone number
		textField_4 = new JTextField();
		textField_4.setBounds(119, 122, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))//if its not numbers
		             {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//last name
		textField_5 = new JTextField();
		textField_5.setBounds(119, 94, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( (c > '0' && c <'9')) { //if there is numbers
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//year of birth
		textField_6 = new JTextField();
		textField_6.setBounds(119, 150, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           //only numbers
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) //only numbers
		             {
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//first name
		textField_7 = new JTextField();
		textField_7.setBounds(119, 69, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( (c > '0' && c <'9')) {//if there is numbers
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//ID
		textField_9 = new JTextField();
		textField_9.setBounds(119, 42, 96, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		textField_9.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) { //only numbers
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {//only numbers
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//salary
		textField_10 = new JTextField();
		textField_10.setBounds(333, 122, 96, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		textField_10.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.')//if its not a double number
		             {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		
		JLabel lblNewLabel_12 = new JLabel("Bonus");
		lblNewLabel_12.setBounds(33, 191, 66, 14);
		contentPane.add(lblNewLabel_12);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(29, 226, 120, 26);
		contentPane.add(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Select Department");
		mnNewMenu.setBounds(186, 104, 193, 27);
		menuBar.add(mnNewMenu);

	  ButtonGroup G2 = new ButtonGroup();
		
		for(Integer i:Main.libr.getAllDepartments().keySet())//display the all departments id to choose from
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(i.toString());
			mnNewMenu.add(rdbtnNewRadioButton_1);
			G2.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) { //when it chosen save the id in depId
					// TODO Auto-generated method stub
		
						for(Integer i:Main.libr.getAllDepartments().keySet())
						{	
							if(	i.equals((Integer.parseInt(e.getActionCommand()))))
								depId=i;
						}
				
					
				}
			});
		
		}
					
		
		
		//bounss
		textField_11 = new JTextField();
		textField_11.setBounds(119, 188, 96, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		textField_11.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)&& c!='.')//if it not a double number
		             {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField textStartingDate = new JFormattedTextField(format1);
		textStartingDate.setBounds(333, 91, 96, 20);
		contentPane.add(textStartingDate);
		textStartingDate.addKeyListener(new KeyAdapter() {
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
		
		DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField textDateApp = new JFormattedTextField(format2);
		textDateApp.setBounds(333, 153, 96, 20);
		contentPane.add(textDateApp);
		textDateApp.addKeyListener(new KeyAdapter() {
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
	
		
		JLabel lblNewLabel_13 = new JLabel("Date appointment");
		lblNewLabel_13.setBounds(233, 153, 102, 20);
		contentPane.add(lblNewLabel_13);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(385, 297, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date1 = null;
				try { //try to parse the date
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(textStartingDate.getText());
				} catch (ParseException e2) {
					 JOptionPane.showMessageDialog(null,e2.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}  
				Date date2 = null;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(textDateApp.getText());
				} catch (ParseException e3) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null,e3.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					return;
				}  
		try {
			//try to make new object, if its not worked That mean there is an empty field

			DepartmentManager dm=new DepartmentManager(textField_9.getText(),textField_7.getText(), textField_5.getText(),textField_4.getText(), gender,date1, Double.parseDouble(textField_10.getText()), 
					Main.libr.getRealDepartment(depId),Integer.parseInt(textField_6.getText()),date2,Double.parseDouble(textField_11.getText()));
			try {
				Main.libr.addDepartmentManager(dm); //add the department manger to the factory
				Main.libr.addUser(textField_2.getText(), textField_3.getText());//add user name and passwors to users
				 
			} catch (PersonAlreadyExistException e1) {
				
				//if its already exist
				 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				 return;
			} catch (YearOfBirthNotInRange e1) {
				//if the Year Of Birth Not InRange
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
		}catch (Exception e2) {//there is an empty field
			EmptyTextfileds err = new EmptyTextfileds();
			JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

			}	
		});
		
		contentPane.add(btnNewButton);
		
	
	}
		

}