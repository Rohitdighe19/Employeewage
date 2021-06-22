
public class EmployeeWage  {
	public static void main(String[] args) {

		int isPartTime = 1;
		int isFullTime = 2;
		int empRatePerHour = 20;
		int empHours = 0;
		int empWage = 0;

		double empCheck = Math.floor(Math.random() * 10) % 3;

		if (empCheck == isFullTime) {
			System.out.println("Employee is present full-time");
			empHours = 8;
			empWage = empHours * empRatePerHour;
			System.out.println("Employee's wage = " + empWage);
		} else if (empCheck == isPartTime) {
			System.out.println("Employee is present part-time");
			empHours = 4;
			empWage = empHours * empRatePerHour;
			System.out.println("Employee's wage = " + empWage);
		} else {
			System.out.println("Employee is abscent");
			empHours = 0;
			empWage = empHours * empRatePerHour;
			System.out.println("Employee's wage = " + empWage);
		}
	}
}