package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class ShowAllEmployees extends JInternalFrame {



	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ShowAllEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<----");
		btnNewButton.setBounds(0, 348, 96, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if the user admin , return to admin page	
						setVisible(false);
			
					
				
			}
		});
		
		String[] col = {"Show All Employees"};
		Object [] data = new Object[1];
		
		table = new JTable();
		table.setBounds(56, 322, 464, -272);
		DefaultTableModel model = new DefaultTableModel();
		contentPane.add(table);
		model.setColumnIdentifiers(col);
		table.setModel(model);

		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(10,28,749,296);
		contentPane.add(pane);
		
		
	
		for(Employee e:Main.libr.getAllEmployees().values()) {
			data[0]=e.toString();
			model.addRow(data);
		
		}
		

		
	
		
	}

}