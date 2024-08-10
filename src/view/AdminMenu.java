package view;

import entity.Department;
import entity.Employee;
import java.util.List;
import java.util.Scanner;
import service.EmployeeLogicHandle;

public class AdminMenu {

  private Scanner scanner = new Scanner(System.in);
  private EmployeeLogicHandle employeeLogicHandle;

  public AdminMenu(List<Department> departments, List<Employee> employeeList) {
    this.employeeLogicHandle = new EmployeeLogicHandle(employeeList);
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
          employeeLogicHandle.searchEmployee(scanner);
          break;
        case 6:
          employeeLogicHandle.calculateEmployeeSalary(scanner);
          break;
        case 7:
          manageDepartments(); // Placeholder for department management
          break;
        case 0:
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }

  private void manageDepartments() {
    // Implement department management logic here
    System.out.println("Quản lý phòng ban chưa được cài đặt.");
  }
}