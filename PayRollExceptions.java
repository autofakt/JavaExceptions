import java.util.Scanner;

class Payroll{
	private String name;
	private String ID;
	private double payRate;
	private double hoursWorked;
	
	public Payroll(){
		this.name = "";
		this.ID = "";
		this.payRate = 0;
		this.hoursWorked = 0;
	}
	
	public Payroll(String name, String ID) {
		this.name = name;
		this.ID = ID;
		this.payRate = 0;
		this.hoursWorked = 0;		
	}
	
	public Payroll(String name, String ID, double payRate, double hoursWorked) throws EmptyString, 
	invalidNumberHoursWorked, invalidNumberPayRate, invalidNumericals {
		if(name.isEmpty())
			throw new EmptyString();
		else
			this.name = name;
		if(ID.isEmpty())
			throw new EmptyString();
		else {
			if(IDChecker(ID))
				this.ID = ID;
			else
				throw new invalidNumericals();
		}	
		if(payRate<0 || payRate>25)
			throw new invalidNumberPayRate();
		else
			this.payRate = payRate;
		
		if(hoursWorked<0 || hoursWorked>84)
			throw new invalidNumberHoursWorked();
		else
			this.hoursWorked = hoursWorked;
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;		
	}
	
	public String getID(){
		return this.ID;
	}
	
	public void setID(String ID){
		this.ID = ID;		
	}
	
	public double getPayRate() {
		return this.payRate;
	}
	
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	
	public double getHoursWorked() {
		return this.hoursWorked;
	}
	
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public double getGrossPay() {
		return hoursWorked * payRate;
	}
	
	public boolean IDChecker(String ID) {
			String[] tokens = ID.split("-");
			if (tokens.length != 2) // Checks for the correct format
				return false;
			String numbersID = tokens[0];
			String charID = tokens[1];
			if(!numbersID.matches("[0-9]+")) //Checks for digits only
				return false;
			else if(!charID.matches("[a-mA-M]+")) //A-M only
				return false;
			else
				return true;			
	}
	
}

class EmptyString extends Exception {
	public EmptyString() {
		super("Error: Empty String Alert");
	}
}

class invalidNumericals extends Exception {
	public invalidNumericals() {
		super("Error: Numericals in ID must be between 0-9 and letters must be between A-M");
	}
}

class invalidNumberPayRate extends Exception{
	public invalidNumberPayRate() {
		super("Error: Hourly Rate Cannot be negative or greater than 25");
	}
}

class invalidNumberHoursWorked extends Exception{
	public invalidNumberHoursWorked() {
		super("Error: Hours Cannot be negative or greater than 84");
	}
}


public class PayRollExceptions {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the employee's name: ");
		String name =  keyboard.nextLine();
		name = name.trim();
		
		System.out.print("Enter employee number, (ex. 999-M): ");
		String ID = keyboard.nextLine();
		ID = ID.trim();

		System.out.print("Enter the employee's hourly rate: ");
		double payRate = keyboard.nextDouble();

		System.out.print("Enter the number of hours the employee has worked: ");
		double hoursWorked = keyboard.nextDouble();
		
		try {
			Payroll employee = new Payroll(name,ID,payRate,hoursWorked);
			System.out.println("Employees name: " + name);
			System.out.println("ID: " + ID);
			System.out.println("Hourly Rate: $" + payRate);
			System.out.println("Hours: " + (int)hoursWorked+ " hrs");
			System.out.println("Gross Pay: $" + employee.getGrossPay());
		}
		catch(EmptyString e) {
			System.out.println(e.getMessage());
		}
		catch(invalidNumberHoursWorked e) {
			System.out.println(e.getMessage());
		}
		catch(invalidNumberPayRate e) {
			System.out.println(e.getMessage());
		}
		catch(invalidNumericals e) {
			System.out.println(e.getMessage());
		}
	}

}
