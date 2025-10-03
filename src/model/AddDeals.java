package model;


import java.awt.event.*;

import javax.swing.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map.Entry;

import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import Exeption.EmptyTextfileds;
import Exeption.ErrorInput;

public class AddDeals extends JInternalFrame {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static String customerID;
	private static HashSet <VehicleTransportation> veHashSet = new HashSet<>();
	
	public AddDeals() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Deal");
		lblNewLabel.setBounds(170, 5, 65, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Deal Date");
		lblNewLabel_2.setBounds(10, 103, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Shipping Cost");
		lblNewLabel_3.setBounds(10, 128, 96, 31);
		contentPane.add(lblNewLabel_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(248, 51, 130, 22);
		contentPane.add(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Select Vehicle");
		mnNewMenu.setBounds(186, 104, 193, 27);
		menuBar.add(mnNewMenu);
	

		
		for(String s:Main.libr.getAllVehicleTransportation().keySet())//display the departments Id to choose from
		{
			JMenuItem rdbtnNewRadioButton_1 = new JRadioButtonMenuItem(s);
		//	JRadioButton rdbtnNewRadioButton_1= new JRadioButton(s);
			mnNewMenu.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(String i: Main.libr.getAllVehicleTransportation().keySet())
					{
						if(	i.equals(e.getActionCommand()))
							veHashSet.add(Main.libr.getRealVehicleTransportation(i));
						
					}
					
				}
			});
		}
	
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 97, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 133, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c!='.')//if its not double number
		             {
		            	 ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
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
		

		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(10, 51, 99, 22);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Select Customer");
		mnNewMenu_1.setBounds(10, 27, 113, 27);
		menuBar_1.add(mnNewMenu_1);
		
	 ButtonGroup G1 = new ButtonGroup();
		
		for(String s:Main.libr.getAllCustomers().keySet())//display the Customers Id to choose from
		{
			JMenuItem rdbtnNewRadioButton = new JRadioButtonMenuItem(s);
			mnNewMenu_1.add(rdbtnNewRadioButton);
			G1.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(String i: Main.libr.getAllCustomers().keySet())
					{
						if(	i.equals(e.getActionCommand()))
							customerID= i;
					}
					
				}
			});
		}
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setBounds(337, 209, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener()  {
			@Override
			public void actionPerformed(ActionEvent e) {
	
			Customer c =Main.libr.getRealCustomer(customerID);//get customer
			 Date date1 = new Date();
			try {
				 date1 = new SimpleDateFormat("dd/MM/yyyy").parse(textField_1.getText());
			} catch (ParseException e1) { 
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null,e1.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				 return;
			}

			try {
				Integer.parseInt(textField_2.getText()); //try to parse int
				
				//try to make new object, if its not worked thats mean there is a empty filed 
				Deal deal = new Deal(c,date1,veHashSet,Integer.parseInt(textField_2.getText()));
				
				 Main.libr.addDeal(deal); //add to the factory
			} catch (Exception e2) { //empty fields
				EmptyTextfileds err = new EmptyTextfileds();
				JOptionPane.showMessageDialog(null,err.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				return;
				
			}
		
			
			
		
				 
			}
		});
	
	  }
	}