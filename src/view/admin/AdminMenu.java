package view.admin;

import entity.Department;
import entity.Employee;
import service.AdminMenuLogicHandle;
import service.EmployeeLogicHandle;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

  private Scanner scanner = new Scanner(System.in);
  private EmployeeLogicHandle employeeLogicHandle;
  private AdminMenuLogicHandle adminMenuLogicHandle;

  private List<Department> departments;
  private List<Employee> employees;

//  public AdminMenu(List<Department> departments, List<Employee> employeeList) {
//    this.employeeLogicHandle = new EmployeeLogicHandle(employeeList);
//    this.adminMenuLogicHandle = new AdminMenuLogicHandle(departments);
//  }

  // Constructor yêu cầu hai đối số
  public AdminMenu(List<Department> departments, List<Employee> employees) {
    this.departments = departments;
    this.employees = employees;
  }

  public void display() {
    int choice;
    do {
      System.out.println("\n==== Menu Admin ====");
      System.out.println("1. Thêm nhân viên mới");
      System.out.println("2. Xem thông tin nhân viên");
      System.out.println("3. Sửa thông tin nhân viên");
      System.out.println("4. Khóa tài khoản nhân viên");
      System.out.println("5. Tìm kiếm nhân viên");
      System.out.println("6. Tính lương cho nhân viên");
      System.out.println("7. Quản lý tất cả các phòng ban");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Đọc dòng còn lại sau khi nhập số

      switch (choice) {
        case 1:
          employeeLogicHandle.addEmployee(scanner);
          break;
        case 2:
          employeeLogicHandle.displayEmployeeInfo(scanner);
          break;
        case 3:
          employeeLogicHandle.updateEmployeeInfo(scanner);
          break;
        case 4:
          employeeLogicHandle.lockEmployeeAccount(scanner);
          break;
        case 5:
          searchEmployee();
          break;
        case 6:
          employeeLogicHandle.calculateEmployeeSalary(scanner);
          break;
        case 7:
          adminMenuLogicHandle.manageDepartments(scanner);
          break;
        case 0:
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }

  private void searchEmployee() {
    System.out.print("Nhập ID hoặc tên nhân viên cần tìm: ");
    String query = scanner.nextLine();
    Employee foundEmployee = employeeLogicHandle.findEmployeeByIdOrName(query); // Tìm kiếm bằng ID hoặc tên
    if (foundEmployee != null) {
      System.out.println("Thông tin nhân viên: " + foundEmployee);
    } else {
      System.out.println("Không tìm thấy nhân viên với ID hoặc tên: " + query);
    }
  }
}