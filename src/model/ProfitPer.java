package model;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ProfitPer extends JInternalFrame {
	private JTextField textField;
	private static String id;

	public ProfitPer() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Select VehicleTransportation id:");
		lblNewLabel_2.setBounds(10, 50, 210, 22);
		getContentPane().add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(284, 50, 130, 22);
		getContentPane().add(menuBar);
		 
		JMenu mnNewMenu = new JMenu("select");
		mnNewMenu.setBounds(205, 58, 96, 20);
		menuBar.add(mnNewMenu);
		
		ButtonGroup G1 = new ButtonGroup();
	
		 if(Main.libr!=null) {
		for(String d:Main.libr.getAllVehicleTransportation().keySet())
		{
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(d);
			mnNewMenu.add(rdbtnNewRadioButton_1);
			G1.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(String d:Main.libr.getAllVehicleTransportation().keySet())
					{
						if(	d.equals(e.getActionCommand()))
							id=d;
					}
				}
			});
		   }
		}
	
		
		JButton btnNewButton = new JButton("Calucate");
		btnNewButton.setBounds(319, 149, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				VehicleTransportation vehicleTransportation= Main.libr.getRealVehicleTransportation(id);
				double d = Main.libr.profitPerVehiclesTransportation(vehicleTransportation);
				JOptionPane.showMessageDialog(getContentPane(),d , "The Profit Per VehiclesTransportation ",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		  JButton btnNewButton_1 = new JButton("Exit");
		  btnNewButton_1.setBounds(10, 13, 68, 23);
		 getContentPane().add(btnNewButton_1);
		  btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
						setVisible(false);
				
			}
		});
		
	
		
	}

}