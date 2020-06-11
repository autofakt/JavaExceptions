import java.util.Scanner;

class Employee extends InvalidEmployeeNumber {
	private String name;
	private String eNumber;
	private String hireDate;

	public Employee() {
		name = "";
		eNumber = "";
		hireDate = "";
	}

	public Employee(String name, String eNumber, String hireDate) throws InvalidEmployeeNumber {
		if (eNumber.length() != 5)
			throw new InvalidEmployeeNumber();
		else {
			String[] tokens = eNumber.split("-");
			if (tokens.length != 2) // Checks for the correct format
				throw new InvalidEmployeeNumber();
			String numbersID = tokens[0];
			String charID = tokens[1];
			if (!numbersID.matches("[0-9]+")) // Checks for digits only
				throw new InvalidEmployeeNumber();
			else if (!charID.matches("[a-mA-M]+")) // A-M only
				throw new InvalidEmployeeNumber();
			else
				; // default
		}
		this.name = name;
		this.eNumber = eNumber;
		this.hireDate = hireDate;

	}

	public String getName() {
		return this.name;
	}

	public String getENumber() {
		return this.eNumber;
	}

	public String getHireDate() {
		return this.hireDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setENumber(String eNumber) {
		this.eNumber = eNumber;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}

class ProductionWorker extends Employee {
	private int shift;
	private double hourlyPay;

	public ProductionWorker(String name, String eNumber, String hireDate, int shift, double hourlyPay)
			throws InvalidEmployeeNumber, InvalidShift, InvalidPayRate {

		super(name, eNumber, hireDate);

		if (shift != 1 && shift != 2)
			throw new InvalidShift();
		this.shift = shift;

		if (hourlyPay < 0)
			throw new InvalidPayRate();
		this.hourlyPay = hourlyPay;
	}

	public int getShift() {
		return this.shift;
	}

	public double getHourlyPay() {
		return this.hourlyPay;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
}

class InvalidEmployeeNumber extends Exception {
	public InvalidEmployeeNumber() {
		super("ERROR: InvalidEmployeeNumber");
	}
}

class InvalidShift extends Exception {
	public InvalidShift() {
		super("ERROR: InvalidShift");
	}
}

class InvalidPayRate extends Exception {
	public InvalidPayRate() {
		super("ERROR: InvalidPayRate");
	}
}

public class ExceptionProject {

	public static void main(String[] args) {
		String employeeName;
		String employeeNumber;
		String hireDate;
		int shiftNumber;
		double hourlyRate;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter employee name: ");
		employeeName = keyboard.nextLine();
		System.out.print("Enter employee number, (ex. 999-M): ");
		employeeNumber = keyboard.nextLine();
		System.out.print("Enter employee hire date: ");
		hireDate = keyboard.nextLine();
		System.out.print("Employee shift, (1 = day or 2 = night): ");
		shiftNumber = keyboard.nextInt();
		System.out.print("Enter employee hourly pay rate: ");
		hourlyRate = keyboard.nextDouble();

		try {
			ProductionWorker worker = new ProductionWorker(employeeName, employeeNumber, hireDate, shiftNumber,
					hourlyRate);

			System.out.println("Employee Details");
			System.out.println("Employees name: " + worker.getName());
			System.out.println("Employee Number: " + worker.getENumber());
			System.out.println("Hire Date: " + worker.getHireDate());
			System.out.println("Shift: " + worker.getShift());
			System.out.println("Hourly Pay Rate: $" + worker.getHourlyPay());
		} catch (InvalidEmployeeNumber e) {
			System.out.println(e.getMessage());
		} catch (InvalidShift e) {
			System.out.println(e.getMessage());
		} catch (InvalidPayRate e) {
			System.out.println(e.getMessage());
		}
	}

}
