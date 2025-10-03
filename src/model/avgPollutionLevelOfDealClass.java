package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JList;

public class avgPollutionLevelOfDealClass extends JInternalFrame {

	private JPanel contentPane;
	private static String dealId;

	private void click() {
		File sound = new File("C:\\Users\\hp\\eclipse-workspace\\ששש.zip_expanded\\HSR_EXC1\\Music\\Sound\\Click.wav");
		try {

			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(sound));
			c.start();
		} catch (Exception e) {
		}
	}

	public avgPollutionLevelOfDealClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Choose Deal to calculate average pollution level of Deal :");
		lblNewLabel.setBounds(10, 47, 283, 45);
		contentPane.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 89, 130, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Select Deal");
		mnNewMenu.setBounds(305, 23, 113, 27);
		menuBar.add(mnNewMenu);

		if (Main.libr != null) {
			for (String d : Main.libr.getAllDeals().keySet()) {
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(d);
				mnNewMenu.add(rdbtnNewRadioButton_1);
				rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						click();
						for (String d : Main.libr.getAllDeals().keySet()) {
							if (d.equals(e.getActionCommand()))
								dealId = d;
						}
					}
				});
			}
		}

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setBounds(299, 199, 89, 23);
		contentPane.add(btnNewButton);


		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click();
			
				Double d = Main.libr.avgPollutionLevelOfDeal(Main.libr.getRealDeal(dealId));
				
				JOptionPane.showMessageDialog(contentPane, d, "the average pollution is",
						JOptionPane.INFORMATION_MESSAGE);

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
		

	}
}
	
		
		 
