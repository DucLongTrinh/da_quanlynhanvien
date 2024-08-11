package view;

import entity.Employee;
import service.NormalUserMenuLogicHandle;

import java.util.List;
import java.util.Scanner;

public class NormalUserMenu {
  private Scanner scanner;
  private NormalUserMenuLogicHandle logicHandle;

  public NormalUserMenu(List<Employee> employeeList) {
    this.scanner = new Scanner(System.in);
    this.logicHandle = new NormalUserMenuLogicHandle(employeeList, scanner);
  }

  public void display() {
    int choice;
    do {
      System.out.println("===== Menu Nhân Viên Thường =====");
      System.out.println("1. Xem thông tin cá nhân");
      System.out.println("2. Cập nhật thông tin cá nhân");
      System.out.println("3. Xem lịch sử làm việc");
      System.out.println("4. Kiểm tra lương");
      System.out.println("5. Xin nghỉ phép");
      System.out.println("0. Đăng xuất");
      System.out.print("Chọn chức năng: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Đọc dấu dòng sau khi nhập số

      switch (choice) {
        case 1:
          logicHandle.viewPersonalInfo();
          break;
        case 2:
          logicHandle.updatePersonalInfo();
          break;
        case 3:
          logicHandle.viewWorkHistory();
          break;
        case 4:
          logicHandle.checkSalary();
          break;
        case 5:
          logicHandle.requestLeave();
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