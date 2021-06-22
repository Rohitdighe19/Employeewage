import java.util.*;

interface InterfaceCalculateWage {
	public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingHours, int workingDays);
	public void calculateWage();
	public int getTotalWage(String companyName);
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
		totalEmpWage = 0;
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
	private Map<String, CompanyEmpWage> companyToEmpWageMap;

	public EmployeeWage() {
			companyEmpWageArrayList = new ArrayList<>();
			companyToEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String companyName, int empWagePerHour, int workingDays, int workingHours) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, empWagePerHour, workingDays, workingHours);
		companyEmpWageArrayList.add(companyEmpWage);
		companyToEmpWageMap.put(companyName, companyEmpWage);
	}

	public void calculateWage() {
		for (int i=0; i<companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.calculateWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	@Override
	public int getTotalWage(String companyName) {
		return companyToEmpWageMap.get(companyName).totalEmpWage;
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
		employeeWage.addCompanyEmpWage("Dmart", 30, 100, 30);
		employeeWage.addCompanyEmpWage("Walmart", 30, 100, 30);
		employeeWage.calculateWage();
		System.out.println("Total wage for Walmart company: " + employeeWage.getTotalWage("Walmart"));
	}
}