package model;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TotalProfitClass extends JInternalFrame {



	public TotalProfitClass() {
		
		if(Main.libr.totalProfit()!=0)
		JOptionPane.showMessageDialog(this, Main.libr.totalProfit(), "Total Profit",JOptionPane.INFORMATION_MESSAGE);
		
		else {
			JOptionPane.showMessageDialog(null,"There is no deals to calculate" ,"Read File Error", JOptionPane.ERROR_MESSAGE);
		}
  
	}
}