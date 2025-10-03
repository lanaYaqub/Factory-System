package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ShowAllCustomers extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;

	public ShowAllCustomers() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<----");
		btnNewButton.setBounds(0, 303, 96, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if the user admin , return to admin page	
						setVisible(false);
			
					
				
			}
		});
		
		String[] col = {"Show All Customers"};
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
		pane.setBounds(0,15,775,287);
		contentPane.add(pane);
		
		
	
		for(Customer c:Main.libr.getAllCustomers().values()) {
			data[0]=c.toString();
			model.addRow(data);
		
		}
		

	}

}