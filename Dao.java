package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Dao {
	private Scanner in = null;

	public Dao(Scanner in) {
		this.in = in;
	}

	static String url = "jdbc:mysql://localhost/employee";
	static String user = "root";
	static String password = "haben46Shady@123";

	public static void create() throws SQLException {
		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("create");
		myStmt = myConn.createStatement();

		PreparedStatement pstmt = myConn
				.prepareStatement("CREATE TABLE IF NOT EXISTS employee (empID int auto_increment,"
						+ " empName varchar(255), empPhone int, empAddress varchar(255), empSalary double, empQualification varchar(255), empAge int, PRIMARY KEY(empID))");

		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Table created!");

		myConn.close();

	}

	public void insert() throws SQLException {
		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("insert");
		myStmt = myConn.createStatement();
		PreparedStatement pstmt = myConn.prepareStatement(
				"INSERT INTO employee (empName,empPhone,empAddress,empSalary,empQualification,empAge) VALUES(?,?,?,?,?,?)");
		// System.out.println("Enter Employee ID: ");
		// int empID = in.nextInt();
		// pstmt.setInt(1, empID);
		System.out.println("Enter Employee Name:");
		String empName = in.next();
		pstmt.setString(1, empName);
		System.out.println("Enter Employee Phone:");
		int empPhone = in.nextInt();
		pstmt.setInt(2, empPhone);
		System.out.println("Enter Employee Address: ");
		String empAddress = in.next();
		pstmt.setString(3, empAddress);
		System.out.println("Enter Employee Salary");
		double empSalary = in.nextDouble();
		pstmt.setDouble(4, empSalary);
		System.out.println("Enter Employee Qualification");
		String empQualification = in.next();
		pstmt.setString(5, empQualification);
		System.out.println("Enter Employee Age");
		int empAge = in.nextInt();
		pstmt.setInt(6, empAge);
		int i = pstmt.executeUpdate();

	}

	public void list() throws SQLException {
		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("insert");
		myStmt = myConn.createStatement();
		ResultSet rs = myStmt.executeQuery("SELECT * from employee");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\n" + rs.getString(2) + "\n" + rs.getInt(3) + "\n" + rs.getString(4)
					+ "\n" + rs.getDouble(5) + "\n" + rs.getString(6) + "\n" + rs.getInt(7));
		}

	}

	public void update() throws SQLException {

		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("insert");
		myStmt = myConn.createStatement();

		PreparedStatement pstmt = myConn
				.prepareStatement("UPDATE employee SET empName=?,empPhone=?, empAddress=?, empQualification=?, empAge=?"
						+ "empAge=?  WHERE empID=?");

		System.out.println("Enter Employee Name:");
		String empName = in.next();
		pstmt.setString(1, empName);
		System.out.println("Enter Employee Phone:");
		String empPhone = in.next();
		pstmt.setString(2, empPhone);
		System.out.println("Enter Employee Address: ");
		String empAddress = in.next();
		pstmt.setString(3, empAddress);
		System.out.println("Enter Employee Salary");
		double empSalary = in.nextDouble();
		pstmt.setDouble(4, empSalary);
		System.out.println("Enter Employee Qualification");
		String empQualification = in.next();
		pstmt.setString(5, empQualification);
		System.out.println("Enter Employee Age");
		int empAge = in.nextInt();
		pstmt.setInt(6, empAge);
		int i = pstmt.executeUpdate();
		try {
			i = pstmt.executeUpdate();
			System.out.println(i + " Record Updated Successfully");
		} catch (Exception e) {
			System.out.println("Record was not found");
			e.printStackTrace();
		}
	}

	public void delete() throws SQLException {

		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("insert");
		myStmt = myConn.createStatement();
		PreparedStatement pstmt = myConn.prepareStatement("DELETE FROM employee WHERE empID=?");

		System.out.println("Enter Employee ID: ");
		int empID = in.nextInt();
		pstmt.setInt(1, empID);

		int i = pstmt.executeUpdate();
		System.out.println(i + " Deleted Successfully");
		pstmt.close();
		myConn.close();

	}

	public void search() throws SQLException {

		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("insert");
		myStmt = myConn.createStatement();
		PreparedStatement pstmt = myConn.prepareStatement("SELECT * FROM  employee WHERE empID=?");

		System.out.println("Enter Employee ID: ");
		int empID = in.nextInt();
		pstmt.setInt(1, empID);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("empID") + " " + rs.getString("empName") + " " + rs.getString("empPhone") + " "
					+ rs.getString("empAddress") + " " + rs.getString("empQualification") + rs.getInt("empAge")
					+ rs.getDouble("empSalary"));

		}
		System.out.println("Employee ID " + empID + " selected Successfully");

		pstmt.close();
	}

	public void getHighestPaid() throws SQLException {
		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
	System.out.println("maxxxxxxxxxxxxxx");
		myStmt = myConn.createStatement();
		PreparedStatement pstmt = myConn.prepareStatement("SELECT * FROM employee ORDER BY empSalary DESC LIMIT 1");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("empID") + " " + rs.getString("empName") + " " + rs.getString("empPhone") + " "
					+ rs.getString("empAddress") + " " + rs.getString("empQualification") + rs.getInt("empAge")+ " "
					+ rs.getDouble("empSalary"));

		}

		pstmt.close();
	}

	public  void getCount() throws SQLException {
		Connection myConn;
		Statement myStmt;
		myConn = DriverManager.getConnection(url, user, password);
		System.out.println(">>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>>>>");
		myStmt = myConn.createStatement();
		PreparedStatement pstmt = myConn.prepareStatement("SELECT count( * ) as  employee_record FROM employee");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			//+ " " + rs.getString("empName") + " " + rs.getString("empPhone") + " "+ rs.getString("empAddress") + " " + rs.getString("empQualification") + rs.getInt("empAge")+ " "+ rs.getDouble("empSalary"));

		}

		pstmt.close();
	}
	}

