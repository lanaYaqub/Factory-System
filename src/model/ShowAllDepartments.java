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

public class ShowAllDepartments extends JInternalFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ShowAllDepartments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 396);
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
		
		String[] col = {"Show All Departments"};
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
		pane.setBounds(10,23,514,287);
		contentPane.add(pane);
		
		
	
		for(Department d:Main.libr.getAllDepartments().values()) {
			data[0]=d.toString();
			model.addRow(data);
		
		}
		
	}

}