package model;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;
import Exeption.PersonAlreadyExistException;
import Exeption.YearOfBirthNotInRange;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import utils.Gender;

public class AddEmployees extends JInternalFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private static Integer depId;
	
	private	Image image1=null;
	//static AddEmployees frame = new AddEmployees();

	public AddEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(29, 181, 66, 26);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 184, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(232, 184, 85, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(297, 184, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Add Employee");
		lblNewLabel_2.setBounds(130, -12, 152, 52);
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
		lblNewLabel_8.setBounds(232, 90, 83, 28);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Gender.values()));
		comboBox.setBounds(322, 53, 49, 22);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setBounds(232, 51, 66, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("Year Of Birth");
		lblNewLabel_9.setBounds(29, 156, 85, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Salary");
		lblNewLabel_10.setBounds(232, 125, 66, 14);
		contentPane.add(lblNewLabel_10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(232, 147, 120, 26);
		contentPane.add(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Select Department");
		mnNewMenu.setBounds(186, 104, 193, 27);
		menuBar.add(mnNewMenu);
		ButtonGroup G2 = new ButtonGroup();
	
		
		 if(Main.libr!=null) {
		for(Integer i:Main.libr.getAllDepartments().keySet())//display all the departments id to choose from
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(i.toString());
			mnNewMenu.add(rdbtnNewRadioButton_1);
			G2.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {//when the department id has chosen, save it in depId
					
						// TODO Auto-generated method stub
						
						for(Integer i:Main.libr.getAllDepartments().keySet())
						{	
							if(	i.equals((Integer.parseInt(e.getActionCommand()))))
								depId=i;
						}
				
					
				}
			});
		
		}
		}
		


		 //phone number
		textField_4 = new JTextField();
		textField_4.setBounds(119, 122, 96, 20);
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
		//last name
		textField_5 = new JTextField();
		textField_5.setBounds(119, 94, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( (c > '0' && c <'9')) {//if there is number
		             
		            
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
		             if ( (c > '0' && c <'9')) { //if there is number
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		//starting date
		textField_8 = new JTextField();
		textField_8.setBounds(322, 94, 96, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		textField_8.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='/')//if there is a char
		             {
		            	 ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
	
		//id
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
		textField_10.setBounds(322, 122, 96, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		textField_10.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {//only numbers
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		
		
		
		JLabel lblNewLabel_11 = new JLabel("Choose image");
		lblNewLabel_11.setBounds(10, 227, 85, 26);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("Select");
		btnNewButton_2.setBounds(98, 229, 89, 23);
		contentPane.add(btnNewButton_2);
	//	btnNewButton_2.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		/* JButton b = (JButton) e.getSource();  
		  if (b == btnNewButton_2)  
		  {  
				 FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD); 
			  fd.show();  
			  if (fd.getFile() == null)  
			  {  
				JLabel lblNewLabel_13 = new JLabel("You have not select");
				lblNewLabel_11.setBounds(13, 210, 99, 30);
			  
			  } else  
			  {  
			   String d = (fd.getDirectory() + fd.getFile());  
			   Toolkit toolkit = Toolkit.getDefaultToolkit();  
			   image1 = toolkit.getImage(d);  
			   
			  }
		
		  }
		}
		});
		*/
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			 Date date1 = new Date();
				try {
					 date1 = new SimpleDateFormat("dd/MM/yyyy").parse(textField_8.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
					 return;
				}
		
				try {
					Employee emp = new Employee(textField_9.getText(),textField_7.getText(), textField_5.getText(),textField_4.getText(), 
							(Gender)comboBox.getSelectedItem(),date1, Double.parseDouble(textField_10.getText()),Main.libr.getRealDepartment(depId)
							,Integer.parseInt(textField_6.getText()) );
			
					try {
						 Main.libr.addEmployee(emp);
						 Main.libr.addUser(textField_2.getText(), textField_3.getText());//add user to users
					} catch (PersonAlreadyExistException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
						 return;
					} catch (YearOfBirthNotInRange e1) {
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
			
		});
		btnNewButton.setBounds(322, 229, 89, 23);
		contentPane.add(btnNewButton);
		


		
	
	
		}
	}