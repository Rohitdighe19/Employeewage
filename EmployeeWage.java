
public class EmployeeWage  {
	public static final int empWagePerHour = 20;
	public static final int workingHours = 100;
	public static final int isPartTime = 1;
	public static final int isFullTime = 2;
	public static final int workingDays = 20;

	public static void main(String[] args) 
	{
		int empHours = 0;
		int empWage = 0;
		int totalWorkingDays = 0;
		int totalEmpWage = 0;
		int totalEmpHours = 0;
		int day = 0;
		while(totalWorkingDays<workingDays)
		{	
			day++;
			totalWorkingDays++;

			int empCheck=((int)Math.floor(Math.random()*10))%3;
			switch(empCheck)
			{
				case isFullTime:
					empHours = 8;
					System.out.println("Employee is present full-time on day " + day);
					break;
				case isPartTime:
					empHours = 4;
					System.out.println("Employee is present part-time on day " + day);
					break;
				default:
					empHours = 0;
					System.out.println("Employee is abscent on day " + day);
			}
			totalEmpHours += empHours;
			empWage = empHours * empWagePerHour;
			totalEmpWage += empWage;
		}
		System.out.println("Total employee's wage is: " + totalEmpWage);
	}
}