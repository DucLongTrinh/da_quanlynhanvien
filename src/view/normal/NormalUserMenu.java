package view.normal;

import entity.Employee;
import service.NormalUserMenuLogicHandle;

import java.util.List;
import java.util.Scanner;

public class NormalUserMenu {
  private Scanner scanner;
  private NormalUserMenuLogicHandle logicHandle;

  // Constructor nhận vào danh sách nhân viên
  public NormalUserMenu(List<Employee> employeeList) {
    this.scanner = new Scanner(System.in);
    this.logicHandle = new NormalUserMenuLogicHandle(employeeList, scanner);
  }

  // method hiển thị menu
  public void display() {
    int choice;
    do {
      // Hiển thị menu cho nhân viên thường
      System.out.println("===== Menu Nhân Viên Thường =====");
      System.out.println("1. Xem thông tin cá nhân");
      System.out.println("2. Cập nhật thông tin cá nhân");
      System.out.println("3. Xem lịch sử làm việc");
      System.out.println("4. Kiểm tra lương");
      System.out.println("5. Xin nghỉ phép");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      // Nhận lựa chọn từ người dùng
      choice = scanner.nextInt();
      scanner.nextLine(); // Đọc dấu dòng sau khi nhập số

      // Xử lý lựa chọn
      switch (choice) {
        case 1:
          // Xem thông tin cá nhân
          logicHandle.viewPersonalInfo();
          break;
        case 2:
          // Cập nhật thông tin cá nhân
          logicHandle.updatePersonalInfo();
          break;
        case 3:
          // Xem lịch sử làm việc
          logicHandle.viewWorkHistory();
          break;
        case 4:
          // Kiểm tra lương
          logicHandle.checkSalary();
          break;
        case 5:
          // Xin nghỉ phép
          logicHandle.requestLeave();
          break;
        case 0:
          // Đăng xuất
          System.out.println("Đăng xuất thành công.");
          break;
        default:
          // Thông báo khi lựa chọn không hợp lệ
          System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
      }
    } while (choice != 0);
  }
}