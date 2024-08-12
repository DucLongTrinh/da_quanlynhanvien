package view.manager;

import entity.Department;
import entity.Employee;
import java.util.List;
import java.util.Scanner;
import service.ManagerMenuLogicHandle;

public class ManagerMenu {

  private Department currentDepartment; // Phòng ban hiện tại
  private List<Employee> employeeList; // Danh sách nhân viên trong phòng ban
  private Scanner scanner; // Đối tượng Scanner để nhận đầu vào từ người dùng
  private ManagerMenuLogicHandle managerMenuLogicHandle; // Đối tượng quản lý menu trưởng phòng

  public ManagerMenu(Department department, List<Employee> employeeList) {
    this.currentDepartment = department;
    this.employeeList = employeeList;
    this.scanner = new Scanner(System.in);
    this.managerMenuLogicHandle = new ManagerMenuLogicHandle(department, employeeList); // Khởi tạo đối tượng
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

      // Nhận lựa chọn từ người dùng
      choice = scanner.nextInt();
      scanner.nextLine(); // Đọc dòng còn lại sau khi nhập số

      // Xử lý lựa chọn của người dùng
      switch (choice) {
        case 1:
          managerMenuLogicHandle.addEmployee(scanner); // Phương thức thêm nhân viên
          break;
        case 2:
          managerMenuLogicHandle.displayEmployeeInfo(scanner); // Phương thức xem thông tin nhân viên
          break;
        case 3:
          managerMenuLogicHandle.updateEmployeeInfo(scanner); // Phương thức sửa thông tin nhân viên
          break;
        case 4:
          managerMenuLogicHandle.lockEmployeeAccount(scanner); // Phương thức khóa tài khoản nhân viên
          break;
        case 5:
          managerMenuLogicHandle.searchEmployee(scanner); // Phương thức tìm kiếm nhân viên
          break;
        case 6:
          managerMenuLogicHandle.calculateEmployeeSalary(scanner); // Phương thức tính lương
          break;
        case 7:
          managerMenuLogicHandle.addLeaveToEmployee(scanner); // Phương thức thêm ngày nghỉ
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