package service;

import entity.Department;
import entity.Employee;

import java.util.List;
import java.util.Scanner;

public class ManagerMenuLogicHandle {

  private Department currentDepartment;
  private Scanner scanner;
  private EmployeeLogicHandle employeeLogicHandle; // Đối tượng EmployeeLogicHandle

  public ManagerMenuLogicHandle(Department department, List<Employee> employeeList) {
    this.currentDepartment = department;
    this.scanner = new Scanner(System.in);
    this.employeeLogicHandle = new EmployeeLogicHandle(
        employeeList); // Khởi tạo EmployeeLogicHandle
  }

  public void addEmployee() {
    System.out.print("Nhập ID nhân viên mới: ");
    String id = scanner.nextLine();

    System.out.print("Nhập tên nhân viên mới: ");
    String name = scanner.nextLine();

    // Khởi tạo một Employee mới
    Employee newEmployee = new Employee(id, name, currentDepartment);
    employeeLogicHandle.addEmployee(
        newEmployee); // Gọi phương thức addEmployee từ EmployeeLogicHandle
  }

  public void displayEmployeeInfo() {
    employeeLogicHandle.displayEmployeeInfo(scanner); // Gọi phương thức từ EmployeeLogicHandle
  }

  public void updateEmployeeInfo() {
    employeeLogicHandle.updateEmployeeInfo(scanner); // Gọi phương thức từ EmployeeLogicHandle
  }

  public void lockEmployeeAccount() {
    employeeLogicHandle.lockEmployeeAccount(scanner); // Gọi phương thức từ EmployeeLogicHandle
  }

  public void calculateEmployeeSalary() {
    employeeLogicHandle.calculateEmployeeSalary(scanner); // Gọi phương thức từ EmployeeLogicHandle
  }

  public void addLeaveToEmployee() {
    employeeLogicHandle.addLeaveToEmployee(scanner); // Gọi phương thức từ EmployeeLogicHandle
  }

  public void searchEmployee() {
    System.out.print("Nhập ID hoặc tên nhân viên cần tìm: ");
    String query = scanner.nextLine();

    Employee foundEmployee = employeeLogicHandle.findEmployeeByIdOrName(
        query); // Thay thế bằng phương thức tìm kiếm
    if (foundEmployee != null) {
      System.out.println("Thông tin nhân viên: " + foundEmployee);
    } else {
      System.out.println("Không tìm thấy nhân viên với ID hoặc tên: " + query);
    }
  }
}