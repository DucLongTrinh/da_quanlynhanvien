package view;

import entity.Department;
import entity.Employee;
import java.util.List;
import java.util.Scanner;

public class ManagerMenu {
  private Department currentDepartment;
  private List<Employee> employeeList; // List of employees in the department
  private Scanner scanner;

  public ManagerMenu(Department department, List<Employee> employeeList) {
    this.currentDepartment = department;
    this.employeeList = employeeList;
    this.scanner = new Scanner(System.in);
  }

  public void display() {
    int choice;
    do {
      System.out.println("===== Menu Trưởng Phòng =====");
      System.out.println("1. Thêm nhân viên mới thuộc phòng ban");
      System.out.println("2. Xem thông tin nhân viên thuộc phòng ban");
      System.out.println("3. Sửa thông tin nhân viên");
      System.out.println("4. Khóa tài khoản nhân viên");
      System.out.println("5. Tìm kiếm nhân viên");
      System.out.println("6. Tính lương cho nhân viên");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Read remaining line

      switch (choice) {
        case 1:
          addEmployee();
          break;
        case 2:
          displayEmployeeInfo();
          break;
        case 3:
          updateEmployeeInfo();
          break;
        case 4:
          lockEmployeeAccount();
          break;
        case 5:
          searchEmployee();
          break;
        case 6:
          calculateEmployeeSalary();
          break;
        case 0:
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }

  private void addEmployee() {
    // Logic for adding a new employee
    System.out.println("Chức năng thêm nhân viên đang được phát triển.");
  }

  private void displayEmployeeInfo() {
    // Logic for displaying employee information
    for (Employee employee : employeeList) {
      System.out.println(employee);  // Assuming Employee has a toString method
    }
  }

  private void updateEmployeeInfo() {
    // Logic for updating employee information
    System.out.println("Chức năng sửa thông tin nhân viên đang được phát triển.");
  }

  private void lockEmployeeAccount() {
    // Logic for locking an employee account
    System.out.println("Chức năng khóa tài khoản nhân viên đang được phát triển.");
  }

  private void searchEmployee() {
    // Logic for searching for an employee
    System.out.println("Chức năng tìm kiếm nhân viên đang được phát triển.");
  }

  private void calculateEmployeeSalary() {
    // Logic for calculating employee salary
    System.out.println("Chức năng tính lương cho nhân viên đang được phát triển.");
  }
}