package trng.interfac.myJDBCApplication;

import java.util.Scanner;
import trng.interfac.myJDBCLibrary.*;

public class EmployeeOperationsApp {
	public static void main(String[] args) {
		try (Scanner ip = new Scanner(System.in)) {
			System.out.println("\n Enter the number of employees you wish to create\n ");
			int armax = ip.nextInt();
			System.out.println("Do you wish to add the data from a file?\n");
			System.out.println("1:Yes 2:No");
			int choice=ip.nextInt();
			if(choice==1)
			{
			System.out.println("NOTE: The system only accepts a .csv file with data written in the following format with a header.\n"
					+ "Below example shows the header and a line of example data just as a guide\n\n");
			System.out.println("EmpID, Name, Salary, Age, Gender\n"
					            + "101,John,60000,35,1\n");
			System.out.println("Add the file name here ");
			String filename=ip.next();
			EmployeeService ser = new EmployeeServiceImplementation(armax);
			ser.readfromCSVFile(filename);
			EmployeeUtil.displayMenu(ser);
			}
			else
			{
			 EmployeeService ser1= new EmployeeServiceImplementation(armax);
			EmployeeUtil.displayMenu(ser1);
			}
		}
	}
}