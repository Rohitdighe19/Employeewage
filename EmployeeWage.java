
public class EmployeeWage {
	public static void main(String[] args) {

		int isFullTime = 1;
		int empRatePerHour = 20;
		int empHours = 0;
		int empWage = 0;

		double empCheck = Math.floor(Math.random() * 10) % 2;

		if (empCheck == isFullTime) {
			System.out.println("Employee is present");
			empHours = 8;
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