package model;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.ParseException;

//lana yaqub 324302454
//layan abu sinni 324296425

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.util.TreeSet;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import Exeption.DepartmentNotInTheSystem;
import Exeption.ErrorInput;
import Exeption.IncorrectNumberOfSeats;
import Exeption.PersonAlreadyExistException;
import Exeption.PersonNotExistException;
import Exeption.PoullutionLevelHybridVehiclesMustBeOne;
import Exeption.PoullutionLevelNotInRange;
import Exeption.TheDealIsNotFound;
import Exeption.TheVehicleTransportationIsNotExist;
import Exeption.YearOfBirthNotInRange;
import utils.Area;
import utils.Color;
import utils.Gender;	
	
	public class Factory implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private HashMap<String,Employee> allEmployees;
		private HashMap<String,Customer> allCustomers;
		private HashMap<String,VehicleTransportation> allVehicleTransportation;
		private HashMap<String,Deal> allDeals;
		private HashMap<Integer,Department> allDepartments;
		private HashMap<String,String> allUsers;
        private static Factory factory;
        private Integer tempVehicle=0;
		private Integer tenpDeal=0;
		
		private Factory() {
			allEmployees = new HashMap<String,Employee>();
			allCustomers = new HashMap<String, Customer>();
			allVehicleTransportation = new HashMap<String, VehicleTransportation>();
			allDeals = new HashMap<String, Deal>();
			allDepartments = new HashMap<Integer, Department>();
			allUsers= new HashMap<String,String>();//to save all the user name and password for all the employees
		}
		
		public static Factory getInstance() {
			if(factory == null)
				factory = new Factory();
			return factory; 
		}
		 
//****************************************************************************** 	
		//add functions 
	
		//Check if the Hash map  of the employee contains the Id of the employee
		// throw new exception that we made PersonAlreadyExistException
		//throw new exception if the year birth of the employee is not between 1900-2022
		
//checks if the input is legal(isn't null), 
//then checks the Employee doesn't exists in the allEmployees HashM
//if so then adds it using put method and and add it to the employees hash set of the department and returns true.
		public boolean addUser(String s,String s2)  {
			allUsers.put(s, s2);
			return true;
		}
		public boolean addEmployee(Employee e) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(e == null) {
				return false;
				
			}
			
			if(allEmployees.containsKey(e.getID())) {
				throw new PersonAlreadyExistException(e);
			
			}
			if(e.getYearOfBirth() < 1900 || e.getYearOfBirth() > 2022) {
				
				throw new YearOfBirthNotInRange(e);
		
		}
			
			allEmployees.put(e.getID(), e);
			JOptionPane.showMessageDialog(null,"The Department Manger Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return e.getDep().getAllEmployees().add(e);
			
		}
		//Check if the Hash map  of the employee contains the Id of the Department Manager
		// throw new exception that we made PersonAlreadyExistException
		//throw new exception if the year birth of the Department Manager is not between 1900-2022
		//checks if the input is legal(isn't null),
		//then checks the Department Manager doesn't exists in the allEmployees HashM
		//if so then adds it using put method and and set the Department returns true.
		public boolean addDepartmentManager(DepartmentManager dm) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(dm == null )
				return false;
			if(allEmployees.containsKey(dm.getID())) {
				throw new PersonAlreadyExistException(dm);
			
			}
			if(dm.getYearOfBirth() < 1900 || dm.getYearOfBirth() > 2022) {
				
				throw new YearOfBirthNotInRange(dm);
		
		}

			allEmployees.put(dm.getID(), dm);
			dm.getDep().setDepManager(dm);
			JOptionPane.showMessageDialog(null,"The Department Manger Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		//Check if the Hash map  of the allCustomers contains the Id of the Customers 
		// then throw new exception that we made 
		//throw new exception if the year birth of the Customers is not between 1900-2022
		//checks if the input is legal(isn't null),
		//then checks the Customers doesn't exists in the allCustomers HashM
		//if so then adds it using put method and returns true.
		public boolean addCustomer(Customer c) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(c == null)
				return false;
			if(allCustomers.containsKey(c.getID())) {
				throw new PersonAlreadyExistException(c);
			
			}
			if(c.getYearOfBirth() < 1900 || c.getYearOfBirth() > 2022) {
				
				throw new YearOfBirthNotInRange(c);
		
		}
			
			allCustomers.put(c.getID(), c);
			JOptionPane.showMessageDialog(null,"The Customer Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//Check if the Hash map  of the allCustomers contains the Id of the VIPCustomers
		// then throw new exception that we made 
		//throw new exception if the year birth of the VIPCustomers is not between 1900-2022
		//checks if the input is legal(isn't null),
		//then checks the VIPCustomers doesn't exists in the allCustomers HashM
		//if so then adds it using put method and returns true.
		public boolean addVIPCustomer(VIPCustomer vc) throws PersonAlreadyExistException, YearOfBirthNotInRange {
			if(vc == null)
				return false;
			if(allCustomers.containsKey(vc.getID())) {
				throw new PersonAlreadyExistException(vc);
			
			}
			if(vc.getYearOfBirth() < 1900 || vc.getYearOfBirth() > 2022) {
				
					throw new YearOfBirthNotInRange(vc);
			
			}
			allCustomers.put(vc.getID(), vc);
			JOptionPane.showMessageDialog(null,"The Customer Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal(isn't null), 
		//then check if the Pollution Level not between 1- 15 then throw an exception 
		//then check if the Number Of Seats of the vehicle are bigger than 7 the throw an  exception 
		//then checks the car doesn't exists in the vehicles HashMap
		//if so then adds it using put method and returns true.

		public boolean addCar(Car car) throws PoullutionLevelNotInRange, IncorrectNumberOfSeats {
		IncorrectNumberOfSeats iNumberOfSeats=new IncorrectNumberOfSeats(car);
		PoullutionLevelNotInRange poullution=new PoullutionLevelNotInRange(car);
		ErrorInput e=new ErrorInput();
			if (car == null) {
				JOptionPane.showMessageDialog(null,e.getMessage() ,"Read File Error", JOptionPane.ERROR_MESSAGE);
			return false;
			}
			if (car.getPollutionLevel() > 15 || car.getPollutionLevel() < 1) {
		
				JOptionPane.showMessageDialog(null,poullution.getMessage() ,"Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if (car.getNumberOfSeats() > 7) {
				
				JOptionPane.showMessageDialog(null,iNumberOfSeats.getMessage() ,"Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
	         }
			
		
			if (!allVehicleTransportation.containsKey(car.getLicensePlate())) {
				allVehicleTransportation.put(car.getLicensePlate(), car);
				 JOptionPane.showMessageDialog(null,"The Car Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			JOptionPane.showMessageDialog(null,e.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
			return false;

		} 
		//checks if the input is legal(isn't null), 
		//then check if the Pollution Level not 1 then throw an exception 
		//then check if the Number Of Seats of the Hybrid vehicle are bigger than 7 the throw an  exception 
		//then checks the car doesn't exists in the vehicles HashMap
		//if so then adds it using put method and returns true.
		public boolean addHybridCar(HybridCar hybridCar) throws PoullutionLevelHybridVehiclesMustBeOne, IncorrectNumberOfSeats       {
			if(hybridCar == null)
			{
				JOptionPane.showMessageDialog(null,"Not Added","Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(hybridCar.getPollutionLevel() != 1 ) {
				throw new PoullutionLevelHybridVehiclesMustBeOne(hybridCar);
			}
			if(hybridCar.getNumberOfSeats() > 7) {
				throw new IncorrectNumberOfSeats(hybridCar);
				}
			allVehicleTransportation.put(hybridCar.getLicensePlate(), hybridCar);
			 JOptionPane.showMessageDialog(null,"The Car Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true; 
			
			
		}
		//checks if the input is legal(isn't null), 
        //then check if the Pollution Level not between 1- 15 then throw an exception 
		
		//then checks the car doesn't exists in the vehicles HashMap
		//if so then adds it using put method and returns true.
		public boolean addVan(Van v) throws PoullutionLevelNotInRange {
			PoullutionLevelNotInRange p = new PoullutionLevelNotInRange(v);
			if(v == null) {
				JOptionPane.showMessageDialog(null,p.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
		}
			if((v.getPollutionLevel() < 1 || v.getPollutionLevel() > 15 )) {
				
					throw new PoullutionLevelNotInRange(v);
				
			}
			allVehicleTransportation.put(v.getLicensePlate(), v);
			JOptionPane.showMessageDialog(null,"The Van Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal(isn't null), 
        //then check if the Pollution Level not between 1- 15 then throw an exception 
		//then check if the Number Of Seats of the vehicle are bigger than 7 the throw an  exception 
		//then checks the car doesn't exists in the vehicles HashMap
		//if so then adds it using put method and returns true.
		public boolean addMotorcycle(Motorcycle m) throws PoullutionLevelNotInRange {
			if(m == null)
			{
				JOptionPane.showMessageDialog(null,"Not Added","Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if((m.getPollutionLevel() < 1 || m.getPollutionLevel() > 15 )) {
				
				throw new PoullutionLevelNotInRange(m);
			
		}
			allVehicleTransportation.put(m.getLicensePlate(), m);
			JOptionPane.showMessageDialog(null,"The Motorcycle Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		//checks if the input is legal(isn't null), 
		//then check if the Pollution Level not 1 then throw an exception 
		//then check if the Number Of Seats of the Hybrid vehicle are bigger than 7 the throw an  exception 
		//then checks the car doesn't exists in the vehicles HashMap
		//if so then adds it using put method and returns true.
		public boolean addHybridMotorcycle(HybridMotorcycle hybridMotorcycle) throws PoullutionLevelHybridVehiclesMustBeOne {
			if(hybridMotorcycle == null)
			{
				JOptionPane.showMessageDialog(null,"Not Added","Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(hybridMotorcycle.getPollutionLevel() != 1 ) {
				throw new PoullutionLevelHybridVehiclesMustBeOne(hybridMotorcycle);
			}
			allVehicleTransportation.put(hybridMotorcycle.getLicensePlate(), hybridMotorcycle);
			JOptionPane.showMessageDialog(null,"The Motorcycle Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		
		public boolean addDepartment(Department d) {
		DepartmentNotInTheSystem e4= new DepartmentNotInTheSystem();
			
			if(d ==null) {
			JOptionPane.showMessageDialog(null,e4.getMessage(),"Read File Error", JOptionPane.ERROR_MESSAGE);
			return false;
			}
			if(allDepartments.containsKey(d.getDepartmentID()))
			{
				JOptionPane.showMessageDialog(null,"Department Already Exist","Read File Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			allDepartments.put(d.getDepartmentID(), d);
			JOptionPane.showMessageDialog(null,"The Deaprtment Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} 
		
		public boolean addDeal(Deal d) {
			if(d == null) {
				JOptionPane.showMessageDialog(null,"Deal not added", "Submited", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

			d.getCustomer().getAllDeals().add(d);
			allDeals.put(d.getDealID(), d);
			JOptionPane.showMessageDialog(null,"The Deal Added Successfully", "Submited", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	//*********************************************************************************************************
		// REMOVE function 

		    //checks if the input is legal (isn't null).
			//then checks if the car we want to remove exists in the vehicles hash map
			//if so the remove it and return true.
			//else return false.
		public boolean removeCar(Car car) throws TheVehicleTransportationIsNotExist {
		
			if(car == null) {
				throw new TheVehicleTransportationIsNotExist();
			}
				
			if(!allVehicleTransportation.containsKey(car.getLicensePlate())) {
				throw new TheVehicleTransportationIsNotExist();
			}
			allVehicleTransportation.remove(car.getLicensePlate());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal (isn't null).
		//then checks if the Van we want to remove exists in the vehicles hash map
		//if so the remove it and return true.
		//else return false.
		
		public boolean removeVan(Van van)throws TheVehicleTransportationIsNotExist  {
			
		
			if(van == null) {
				throw new TheVehicleTransportationIsNotExist();
			}
			if(!allVehicleTransportation.containsKey(van.getLicensePlate())) {
				throw new TheVehicleTransportationIsNotExist();
		}
			allVehicleTransportation.remove(van.getLicensePlate());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		
		//checks if the input is legal (isn't null).
		//then checks if the Motorcycle we want to remove exists in the vehicles hash map
		//if so the remove it and return true.
		//else return false.
		public boolean removeMotorcycle(Motorcycle motorcycle) throws TheVehicleTransportationIsNotExist{
		
			if(motorcycle == null) {
				throw new TheVehicleTransportationIsNotExist();
		}
			if(!allVehicleTransportation.containsKey(motorcycle.getLicensePlate())) {
				throw new TheVehicleTransportationIsNotExist();
			}
			allVehicleTransportation.remove(motorcycle.getLicensePlate());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal (isn't null).
		//then checks if the Hybrid Car we want to remove exists in the vehicles hash map
		//if so the remove it and return true.
		//else return false.
		public boolean removeHybridCar(HybridCar hybridCar) throws TheVehicleTransportationIsNotExist {		
			
			if(hybridCar == null) {
				throw new TheVehicleTransportationIsNotExist();
		}
			if(!allVehicleTransportation.containsKey(hybridCar.getLicensePlate())) {
				throw new TheVehicleTransportationIsNotExist();
			}
			allVehicleTransportation.remove(hybridCar.getLicensePlate());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal (isn't null).
		//then checks if the Hybrid Motorcycle we want to remove exists in the vehicles hash map
		//if so the remove it and return true.
		//else return false.
		public boolean removeHybridMotorcycle(HybridMotorcycle HybridMotorcycle) throws TheVehicleTransportationIsNotExist{		
			
			if(HybridMotorcycle == null) 
				throw new TheVehicleTransportationIsNotExist();
		
			if(!allVehicleTransportation.containsKey(HybridMotorcycle.getLicensePlate())) {
				throw new TheVehicleTransportationIsNotExist();
			}
			allVehicleTransportation.remove(HybridMotorcycle.getLicensePlate());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
			
		}
		//checks if the input is legal (isn't null).
		//if the input is null the throw new exception 
		//then checks if the Customer we want to remove exists in the allCustomers hash map
		//if so the remove it and return true.
		//else return false.
		
		public boolean removeCustomer(Customer customer) throws PersonNotExistException{
			
			if(customer == null) {
				throw new PersonNotExistException();
			}
			
			if(allCustomers.containsKey(customer.getID())) {
				allCustomers.remove(customer.getID());
				JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
				return true;
				
			}
			throw new PersonNotExistException();
			
		}
		//checks if the input is legal (isn't null).
		//if the input is null the throw new exception 
		//then checks if the VIPCustomer we want to remove exists in the allCustomers hash map
		//if so the remove it and return true.
		//else return false.
		public boolean removeVIPCustomer(VIPCustomer vipCustomer) throws PersonNotExistException{
			
			
			if(vipCustomer == null) {

				throw new PersonNotExistException();
			}
			
			if(allCustomers.containsKey(vipCustomer.getID())) {
				allCustomers.remove(vipCustomer.getID());
				JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
	

			throw new PersonNotExistException();
			
		}
		//checks if the input is legal (isn't null).
		//if the input is null the throw new exception 
		//then checks if the Employee we want to remove exists in the allEmployees hash map
		//if so the remove it and return true.
		//else return false.
		public boolean removeEmployee(Employee employee) throws PersonNotExistException{
			
			if(employee == null) {

				throw new PersonNotExistException();
				
			}
			if(allEmployees.containsKey(employee.getID())) {
				allEmployees.remove(employee.getID());
				employee.getDep().getAllEmployees().remove(employee);
				JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}

			throw new PersonNotExistException();
			
		}
		//checks if the input is legal (isn't null).
		//if the input is null the throw new exception 
		//then checks if the Department Manager we want to remove exists in the allEmployees hash map
	 //if so the remove it and return true.
  			//else return false.
		public boolean removeDepartmentManager(DepartmentManager departmentManager) throws PersonNotExistException{
			
			
			if(departmentManager == null) {

				throw new PersonNotExistException();
			}
			if(allEmployees.containsKey(departmentManager.getID())) {
				allEmployees.remove(departmentManager.getID());
				departmentManager.getDep().setDepManager(null);
				JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}

			throw new PersonNotExistException();
			
		}

		//checks if the input is legal (isn't null).
		//checks if the deal doesn't exists then return false.
		//and then check if there is a customer that has the same ID if so then remove the deal 
		//from the deals list of this customer and finally remove the deal from all deals map and return false.

		public boolean removeDeal(Deal deal) throws TheDealIsNotFound{ 
			
			if(deal == null)
				throw new TheDealIsNotFound();
			if(!allDeals.containsKey(deal.getDealID()))
				throw new TheDealIsNotFound();
			deal.getCustomer().getAllDeals().remove(deal);
			allDeals.remove(deal.getDealID());
			JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		
		//checks if the input is legal (isn't null).
		//checks if the department doesn't exists then return false.
		//and then check if there is a department that contains employee so then remove the employee 
		//from the allDepartments list of this department and finally remove the department from all allDepartments map and return false.
		public boolean removeDepartment(Department department)throws DepartmentNotInTheSystem {
			
			if(department ==null) {
				throw new DepartmentNotInTheSystem();
			
		}
			if(allDepartments.containsKey(department.getDepartmentID())) {
				for(Employee employee:department.getAllEmployees()) {
					employee.setDep(null);
					allEmployees.remove(employee.getID());
				}
				
				if(department.getDepManager()!=null)
				{
					allEmployees.remove(department.getDepManager().getID());
					department.getDepManager().setDep(null);
				}
				allDepartments.remove(department.getDepartmentID());
				JOptionPane.showMessageDialog(null,"Successfully Removed", "Removed", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			throw new DepartmentNotInTheSystem();
		  }


		//getreal functions 
		//Note: We assume that in our system, a string cannot be null.
		
		//searching for the VehicleTransportation that has the same license plate and return it.
		//if there is no VehicleTransportation like this then return null.
		public VehicleTransportation getRealVehicleTransportation(String licensePlate){
			return allVehicleTransportation.get(licensePlate);	
		}
		//searching for the Hybrid Car that has the same license plate and return it.
		//if there is no Hybrid Car like this then return null.
		public HybridCar getRealHybridCar(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (HybridCar)allVehicleTransportation.get(licensePlate);
			return null;
		}
		//searching for the Hybrid Motorcycle that has the same license plate and return it.
		//if there is no Hybrid Motorcycle like this then return null.
		public HybridMotorcycle getRealHybridMotorcycle(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (HybridMotorcycle)allVehicleTransportation.get(licensePlate);
			return null;
		}
		//searching for the  Motorcycle that has the same license plate and return it.
				//if there is no Motorcycle like this then return null.
		public Motorcycle getRealMotorcycle(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Motorcycle)allVehicleTransportation.get(licensePlate);
			return null;
		}
		//searching for the Car  that has the same license plate and return it.
		//if there is no Car like this then return null.
		public Car getRealCar(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Car)allVehicleTransportation.get(licensePlate);
			return null;
		}
		//searching for the Van  that has the same license plate and return it.
				//if there is no Van like this then return null.
		public Van getRealVan(String licensePlate){
			if(allVehicleTransportation.get(licensePlate) != null)
				return (Van)allVehicleTransportation.get(licensePlate);
			return null;
		}
		//searching for the Customer  that has the same ID and return it.
		//if there is no Customer like this then return null.
		public Customer getRealCustomer(String ID){
			if(allCustomers.get(ID) != null)
				return (Customer)allCustomers.get(ID);
			return null;
		}
		//searching for the VIP Customer  that has the same ID and return it.
		//if there is no VIP Customer like this then return null.
		public Customer getRealVIPCustomer(String ID){
			if(allCustomers.get(ID) != null)
				return (VIPCustomer)allCustomers.get(ID);
			return null;
		}
		//searching for the Employee  that has the same ID and return it.
		//if there is no Employee like this then return null.
		public Employee getRealEmployee(String ID){
			if(allEmployees.get(ID) != null)
				return (Employee)allEmployees.get(ID);
			return null;
		}
		//searching for the Department Manager  that has the same ID and return it.
				//if there is no Department Manager like this then return null.
		public DepartmentManager getRealDepartmentManager(String ID){
			if(allEmployees.get(ID) != null)
				return (DepartmentManager)allEmployees.get(ID);
			return null;
		}
		//searching for the Deal that has the same deal ID and return it.
		//if there is no Deal like this then return null.
		public Deal getRealDeal(String dealID){
			return allDeals.get(dealID);
		}
		//searching for the Department that has the same departmentID and return it.
		//if there is no Department like this then return null.
		public Department getRealDepartment(int departmentID){
			
			return allDepartments.get(departmentID);
		}
		
	
	

/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
		
		public int totalProfit() {
			if(allDeals.isEmpty())
				return 0;
			List<Deal> deal = getAllDeals().values().stream().collect(Collectors.toList());
			double revenue = deal.stream().mapToDouble(d->d.getTotalDealPrice()).sum();
			double costs = deal.stream().mapToDouble(d -> d.getAllVehicleTransportation().stream().mapToDouble(v->v.getCostOfManufacturing()).sum()).sum();
			return (int) (revenue-costs);

		}
	
	///average pollution of the vehicle in the deal
		//stream
		public double avgPollutionLevelOfDeal (Deal deal) {
			if(deal == null) {
				return -1;
				}


				List<VehicleTransportation> vehicleTransportations  = deal.getAllVehicleTransportation().stream().collect(Collectors.toCollection(ArrayList<VehicleTransportation>::new));	
		        return(vehicleTransportations.stream().mapToInt(VehicleTransportation::getPollutionLevel).sum()/deal.getAllVehicleTransportation().size());
					
			}
	///firs k employees sortet by id
	public List<Employee> allEmployees(int k){
		
		List<Employee> employees  = allEmployees.values().stream().collect(Collectors.toCollection(ArrayList<Employee>::new));	
		employees.stream().sorted((Employee o1, Employee o2) -> {
					return o1.getID().compareTo(o2.getID());
		});
		
		return employees.stream().limit(k).collect(Collectors.toList());
	}
	
	
	//function that sorted an arrayList according to the salary then according to the Date 
	public  ArrayList<DepartmentManager> AllBestsDepManger() {
		
		return (ArrayList<DepartmentManager>) allEmployees.values().stream().filter(e -> e instanceof DepartmentManager).map(e -> (DepartmentManager)e)
				.sorted(new SortDepartmentMan()).collect(Collectors.toList());
	}
	
	public double profitPerVehiclesTransportation (VehicleTransportation vehicleTransportation) {
		ProfitPerVehiclesTransportationClass profitClass= (VehicleTransportation v) -> (v.getPrice() - v.getCostOfManufacturing());
		return profitClass.ProfitPerVehiclesTransportationClass(vehicleTransportation);
	}
//***********************************************************************************
				//GET & SET
		
		public HashMap<String, Employee> getAllEmployees() {
			return allEmployees;
		}

		public void setAllEmployees(HashMap<String, Employee> allEmployees) {
			this.allEmployees = allEmployees;
		}

		public HashMap<String, Customer> getAllCustomers() {
			return allCustomers;
		}

		public void setAllCustomers(HashMap<String, Customer> allCustomers) {
			this.allCustomers = allCustomers;
		}

		public HashMap<String, VehicleTransportation> getAllVehicleTransportation() {
			return allVehicleTransportation;
		}

		public void setAllVehicleTransportation(HashMap<String, VehicleTransportation> allVehicleTransportation) {
			this.allVehicleTransportation = allVehicleTransportation;
		}

		public HashMap<String, Deal> getAllDeals() {
			return allDeals;
		}

		public void setAllDeals(HashMap<String, Deal> allDeals) {
			this.allDeals = allDeals;
		}

		public HashMap<Integer, Department> getAllDepartments() {
			return allDepartments;
		}

		public void setAllDepartments(HashMap<Integer, Department> allDepartments) {
			this.allDepartments = allDepartments;
		}

		public static Factory getEnterpise() {
			return factory;
		}
		public static void setEnterpise(Factory enterpise) {
			Factory.factory = enterpise;
		}

		public Integer getTenpDeal() {
			return tenpDeal;
		}

		public void setTenpDeal(Integer tenpDeal) {
			this.tenpDeal = tenpDeal;
		}

		public Integer getTempVehicle() {
			return tempVehicle;
		}

		public void setTempVehicle(Integer tempVehicle) {
			this.tempVehicle = tempVehicle;
		}

		public HashMap<String, String> getAllUsers() {
			return allUsers;
		}

		public void setAllUsers(HashMap<String, String> allUsers) {
			this.allUsers = allUsers;
		}

	


	
}	
