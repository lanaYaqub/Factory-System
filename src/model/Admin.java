package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;

public class Admin extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 569);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		  JMenuItem i1, i2,i3,i4,i5,i6,i7,i8;  
			JMenu mnNewMenu = new JMenu("ADD");
			mnNewMenu.setBounds(0, 0, 113, 27);
			
			
			i1=new JMenuItem("Add Department Manager");
			i2=new JMenuItem("Add Departments");
			i3=new JMenuItem("Add Employees");
			i4=new JMenuItem("Add Customers ");
			i5=new JMenuItem("Add Car / Hybrid Car");
			i6=new JMenuItem("Add Motorcycle / Hybrid Motorcycle");
			i7=new JMenuItem("Add Van");
			i8=new JMenuItem("Add Deals");
			mnNewMenu.add(i1);
			mnNewMenu.add(i2);
			mnNewMenu.add(i3);
			mnNewMenu.add(i4);
			mnNewMenu.add(i5);
			mnNewMenu.add(i6);
			mnNewMenu.add(i7);
			mnNewMenu.add(i8);
			
			
			i1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			
				//	setVisible(false);
				AddDepartmentManger addDepartmentManger=	new	AddDepartmentManger();
					contentPane.add(addDepartmentManger);
					addDepartmentManger.setVisible(true);
				}
			});
			i2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					AddDepartment addDepartment=	new	AddDepartment();
					contentPane.add(addDepartment);
					addDepartment.setVisible(true);
				}
			});
            i3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				
					AddEmployees addEmployee=	new	AddEmployees();
					contentPane.add(addEmployee);
					addEmployee.setVisible(true);
				}
			});
          i4.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		AddCustomers addCustomers=	new	AddCustomers();
		contentPane.add(addCustomers);
		addCustomers.setVisible(true);
	}
});
i5.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		AddCar addCar=	new	AddCar();
		contentPane.add(addCar);
		addCar.setVisible(true);
	}
});
i6.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		AddMotorcycle addMotorcycle=new	AddMotorcycle();
		contentPane.add(addMotorcycle);
		addMotorcycle.setVisible(true);
	}
});
      i7.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		AddVan addVan=new	AddVan();
		contentPane.add(addVan);
		addVan.setVisible(true);
	}
});
        i8.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		AddDeals addDeals=new	AddDeals();
		contentPane.add(addDeals);
		addDeals.setVisible(true);
	}
});
			menuBar.add(mnNewMenu);
			
			JMenu mnNewMenu_1 = new JMenu("Remove");
			JMenuItem r1, r2,r3,r4,r5;  
			
			r1=new JMenuItem("Remove Department Manager / Employees ");
			r2=new JMenuItem("Remove Departments");
			r3=new JMenuItem("Remove Customers / VipCustomers ");
			r4=new JMenuItem("Remove VehicleTransportation");
			r5=new JMenuItem("Remove Deals");
			mnNewMenu_1.add(r1);
			mnNewMenu_1.add(r2);
			mnNewMenu_1.add(r3);
			mnNewMenu_1.add(r4);
			mnNewMenu_1.add(r5);
		r1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveEmployees removeEmployees=new RemoveEmployees();
				contentPane.add(removeEmployees);
				removeEmployees.setVisible(true);
			}
		}); 
	r2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RemoveDepartments removeDepartments=new RemoveDepartments();
				contentPane.add(removeDepartments);
				removeDepartments.setVisible(true);
			}
		});
	r3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			RemoveCustomers removeCustomers=new RemoveCustomers();
			contentPane.add(removeCustomers);
			removeCustomers.setVisible(true);
		}
	});
	r4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			RemoveVehicles removeVehicles=new RemoveVehicles();
			contentPane.add(removeVehicles);
			removeVehicles.setVisible(true);
		}
	});
	r5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			RemoveDeals removeDeals=new RemoveDeals();
			contentPane.add(removeDeals);
			removeDeals.setVisible(true);
			
			
		}
	});
	
			
 			menuBar.add(mnNewMenu_1);

  
 			//show all the data that save in the file 
              JMenu mnNewMenu_Data = new JMenu("Data Display");
              //define buttons for enter the page and show all data
              JMenuItem d1, d2,d3,d4,d5;  

              d1=new JMenuItem("All Employees And Departments Manger");
              d2=new JMenuItem("All Customers");
              d3=new JMenuItem("All VehicleTransportation");
              d4=new JMenuItem("All Deals");
              d5=new JMenuItem("All Departments");
              mnNewMenu_Data.add(d1);
              mnNewMenu_Data.add(d2);
              mnNewMenu_Data.add(d3);
              mnNewMenu_Data.add(d4);
              mnNewMenu_Data.add(d5);
d1.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	ShowAllEmployees showAllEmployees=new ShowAllEmployees();
	contentPane.add(showAllEmployees);
	showAllEmployees.setVisible(true);
}
}); 
d2.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	ShowAllCustomers showAllCustomers=new ShowAllCustomers();
	contentPane.add(showAllCustomers);
	showAllCustomers.setVisible(true);
}
});
d3.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	ShowAllVhichle showAllVhichle=new ShowAllVhichle();
contentPane.add(showAllVhichle);
showAllVhichle.setVisible(true);
}
});
d4.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	ShowAllDeals showAllDeals=new ShowAllDeals();
contentPane.add(showAllDeals);
showAllDeals.setVisible(true);
}
});
d5.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

	ShowAllDepartments departments=new ShowAllDepartments();
contentPane.add(departments);
departments.setVisible(true);


}
});


	menuBar.add(mnNewMenu_Data);


JButton btnNewButton = new JButton("Save");
menuBar.add(btnNewButton);


btnNewButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
				try {
					Main.libr.setTempVehicle(VehicleTransportation.getCounter());
					Main.libr.setTenpDeal(Deal.getCounter());
					Main.save(Main.libr);
				
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Not Saved","Error", JOptionPane.ERROR_MESSAGE);
				}
	
	}
});
            JMenu mnNewMenu_q = new JMenu("Query");
            JMenuItem q1, q2,q3,q4,q5;  
            q1=new JMenuItem("Avg pollution level Of Deal");
            q2=new JMenuItem("All Bests Department Manger ");
            q3=new JMenuItem("Profit Per Vehicles");
            q4=new JMenuItem("All Employeess");
            q5=new JMenuItem("Total profit");
            mnNewMenu_q.add(q1);
            q1.addActionListener(new ActionListener() {
            	//AllBestsDepMangerClass
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					avgPollutionLevelOfDealClass dealClass=new avgPollutionLevelOfDealClass();
					contentPane.add(dealClass);
					dealClass.setVisible(true);
				}
			});
            mnNewMenu_q .add(q2);
            mnNewMenu_q .add(q3);
            mnNewMenu_q .add(q4);
            mnNewMenu_q .add(q5);
            q2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AllBestsDepMangerClass aMangerClass=new AllBestsDepMangerClass();
					contentPane.add(aMangerClass);
					aMangerClass.setVisible(true);
				}
			});
            q3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//ProfitPerVehiclesTransportationClass
					ProfitPer pClass=new ProfitPer();
					contentPane.add(pClass);
					pClass.setVisible(true);
				}
			});
            q4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//AllEmployeesClass
					AllEmployeesClass allEmployeesClass=new AllEmployeesClass();
					contentPane.add(allEmployeesClass);
					allEmployeesClass.setVisible(true);
					
				}
			});
            q5.addActionListener(new ActionListener() {
				
 				@Override
 				public void actionPerformed(ActionEvent e) {
 					// TODO Auto-generated method stub
 					//AllEmployeesClass
 					TotalProfitClass  totalp=new TotalProfitClass();
 					contentPane.add(totalp);
 					totalp.setVisible(true);
 					
 				}
 			});

            menuBar.add(mnNewMenu_q );
            
  		  JButton btnNewButton_1 = new JButton("Exit");
  		  menuBar.add(btnNewButton_1);
  		btnNewButton_1.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {		
  						setVisible(false);
  						new logIn().setVisible(true);
  				
  			}
  		});
			
	}
}