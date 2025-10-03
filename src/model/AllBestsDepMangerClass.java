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
import javax.swing.JTable;
import javax.swing.JButton;

public class AllBestsDepMangerClass extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public AllBestsDepMangerClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<---");
		btnNewButton.setBounds(20, 303, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// if the user is admin , return to admin page

					setVisible(false);

			}
		});

		
		
	String[] col = {"Show All DepartmentManager"};
		Object [] data = new Object[1];
		
		table = new JTable();
		table.setBounds(56, 285, 539, -235);
		DefaultTableModel model = new DefaultTableModel();
		contentPane.add(table);
		model.setColumnIdentifiers(col);
		table.setModel(model);

		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(61,53,552,239);
		contentPane.add(pane);
		
		
	
		for(DepartmentManager e:Main.libr.AllBestsDepManger()) {
			data[0]=e.toString();
			model.addRow(data);
		
		}

	}
}
