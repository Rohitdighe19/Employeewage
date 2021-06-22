import java.util.*;

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
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	private ArrayList<Integer> dailyWageList;

	public EmployeeWage() {
			companyEmpWageArrayList = new ArrayList<>();
			dailyWageList = new ArrayList<>();
	}

	public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHours) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, empWagePerHour, workingDays, workingHours);
		companyEmpWageArrayList.add(companyEmpWage);
	}

	public void calculateWage() {
		for (int i=0; i<companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.calculateWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	public void computeDailyWage() {
		for (int j=0; j<dailyWageList.size(); j++) {
			System.out.println("Daily wage of employee is: " + dailyWageList.get(j));
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
			int dailyWage = empHours * companyEmpWage.empWagePerHour;
			dailyWageList.add(dailyWage);
			totalWorkingHours += empHours;
		}
		return totalWorkingHours * companyEmpWage.empWagePerHour;
	}

	public static void main(String[] args)
	{
		EmployeeWage employeeWage = new EmployeeWage();
		employeeWage.addCompanyEmpWage("Walmart", 30, 100, 30);
		employeeWage.calculateWage();
		employeeWage.computeDailyWage();
	}
}