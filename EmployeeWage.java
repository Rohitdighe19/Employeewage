
public class EmployeeWage  {
	public static final int empWagePerHour = 20;
	public static final int workingHours = 100;
	public static final int isPartTime = 1;
	public static final int isFullTime = 2;
	public static final int workingDays = 30;

	public static void calculateWage() 
	{
		int empHours = 0;
		int empWage = 0;
		int totalWorkingDays = 0;
		int totalEmpWage = 0;
		int totalWorkingHours = 0;
		int day = 0;
		while(totalWorkingHours<workingHours && totalWorkingDays<workingDays)
		{	
			day++;
			totalWorkingDays++;
			int empCheck=((int)Math.floor(Math.random()*10))%3;
			switch(empCheck)
			{
				case isFullTime:
					empHours = 8;
					System.out.println("Employee is present full-time on day " + day + " for " + empHours + " hours");
					break;
				case isPartTime:
					empHours = 4;
					System.out.println("Employee is present part-time on day " + day + " for " + empHours + " hours");
					break;
				default:
					empHours = 0;
					System.out.println("Employee is abscent on day " + day);
			}
			totalWorkingHours += empHours;
			empWage = empHours * empWagePerHour;
			totalEmpWage += empWage;
		}
		System.out.println();
		System.out.println("Maximum working hours: " + totalWorkingHours);
		System.out.println("Maximum working days: " + totalWorkingDays);
		System.out.println("Total employee's wage for maximum of " + workingHours + " hours or " + workingDays + " days is: " + totalEmpWage);
	}
	public static void main(String[] args)
	{
		calculateWage(); // Directly calling function without creating obj 'cause its a static one.
	}
}