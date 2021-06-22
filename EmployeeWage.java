public class EmployeeWage {

	public static final int isPartTime = 1;
	public static final int isFullTime = 2;

	private final String companyName;
	private final int empWagePerHour;
	private final int workingDays;
	private final int workingHours;
	private int totalEmpWage;

	public EmployeeWage(String companyName, int empWagePerHour, int workingHours, int workingDays)
	{
		this.companyName = companyName;
		this.empWagePerHour = empWagePerHour;
		this.workingHours = workingHours;
		this.workingDays = workingDays;
	}

	public void calculateWage() 
	{
		int empHours = 0;
		int empWage = 0;
		int totalWorkingDays = 0;
		int totalWorkingHours = 0;

		while(totalWorkingHours<workingHours && totalWorkingDays<workingDays)
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
		totalEmpWage = totalWorkingHours * empWagePerHour;
	}

	@Override
	public String toString() {
		return "Total employee's wage of " +companyName+ " for maximum of " +workingHours+ " hours or " +workingDays+ " days is: " +totalEmpWage+ "\n";
	}

	public static void main(String[] args)
	{
		EmployeeWage dmart = new EmployeeWage("Dmart", 20, 100, 30);
		EmployeeWage walmart = new EmployeeWage("Walmart", 30, 100, 30);
		dmart.calculateWage();
		System.out.println(dmart);
		walmart.calculateWage();
		System.out.println(walmart);
	}
}