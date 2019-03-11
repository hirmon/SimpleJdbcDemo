package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Service {
	
	
	
	

/*	public static void create() {
		System.out.println("create method");
	}*/

	public static void list() {
		System.out.println("list method");
	}

	public static void update() {
		System.out.println("update method");
	}

	public static void delete() {
		System.out.println("delete method");
	}

	public static void search() {
		System.out.println("search method");
	}

	public static void getHighestPaid() {
		System.out.println("highest method");
	}

	public static void getCount() {
		System.out.println("total count method");
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Scanner in = new Scanner(System.in);
		 Dao db = new Dao(in);

		boolean flag = true;
		while (flag) {
			System.out.println("1) Create Employee");
			System.out.println("2) Insert Employee");
			System.out.println("3) List Employees");
			System.out.println("4) Update Employee");
			System.out.println("5) Delete Employee");
			System.out.println("6) Search Employee");
			System.out.println("7) Get Highest Paid Employee");
			System.out.println("8) Get Total Employees count");
			System.out.println("9) Exit");

			System.out.println("Enter the option:");
			int option = in.nextInt();

			switch (option) {
			case 1:
				db.create();
				break;
			case 2:
				db.insert();
				break;
			case 3:
				db.list();
				break;
			case 4:
				db.update();
				break;
			case 5:
				db.delete();
				break;
			case 6:
				db.search();
				break;
			case 7:
				db.getHighestPaid();
				break;
			case 8:
				db.getCount();
				break;
				
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Invalid Option Seleceted!");
				continue;
			}
		}

		System.out.println("Thanks for using our software!!!");

	}

}
