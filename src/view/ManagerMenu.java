package view;

import entity.Department;
import entity.Employee;
import java.util.List;
import java.util.Scanner;
import service.ManagerMenuLogicHandle;

public class ManagerMenu {

  private Department currentDepartment;
  private List<Employee> employeeList; // List of employees in the department
  private Scanner scanner;
  private ManagerMenuLogicHandle managerMenuLogicHandle; // Thêm đối tượng ManagerMenuLogicHandle

  public ManagerMenu(Department department, List<Employee> employeeList) {
    this.currentDepartment = department;
    this.employeeList = employeeList;
    this.scanner = new Scanner(System.in);
    this.managerMenuLogicHandle = new ManagerMenuLogicHandle(department,
        employeeList); // Khởi tạo đối tượng
  }

  public void display() {
    int choice;
    do {
      System.out.println("===== Menu Trưởng Phòng =====");
      System.out.println("1. Thêm nhân viên mới thuộc phòng ban");
      System.out.println("2. Xem thông tin nhân viên thuộc phòng ban");
      System.out.println("3. Sửa thông tin nhân viên thuộc phòng ban");
      System.out.println("4. Khóa tài khoản nhân viên thuộc phòng ban");
      System.out.println("5. Tìm kiếm nhân viên thuộc phòng ban");
      System.out.println("6. Tính lương cho nhân viên thuộc phòng ban");
      System.out.println("7. Thêm ngày nghỉ cho nhân viên");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Đọc dòng còn lại

      switch (choice) {
        case 1:
          managerMenuLogicHandle.addEmployee();
          break;
        case 2:
          managerMenuLogicHandle.displayEmployeeInfo();
          break;
        case 3:
          managerMenuLogicHandle.updateEmployeeInfo();
          break;
        case 4:
          managerMenuLogicHandle.lockEmployeeAccount();
          break;
        case 5:
          managerMenuLogicHandle.searchEmployee();
          break;
        case 6:
          managerMenuLogicHandle.calculateEmployeeSalary();
          break;
        case 7:
          managerMenuLogicHandle.addLeaveToEmployee();
          break;
        case 0:
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }

}