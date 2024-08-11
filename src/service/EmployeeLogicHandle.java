package service;

import constants.Status;
import entity.Employee;
import entity.Leave;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeLogicHandle {

  private List<Employee> employeeList;

  public EmployeeLogicHandle(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  // Các Method thêm nhân viên, xem thông tin, sửa thông tin, khóa tài khoản, tìm kiếm, tính lương được định nghĩa tại đây

  // Thêm nhân viên vào danh sách

  public void addEmployee(Employee employee) {
    if (employee != null && !employeeList.contains(employee)) {
      employeeList.add(employee);
      System.out.println("Đã thêm nhân viên: " + employee.getName());
    } else {
      System.out.println("Nhân viên đã tồn tại hoặc NULL không thể thêm.");
    }
  }


  // Hiển thị thông tin nhân viên
  public void displayEmployeeInfo(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để xem thông tin: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    employee.displayInfo();
  }


  // Cập nhật thông tin nhân viên
  public void updateEmployeeInfo(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần cập nhật: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    employee.updateInfo(scanner);
    System.out.println("Thông tin nhân viên " + employee.getName() + " đã được cập nhật.");
  }

  // Khóa tài khoản nhân viên
  public void lockEmployeeAccount(Scanner scanner) {
    System.out.print("Nhập ID nhân viên cần khóa: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    employee.isLocked();
    System.out.println("Tài khoản nhân viên " + employee.getName() + " đã bị khóa.");
  }

  // Tìm nhân viên theo ID

  public Employee findEmployeeById(String id) {
    for (Employee employee : employeeList) {
      if (employee.getId().equals(id)) {
        return employee;
      }
    }
    return null; // Trả về null nếu không tìm thấy
  }

  // để tìm kiếm nhân viên bằng ID hoặc tên:
  public Employee findEmployeeByIdOrName(String query) {
    for (Employee employee : employeeList) {
      if (employee.getId().equalsIgnoreCase(query) || employee.getName().equalsIgnoreCase(query)) {
        return employee;
      }
    }
    return null; // Nếu không tìm thấy nhân viên nào
  }

  // Tính lương cho nhân viên
  public void calculateEmployeeSalary(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để tính lương: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    double salary = employee.calculateSalary();
    System.out.println("Lương của nhân viên " + employee.getName() + " là: " + salary);
  }


  // Thêm ngày nghỉ phép cho nhân viên
  public void addLeaveToEmployee(Scanner scanner) {
    System.out.print("Nhập ID nhân viên để thêm ngày nghỉ: ");
    String id = scanner.nextLine();

    Employee employee = findEmployeeById(id);
    if (employee == null) {
      System.out.println("Không tìm thấy nhân viên với ID: " + id);
      return;
    }

    System.out.print("Nhập ngày bắt đầu nghỉ (yyyy-mm-dd): ");
    LocalDate startDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Nhập ngày kết thúc nghỉ (yyyy-mm-dd): ");
    LocalDate endDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Nhập lý do nghỉ: ");
    String reason = scanner.nextLine();

    Leave leave = new Leave(startDate, endDate, reason);
    employee.addLeave(leave);
    System.out.println("Ngày nghỉ đã được thêm cho nhân viên " + employee.getName() + ".");
  }

  // Method lấy danh sách nhân viên
  public List<Employee> getEmployees() {
    return new ArrayList<>(employeeList); // Trả về bản sao danh sách để bảo vệ tính toàn vẹn
  }

}
