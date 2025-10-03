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

public class ShowAllVhichle extends JInternalFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ShowAllVhichle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<----");
		btnNewButton.setBounds(10, 344, 96, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if the user admin , return to admin page	
						setVisible(false);
			
					
				
			}
		});
		
		String[] col = {"Show All VehicleTransportation"};
		Object [] data = new Object[1];
		
		JTable table = new JTable();
		table.setBounds(56, 322, 464, -272);
		DefaultTableModel model = new DefaultTableModel();
		contentPane.add(table);
		model.setColumnIdentifiers(col);
		table.setModel(model);

		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(10,11,780,331);
		contentPane.add(pane);
		
		
	
		for(VehicleTransportation c:Main.libr.getAllVehicleTransportation().values()) {
			data[0]=c.toString();
			model.addRow(data);
		
		}
		

	}

}