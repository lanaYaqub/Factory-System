package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import Exeption.ErrorInput;
import utils.Gender;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class AllEmployeesClass extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public AllEmployeesClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter number :");
		lblNewLabel.setBounds(10, 32, 93, 30);
		contentPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(91, 37, 85, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           
	        	    char c = e.getKeyChar();
		             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		             
		            
		                ErrorInput errorInput=new ErrorInput();
		            	 JOptionPane.showMessageDialog(null,errorInput.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
		            	    e.consume();
		       
		             }
	         }
		      });
		
		lblNewLabel_1 = new JLabel("Sorted by the ID");
		lblNewLabel_1.setBounds(46, 65, 227, 20);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(194, 37, 106, 20);
		contentPane.add(btnNewButton);
		
		String[] columnNames = { "K Employees"};
		Object[]data = new Object[1];
		DefaultTableModel model = new DefaultTableModel();
		
		
		table = new JTable();
		table.setBounds(10, 96, 420, 143);
		contentPane.add(table);
		btnNewButton.addActionListener(new ActionListener() {
		

			
			
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer k=Integer.parseInt(textField.getText());
				if(k > Main.libr.getAllEmployees().size() ) {
					 JOptionPane.showMessageDialog(null,"You have enterd wrong input!!!","Read File Error", JOptionPane.ERROR_MESSAGE);
				}else {
					
				
				List<Employee> allem =Main.libr.allEmployees(k);
				contentPane.add(table);
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);

				table.setRowHeight(30);
				table.setAutoCreateRowSorter(true);
				JScrollPane pane =new JScrollPane(table);
				pane.setBounds(46,96,364,143);
				contentPane.add(pane);
				if(allem != null) {
					
					
					
					for(Employee e1:allem) {
						data[0]=e1.toString();
						model.addRow(data);
					}
						
					}
			
		
				
				}
			}
				
				
				
			
		});
		
	

		  JButton btnNewButton_1 = new JButton("Exit");
		  btnNewButton_1.setBounds(10, 11, 68, 23);
		  contentPane.add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
		
		

		
	}
}

		
