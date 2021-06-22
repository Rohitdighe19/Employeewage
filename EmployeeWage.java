
public class EmployeeWage  {
	public static final int empRatePerHour=20;
	public static final int isPartTime=1;
	public static final int isFullTime=2;

	public static void main(String[] args) 
	{
		int empRatePerHour = 20;
		int empHours = 0;
		int empWage = 0;

		int empCheck=((int)Math.floor(Math.random()*10))%3;
		
		switch(empCheck){
			case isFullTime:
					empHours = 8;
					System.out.println("Employee is present full-time");
					break;
			case isPartTime:
					empHours = 4;
					System.out.println("Employee is present part-time");
					break;
			default:
					empHours = 0;
					System.out.println("Employee is abscent");
					break;
		}

		empWage = empHours * empRatePerHour;
		System.out.println("Employee's Wage: " + empWage);
	}
}