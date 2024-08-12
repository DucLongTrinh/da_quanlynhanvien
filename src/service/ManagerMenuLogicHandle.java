package service;

import entity.Department;
import entity.Employee;

import java.util.List;
import java.util.Scanner;

public class ManagerMenuLogicHandle {
  private Department currentDepartment;
  private Scanner scanner;
  private EmployeeLogicHandle employeeLogicHandle; // Đối tượng EmployeeLogicHandle

  // Constructor
  public ManagerMenuLogicHandle(Department department, List<Employee> employeeList) {
    this.currentDepartment = department;
    this.scanner = new Scanner(System.in);
    this.employeeLogicHandle = new EmployeeLogicHandle(employeeList); // Khởi tạo EmployeeLogicHandle
  }

  // method thêm nhân viên mới
  public void addEmployee(Scanner scanner) {
    System.out.print("Nhập ID nhân viên mới: ");
    String id = scanner.nextLine();

    System.out.print("Nhập tên nhân viên mới: ");
    String name = scanner.nextLine();

    // Còn nhiều thuộc tính khác có thể cần nhập vào để tạo Employee, thêm vào theo quy định của bạn

    // Khởi tạo một Employee mới (Điều chỉnh các tham số dưới đây theo yêu cầu của bạn)
    Employee newEmployee = new Employee(id, name, currentDepartment, 10, 5,
        null, null, null, null, null,
        null, null, null, null, null, null);

    // Thêm nhân viên mới
    employeeLogicHandle.addEmployee(newEmployee); // method addEmployee từ EmployeeLogicHandle
    System.out.println("Thêm nhân viên thành công!");
  }

  // method hiển thị thông tin nhân viên
  public void displayEmployeeInfo(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần xem thông tin: ");
    String id = scanner.nextLine();
    employeeLogicHandle.displayEmployeeInfo(id); // method từ EmployeeLogicHandle
  }

  // method cập nhật thông tin nhân viên
  public void updateEmployeeInfo(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần cập nhật thông tin: ");
    String id = scanner.nextLine();
    employeeLogicHandle.updateEmployeeInfo(id, scanner); // method từ EmployeeLogicHandle
  }

  // method khóa tài khoản nhân viên
  public void lockEmployeeAccount(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần khóa tài khoản: ");
    String id = scanner.nextLine();
    employeeLogicHandle.lockEmployeeAccount(id); // Gọi method từ EmployeeLogicHandle
    System.out.println("Khóa tài khoản nhân viên thành công!");
  }

  // method tính lương cho nhân viên
  public void calculateEmployeeSalary(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần tính lương: ");
    String id = scanner.nextLine();
    double salary = employeeLogicHandle.calculateEmployeeSalary(id); // Gọi method từ EmployeeLogicHandle
    System.out.println("Lương của nhân viên " + id + " là: " + salary);
  }

  // method thêm ngày nghỉ cho nhân viên
  public void addLeaveToEmployee(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần thêm ngày nghỉ: ");
    String id = scanner.nextLine();
    System.out.print("Nhập số ngày nghỉ: ");
    int days = scanner.nextInt();
    scanner.nextLine(); // Xóa bỏ newline

    employeeLogicHandle.addLeaveToEmployee(id, days); // Gọi method từ EmployeeLogicHandle
    System.out.println("Thêm ngày nghỉ cho nhân viên thành công!");
  }

  // method tìm kiếm nhân viên
  public void searchEmployee(Scanner scanner) {
    System.out.print("Nhập ID hoặc tên nhân viên cần tìm: ");
    String query = scanner.nextLine();

    Employee foundEmployee = employeeLogicHandle.findEmployeeByIdOrName(query); // Thay thế bằng method tìm kiếm
    if (foundEmployee != null) {
      System.out.println("Thông tin nhân viên: " + foundEmployee);
    } else {
      System.out.println("Không tìm thấy nhân viên với ID hoặc tên: " + query);
    }
  }
}