interface InterfaceCalculateWage {
	public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingHours, int workingDays);
	public void calculateWage();
}

class CompanyEmpWage {
	public final String companyName;
	public final int empWagePerHour;
	public final int workingDays;
	public final int workingHours;
	public int totalEmpWage;

	public CompanyEmpWage(String companyName, int empWagePerHour, int workingHours, int workingDays)
	{
		this.companyName = companyName;
		this.empWagePerHour = empWagePerHour;
		this.workingHours = workingHours;
		this.workingDays = workingDays;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString() {
		return "Total employee's wage of " +companyName+ " for maximum of " +workingHours+ " hours or " +workingDays+ " days is: " +totalEmpWage+ "\n";
	}
}
public class EmployeeWage implements InterfaceCalculateWage {

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmployeeWage() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHours) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(companyName, empWagePerHour, workingDays, workingHours);
		numOfCompany++;
	}

	public void calculateWage() {
		for (int i=0; i<numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.calculateWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}

	private int calculateWage(CompanyEmpWage companyEmpWage) 
	{
		int empHours = 0;
		int empWage = 0;
		int totalWorkingDays = 0;
		int totalWorkingHours = 0;

		while(totalWorkingHours<companyEmpWage.workingHours && totalWorkingDays<companyEmpWage.workingDays)
		{	
			totalWorkingDays++;
			int empCheck=((int)Math.floor(Math.random()*10))%3;
			switch(empCheck)
			{
				case isFullTime:
					empHours = 8;
					break;
				case isPartTime:
					empHours = 4;
					break;
				default:
					empHours = 0;
			}
			totalWorkingHours += empHours;
		}
		return totalWorkingHours * companyEmpWage.empWagePerHour;
	}

	public static void main(String[] args)
	{
		EmployeeWage employeeWage = new EmployeeWage();
		employeeWage.addCompanyEmpWage("Dmart", 20, 100, 30);
		employeeWage.addCompanyEmpWage("Walmart", 30, 100, 30);
		employeeWage.calculateWage();
	}
}